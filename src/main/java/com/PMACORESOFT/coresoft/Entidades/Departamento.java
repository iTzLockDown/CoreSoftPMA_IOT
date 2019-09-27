package com.PMACORESOFT.coresoft.Entidades;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;

import static com.PMACORESOFT.coresoft.Util.UtilBD.*;

@Entity
@Table(name= IOT_PMA_DEPARTAMENTO)
public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "No puede ser vacio.")
    @Column(nullable = false, length = 50)
    private String NombreDepartamento;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreDepartamento() {
        return NombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        NombreDepartamento = nombreDepartamento;
    }
}
