package bidReport.service.Impl;

import bidReport.dto.UserUpdateDto;
import bidReport.model.User;
import bidReport.repository.UserRepository;
import bidReport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by pc-mg on 7/23/2018.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public Optional<User> findById(int id) {
        return  userRepository.findById(id);
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User update(UserUpdateDto userUpdateDto) {
        Optional<User> user = userRepository.findById(userUpdateDto.getId());
        if(user.isPresent()) {
            User editUser = user.get();
            editUser.setFirstname(userUpdateDto.getFirstname());
            editUser.setLastname(userUpdateDto.getLastname());
            editUser.setUsername(userUpdateDto.getUsername());
            return userRepository.save(editUser);
        }
        else {
            return null;
        }
    }

    @Override
    public void delete(int id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(u -> userRepository.delete(u));
    }
}
