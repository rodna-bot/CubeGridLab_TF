package com.upc.cubegridlab.repositorios;

import com.upc.cubegridlab.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    //Lógica para la seguridad y tockens
    Optional<Usuario> findByUsername(String username);
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO usuarios_roles (codigo_usuario, codigo_rol ) VALUES (:user_id, :rol_id)", nativeQuery = true)
    public Integer insertUserRol(@Param("user_id") Integer user_id, @Param("rol_id") Integer rol_id);
}
