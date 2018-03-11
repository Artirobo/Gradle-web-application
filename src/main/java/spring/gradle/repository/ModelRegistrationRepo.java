package spring.gradle.repository;


import spring.gradle.model.ModelRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by arti on 10/26/17.
 */
public interface ModelRegistrationRepo extends JpaRepository<ModelRegistration,Long> {
}
