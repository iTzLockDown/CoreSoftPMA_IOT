package com.PMACORESOFT.coresoft.Servicios.Dominio;

import com.PMACORESOFT.coresoft.Dao.IDispositivoDao;
import com.PMACORESOFT.coresoft.Dao.IDistritoDao;
import com.PMACORESOFT.coresoft.Entidades.Dispositivo;
import com.PMACORESOFT.coresoft.Entidades.Distrito;
import com.PMACORESOFT.coresoft.Servicios.Contrato.IDispositivoService;
import com.PMACORESOFT.coresoft.Servicios.Contrato.IDistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistritoService implements IDistritoService {
    @Autowired
    private IDistritoDao distritoDao;

    @Override
    public List<Distrito> findAll() {
        return (List<Distrito>)distritoDao.findAll();
    }

    @Override
    public Distrito findById(Long id) {
        return distritoDao.findById(id).orElse(null);
    }

    @Override
    public Distrito save(Distrito oDistrito) {
        return distritoDao.save(oDistrito);
    }

    @Override
    public void delete(Long id) {
        distritoDao.deleteById(id);
    }
}
