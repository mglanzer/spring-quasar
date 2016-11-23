package com.mglanzer.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EntityScan(basePackages = arrayOf("com.mglanzer.persistence.model"))
@EnableJpaRepositories(basePackages = arrayOf("com.mglanzer.persistence.repository"))
open class PersistenceConfig {}
