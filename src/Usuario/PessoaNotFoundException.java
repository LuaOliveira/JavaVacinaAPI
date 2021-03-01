package Usuario;

public class PessoaNotFoundException extends RuntimeException {

	PessoaNotFoundException(Long id){
		super("Não foi possivel encontrar a pessoa" + id);
	}
}
