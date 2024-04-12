package com.libcode.crud.crud.users.controllers;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.libcode.crud.crud.users.repository.UserRepository;
import com.libcode.crud.crud.users.entities.User; // Import the User class
import org.springframework.web.bind.annotation.PathVariable;

// Controlador que maneja las peticiones de la vista list-users.html
@Controller

// Mapeo de la ruta raiz del proyecto 
@RequestMapping("/")

// Clase PageUserController que maneja las peticiones de la vista list-users.html
public class PageUserController {

    @Autowired 
    private UserRepository userRepository; 

    // Metodo que retorna la vista list-users.html 
    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "list-users";
    }

    // Metodo que retorna la vista form-user.html
    @GetMapping("/nuevo")
    public String formularioNuevoUser(Model model) {
        model.addAttribute("usuario", new User());
        return "form-users";
    }

    // Metodo que guarda un nuevo usuario en la base de datos
    @PostMapping("/nuevo")
    public String guardarUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/users";
    }

    // Metodo que edita un usuario de la base de datos
    @GetMapping("/editar/{id}")
    public String formularioEditarUser(Model model, @PathVariable Long id) {
        User usuario = userRepository.findById(id).get();
        model.addAttribute("usuario", usuario);
        return "form-users";
    }

    // Metodo que elimina un usuario de la base de datos
    @GetMapping("/eliminar/{id}")
    public String eliminarUser(@PathVariable Long id) {
        userRepository.delete(new User(id));
        return "redirect:/users";
    }
    
}