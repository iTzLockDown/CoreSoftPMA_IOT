package com.PMACORESOFT.coresoft.Servicios.Dominio;

import com.PMACORESOFT.coresoft.Dao.IRolDao;
import com.PMACORESOFT.coresoft.Entidades.Rol;
import com.PMACORESOFT.coresoft.Servicios.Contrato.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService implements IRolService {
    @Autowired
    private IRolDao rolDao;

    @Override
    public List<Rol> findAll() {
        return (List<Rol>)rolDao.findAll();
    }

    @Override
    public Rol findById(Long id) {
        return rolDao.findById(id).orElse(null);
    }

    @Override
    public Rol save(Rol oRol) {
        return rolDao.save(oRol);
    }

    @Override
    public void delete(Long id) {
        rolDao.deleteById(id);
    }
}
