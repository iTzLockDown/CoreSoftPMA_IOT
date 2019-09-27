package com.PMACORESOFT.coresoft.Servicios.Dominio;

import com.PMACORESOFT.coresoft.Dao.IUsuarioDao;
import com.PMACORESOFT.coresoft.Entidades.Usuario;
import com.PMACORESOFT.coresoft.Servicios.Contrato.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>)usuarioDao.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario oUsuario) {
        return usuarioDao.save(oUsuario);
    }

    @Override
    public void delete(Long id) {
        usuarioDao.deleteById(id);
    }
}
