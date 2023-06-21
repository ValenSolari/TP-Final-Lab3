package com.example.demo4.Clases;

public class Empleado extends Persona {
    private Integer salario;
    private Integer horasDeTrabajo;
    private Rol rol;
    private String fechaContratacion;

    ///region Constructor

    public Empleado(String dni, String nombre, String apellido, Integer edad, String direccion, String email,
                    Integer salario, Integer horasDeTrabajo, Rol rol, String fechaContratacion) {
        super(dni, nombre, apellido, edad, direccion, email);
        this.salario = salario;
        this.horasDeTrabajo = horasDeTrabajo;
        this.rol = rol;
        this.fechaContratacion = fechaContratacion;
    }

    public Empleado() {
    }
    ///endregion

    ///region Get and set

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public Integer getHorasDeTrabajo() {
        return horasDeTrabajo;
    }

    public void setHorasDeTrabajo(Integer horasDeTrabajo) {
        this.horasDeTrabajo = horasDeTrabajo;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
    ///endregion

    ///region Metodos
    @Override
    public String toString() {
        return "Empleado{" +
                "salario=" + salario +
                ", horasDeTrabajo=" + horasDeTrabajo +
                ", rol=" + rol +
                ", fechaContratacion='" + fechaContratacion + '\'' +
                "} " + super.toString();
    }

    ///endregion
}
