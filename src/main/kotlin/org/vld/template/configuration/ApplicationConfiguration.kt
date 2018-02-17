package org.vld.template.configuration

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ApplicationConfiguration {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(ApplicationConfiguration::class.java)
    }

    @Bean
    open fun ok(): String {
        logger.info("ok")
        return "ok"
    }
}
