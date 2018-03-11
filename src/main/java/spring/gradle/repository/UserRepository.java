package spring.gradle.repository;

import spring.gradle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by arti on 8/19/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query("update User u set u.username=?1 where u.id = ?2")
    public void setUpdatebyId(String user,Long id);


}


