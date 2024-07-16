package com.aluracursos.foroHub.controller;

import com.aluracursos.foroHub.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DTORespuestaTopico> registrarTopico(@RequestBody @Valid DTORegistroTopico dtoRegistroTopico,
                                                              UriComponentsBuilder uriComponentsBuilder) {

        Topico topico = topicoRepository.save(new Topico(dtoRegistroTopico));
        DTORespuestaTopico dtoRespuestaTopico = new DTORespuestaTopico(topico.getId(),
                topico.getTitulo(), topico.getMensaje(), topico.getCurso());

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(dtoRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DTOListadoTopico>> listadoTopico(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DTOListadoTopico::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DTOActualizarTopico dtoActualizarTopico) {
        Topico topico = topicoRepository.getReferenceById(dtoActualizarTopico.id());
        topico.actualizarDatos(dtoActualizarTopico);
        return ResponseEntity.ok(new DTORespuestaTopico(topico.getId(),
                topico.getTitulo(), topico.getMensaje(), topico.getCurso()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }

    //Buscar tópico con id
    @GetMapping("/{id}")
    public ResponseEntity<DTORespuestaTopico> retornarDatosTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DTORespuestaTopico(topico.getId(),
                topico.getTitulo(), topico.getMensaje(), topico.getCurso());
        return ResponseEntity.ok(datosTopico);
    }
}
