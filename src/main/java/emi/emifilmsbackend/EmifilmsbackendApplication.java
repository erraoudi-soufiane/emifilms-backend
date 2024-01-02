package emi.emifilmsbackend;

import emi.emifilmsbackend.model.Comment;
import emi.emifilmsbackend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@SpringBootApplication
public class EmifilmsbackendApplication implements CommandLineRunner {
	@Autowired
	private CommentRepository commentRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmifilmsbackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		commentRepository.save(new Comment(null, 848326L, "soufiane ER RAOUDI", "I like this movie"));
		commentRepository.save(new Comment(null, 848326L, "Anas DRIOUACH", "I like this movie too"));
		commentRepository.save(new Comment(null, 848326L, "Hamza lemales", "I like this movie"));
		commentRepository.save(new Comment(null, 114L, "Lamia JBIRA", "I like this movie"));
		commentRepository.save(new Comment(null, 115L, "Anwar Adil", "I like this movie"));

		System.out.println(commentRepository.findByMovieId(848326L));
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:4200")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
						.allowedHeaders("*");
			}
		};
	}
}
