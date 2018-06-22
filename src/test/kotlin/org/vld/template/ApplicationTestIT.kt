package org.vld.template

import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.junit4.SpringRunner
import org.testcontainers.containers.BindMode
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.output.Slf4jLogConsumer
import org.testcontainers.jdbc.ContainerDatabaseDriver
import javax.sql.DataSource

//class KPostgreSQLContainer(imageName: String) : PostgreSQLContainer<KPostgreSQLContainer>(imageName)

//class KGenericContainer(imageName: String) : GenericContainer<KGenericContainer>(imageName)

@RunWith(SpringRunner::class)
@SpringBootTest
class ApplicationTestIT {

    @Autowired
    private lateinit var dataSource: DataSource

    // ** PostgreSQL

    // Docker Compose
    /*@Before
    fun setupDataSourceForEachTest() {
        dataSource = DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost:5432/postgres")
                .username("postgres")
                .password("postgres")
                .driverClassName("org.postgresql.Driver")
                .build()
    }*/

    // Testcontainers
    /*@Before
    fun setupDataSourceForEachTest() {
        dataSource = DataSourceBuilder.create()
                .url("jdbc:tc:postgresql:10://localhost:5432/postgres")
                .username("postgres")
                .password("postgres")
                .driverClassName("org.testcontainers.jdbc.ContainerDatabaseDriver")
                .build()
    }*/

    // ** SQL Server

    // Docker Compose
    /*@Before
    fun setupDataSourceForEachTest() {
        dataSource = DataSourceBuilder.create()
                .url("jdbc:sqlserver://localhost:1433;databaseName=master")
                .username("sa")
                .password("Password!1")
                .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                .build()
    }*/

    // Testcontainers
    /*@Before
    fun setupDataSourceForEachTest() {
        dataSource = DataSourceBuilder.create()
                .url("jdbc:tc:mssqlserver:2017-GA://localhost:1433;databaseName=master")
                .username("sa")
                .password("Password!1")
                .driverClassName("org.testcontainers.jdbc.ContainerDatabaseDriver")
                .build()
    }*/

    companion object {

        val logger: Logger = LoggerFactory.getLogger("ApplicationTestIT")

//        private lateinit var dataSource: DataSource

        // ** PostgreSQL

        // Docker Compose
        /*@BeforeClass
        @JvmStatic
        fun setupDataSourceForAllTests() {
            dataSource = DataSourceBuilder.create()
                    .url("jdbc:postgresql://localhost:5432/postgres")
                    .username("postgres")
                    .password("postgres")
                    .driverClassName("org.postgresql.Driver")
                    .build()
        }*/

        // Testcontainers
        /*@BeforeClass
        @JvmStatic
        fun setupDataSourceForAllTests() {
            dataSource = DataSourceBuilder.create()
                    .url("jdbc:tc:postgresql:10://localhost:5432/postgres")
                    .username("postgres")
                    .password("postgres")
                    .driverClassName("org.testcontainers.jdbc.ContainerDatabaseDriver")
                    .build()
        }*/

        // ** SQL Server

        // Docker Compose
        /*@BeforeClass
        @JvmStatic
        fun setupDataSourceForAllTests() {
            dataSource = DataSourceBuilder.create()
                    .url("jdbc:sqlserver://localhost:1433;databaseName=master")
                    .username("sa")
                    .password("Password!1")
                    .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                    .build()
        }*/

        // Testcontainers
        /*@BeforeClass
        @JvmStatic
        fun setupDataSourceForAllTests() {
            dataSource = DataSourceBuilder.create()
                    .url("jdbc:tc:mssqlserver:2017-GA://localhost:1433;databaseName=master")
                    .username("sa")
                    .password("Password!1")
                    .driverClassName("org.testcontainers.jdbc.ContainerDatabaseDriver")
                    .build()
        }*/
    }

    /*@get:Rule
    val container = KGenericContainer("postgres:10")
            .withLogConsumer(Slf4jLogConsumer(logger))
            .withExposedPorts(5432)
            .withClasspathResourceMapping("init_database.sql", "/docker-entrypoint-initdb.d/001-init_database.sql", BindMode.READ_ONLY)
            .withEnv("POSTGRES_PASSWORD", "postgres")*/

    @Test
    fun givenDatabase_whenQueryDatabase_thenReturnResult() {
        // Given & When
        val result = JdbcTemplate(dataSource).queryForObject("SELECT p.first_name from dbo.person p", String::class.java)
        // Then
        assert(result == "Volodymyr")
    }
}