package com.mglanzer.config

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer
import org.springframework.stereotype.Component

@Component
open class ServletContainerCustomizer : EmbeddedServletContainerCustomizer {
    override fun customize(container: ConfigurableEmbeddedServletContainer) {
        container.setPort(9095)
    }
}