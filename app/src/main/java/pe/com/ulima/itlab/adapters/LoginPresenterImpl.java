package pe.com.ulima.itlab.adapters;

import pe.com.ulima.itlab.LoginActivity;
import pe.com.ulima.itlab.models.LoginBean;
import pe.com.ulima.itlab.views.LoginView;

/**
 * Created by Administrador on 11/10/2015.
 */
public class LoginPresenterImpl implements LoginPresenter,OnLoginFinishedListener {

        private LoginView loginView;
        private LoginInteractor loginInteractor;

        public LoginPresenterImpl(LoginView loginView) {
            this.loginView = loginView;
            this.loginInteractor = new LoginInteractorImpl();
        }

        @Override public void validateCredentials(String username, String password) {
            loginView.showProgress();
            loginInteractor.login(username, password, this);
        }

        @Override public void onUsernameError() {
            loginView.setUsernameError();
            loginView.hideProgress();
        }

        @Override public void onPasswordError() {
            loginView.setPasswordError();
            loginView.hideProgress();
        }

        @Override public void onSuccess(LoginBean user) {
            loginView.navigateToHome(user);
        }
}
