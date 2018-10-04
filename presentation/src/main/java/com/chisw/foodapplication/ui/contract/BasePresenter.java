package com.chisw.foodapplication.ui.contract;

public interface BasePresenter<T> {
    void bind(T view);

    void unbind();
}
