package com.chisw.domain.abstraction.repository;

import com.chisw.domain.abstraction.specification.Specification;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface Repository<T> {
    Observable<T> getItems(Specification specification);

    Observable<T> getAllItems();

    Observable<T> getItem(Specification specification);

    <P> Observable<P> addItem(T item);

    <P> Observable<P> deleteItem(Specification specification);

    <P> Observable<P> updateItems(T item, Specification specification);

}
