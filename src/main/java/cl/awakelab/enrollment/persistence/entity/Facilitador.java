package cl.awakelab.enrollment.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "facilitador")
public class Facilitador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String rut;
    private String nombre;
    private String email;
    private String telefono;
    @Column(name = "valorhora")
    private Float valorHora;
    private String banco;
    @Column(name="ctabancaria")
    private String ctaBancaria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Float getValorHora() {
        return valorHora;
    }

    public void setValorHora(Float valorHora) {
        this.valorHora = valorHora;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getCtaBancaria() {
        return ctaBancaria;
    }

    public void setCtaBancaria(String ctaBancaria) {
        this.ctaBancaria = ctaBancaria;
    }
}
