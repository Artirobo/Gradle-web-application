package spring.gradle.model;


import javax.persistence.*;

/**
 * Created by arti on 8/19/17.
 */

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


//    @NotEmpty(message = "Please enter your username")
    @Column(name ="username")
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
