package ac.za.cput.service;
/*
 *@author @joselleDina
 * Description: Interface for Login Service
 * Date: 31 August 2020
 */

public interface IService<T, ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    void delete(ID id);
}
