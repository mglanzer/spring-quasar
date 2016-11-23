package com.mglanzer

import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.mglanzer.config.AppConfig
import com.mglanzer.persistence.model.FooEntity
import com.mglanzer.persistence.repository.TestRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@SpringBootApplication
@ComponentScan(basePackageClasses = arrayOf(AppConfig::class))
open class Application {

    private val log = LoggerFactory.getLogger(Application::class.java)

    @Bean
    open fun objectMapperBuilder()
            = Jackson2ObjectMapperBuilder().modulesToInstall(KotlinModule())

    @Bean
    open fun init(repository: TestRepository) = CommandLineRunner {
        // save a couple of customers
        repository.save(FooEntity("Bob"))
        repository.save(FooEntity("Sue"))
        repository.save(FooEntity("Sam"))
        repository.save(FooEntity("Rich"))

        // fetch all customers
        log.info("Customers found with findAll():")
        log.info("-------------------------------")
        for (customer in repository.findAll()) {
            log.info(customer.toString())
        }
        log.info("")

        // fetch an individual customer by ID
        val customer = repository.findOne(1L)
        log.info("Customer found with findOne(1L):")
        log.info("--------------------------------")
        log.info(customer.toString())
        log.info("")

        // fetch customers by last name
        log.info("Customer found with findByName('Bob'):")
        log.info("--------------------------------------------")
        for (bauer in repository.findByName("Bob")) {
            log.info(bauer.toString())
        }
        log.info("")
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java , *args)
}