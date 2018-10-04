package com.chisw.data.db.datasource.v5;

import com.chisw.domain.abstraction.specification.Specification;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface DataSource<T> {

    Observable<Long> add(T data);

    Observable<Iterable<Long>> add(Iterable<T> data);

    Observable<Integer> remove();

    Observable<Integer> remove(Specification specification);

    Observable<Integer> update(T data, Specification specification);

    Observable<Iterable<Integer>> update(Iterable<T> data, Specification specification);

    Observable<T> query(Specification specification);

    Observable<T> query();
}
