package com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.service

import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.dto.ProductInfoDTO
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.dto.ProductSaleDTO
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.dto.SaleDTO
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.dto.SaleInfoDTO
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.entity.ItemSale
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.entity.Sale
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.exceptions.InvalidOperationException
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.exceptions.NoItemException
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.repository.ItemSaleRepository
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.repository.ProductRepository
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.repository.SaleRepository
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.CollectionUtils
import java.math.BigDecimal
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@Service
class SaleService @Autowired constructor(
    private val saleRepository: SaleRepository,
    private val userRepository: UserRepository,
    private val productRepository: ProductRepository,
    private val itemSaleRepository: ItemSaleRepository
) {

    fun getAllSales(): List<SaleInfoDTO> {
        return saleRepository.findAll().map { sale -> getSaleInfo(sale) }.toList()
    }

    private fun getSaleInfo(sale: Sale): SaleInfoDTO {

        val products = getProductInfo(sale.items)
        val total = getTotal(products)

        return SaleInfoDTO(
            user = sale.user.name,
            date = sale.date.format(DateTimeFormatter.ofPattern("ddd/MM/yyyy")),
            total = total,
            products = products
        )
    }

    private fun getTotal(products: List<ProductInfoDTO>): BigDecimal {
        var total = BigDecimal(0)

        products.forEach { product ->
            total = total.add(product.price.multiply(BigDecimal(product.quantity)))
        }

        return total
    }

    private fun getProductInfo(items: List<ItemSale>): List<ProductInfoDTO> {

        if (CollectionUtils.isEmpty(items)) {
            return Collections.emptyList()
        }

        return items.map { item ->
            ProductInfoDTO(
                id = item.id ?: 0,
                description = item.product.description,
                price = item.product.price,
                quantity = item.quantity
            )
        }.toList()
    }

    @Transactional
    fun saveSale(saleDto: SaleDTO): Long {

        val user =
            saleDto.userId?.let { userRepository.findById(it).orElseThrow { throw NoItemException("User not Found") } }

        val items = getItemSale(saleDto.items)

        val sale = user?.let {
            Sale(
                date = LocalDate.now(),
                user = it,
                items = items
            )
        }

        var saleId = 0L

        sale?.let {
            saleRepository.save(it).also { savedSale ->
                saleId = savedSale.id!!
                items.forEach { item ->
                    item.sale = savedSale
                }

                savedSale.items = itemSaleRepository.saveAll(items)
                updateSale(savedSale)
            }
        }

        return saleId
    }

    private fun getItemSale(products: List<ProductSaleDTO>): List<ItemSale> {

        if (products.isEmpty()) {
            throw InvalidOperationException("Unable to sell items out of stock")
        }

        return products.map {
            val product =
                productRepository.findById(it.productId).orElseThrow { throw NoItemException("Item not Found") }

            if (product.quantity == 0) {
                throw NoItemException("Product without stock")
            } else if ((product.quantity ?: it.quantity) < it.quantity) {
                throw InvalidOperationException(
                    String.format(
                        "The quantity of sale items (%s) is greater than the quantity available in stock (%s)",
                        it.quantity,
                        product.quantity
                    )
                )
            }

            val total = (product.quantity ?: it.quantity) - it.quantity

            ItemSale(product = product, quantity = total, sale = null)
        }.toList()
    }

    fun updateSale(sale: Sale) {

        val oldSale = sale.id?.let { saleRepository.findById(it) }

        if (oldSale?.isPresent == true) {
            saleRepository.save(sale)
        }

        saleRepository.save(sale)
    }

    fun deleteSale(id: Long) {
        saleRepository.deleteById(id)
    }

    fun findSaleById(id: Long): SaleInfoDTO {
        return getSaleInfo(saleRepository.findById(id).orElseThrow { throw NoItemException("Sale not Found") })
    }

}