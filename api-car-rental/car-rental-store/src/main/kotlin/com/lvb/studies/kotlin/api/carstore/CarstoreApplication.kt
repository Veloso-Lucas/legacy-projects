package com.lvb.studies.kotlin.api.carstore

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CarstoreApplication

fun main(args: Array<String>) {
	runApplication<CarstoreApplication>(*args)
}
