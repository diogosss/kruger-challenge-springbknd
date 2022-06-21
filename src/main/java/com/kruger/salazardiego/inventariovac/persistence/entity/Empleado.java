/*
 * Coded by Diego Salazar for the Kruger CHallenge
 * */

package com.kruger.salazardiego.inventariovac.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name="empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="empleado_id")
    private Integer id_emp;

    @NotNull(message = "Names are required")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Names only accept alphanumeric characters")
    private String nombres;

    @NotNull(message = "Names are required")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Surnames only accept alphanumeric characters")
    private String apellidos;

    @Column(name = "correo", nullable = false)
    @Email(message = "Email not valid")
    @NotBlank
    private String correo;

    @NotNull(message = "age is required")
    //Pattern(regexp = "^[0-9]*$", message = "Id identification only accepts numbers")
    @Min(1111111111L)
    @Max(9999999999L)
    private long cedula;

    private java.sql.Date nacimiento;

    private String direccion;

    private long telefono;

    private boolean estadovac;

    private String tipovac;

    private java.sql.Date fechavacuna;

    private Integer numdosis;

    public Empleado() {
    }

    public Integer getId_emp() {
        return id_emp;
    }

    public void setId_emp(Integer id_emp) {
        this.id_emp = id_emp;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(java.sql.Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public boolean isEstadovac() {
        return estadovac;
    }

    public void setEstadovac(boolean estadovac) {
        this.estadovac = estadovac;
    }

    public String getTipovac() {
        return tipovac;
    }

    public void setTipovac(String tipovac) {
        this.tipovac = tipovac;
    }

    public java.sql.Date getFechavacuna() {
        return fechavacuna;
    }

    public void setFechavacuna(java.sql.Date fechavacuna) {
        this.fechavacuna = fechavacuna;
    }

    public Integer getNumdosis() {
        return numdosis;
    }

    public void setNumdosis(Integer numdosis) {
        this.numdosis = numdosis;
    }
}
