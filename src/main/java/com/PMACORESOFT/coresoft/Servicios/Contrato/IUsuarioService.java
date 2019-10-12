package com.PMACORESOFT.coresoft.Servicios.Contrato;

import com.PMACORESOFT.coresoft.Entidades.Dispositivo;
import com.PMACORESOFT.coresoft.Entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> findAll();
    public Page<Usuario> findAll(Pageable pageable);
    public Usuario findById(Long id);
    public Usuario save(Usuario oUsuario);
    public void delete(Long id);
}
