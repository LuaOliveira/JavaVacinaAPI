package Usuario;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class PessoaController {

	private final RepositorioPessoa repository;

	PessoaController(RepositorioPessoa repository) {
		this.repository = repository;

	}

	// Aggregate root
	// tag::get-aggregate-root[]
	
	/*
	 * @GetMapping("/pessoas") List<Pessoa> all() {
	 * 
	 * return repository.findAll();
	 * 
	 * }
	 */
	  
	  // end::get-aggregate-root[]
	 

	
	  @GetMapping("/pessoas") CollectionModel<EntityModel<Pessoa>> all() {
	  
	  List<EntityModel<Pessoa>> pessoas = repository.findAll().stream() .map(pessoa
	  -> EntityModel.of(pessoa,
	  linkTo(methodOn(PessoaController.class).one(pessoa.getId())).withSelfRel(),
	  linkTo(methodOn(PessoaController.class).all()).withRel("pessoa")))
	  .collect(Collectors.toList());
	  
	  return CollectionModel.of(pessoas,
	  linkTo(methodOn(PessoaController.class).all()).withSelfRel()); }
	 

	@PostMapping("/pessoas")
	Pessoa newPessoa(@RequestBody Pessoa newPessoa) {

		return repository.save(newPessoa);
	}
	// 1º getmapping pessoas
	// Single item
	/*
	 * @GetMapping("/pessoas/{id}") Pessoa one(@PathVariable Long id) { //quando a
	 * pessoa não é encontrada return repository.findById(id) .orElseThrow(() -> new
	 * PessoaNotFoundException(id)); }
	 */

	@GetMapping("/pessoas/{id}")
	EntityModel<Pessoa> one(@PathVariable Long id) {

		Pessoa pessoa = repository.findById(id) //
				.orElseThrow(() -> new PessoaNotFoundException(id));

		return EntityModel.of(pessoa, //
				linkTo(methodOn(PessoaController.class).one(id)).withSelfRel(),
				linkTo(methodOn(PessoaController.class).all()).withRel("pessoas"));
	}

	@PutMapping("/pessoas/{id}")
	Pessoa replacePessoa(@RequestBody Pessoa newPessoa, @PathVariable Long id) {

		return repository.findById(id).map(pessoa -> {
			pessoa.setNome(newPessoa.getNome());
			pessoa.setCpf(newPessoa.getCpf());
			return repository.save(pessoa);
		}).orElseGet(() -> {
			newPessoa.setId(id);
			return repository.save(newPessoa);
		});
	}

	@DeleteMapping("/pessoas/{id}")
	void deletePessoa(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
