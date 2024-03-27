package com.example.transactionalrollbackkt

import jakarta.persistence.*

@Entity
@Table(name = "test")
class TestEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
) {
    constructor() : this(null)

}