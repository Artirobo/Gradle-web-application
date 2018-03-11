package spring.gradle.repository;

import spring.gradle.model.RoleTableLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by arti on 9/3/17.
 */
public interface RoleLoginRepo extends JpaRepository<RoleTableLogin,Long> {

    @Query("select  c from RoleTableLogin c where c.userid.id=?1 ")
    public RoleTableLogin retriveById(Long id);
}
