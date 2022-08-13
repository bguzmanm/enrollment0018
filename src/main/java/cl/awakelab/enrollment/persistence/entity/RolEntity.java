package cl.awakelab.enrollment.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class RolEntity {

    @Id
    @Column(name="rol_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rolId;
    @Column(length = 50)
    private String rolName;

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }
}
