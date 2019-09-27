package com.PMACORESOFT.coresoft.Servicios.Dominio;

import com.PMACORESOFT.coresoft.Dao.IProvinciaDao;
import com.PMACORESOFT.coresoft.Entidades.Provincia;
import com.PMACORESOFT.coresoft.Servicios.Contrato.IProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaService implements IProvinciaService {

    @Autowired
    private IProvinciaDao provinciaDao;

    @Override
    public List<Provincia> findAll() {
        return (List<Provincia>)provinciaDao.findAll();
    }

    @Override
    public Provincia findById(Long id) {
        return provinciaDao.findById(id).orElse(null);
    }

    @Override
    public Provincia save(Provincia oProvincia) {
        return provinciaDao.save(oProvincia);
    }

    @Override
    public void delete(Long id) {
        provinciaDao.deleteById(id);
    }
}
