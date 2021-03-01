package Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// interface é um tipo abstrato que implementa regras as quais a classse deve obedecer. Como se fossem protocolos.
// domínio Pessoa e o tipo do id é long
@Repository
public interface RepositorioPessoa extends JpaRepository<Pessoa, Long> {

}