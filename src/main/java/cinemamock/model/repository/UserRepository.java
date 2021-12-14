package cinemamock.model.repository;

import cinemamock.model.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
    User findByEmail(String email);
}