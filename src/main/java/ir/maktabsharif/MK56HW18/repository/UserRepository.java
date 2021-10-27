package ir.maktabsharif.MK56HW18.repository;

import ir.maktabsharif.MK56HW18.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
