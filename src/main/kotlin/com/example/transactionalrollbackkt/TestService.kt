package com.example.transactionalrollbackkt

import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

private val log = KotlinLogging.logger { }

@Service
@Transactional
class TestService(
    val testRepository: TestRepository,
) {
    fun findAll() = testRepository.findAll()

    fun throwsUncheckedException() {
        testRepository.save(TestEntity())
        log.info { "expect rollback => same count" }
        throw RuntimeException()
    }

    fun throwsCheckedException() {
        testRepository.save(TestEntity())
        log.info { "expect not rollback => add count" }
        throw Exception()
    }
}