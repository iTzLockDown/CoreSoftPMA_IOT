package com.PMACORESOFT.coresoft.Servicios.Dominio;

import com.PMACORESOFT.coresoft.Dao.IEstacionDao;
import com.PMACORESOFT.coresoft.Entidades.Estacion;
import com.PMACORESOFT.coresoft.Servicios.Contrato.IEstacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstacionService implements IEstacionService {
    @Autowired
    private IEstacionDao estacionDao;

    @Override
    public List<Estacion> findAll() {
        return (List<Estacion>)estacionDao.findAll();
    }

    @Override
    public Estacion findById(Long id) {
        return estacionDao.findById(id).orElse(null);
    }

    @Override
    public Estacion save(Estacion oEstacion) {
        return estacionDao.save(oEstacion);
    }

    @Override
    public void delete(Long id) {
        estacionDao.deleteById(id);
    }
}
