package com.chisw.foodapplication.ui.contract.mainactivity;

import com.chisw.foodapplication.ui.contract.BasePresenter;
import com.chisw.foodapplication.ui.contract.BaseView;

public class MainActivityContract {

    public interface MainActivityView extends BaseView<MainActivityPresenter> {
        void showToast(String msg);
    }

    public interface MainActivityPresenter extends BasePresenter<MainActivityView> {
        void start();
        void checkUser(String name, String surname, String email);
    }

}
