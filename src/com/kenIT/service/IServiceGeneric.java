package com.kenIT.service;

import com.kenIT.model.Customer;

import java.util.List;

public interface IServiceGeneric<T> {
    List<T> findAll();
    Customer save(T t);
}
