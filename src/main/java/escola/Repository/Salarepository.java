package escola.repository;

import escola.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository: só conversa com o banco. O Spring cria a implementação sozinho.
public interface SalaRepository extends JpaRepository<Sala, Long> {

    // O Spring entende o nome do método e monta a consulta: "existe sala com este código?"
    boolean existsByCodigo(String codigo);
}