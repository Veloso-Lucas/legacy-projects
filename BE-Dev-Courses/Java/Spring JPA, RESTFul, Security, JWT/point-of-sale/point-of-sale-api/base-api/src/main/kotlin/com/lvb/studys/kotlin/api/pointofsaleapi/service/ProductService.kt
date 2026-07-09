package com.lvb.studys.kotlin.api.pointofsaleapi.service

import com.lvb.studys.kotlin.api.pointofsaleapi.entity.Product
import com.lvb.studys.kotlin.api.pointofsaleapi.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService @Autowired constructor(
    private val productRepository: ProductRepository
) {

    fun getAllProduct(): List<Product> {
        return productRepository.findAll()
    }

    fun saveProduct(product: Product) {
        productRepository.save(product)
    }

    fun updateProduct(product: Product) {

        val oldUser = product.id?.let { productRepository.findById(it) }

        if (oldUser?.isPresent == true) {
            productRepository.save(product)
        }

        productRepository.save(product)
    }

    fun deleteProduct(id: Long) {
        productRepository.deleteById(id)
    }
}