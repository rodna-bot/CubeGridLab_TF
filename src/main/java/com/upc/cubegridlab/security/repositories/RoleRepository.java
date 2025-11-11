package com.upc.cubegridlab.security.repositories;
import com.upc.cubegridlab.security.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Rol, Integer> {
}
