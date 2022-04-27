package co.com.tucompra.segurityrest.domain;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org/
* www.zathuracode.org
* 
*/
@Entity
@Table ( name="lista", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lista implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="codigo_lista", unique=true, nullable=false)
		@NotNull
		private Integer codigoLista;
		
	
	    
					@Column(name="estado"   )
		private Long estado;	
    				@Column(name="nombre"   )
		private String nombre;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="lista")
		private List<Tarea> tareas = new ArrayList<>();	
        
}	