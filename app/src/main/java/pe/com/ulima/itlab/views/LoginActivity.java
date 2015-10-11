package pe.com.ulima.itlab.views;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import pe.com.ulima.itlab.R;
import pe.com.ulima.itlab.adapters.LoginPresenter;
import pe.com.ulima.itlab.adapters.LoginPresenterImpl;
import pe.com.ulima.itlab.models.LoginBean;

public class LoginActivity extends Activity implements LoginView, View.OnClickListener {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_login);

        progressBar = (ProgressBar) findViewById(R.id.login_progress);
        username = (EditText) findViewById(R.id.usuario);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.email_sign_in_button).setOnClickListener(this);

        presenter = new LoginPresenterImpl(this);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        username.setError(getString(R.string.error_field_required));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.error_incorrect_password));
    }

    @Override
    public void navigateToHome(LoginBean user) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("doc", user.getAsistencia());
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        presenter.validateCredentials(username.getText().toString(), password.getText().toString());
    }

}
