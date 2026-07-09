package com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/info")
class POSInfoController {

    @GetMapping
    fun get(): ResponseEntity<Any> {
        return ResponseEntity("POS Info", HttpStatus.OK)
    }
}