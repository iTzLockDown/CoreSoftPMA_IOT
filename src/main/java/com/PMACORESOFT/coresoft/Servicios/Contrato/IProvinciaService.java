package com.PMACORESOFT.coresoft.Servicios.Contrato;

import com.PMACORESOFT.coresoft.Entidades.Dispositivo;
import com.PMACORESOFT.coresoft.Entidades.Provincia;

import java.util.List;

public interface IProvinciaService {
    public List<Provincia> findAll();
    public Provincia findById(Long id);
    public Provincia save(Provincia oProvincia);
    public void delete(Long id);
}
