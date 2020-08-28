package ac.za.cput.repository;

import ac.za.cput.entity.user.Login;

public interface IRepository<T, ID> {

    Login create(T t);
    Login read(ID id);
    Login update(T t);
    void delete(ID id);

}
