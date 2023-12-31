package rikkei.model.service;

import java.util.List;

public interface IGenericService <T,E>{
    List<T> findAll();
    T findById(E id);
    void save(T b);
    void delete(E id);

}
