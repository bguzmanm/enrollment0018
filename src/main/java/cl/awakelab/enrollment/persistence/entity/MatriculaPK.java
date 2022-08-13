package cl.awakelab.enrollment.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class MatriculaPK implements Serializable {

    @Column(name = "id_estudiante")
    private Integer estudianteId;
    @Column(name="id_curso")
    private Integer cursoId;

    public MatriculaPK() {
    }

    public MatriculaPK(Integer estudianteId, Integer cursoId) {
        this.estudianteId = estudianteId;
        this.cursoId = cursoId;
    }

    public Integer getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Integer estudianteId) {
        this.estudianteId = estudianteId;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }
}
