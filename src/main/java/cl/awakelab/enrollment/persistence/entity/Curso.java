package cl.awakelab.enrollment.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codigo;
    private String nombre;

    @Column(name = "id_facilitador")
    private Integer facilitadorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_facilitador", insertable = false, updatable = false)
    private Facilitador facilitador;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFacilitadorId() {
        return facilitadorId;
    }

    public void setFacilitadorId(Integer facilitadorId) {
        this.facilitadorId = facilitadorId;
    }

    public Facilitador getFacilitador() {
        return facilitador;
    }

    public void setFacilitador(Facilitador facilitador) {
        this.facilitador = facilitador;
    }
}
