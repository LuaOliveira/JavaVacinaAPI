package Usuario;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
// classe que possui os métodos que processam as requests
@RestController
public class VacinaController {

	private final RepositorioVacina repository;

	VacinaController(RepositorioVacina repository) {
		this.repository = repository;

	}
	
	@GetMapping("/vacinas")
	CollectionModel<EntityModel<Vacina>> all() {

	  List<EntityModel<Vacina>> vacinas = repository.findAll().stream()
	      .map(vacina -> EntityModel.of(vacina,
	          linkTo(methodOn(VacinaController.class).one(vacina.getId())).withSelfRel(),
	          linkTo(methodOn(VacinaController.class).all()).withRel("vacinas")))
	      .collect(Collectors.toList());

	  return CollectionModel.of(vacinas, linkTo(methodOn(VacinaController.class).all()).withSelfRel());
	}

	
	@PostMapping("/vacinas")
	@ResponseStatus(HttpStatus.CREATED)
	Vacina newVacina(@RequestBody Vacina newVacina) {

		return repository.save(newVacina);
	}

	@GetMapping("/vacinas/{id}")
	EntityModel<Vacina> one(@PathVariable Long id) {

		Vacina vacina = repository.findById(id) //
				.orElseThrow(() -> new VacinaNotFoundException(id));

		 return EntityModel.of(vacina, //
			      linkTo(methodOn(PessoaController.class).one(id)).withSelfRel(),
			      linkTo(methodOn(PessoaController.class).all()).withRel("vacinas"));
	}

	@DeleteMapping("/vacinas/{id}")
	void deleteVacina(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
