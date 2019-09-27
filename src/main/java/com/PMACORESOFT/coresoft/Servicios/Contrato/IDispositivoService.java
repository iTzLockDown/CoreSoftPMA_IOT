package com.PMACORESOFT.coresoft.Servicios.Contrato;

import com.PMACORESOFT.coresoft.Entidades.Departamento;
import com.PMACORESOFT.coresoft.Entidades.Dispositivo;

import java.util.List;

public interface IDispositivoService {
    public List<Dispositivo> findAll();
    public Dispositivo findById(Long id);
    public Dispositivo save(Dispositivo oDispositivo);
    public void delete(Long id);
}
