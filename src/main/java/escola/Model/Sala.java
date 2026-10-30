package escola.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

// Model: representa os dados de uma sala (e a tabela "sala" no banco).
@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O código é obrigatório")
    @Column(nullable = false, unique = true)
    private String codigo;

    @NotBlank(message = "O nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    @NotNull(message = "A capacidade é obrigatória")
    @Positive(message = "A capacidade deve ser maior que zero")
    @Column(nullable = false)
    private Integer capacidade;

    // Toda sala começa livre (reservada = false)
    private boolean reservada = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isReservada() {
        return reservada;
    }

    public void setReservada(boolean reservada) {
        this.reservada = reservada;
    }
}