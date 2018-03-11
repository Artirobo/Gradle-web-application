package spring.gradle.model;


import javax.persistence.*;

/**
 * Created by arti on 9/1/17.
 */

@Entity
@Table(name ="roleusers")
public class RoleTableLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @JoinColumn(name = "user_role_id", referencedColumnName = "id")
    @ManyToOne
    private  USerTableLogin userid;


    @Column(name = "role")
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public USerTableLogin getUserid() {
        return userid;
    }

    public void setUserid(USerTableLogin userid) {
        this.userid = userid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
