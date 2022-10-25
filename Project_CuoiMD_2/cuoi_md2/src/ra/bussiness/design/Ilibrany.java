package ra.bussiness.design;

import java.util.List;
import java.util.Scanner;

public interface Ilibrany<T,E> {
    public boolean create(T t);
    public boolean update(T t);
    public boolean delete(E id);
    List<T> findbyName(E name);
    public void displayData();
    T inputData(Scanner sc);
    List<T> readFormFile();
    public boolean writetoFile(List<T>list);
}
