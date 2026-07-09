package com.lvb.studys.kotlin.api.carrental.controller

import com.lvb.studys.kotlin.api.carrental.dto.OwnerPostDTO
import com.lvb.studys.kotlin.api.carrental.service.ownerPost.IOwnerPostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/owner")
class OwnerPostController @Autowired constructor(
    private val ownerPostService: IOwnerPostService
) {

    @PostMapping
    fun createOwnerCar(@RequestBody ownerPostDTO: OwnerPostDTO): ResponseEntity<OwnerPostDTO> {
        return ResponseEntity.status(HttpStatus.CREATED).body(ownerPostService.createOwnerCar(ownerPostDTO))
    }
}