package com.mglanzer.web.controller

import com.mglanzer.persistence.model.FooEntity
import com.mglanzer.persistence.repository.TestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ApiController @Autowired constructor(val db: TestRepository) {

    @RequestMapping("/ping", method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun ping(): ResponseEntity<String>
            = ResponseEntity.ok("pong")

    @RequestMapping("/find/{name}", method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun findByName(@PathVariable name: String): ResponseEntity<Iterable<FooEntity>>
            = ResponseEntity.ok(db.findByName(name))
}