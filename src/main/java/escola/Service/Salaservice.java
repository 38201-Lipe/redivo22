package escola.service;

import escola.model.Sala;
import escola.repository.SalaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

// Service: aqui ficam TODAS as regras da escola.
@Service
public class SalaService {

    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public Sala cadastrar(Sala sala) {
        // Regra: o código é único
        if (salaRepository.existsByCodigo(sala.getCodigo())) {
            throw new ConflitoException("Já existe uma sala com o código " + sala.getCodigo());
        }
        sala.setId(null);          // o id é sempre gerado pelo banco
        sala.setReservada(false);  // regra: toda sala começa livre
        return salaRepository.save(sala);
    }

    public List<Sala> listar() {
        return salaRepository.findAll();
    }

    public Sala buscarPorId(Long id) {
        // Regra: sala que não existe é "não encontrada"
        return salaRepository.findById(id)
                .orElseThrow(() -> new SalaNaoEncontradaException(id));
    }

    public void excluir(Long id) {
        Sala sala = buscarPorId(id);
        // Regra: sala reservada não pode ser excluída
        if (sala.isReservada()) {
            throw new ConflitoException("Não é possível excluir uma sala reservada");
        }
        salaRepository.delete(sala);
    }

    public Sala reservar(Long id) {
        Sala sala = buscarPorId(id);
        // Regra: não reservar uma sala já reservada
        if (sala.isReservada()) {
            throw new ConflitoException("A sala já está reservada");
        }
        sala.setReservada(true);
        return salaRepository.save(sala);
    }

    public Sala liberar(Long id) {
        Sala sala = buscarPorId(id);
        // Regra: só libera sala que está reservada
        if (!sala.isReservada()) {
            throw new ConflitoException("A sala já está livre");
        }
        sala.setReservada(false);
        return salaRepository.save(sala);
    }
}