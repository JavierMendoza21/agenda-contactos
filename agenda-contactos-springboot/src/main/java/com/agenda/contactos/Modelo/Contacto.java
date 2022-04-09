package com.agenda.contactos.Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.validation.constraints.*;
import javax.persistence.*;

@Entity
public class Contacto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	@NotBlank(message = "Debe ingresar su nombre")
	private String nombre;

	@NotEmpty(message = "Debe ingresar su email")
	@Email
	private String Email;

	@NotBlank(message = "Debe ingresar su celular")
	private String Celular;

	@DateTimeFormat(iso = ISO.DATE)
	@Past
	@NotNull(message = "Debe ingresar su fecha de nacimiento")
	private LocalDate FechaNacimiento;

	private LocalDateTime FechaRegistro;

	@PrePersist
	public void asignarFechaRegistro() {
		FechaRegistro=LocalDateTime.now();
	}
	
	
	public Contacto() {
		super();
	}

	public Contacto(Integer id, String nombre, String email, String celular, LocalDate fechaNacimiento,
			LocalDateTime fechaRegistro) {
		super();
		Id = id;
		this.nombre = nombre;
		Email = email;
		Celular = celular;
		FechaNacimiento = fechaNacimiento;
		FechaRegistro = fechaRegistro;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getCelular() {
		return Celular;
	}

	public void setCelular(String celular) {
		Celular = celular;
	}

	public LocalDate getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	public LocalDateTime getFechaRegistro() {
		return FechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}

}
