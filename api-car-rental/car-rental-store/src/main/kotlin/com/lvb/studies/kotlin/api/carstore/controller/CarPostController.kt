package com.lvb.studies.kotlin.api.carstore.controller

import com.lvb.studies.kotlin.api.carstore.dto.CarPostDTO
import com.lvb.studies.kotlin.api.carstore.service.carPost.ICarPostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sales")
class CarPostController @Autowired constructor(
    private val carPostService: ICarPostService
) {


    @GetMapping("/car/")
    fun getCarSale(): ResponseEntity<List<CarPostDTO>> =
        ResponseEntity.status(HttpStatus.FOUND).body(carPostService.getCarSales())


    @PutMapping("/car/{id}")
    fun changeCarSale(@RequestBody carPostDTO: CarPostDTO, @PathVariable("id") id: String): ResponseEntity<Any> {
        carPostService.changeCarSale(carPostDTO, id.toLong())
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping("/car/{id}")
    fun removeCarSale(@PathVariable("id") id: String): ResponseEntity<Any> {
        carPostService.removeCarSale(id.toLong())
        return ResponseEntity(HttpStatus.OK)
    }
}