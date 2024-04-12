package com.libcode.crud.crud.users.repository;

// Importacion de la clase User
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.libcode.crud.crud.users.entities.User;

// Interfaz que extiende de JpaRepository para realizar las operaciones CRUD de la clase User
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
