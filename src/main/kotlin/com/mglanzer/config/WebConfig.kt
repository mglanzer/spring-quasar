package com.mglanzer.config

import co.paralleluniverse.springframework.web.servlet.config.annotation.FiberWebMvcConfigurationSupport
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@ComponentScan(basePackages = arrayOf("com.mglanzer.web.controller"))
@Import(FiberWebMvcConfigurationSupport::class)
open class WebConfig {
}