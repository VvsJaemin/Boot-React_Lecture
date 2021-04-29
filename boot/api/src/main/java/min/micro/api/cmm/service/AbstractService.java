package min.micro.api.cmm.service;

import java.util.List;
import java.util.Optional;


public abstract class AbstractService<T> {
    public abstract Long save(T t);

    public abstract Optional<T> findById(long id);

    public abstract List<T> findAll();

    public abstract int count();

    public abstract Optional<T> getOne(long id); //null 있는 것들만

    public abstract Long delete(T t);

    public abstract Boolean existsById(long id);

    public abstract void deleteById(long id);


}





