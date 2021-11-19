package com.c0821H1.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();

    void insert(T t);

    T select(int id);

    boolean update(T t);

    boolean delete(int id);
}
