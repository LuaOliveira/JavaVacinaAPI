package Usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// aplicação
@SpringBootApplication
@ComponentScan("Usuario")
@EnableJpaRepositories("Usuario")
class CadastroUsuarios {
	
	public static void main(String... args) {
	    SpringApplication.run(CadastroUsuarios.class, args);
	}

}
