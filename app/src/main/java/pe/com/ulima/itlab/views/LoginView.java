package pe.com.ulima.itlab.views;

import pe.com.ulima.itlab.models.LoginBean;

/**
 * Created by Administrador on 11/10/2015.
 */
public interface LoginView  {
     void showProgress();
     void hideProgress();
     void setUsernameError();
     void setPasswordError();
     void navigateToHome(LoginBean user);
}
