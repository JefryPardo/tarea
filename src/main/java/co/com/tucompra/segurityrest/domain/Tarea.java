package co.com.tucompra.segurityrest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "tarea", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarea implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "codigo", unique = true, nullable = false)
    @NotNull
    private Integer codigo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_lista")
    @NotNull
    private Lista lista;
    @Column(name = "estado")
    private Long estado;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "nombre")
    private String nombre;
}
