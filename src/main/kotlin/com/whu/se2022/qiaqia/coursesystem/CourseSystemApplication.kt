package com.whu.se2022.qiaqia.coursesystem

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class CourseSystemApplication

fun main(args: Array<String>) {
	runApplication<CourseSystemApplication>(*args)
}
