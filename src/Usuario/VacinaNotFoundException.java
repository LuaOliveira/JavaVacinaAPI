package Usuario;

public class VacinaNotFoundException extends RuntimeException {

	VacinaNotFoundException(Long id){
		super("N�o foi possivel encontrar a vacina" + id);
	}
}
