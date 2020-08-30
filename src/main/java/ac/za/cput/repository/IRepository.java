package ac.za.cput.repository;
/*
 *@author @joselledina
 * Description: IRepository used by all
 * Date: 25 August 2020
 */

public interface IRepository<T, ID> {

     T create(T t);
     T read(ID id);
     T update(T t);
    void delete(ID id);

}
