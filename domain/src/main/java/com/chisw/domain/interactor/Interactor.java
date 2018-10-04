package com.chisw.domain.interactor;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public interface Interactor<P, T> {

    void execute(P params, Consumer<T> d);

    Observable<T> execute(P params);
}
