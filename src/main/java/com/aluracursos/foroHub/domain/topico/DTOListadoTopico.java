package com.aluracursos.foroHub.domain.topico;

public record DTOListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        String curso
) {
    public DTOListadoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getCurso());
    }
}
