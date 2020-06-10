package com.whw.test;

import java.util.List;

public interface Testdao {
    int save(Object obj);
    Object get(int id);
    void update(Object obj);
    int count();
    List<?> findAll();
    void delete(Object obj);
}
