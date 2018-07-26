package bidReport.repository;

import bidReport.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pc-mg on 7/22/2018.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
}
