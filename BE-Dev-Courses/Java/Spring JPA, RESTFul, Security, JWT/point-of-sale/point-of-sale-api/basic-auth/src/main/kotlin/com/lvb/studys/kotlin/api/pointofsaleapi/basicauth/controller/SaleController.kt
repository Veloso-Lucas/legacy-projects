package com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.controller

import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.dto.ResponseDTO
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.dto.SaleDTO
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.dto.SaleInfoDTO
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.entity.Sale
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.service.SaleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/sale")
class SaleController @Autowired constructor(
    private val saleService: SaleService
) {

    @GetMapping
    fun getAll(): ResponseEntity<List<SaleInfoDTO>> {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.getAllSales())
    }

    @GetMapping("{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Any> {
        val sale = saleService.findSaleById(id)
        return ResponseEntity.status(HttpStatus.CREATED).body(sale)
    }

    @PostMapping
    fun saveSale(@RequestBody sale: SaleDTO): ResponseEntity<Any> {
        saleService.saveSale(sale)
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseDTO("Successful Sale"))
    }

    @PutMapping
    fun updateSale(@RequestBody sale: Sale): ResponseEntity<Any> {
        saleService.updateSale(sale)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteSale(@PathVariable("id") id: Long): ResponseEntity<Any> {
        saleService.deleteSale(id)
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully")
    }


}