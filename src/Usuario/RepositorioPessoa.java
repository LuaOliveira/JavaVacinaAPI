package Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// interface � um tipo abstrato que implementa regras as quais a classse deve obedecer. Como se fossem protocolos.
// dom�nio Pessoa e o tipo do id � long
@Repository
public interface RepositorioPessoa extends JpaRepository<Pessoa, Long> {

}