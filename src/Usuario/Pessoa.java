package Usuario;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity // Significa que essa classe é também uma entidade, ou seja, e tmbém uma tabela no banco de dados. Cada instancia é uma linha da tabela.
public class Pessoa {

	// atributos
	// 1 passo criar uma classe pessoa em java para recolher os dados da pessoa
	
	private @Id @GeneratedValue  Long id; // generated value diz que o gerenciador dos ids será o provedor de persistencia e não o programador
	private String nome;
	private String email;
	private int cpf;
	private LocalDate data_nascimento;
	
	Pessoa(){}
	//construtor
	public Pessoa(String _nome, String _email, int _cpf, LocalDate _data){
		
		this.nome = _nome;
		this.email = _email;
		this.cpf = _cpf;
		this.data_nascimento = _data;
		
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long _id) {
		this.id = _id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String _nome) {
		this.nome = _nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String _email) {
		this.email = _email;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int _cpf) {
		this.cpf = _cpf;
	}

	public LocalDate getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(LocalDate _data_nascimento) {
		this.data_nascimento = _data_nascimento;
	}
	
	// PRA QUE? 
	@Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof Pessoa))
	      return false;
	    Pessoa pessoa = (Pessoa) o;
	    return Objects.equals(this.id, pessoa.id) && Objects.equals(this.nome, pessoa.nome)
	        && Objects.equals(this.cpf, pessoa.cpf) && Objects.equals(this.data_nascimento, pessoa.data_nascimento);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id, this.nome, this.cpf, this.data_nascimento);
	  }

	  @Override
	  public String toString() {
	    return "Pessoa{" + "id=" + this.id + ", nome='" + this.nome + '\'' + ", email='" + this.email + '\'' + ", cpf='" + this.cpf + '\'' + ", data_nascimento='" + this.data_nascimento + '\'' + '}';
	  }
	
}
