package me.jungmini;

import org.springframework.boot.SpringApplication;

public class TestCouponApplication {

    /**
     * Launches the application with the test container configuration.
     *
     * Initializes the Spring application context using the main method of {@code CouponApplication},
     * adds {@code TestcontainersConfiguration} to the context, and runs the application with the provided arguments.
     *
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.from(CouponApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
