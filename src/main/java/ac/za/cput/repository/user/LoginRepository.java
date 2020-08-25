package ac.za.cput.repository.user;

import ac.za.cput.entity.user.Login;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface LoginRepository<L, S> extends IRepository<Login, String> {
Set<Login> getAll();
}
