package Usuario;

public class VacinaNotFoundException extends RuntimeException {

	VacinaNotFoundException(Long id){
		super("Não foi possivel encontrar a vacina" + id);
	}
}
