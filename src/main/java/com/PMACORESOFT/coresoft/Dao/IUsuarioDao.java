package com.PMACORESOFT.coresoft.Dao;

import com.PMACORESOFT.coresoft.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
}


