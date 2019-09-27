package com.PMACORESOFT.coresoft.Servicios.Contrato;

import com.PMACORESOFT.coresoft.Entidades.Dispositivo;
import com.PMACORESOFT.coresoft.Entidades.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> findAll();
    public Usuario findById(Long id);
    public Usuario save(Usuario oUsuario);
    public void delete(Long id);
}
