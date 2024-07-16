package com.aluracursos.foroHub.domain.topico;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Topico")
@Table(name = "topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String curso;

    public Topico(DTORegistroTopico dtoRegistroTopico) {
        this.titulo = dtoRegistroTopico.titulo();
        this.mensaje = dtoRegistroTopico.mensaje();
        this.curso = dtoRegistroTopico.nombreCurso();
    }

    public void actualizarDatos(DTOActualizarTopico dtoActualizarTopico) {
        if (dtoActualizarTopico.titulo() != null) {
            this.titulo = dtoActualizarTopico.titulo();
        }
        if (dtoActualizarTopico.mensaje() != null) {
            this.mensaje = dtoActualizarTopico.mensaje();
        }
        if (dtoActualizarTopico.curso() != null) {
            this.curso = dtoActualizarTopico.curso();
        }
    }
}
