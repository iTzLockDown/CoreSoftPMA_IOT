package com.PMACORESOFT.coresoft.Servicios.Dominio;

import com.PMACORESOFT.coresoft.Dao.IInformacionDao;
import com.PMACORESOFT.coresoft.Entidades.Informacion;
import com.PMACORESOFT.coresoft.Servicios.Contrato.IInformacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformacionService implements IInformacionService {

    @Autowired
    private IInformacionDao informacionDao;

    @Override
    public List<Informacion> findAll() {
        return (List<Informacion>)informacionDao.findAll();
    }

    @Override
    public Informacion findById(Long id) {
        return informacionDao.findById(id).orElse(null);
    }

    @Override
    public Informacion save(Informacion oInformacion) {
        return informacionDao.save(oInformacion);
    }

    @Override
    public void delete(Long id) {
        informacionDao.deleteById(id);
    }
}
