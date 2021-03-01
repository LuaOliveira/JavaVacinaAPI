package Usuario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


// lida com as exceções
@ControllerAdvice
public class PessoaNotFoundAdvice {

	 @ResponseBody // vai direto pro response body
	 @ExceptionHandler(PessoaNotFoundException.class) // apenas se a exceção for lançada
	 @ResponseStatus(HttpStatus.NOT_FOUND) // retorna erro 404
	 String employeeNotFoundHandler(PessoaNotFoundException ex) {
	 
		 return ex.getMessage();
	  }
}
