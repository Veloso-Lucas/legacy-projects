package com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.controller

import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.dto.ProductDTO
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.dto.ResponseDTO
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.entity.Product
import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.service.ProductService
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/product")
class ProductController @Autowired constructor(
    private val productService: ProductService,

) {

    private var modelMapper: ModelMapper = ModelMapper()

    @GetMapping
    fun getAll(): ResponseEntity<List<Product>> {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProduct())
    }

    @PostMapping
    fun saveProduct(@RequestBody product: ProductDTO): ResponseEntity<Any> {
        productService.saveProduct(modelMapper.map(product, Product::class.java))
        return ResponseEntity(HttpStatus.CREATED)
    }

    @PutMapping
    fun updateProduct(@RequestBody product: ProductDTO): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(modelMapper.map(product, Product::class.java)))
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable("id") id: Long): ResponseEntity<Any> {
        productService.deleteProduct(id)
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO("User deleted successfully"))
    }

}