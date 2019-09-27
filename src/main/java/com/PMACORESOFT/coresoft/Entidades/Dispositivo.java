package com.PMACORESOFT.coresoft.Entidades;

import static com.PMACORESOFT.coresoft.Util.UtilBD.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name =   IOT_PMA_DISPOSITIVO )
public class Dispositivo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty(message = "No puede ser vacio.")
    @Size(min = 4, max = 30, message = "Tiene que ser mayor de 4 caracteres")
    @Column(nullable = false, length = 30)
    private String Nombre;
    @NotEmpty(message = "No puede ser vacio.")
    private Boolean Estado;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean estado) {
        Estado = estado;
    }
}
