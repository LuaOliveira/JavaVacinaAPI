package Usuario;
import java.time.LocalDate;

public class CadastroVacina {
	
	public String nome_vacina;
	public String email_usuario;
	public LocalDate data_vacinacao;
	
	public CadastroVacina(String _vacina, String _email, LocalDate _data) {
		this.nome_vacina = _vacina;
		this.email_usuario = _email;
		this.data_vacinacao = _data;
	}

}
