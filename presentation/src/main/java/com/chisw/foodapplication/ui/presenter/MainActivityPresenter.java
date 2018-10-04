package com.chisw.foodapplication.ui.presenter;

import android.util.Log;

import com.chisw.data.db.entities.v5.user.UserContract;
import com.chisw.data.db.specification.DefaultSqlSpecification;
import com.chisw.domain.interactor.UseCase;
import com.chisw.domain.interactor.user.AddUserUseCase;
import com.chisw.domain.interactor.user.GetUserUseCase;
import com.chisw.domain.interactor.user.UpdateUserUseCase;
import com.chisw.domain.model.user.User;
import com.chisw.foodapplication.ui.contract.mainactivity.MainActivityContract;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class MainActivityPresenter implements MainActivityContract.MainActivityPresenter {

    private static final String TAG = "duck";
    private UseCase<AddUserUseCase.AddUserParameter, AddUserUseCase.AddUserResult> addUseCase;
    private UseCase<GetUserUseCase.GetUserParameter, GetUserUseCase.GetUserResult> getUseCase;
    private UseCase<UpdateUserUseCase.UpdateUserParameter, UpdateUserUseCase.UpdateUserResult> updateUseCase;
    private MainActivityContract.MainActivityView view;

    public MainActivityPresenter(UseCase<AddUserUseCase.AddUserParameter, AddUserUseCase.AddUserResult> addUseCase,
                                 UseCase<GetUserUseCase.GetUserParameter, GetUserUseCase.GetUserResult> getUseCase,
                                 UseCase<UpdateUserUseCase.UpdateUserParameter, UpdateUserUseCase.UpdateUserResult> updateUseCase) {
        this.addUseCase = addUseCase;
        this.getUseCase = getUseCase;
        this.updateUseCase = updateUseCase;
    }

    @Override
    public void bind(MainActivityContract.MainActivityView view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        view = null;
        getUseCase.unsubscribe();
        addUseCase.unsubscribe();
    }

    @Override
    public void start() {

    }

    @Override
    public void checkUser(String name, String surname, String email) {
        Log.i(TAG, "checkUser: " + name + " " + surname + " " + email);
        addUseCase.execute(new AddUserUseCase.AddUserParameter(new User(name, surname, email))).flatMap((Function<AddUserUseCase.AddUserResult, ObservableSource<GetUserUseCase.GetUserResult>>) aLong -> {
            Log.i(TAG, "apply: " + aLong.getUserId());
            return getUseCase.execute(new GetUserUseCase.GetUserParameter(new DefaultSqlSpecification()));
        }).subscribe(new Observer<GetUserUseCase.GetUserResult>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(GetUserUseCase.GetUserResult getUserResult) {
                User user = getUserResult.getUser();
                Log.i(TAG, "onNext: " + user.toString());
                view.showToast(getUserResult.getUser().toString());

                user.setEmail(user.getEmail() + user.getName());
                user.setName(user.getName() + user.getSurname());
                user.setSurname(user.getSurname() + user.getName());
                updateUseCase.execute(new UpdateUserUseCase.UpdateUserParameter(user, new DefaultSqlSpecification(user.getId(), new UserContract()))).subscribe(new Observer<UpdateUserUseCase.UpdateUserResult>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i(TAG, "onSubscribe: UPDATE ");
                    }

                    @Override
                    public void onNext(UpdateUserUseCase.UpdateUserResult updateUserResult) {
                        Log.i(TAG, "onNext: UPDATE" + updateUserResult.getUpdatedRow());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: UPDATE e.toString = " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete: UPDATE");
                    }
                });
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ", e);

            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: ");

            }
        });
    }

}
