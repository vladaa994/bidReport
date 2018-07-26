package bidReport.service;

import bidReport.UserUpdateDto;
import bidReport.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by pc-mg on 7/23/2018.
 */
public interface UserService {

    List<User> findAll();
    Optional<User> findById(int id);
    User save(User user);
    User update(UserUpdateDto userUpdateDto);
    void delete(int id);
}
