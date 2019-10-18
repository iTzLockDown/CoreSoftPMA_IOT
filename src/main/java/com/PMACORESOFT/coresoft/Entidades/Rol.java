package com.PMACORESOFT.coresoft.Entidades;
import static com.PMACORESOFT.coresoft.Util.UtilBD.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name =   IOT_PMA_ROL )
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, length = 20)
    private String nombre;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
