package spring.gradle.repository;

import spring.gradle.model.USerTableLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by arti on 9/3/17.
 */
public interface UserloginRepo extends JpaRepository<USerTableLogin, Long> {
    @Query("select c from USerTableLogin c where c.username=?1")
    public USerTableLogin getbyUSername(String username);
}
