package com.lvb.studies.kotlin.api.carstore.controller

import com.lvb.studies.kotlin.api.carstore.service.ownerPost.IOwnerPostService
import com.lvb.studies.kotlin.api.carstore.dto.OwnerPostDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class OwnerPostController @Autowired constructor(
    private val ownerPostService: IOwnerPostService
) {

    @PostMapping
    fun createOwner(@RequestBody ownerPostDTO: OwnerPostDTO): ResponseEntity<Any> {
        ownerPostService.createOwnerPost(ownerPostDTO)
        return ResponseEntity(HttpStatus.OK)
    }
}