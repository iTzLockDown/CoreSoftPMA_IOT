package com.PMACORESOFT.coresoft.Servicios.Contrato;

import com.PMACORESOFT.coresoft.Entidades.Dispositivo;
import com.PMACORESOFT.coresoft.Entidades.Estacion;

import java.util.List;

public interface IEstacionService {
    public List<Estacion> findAll();
    public Estacion findById(Long id);
    public Estacion save(Estacion oEstacion);
    public void delete(Long id);
}
