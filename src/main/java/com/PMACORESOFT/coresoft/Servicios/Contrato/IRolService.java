package com.PMACORESOFT.coresoft.Servicios.Contrato;

import com.PMACORESOFT.coresoft.Entidades.Dispositivo;
import com.PMACORESOFT.coresoft.Entidades.Rol;

import java.util.List;

public interface IRolService {
    public List<Rol> findAll();
    public Rol findById(Long id);
    public Rol save(Rol oRol);
    public void delete(Long id);
}
