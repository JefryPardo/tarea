package co.com.tucompra.segurityrest.mapper;

import co.com.tucompra.segurityrest.domain.Tarea;
import co.com.tucompra.segurityrest.dto.TareaDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
* Mapper Build with MapStruct https://mapstruct.org
* MapStruct is a code generator that greatly simplifies the
* implementation of mappings between Java bean type
* based on a convention over configuration approach.
*/
@Mapper
public interface TareaMapper {
    @Mapping(source = "lista.codigoLista", target = "codigoLista_Lista")
    public TareaDTO tareaToTareaDTO(Tarea tarea);

    @Mapping(source = "codigoLista_Lista", target = "lista.codigoLista")
    public Tarea tareaDTOToTarea(TareaDTO tareaDTO);

    public List<TareaDTO> listTareaToListTareaDTO(List<Tarea> tareas);

    public List<Tarea> listTareaDTOToListTarea(List<TareaDTO> tareaDTOs);
}