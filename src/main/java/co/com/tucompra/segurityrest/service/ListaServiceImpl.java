package  co.com.tucompra.segurityrest.service;


import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import co.com.tucompra.segurityrest.exception.*;
import co.com.tucompra.segurityrest.repository.*;
import co.com.tucompra.segurityrest.utility.Utilities;

import co.com.tucompra.segurityrest.domain.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import lombok.extern.slf4j.Slf4j;

/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org/
* www.zathuracode.org
* 
*/

@Scope("singleton")
@Service
@Slf4j
public class ListaServiceImpl implements ListaService{

	@Autowired
	private ListaRepository listaRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(Lista lista)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<Lista>> constraintViolations =validator.validate(lista);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return listaRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Lista> findAll(){
		log.debug("finding all Lista instances");
       	return listaRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public Lista save(Lista entity) throws Exception {
		log.debug("saving Lista instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("Lista");
		}
		
		validate(entity);	
	
		if(listaRepository.existsById(entity.getCodigoLista())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return listaRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(Lista entity) throws Exception {
            	log.debug("deleting Lista instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("Lista");
	    		}
    	
                                if(entity.getCodigoLista()==null){
                    throw new ZMessManager().new EmptyFieldException("codigoLista");
                    }
                        
            if(listaRepository.existsById(entity.getCodigoLista())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getCodigoLista()).ifPresent(entidad->{	            	
	                													List<Tarea> tareas = entidad.getTareas();
							                    if(Utilities.validationsList(tareas)==true){
                       	 	throw new ZMessManager().new DeletingException("tareas");
                        }
	                	            });
                       

           
            
            listaRepository.deleteById(entity.getCodigoLista());
            log.debug("delete Lista successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting Lista instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("codigoLista");
            	}
            	if(listaRepository.existsById(id)){
           			delete(listaRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public Lista update(Lista entity) throws Exception {

				log.debug("updating Lista instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("Lista");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(listaRepository.existsById(entity.getCodigoLista())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return listaRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<Lista> findById(Integer codigoLista) {            
            	log.debug("getting Lista instance");
            	return listaRepository.findById(codigoLista);
            }
			
}
