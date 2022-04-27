package co.com.tucompra.segurityrest.controller;

import co.com.tucompra.segurityrest.domain.*;
import co.com.tucompra.segurityrest.dto.ListaDTO;
import co.com.tucompra.segurityrest.mapper.ListaMapper;
import co.com.tucompra.segurityrest.service.ListaService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@RestController
@RequestMapping("/api/v1/lista")
@CrossOrigin(origins = "*")
@Slf4j
public class ListaRestController {
    @Autowired
    private ListaService listaService;
    @Autowired
    private ListaMapper listaMapper;

    @GetMapping(value = "/{codigoLista}")
    public ResponseEntity<?> findById(
        @PathVariable("codigoLista")
    Integer codigoLista) throws Exception {
        log.debug("Request to findById() Lista");

        Lista lista = (listaService.findById(codigoLista).isPresent() == true)
            ? listaService.findById(codigoLista).get() : null;

        return ResponseEntity.ok().body(listaMapper.listaToListaDTO(lista));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() Lista");

        return ResponseEntity.ok()
                             .body(listaMapper.listListaToListListaDTO(
                listaService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid
    @RequestBody
    ListaDTO listaDTO) throws Exception {
        log.debug("Request to save Lista: {}", listaDTO);

        Lista lista = listaMapper.listaDTOToLista(listaDTO);
        lista = listaService.save(lista);

        return ResponseEntity.ok().body(listaMapper.listaToListaDTO(lista));
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid
    @RequestBody
    ListaDTO listaDTO) throws Exception {
        log.debug("Request to update Lista: {}", listaDTO);

        Lista lista = listaMapper.listaDTOToLista(listaDTO);
        lista = listaService.update(lista);

        return ResponseEntity.ok().body(listaMapper.listaToListaDTO(lista));
    }

    @DeleteMapping(value = "/{codigoLista}")
    public ResponseEntity<?> delete(
        @PathVariable("codigoLista")
    Integer codigoLista) throws Exception {
        log.debug("Request to delete Lista");

        listaService.deleteById(codigoLista);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(listaService.count());
    }
}
