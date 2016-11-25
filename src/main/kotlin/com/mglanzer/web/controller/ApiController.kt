package com.mglanzer.web.controller

import co.paralleluniverse.fibers.Suspendable
import co.paralleluniverse.strands.Strand
import com.mglanzer.persistence.model.FooEntity
import com.mglanzer.persistence.repository.TestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/api")
class ApiController @Autowired constructor(val db: TestRepository) {

    @Suspendable
    @RequestMapping("/ping", method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun pingFiber(res: HttpServletResponse): ResponseEntity<String> {

        addFiberHeader(res)

        return ResponseEntity.ok("pong")
    }

    @RequestMapping("/ping/thread", method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun pingThread(res: HttpServletResponse): ResponseEntity<String> {

        addFiberHeader(res)

        return ResponseEntity.ok("pong")
    }

    @Suspendable
    @RequestMapping("/find/{name}", method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun findByName(@PathVariable name: String): ResponseEntity<Iterable<FooEntity>>
            = ResponseEntity.ok(db.findByName(name))

    private fun addFiberHeader(res: HttpServletResponse) {
        val isFiber = Strand.isCurrentFiber()
        res.addHeader("X-Is-Fiber", isFiber.toString());
    }
}