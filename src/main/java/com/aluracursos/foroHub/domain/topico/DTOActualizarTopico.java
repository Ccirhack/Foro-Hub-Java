package com.aluracursos.foroHub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DTOActualizarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        String curso
) {
}
