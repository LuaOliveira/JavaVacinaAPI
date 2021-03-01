package Usuario;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {

	private final RepositorioPessoa repository;
	
	PessoaController(RepositorioPessoa repository){
		this.repository = repository;
				
	}
	
	
	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/pessoas")
	List<Pessoa> all() {
		
		return repository.findAll();
	
	 }
	// end::get-aggregate-root[]
	
	@PostMapping("/pessoas")
	Pessoa newPessoa(@RequestBody Pessoa newPessoa) {
		
	    return repository.save(newPessoa);
	}
	
	// Single item
	  
	@GetMapping("/pessoas/{id}")
	Pessoa one(@PathVariable Long id) {
	    //quando a pessoa não é encontrada
	    return repository.findById(id)
	      .orElseThrow(() -> new PessoaNotFoundException(id));
	}
	
	@PutMapping("/pessoas/{id}")
	 Pessoa replacePessoa(@RequestBody Pessoa newPessoa, @PathVariable Long id) {
	    
	    return repository.findById(id)
	      .map(pessoa -> {
	        pessoa.setNome(newPessoa.getNome());
	        pessoa.setCpf(newPessoa.getCpf());
	        return repository.save(pessoa);
	      })
	      .orElseGet(() -> {
	        newPessoa.setId(id);
	        return repository.save(newPessoa);
	      });
	  }
	
	@DeleteMapping("/pessoas/{id}")
	  void deletePessoa(@PathVariable Long id) {
	    repository.deleteById(id);
	  }
	
	
	
	
	
	
}
