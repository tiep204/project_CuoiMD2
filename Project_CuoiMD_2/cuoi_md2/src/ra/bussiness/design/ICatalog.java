package ra.bussiness.design;

import ra.bussiness.entity.Catalog;

import java.util.List;

public interface ICatalog<T, E> extends Ilibrany<T,E> {
    public List<Catalog> sorlbyName();

}
