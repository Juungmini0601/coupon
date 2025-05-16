package me.jungmini;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

    /**
     * Creates and configures a MySQL test container using the MySQL 8.0.22 Docker image.
     *
     * @return a MySQLContainer instance for integration testing
     */
    @Bean
    @ServiceConnection
    MySQLContainer<?> mysqlContainer() {
        return new MySQLContainer<>(DockerImageName.parse("mysql:8.0.22"));
    }

    /**
     * Creates a Redis test container using the Redis 7.2 Docker image with port 6379 exposed.
     *
     * @return a configured GenericContainer instance for Redis integration testing
     */
    @Bean
    @ServiceConnection(name = "redis")
    GenericContainer<?> redisContainer() {
        return new GenericContainer<>(DockerImageName.parse("redis:7.2")).withExposedPorts(6379);
    }

}
