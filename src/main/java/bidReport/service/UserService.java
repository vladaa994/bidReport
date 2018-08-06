package bidReport.service;

import bidReport.dto.UserUpdateDto;
import bidReport.model.User;

/**
 * Created by pc-mg on 7/23/2018.
 */
public interface UserService extends BaseService<User> {

    User update(UserUpdateDto userUpdateDto);
}
