package Usuario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class VacinaNotFoundAdvice {

	 @ResponseBody // vai direto pro response body
	 @ExceptionHandler(VacinaNotFoundException.class) // apenas se a exceção for lançada
	 @ResponseStatus(HttpStatus.NOT_FOUND) // retorna erro 404
	 String vacinaNotFoundHandler(VacinaNotFoundException ex) {
	 
		 return ex.getMessage();
	 }
}
