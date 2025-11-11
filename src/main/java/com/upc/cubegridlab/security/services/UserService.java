package com.upc.cubegridlab.security.services;


import com.upc.cubegridlab.entidades.Usuario;
import com.upc.cubegridlab.repositorios.UsuarioRepositorio;
import com.upc.cubegridlab.security.entities.Rol;
import com.upc.cubegridlab.security.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UsuarioRepositorio userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public void grabar(Rol role) {
        role.setCodigo(null);
        roleRepository.save(role);
    }
    public Integer insertUserRol(Integer user_id, Integer rol_id) {
        Integer result = 0;
        userRepository.insertUserRol(user_id, rol_id);
        return 1;
    }
    public List<Rol> listarRol(){
        return roleRepository.findAll();
    }

}
