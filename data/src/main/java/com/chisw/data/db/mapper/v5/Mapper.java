package com.chisw.data.db.mapper.v5;

public interface Mapper<F, T> {
    T map(F from);
}
