package com.PMACORESOFT.coresoft.Entidades;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import static com.PMACORESOFT.coresoft.Util.UtilBD.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name =   IOT_PMA_PROVINCIA )
public class Provincia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "No puede ser vacio.")
    @Column(nullable = false, length = 50)
    private String Nombre;

    @NotNull(message = "El Departamento no puede estar vacio.")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_provincia_departamento_id" )
    private Departamento ProvinciaDepartamento;

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

    public Departamento getProvinciaDepartamento() {
        return ProvinciaDepartamento;
    }

    public void setProvinciaDepartamento(Departamento provinciaDepartamento) {
        ProvinciaDepartamento = provinciaDepartamento;
    }
}
