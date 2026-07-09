package com.lvb.studys.kotlin.api.carrental.controller

import com.lvb.studys.kotlin.api.carrental.dto.CarPostDTO
import com.lvb.studys.kotlin.api.carrental.message.KafkaProduceMessage
import com.lvb.studys.kotlin.api.carrental.service.carPost.ICarPostStoreService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/car")
class CarPostController @Autowired constructor(
    private val carPostStoreService: ICarPostStoreService,
    private val kafkaProduceMessage: KafkaProduceMessage
) {


    @GetMapping("/posts")
    fun getCarSale(): ResponseEntity<List<CarPostDTO>> {
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostStoreService.getCarForSales())
    }

    @PostMapping("/post")
    fun postCarForSale(@RequestBody carPostDTO: CarPostDTO): ResponseEntity<Void> {
        kafkaProduceMessage.sendMessage(carPostDTO)
        return ResponseEntity(HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun changeCarSale(@RequestBody carPostDTO: CarPostDTO, @PathVariable("id") id: String): ResponseEntity<Void> {
        carPostStoreService.changeCarForSale(carPostDTO, id)
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteCarForSale(@PathVariable("id") id: String): ResponseEntity<Void> {
        carPostStoreService.removerCarForSale(id)
        return ResponseEntity(HttpStatus.OK)
    }
}