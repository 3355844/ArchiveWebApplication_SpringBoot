package ArchiveWebApplication;

import ArchiveWebApplication.service.ArchiveService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by 33558 on 13.03.2017.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(final ArchiveService service) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                System.out.println("Come to bean Command Line Runner");
            }
        };
    }
}
