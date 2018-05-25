package kg.almetico.transport.navigator.repository;

import kg.almetico.transport.navigator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kutu on 4/29/18.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
