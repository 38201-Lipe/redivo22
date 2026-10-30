package escola.controller;

import escola.model.Sala;
import escola.service.SalaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controller: recebe a requisição, chama a Service e devolve a resposta HTTP.
// Não tem regra de negócio e não usa o Repository.
@RestController
@RequestMapping("/salas")
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @PostMapping
    public ResponseEntity<Sala> cadastrar(@Valid @RequestBody Sala sala) {
        Sala salva = salaService.cadastrar(sala);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva); // 201
    }

    @GetMapping
    public List<Sala> listar() {
        return salaService.listar(); // 200
    }

    @GetMapping("/{id}")
    public Sala buscarPorId(@PathVariable Long id) {
        return salaService.buscarPorId(id); // 200 (ou 404)
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        salaService.excluir(id);
        return ResponseEntity.noContent().build(); // 204
    }

    @PatchMapping("/{id}/reservar")
    public Sala reservar(@PathVariable Long id) {
        return salaService.reservar(id); // 200
    }

    @PatchMapping("/{id}/liberar")
    public Sala liberar(@PathVariable Long id) {
        return salaService.liberar(id); // 200
    }
}