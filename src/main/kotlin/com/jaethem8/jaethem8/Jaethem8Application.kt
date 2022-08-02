package com.jaethem8.jaethem8

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Jaethem8Application{
//	@Bean
//	fun passwordEncoder(): BCryptPasswordEncoder {
//		return BCryptPasswordEncoder()
//	}
}


fun main(args: Array<String>) {
	runApplication<Jaethem8Application>(*args)
}


