package corp.siendev.com.misterkeeper.repository;

import corp.siendev.com.misterkeeper.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
