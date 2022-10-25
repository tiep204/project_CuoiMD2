package ra.bussiness.design;

import ra.bussiness.entity.User;

import java.util.List;

public interface IUser<T,E> extends Ilibrany<T,E> {
    public boolean checkLogin(String name, String pass);

}
