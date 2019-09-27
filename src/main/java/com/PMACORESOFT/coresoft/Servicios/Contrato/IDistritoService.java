package com.PMACORESOFT.coresoft.Servicios.Contrato;

import com.PMACORESOFT.coresoft.Entidades.Dispositivo;
import com.PMACORESOFT.coresoft.Entidades.Distrito;

import java.util.List;

public interface IDistritoService {
    public List<Distrito> findAll();
    public Distrito findById(Long id);
    public Distrito save(Distrito oDistrito);
    public void delete(Long id);
}
