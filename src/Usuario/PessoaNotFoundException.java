package Usuario;

public class PessoaNotFoundException extends RuntimeException {

	PessoaNotFoundException(Long id){
		super("N�o foi possivel encontrar a pessoa" + id);
	}
}
