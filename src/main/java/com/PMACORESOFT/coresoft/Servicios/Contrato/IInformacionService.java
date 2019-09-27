package com.PMACORESOFT.coresoft.Servicios.Contrato;

import com.PMACORESOFT.coresoft.Entidades.Dispositivo;
import com.PMACORESOFT.coresoft.Entidades.Informacion;

import java.util.List;

public interface IInformacionService {
    public List<Informacion> findAll();
    public Informacion findById(Long id);
    public Informacion save(Informacion oInformacion);
    public void delete(Long id);
}
