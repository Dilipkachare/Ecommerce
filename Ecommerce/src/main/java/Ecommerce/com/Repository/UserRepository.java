package Ecommerce.com.Repository;

import Ecommerce.com.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}