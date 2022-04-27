package co.com.tucompra.segurityrest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TareaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    private Integer codigo;
    private Long estado;
    private Date fecha;
    private String nombre;
    private Integer codigoLista_Lista;
}
