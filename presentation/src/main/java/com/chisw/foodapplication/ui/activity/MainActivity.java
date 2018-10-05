package com.chisw.foodapplication.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chisw.domain.interactor.user.AddUserUseCase;
import com.chisw.domain.interactor.user.GetUserUseCase;
import com.chisw.domain.interactor.user.UpdateUserUseCase;
import com.chisw.foodapplication.R;
import com.chisw.foodapplication.ui.contract.mainactivity.MainActivityContract;
import com.chisw.foodapplication.ui.presenter.MainActivityPresenter;

import java.util.NoSuchElementException;
import java.util.Optional;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.chisw.foodapplication.core.App.userRepository;

public class MainActivity extends AppCompatActivity implements MainActivityContract.MainActivityView {


    private MainActivityContract.MainActivityPresenter presenter;

    private EditText etName;
    private EditText etSurname;
    private EditText etEmail;
    private Button btnPress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_food);

        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        etEmail = findViewById(R.id.etEmail);
        btnPress = findViewById(R.id.button);

        presenter = new MainActivityPresenter(
                new AddUserUseCase(Schedulers::io,
                        AndroidSchedulers::mainThread,
                        userRepository()),

                new GetUserUseCase(Schedulers::io,
                        AndroidSchedulers::mainThread,
                        userRepository()
                ),
                new UpdateUserUseCase(Schedulers::io,
                        AndroidSchedulers::mainThread,
                        userRepository()
                ));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onStart() {
        super.onStart();

        presenter.bind(this);

        Optional<EditText> etNameOptional = Optional.of(etName);
        Optional<EditText> etSurnameOptional = Optional.of(etSurname);
        Optional<EditText> etEmailOptional = Optional.of(etEmail);
        Optional<Button> btnPressOptional = Optional.of(btnPress);


        try {

            btnPressOptional.get().setOnClickListener((v) -> presenter.checkUser(
                    editTextToString(etNameOptional.get()),
                    editTextToString(etSurnameOptional.get()),
                    editTextToString(etEmailOptional.get())));
        } catch (NoSuchElementException ex) {

        }
    }

    private String editTextToString(EditText editText) {
        return editText.getText().toString();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.unbind();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
    }
}
