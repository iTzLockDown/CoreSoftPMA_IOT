package com.PMACORESOFT.coresoft.Dao;

import com.PMACORESOFT.coresoft.Entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
}


