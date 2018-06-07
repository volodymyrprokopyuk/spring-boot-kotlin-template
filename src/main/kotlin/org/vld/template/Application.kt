package org.vld.template

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.runApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class Application : CommandLineRunner {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(Application::class.java)
    }

    override fun run(vararg args: String?) {
        logger.debug("ok")
    }
}

fun main(args: Array<String>) = runApplication<Application>(*args)