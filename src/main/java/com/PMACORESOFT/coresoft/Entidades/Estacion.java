package com.PMACORESOFT.coresoft.Entidades;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import static com.PMACORESOFT.coresoft.Util.UtilBD.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name =   IOT_PMA_ESTACION )
public class Estacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty(message = "No puede ser vacio.")
    @Column(nullable = false, length = 50)
    private String Nombre;
    @NotEmpty(message = "No puede ser vacio.")
    private Boolean Estado;

    private String Localidad;
/*    @NotNull(message = "El Distrito no puede estar vacio.")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_estado_distrito_id" )
    private Distrito EstacionDistrito;*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String localidad) {
        Localidad = localidad;
    }
/*    public Distrito getEstacionDistrito() {
        return EstacionDistrito;
    }

    public void setEstacionDistrito(Distrito estacionDistrito) {
        EstacionDistrito = estacionDistrito;
    }*/
}
