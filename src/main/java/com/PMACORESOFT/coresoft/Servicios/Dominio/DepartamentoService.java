package com.PMACORESOFT.coresoft.Servicios.Dominio;

import com.PMACORESOFT.coresoft.Dao.IDepartamentoDao;
import com.PMACORESOFT.coresoft.Entidades.Departamento;
import com.PMACORESOFT.coresoft.Servicios.Contrato.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService implements IDepartamentoService {

    @Autowired
    private IDepartamentoDao departamentoDao;

    @Override
    public List<Departamento> findAll() {
        return (List<Departamento>)departamentoDao.findAll();
    }

    @Override
    public Departamento findById(Long id) {
        return departamentoDao.findById(id).orElse(null);
    }

    @Override
    public Departamento save(Departamento oDepartamento) {
        return departamentoDao.save(oDepartamento);
    }

    @Override
    public void delete(Long id) {
        departamentoDao.deleteById(id);
    }
}
