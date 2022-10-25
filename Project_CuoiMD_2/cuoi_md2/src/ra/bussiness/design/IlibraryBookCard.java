package ra.bussiness.design;

import ra.bussiness.entity.LibraryBookCard;

public interface IlibraryBookCard<T,E> extends Ilibrany<T,E> {
    LibraryBookCard searchByUserld(int Id);
}
