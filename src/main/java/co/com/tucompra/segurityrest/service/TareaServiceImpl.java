package co.com.tucompra.segurityrest.service;

import co.com.tucompra.segurityrest.domain.*;
import co.com.tucompra.segurityrest.exception.*;
import co.com.tucompra.segurityrest.repository.*;
import co.com.tucompra.segurityrest.utility.Utilities;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.*;

import java.util.*;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service
@Slf4j
public class TareaServiceImpl implements TareaService {
    @Autowired
    private TareaRepository tareaRepository;
    @Autowired
    private Validator validator;

    @Override
    public void validate(Tarea tarea) throws ConstraintViolationException {
        Set<ConstraintViolation<Tarea>> constraintViolations = validator.validate(tarea);

        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return tareaRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tarea> findAll() {
        log.debug("finding all Tarea instances");

        return tareaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Tarea save(Tarea entity) throws Exception {
        log.debug("saving Tarea instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Tarea");
        }

        validate(entity);

        if (tareaRepository.existsById(entity.getCodigo())) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        return tareaRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Tarea entity) throws Exception {
        log.debug("deleting Tarea instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Tarea");
        }

        if (entity.getCodigo() == null) {
            throw new ZMessManager().new EmptyFieldException("codigo");
        }

        if (tareaRepository.existsById(entity.getCodigo()) == false) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        tareaRepository.deleteById(entity.getCodigo());
        log.debug("delete Tarea successful");
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteById(Integer id) throws Exception {
        log.debug("deleting Tarea instance");

        if (id == null) {
            throw new ZMessManager().new EmptyFieldException("codigo");
        }

        if (tareaRepository.existsById(id)) {
            delete(tareaRepository.findById(id).get());
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Tarea update(Tarea entity) throws Exception {
        log.debug("updating Tarea instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Tarea");
        }

        validate(entity);

        if (tareaRepository.existsById(entity.getCodigo()) == false) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        return tareaRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Tarea> findById(Integer codigo) {
        log.debug("getting Tarea instance");

        return tareaRepository.findById(codigo);
    }
}
