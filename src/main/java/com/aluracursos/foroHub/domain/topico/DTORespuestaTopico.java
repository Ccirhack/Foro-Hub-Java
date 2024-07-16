package com.aluracursos.foroHub.domain.topico;

public record DTORespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        String curso
) {
}
