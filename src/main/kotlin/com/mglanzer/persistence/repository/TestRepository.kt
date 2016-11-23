package com.mglanzer.persistence.repository

import com.mglanzer.persistence.model.FooEntity
import org.springframework.data.repository.CrudRepository

interface TestRepository : CrudRepository<FooEntity, Long> {

    fun findByName(name: String) : Iterable<FooEntity>
}