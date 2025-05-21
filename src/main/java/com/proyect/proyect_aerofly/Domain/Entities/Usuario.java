package com.proyect.proyect_aerofly.Domain.Entities;

public class Usuario {

    private Long id;
    private String username;
    private String password;
    private Rol rol;

    public Usuario(Long id, String username, String password, Rol rol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    // Getters
    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public Rol getRol() { return rol; }

    // Cambiar contraseña
    public void cambiarPassword(String nuevaPassword) {
        this.password = nuevaPassword;
    }
}
