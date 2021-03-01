package Usuario;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// classe da aplicacao de cada vacina
@Entity
public class Vacina {
	
		
	public String nome_vacina;
	private @Id @GeneratedValue  Long id;
	public String email_usuario;
	public LocalDate data_vacinacao;
	
	
	public Vacina() {}
		
	public Vacina(String _vacina, String _email, LocalDate _data) {
		
		this.nome_vacina = _vacina;
		this.email_usuario = _email;
		this.data_vacinacao = _data;
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long _id) {
		this.id = _id;
	}

	public String getNome_vacina() {
		return nome_vacina;
	}

	public void setNome_vacina(String _nome_vacina) {
		this.nome_vacina = _nome_vacina;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public void setEmail_usuario(String _email_usuario) {
		this.email_usuario = _email_usuario;
	}

	public LocalDate getData_vacinacao() {
		return data_vacinacao;
	}

	public void setData_vacinacao(LocalDate _data_vacinacao) {
		this.data_vacinacao = _data_vacinacao;
	}
	
	@Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof Vacina))
	      return false;
	    Vacina vacina = (Vacina) o;
	    return Objects.equals(this.id, vacina.id) && Objects.equals(this.nome_vacina, vacina.nome_vacina)
	        && Objects.equals(this.email_usuario, vacina.email_usuario) && Objects.equals(this.data_vacinacao, vacina.data_vacinacao);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id, this.nome_vacina, this.email_usuario, this.data_vacinacao);
	  }

	  @Override
	  public String toString() {
	    return "Vacina{" + "id=" + this.id + ", nome_da_vacina='" + this.nome_vacina + '\'' + ", email_usuario='" + this.email_usuario + '\'' + ", data_de_vacinacao='" + this.data_vacinacao + '\'' + '}';
	  }
	  
}
	