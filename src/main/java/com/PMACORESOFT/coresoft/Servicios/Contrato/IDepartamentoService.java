package com.PMACORESOFT.coresoft.Servicios.Contrato;

import com.PMACORESOFT.coresoft.Entidades.Departamento;

import java.util.List;

public interface IDepartamentoService {
    public List<Departamento> findAll();
    public Departamento findById(Long id);
    public Departamento save(Departamento oDepartamento);
    public void delete(Long id);
}
