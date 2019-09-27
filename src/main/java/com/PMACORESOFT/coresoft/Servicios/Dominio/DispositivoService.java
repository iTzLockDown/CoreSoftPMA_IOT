package com.PMACORESOFT.coresoft.Servicios.Dominio;

import com.PMACORESOFT.coresoft.Dao.IDispositivoDao;
import com.PMACORESOFT.coresoft.Entidades.Dispositivo;
import com.PMACORESOFT.coresoft.Servicios.Contrato.IDispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispositivoService implements IDispositivoService {
    @Autowired
    private IDispositivoDao dispositivoDao;

    @Override
    public List<Dispositivo> findAll() {
        return (List<Dispositivo>)dispositivoDao.findAll();
    }

    @Override
    public Dispositivo findById(Long id) {
        return dispositivoDao.findById(id).orElse(null);

    }


    @Override
    public Dispositivo save(Dispositivo oDispositivo) {
        return dispositivoDao.save(oDispositivo);
    }

    @Override
    public void delete(Long id) {
        dispositivoDao.deleteById(id);
    }
}
