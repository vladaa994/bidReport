package bidReport.service;

import java.util.List;
import java.util.Optional;

/**
 * Created by pc-mg on 8/5/2018.
 */
public interface BaseService<T> {

    List<T> findAll();
    Optional<T> findById(int id);
    T save(T user);
    default T update(T userUpdateDto){
        return null;
    }
    void delete(int id);
}
