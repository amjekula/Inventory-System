package ac.za.cput.controller;
import java.util.List;
public interface IController<T,t> {
    T create(T t);
    T delete(T t);
    T read(t id);
    T update(T t) ;
    List<T> readAll();
}