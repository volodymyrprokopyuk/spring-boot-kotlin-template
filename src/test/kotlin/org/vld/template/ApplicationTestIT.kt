package org.vld.template

import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.junit4.SpringRunner
import javax.sql.DataSource

@RunWith(SpringRunner::class)
@SpringBootTest
class ApplicationTestIT {

    @Autowired
    private lateinit var dataSource: DataSource

    /*@Before
    fun setupDataSourceForEachTest() {
        dataSource = DataSourceBuilder.create()
                .url("jdbc:tc:mssqlserver:2017-GA://localhost:1433;databaseName=masterx?TC_INITSCRIPT=init/sqlserver_init.sql")
                .username("sax")
                .password("Password1!")
                .driverClassName("org.testcontainers.jdbc.ContainerDatabaseDriver")
                .build()
    }*/

    companion object {

        val logger: Logger = LoggerFactory.getLogger("ApplicationTestIT")

        private lateinit var dataSource: DataSource

        /*@BeforeClass
        @JvmStatic
        fun setupDataSourceForAllTests() {
            dataSource = DataSourceBuilder.create()
                    .url("jdbc:tc:mssqlserver:2017-GA://localhost:1433;databaseName=masterx?TC_INITSCRIPT=init/sqlserver_init.sql")
                    .username("sax")
                    .password("Password1!")
                    .driverClassName("org.testcontainers.jdbc.ContainerDatabaseDriver")
                    .build()
        }*/
    }

    @Test
    fun givenDatabase_whenQueryDatabase_thenReturnResult() {
        // Given & When
        val result = JdbcTemplate(dataSource).queryForObject("SELECT p.first_name FROM family.person p", String::class.java)
        // Then
        assert(result == "Volodymyr")
    }
}