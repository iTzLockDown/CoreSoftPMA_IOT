package com.PMACORESOFT.coresoft.Entidades;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import static com.PMACORESOFT.coresoft.Util.UtilBD.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name =   IOT_PMA_INFORMACION )
public class Informacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ind;

    @NotEmpty(message = "No puede ser vacio.")
    @Column(nullable = false, length = 20)
    private String  UnidadMedida;

    @NotEmpty(message = "No puede ser vacio")
    @Column(nullable = false, length = 20)
    private String ValorMedida;

    @NotEmpty(message = "No puede ser vacio.")
    private Boolean Estado;


    @NotNull(message = "La estacion no puede estar vacio.")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_informacion_estacion_id" )
    private Estacion EstacionInformacion;

    @NotEmpty(message = "No puede ser vacio.")
    @Column(nullable = false, length = 50)
    private String TipoDispositivo;

    public long getInd() {
        return ind;
    }

    public void setInd(long ind) {
        this.ind = ind;
    }

    public String getUnidadMedida() {
        return UnidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        UnidadMedida = unidadMedida;
    }

    public String getValorMedida() {
        return ValorMedida;
    }

    public void setValorMedida(String valorMedida) {
        ValorMedida = valorMedida;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean estado) {
        Estado = estado;
    }

    public Estacion getEstacionInformacion() {
        return EstacionInformacion;
    }

    public void setEstacionInformacion(Estacion estacionInformacion) {
        EstacionInformacion = estacionInformacion;
    }

    public String getTipoDispositivo() {
        return TipoDispositivo;
    }

    public void setTipoDispositivo(String tipoDispositivo) {
        TipoDispositivo = tipoDispositivo;
    }
}
