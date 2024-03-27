package com.example.transactionalrollbackkt

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/tests")
@RestController
class TestController(
    val testService: TestService,
) {

    @GetMapping
    fun findAll() = testService.findAll().size

    @PostMapping("/rollback")
    fun addExpectRollback() = testService.throwsUncheckedException()

    @PostMapping("/not-rollback")
    fun addExpectNotRollback() = testService.throwsCheckedException()
}