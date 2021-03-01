  package Usuario;


import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CarregaBasedados {
	
	  private static final Logger log = LoggerFactory.getLogger(CarregaBasedados.class);

	  @Bean
	  CommandLineRunner initDatabase(RepositorioPessoa repository1, RepositorioVacina repository2) {

	    return args -> {
	      log.info("Preloading " + repository1.save(new Pessoa("Maria", "maria@email.com", 111000111,LocalDate.of(1990, 10, 1) )));
	      log.info("Preloading " + repository1.save(new Pessoa("Joao", "joao@email.com", 111111111,LocalDate.of(1980, 10, 1) )));
	      log.info("Preloading " + repository2.save(new Vacina("Covid", "maria@email.com", LocalDate.of(1990, 10, 1) )));
	      log.info("Preloading " + repository2.save(new Vacina("H1n1", "joao@email.com", LocalDate.of(1980, 10, 1) )));
	    };
	    
	  }
	   
	  	
}
