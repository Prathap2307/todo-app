package io.schultz.dustin.todoapp;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication


 //@ComponentScan(basePackages="io.schultz")
  
//  @EnableJpaRepositories("io.schultz.dustin.todoapp.repository")
  
//  @EnableAutoConfiguration
  
//@EnableJpaRepositories("io.schultz.dustin.todoapp.service")

@EnableAsync
public class TodoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}

	@Configuration

	@EnableWebMvc

	public class CorsConfiguration implements WebMvcConfigurer

	{

		@Override

		public void addCorsMappings(CorsRegistry registry) {

			registry.addMapping("/**")

					.allowedMethods("GET", "POST", "PUT", "DELETE");

		}

	}

	private static final Logger logger = LoggerFactory.getLogger(TodoAppApplication.class);

	@Bean("threadPoolTaskExecutor")
	public TaskExecutor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(20);
		executor.setMaxPoolSize(1000);
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.setThreadNamePrefix("Async-");
		return executor;
	}

	// @Override
	// public void run(String... args) throws Exception {
	// Start the clock
	// long start = System.currentTimeMillis();

	// Kick of multiple, asynchronous lookups
	/*
	 * CompletableFuture<User> page1 =
	 * gitHubLookupService.findUser("PivotalSoftware"); CompletableFuture<User>
	 * page2 = gitHubLookupService.findUser("CloudFoundry"); CompletableFuture<User>
	 * page3 = gitHubLookupService.findUser("Spring-Projects");
	 * CompletableFuture<User> page4 = gitHubLookupService.findUser("RameshMF");
	 */
	// Wait until they are all done
	// CompletableFuture.allOf(page1, page2, page3, page4).join();

	// Print results, including elapsed time
	/*
	 * logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
	 * logger.info("--> " + page1.get()); logger.info("--> " + page2.get());
	 * logger.info("--> " + page3.get()); logger.info("--> " + page4.get());
	 */
	// }

	@Bean
	public CommandLineRunner run(ApplicationContext appContext) {
		return args -> {

			String[] beans = appContext.getBeanDefinitionNames();
			Arrays.stream(beans).sorted().forEach(System.out::println);

		};
	}


}
