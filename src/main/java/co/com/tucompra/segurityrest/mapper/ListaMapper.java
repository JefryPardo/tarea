package co.com.tucompra.segurityrest.mapper;

import co.com.tucompra.segurityrest.domain.Lista;
import co.com.tucompra.segurityrest.dto.ListaDTO;

import org.mapstruct.Mapper;

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
public interface ListaMapper {
    
    public ListaDTO listaToListaDTO(Lista lista);

    public Lista listaDTOToLista(ListaDTO listaDTO);

    public List<ListaDTO> listListaToListListaDTO(List<Lista> listas);

    public List<Lista> listListaDTOToListLista(List<ListaDTO> listaDTOs);
}
