package Usuario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


// lida com as exce��es
@ControllerAdvice
public class PessoaNotFoundAdvice {

	 @ResponseBody // vai direto pro response body
	 @ExceptionHandler(PessoaNotFoundException.class) // apenas se a exce��o for lan�ada
	 @ResponseStatus(HttpStatus.NOT_FOUND) // retorna erro 404
	 String employeeNotFoundHandler(PessoaNotFoundException ex) {
	 
		 return ex.getMessage();
	  }
}
