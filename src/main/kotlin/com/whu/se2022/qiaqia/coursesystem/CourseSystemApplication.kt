package com.whu.se2022.qiaqia.coursesystem

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableScheduling
class CourseSystemApplication

fun main(args: Array<String>) {
	runApplication<CourseSystemApplication>(*args)
}
