package co.com.tucompra.segurityrest.controller;

import co.com.tucompra.segurityrest.domain.*;
import co.com.tucompra.segurityrest.dto.TareaDTO;
import co.com.tucompra.segurityrest.mapper.TareaMapper;
import co.com.tucompra.segurityrest.service.TareaService;

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
@RequestMapping("/api/v1/tarea")
@CrossOrigin(origins = "*")
@Slf4j
public class TareaRestController {
    @Autowired
    private TareaService tareaService;
    @Autowired
    private TareaMapper tareaMapper;

    @GetMapping(value = "/{codigo}")
    public ResponseEntity<?> findById(@PathVariable("codigo")
    Integer codigo) throws Exception {
        log.debug("Request to findById() Tarea");

        Tarea tarea = (tareaService.findById(codigo).isPresent() == true)
            ? tareaService.findById(codigo).get() : null;

        return ResponseEntity.ok().body(tareaMapper.tareaToTareaDTO(tarea));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() Tarea");

        return ResponseEntity.ok()
                             .body(tareaMapper.listTareaToListTareaDTO(
                tareaService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid
    @RequestBody
    TareaDTO tareaDTO) throws Exception {
        log.debug("Request to save Tarea: {}", tareaDTO);

        Tarea tarea = tareaMapper.tareaDTOToTarea(tareaDTO);
        tarea = tareaService.save(tarea);

        return ResponseEntity.ok().body(tareaMapper.tareaToTareaDTO(tarea));
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid
    @RequestBody
    TareaDTO tareaDTO) throws Exception {
        log.debug("Request to update Tarea: {}", tareaDTO);

        Tarea tarea = tareaMapper.tareaDTOToTarea(tareaDTO);
        tarea = tareaService.update(tarea);

        return ResponseEntity.ok().body(tareaMapper.tareaToTareaDTO(tarea));
    }

    @DeleteMapping(value = "/{codigo}")
    public ResponseEntity<?> delete(@PathVariable("codigo")
    Integer codigo) throws Exception {
        log.debug("Request to delete Tarea");

        tareaService.deleteById(codigo);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(tareaService.count());
    }
}
