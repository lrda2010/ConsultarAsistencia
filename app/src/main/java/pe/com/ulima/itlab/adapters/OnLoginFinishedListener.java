package pe.com.ulima.itlab.adapters;

import pe.com.ulima.itlab.models.LoginBean;

/**
 * Created by Administrador on 11/10/2015.
 */
interface  OnLoginFinishedListener {
     void onUsernameError();
     void onPasswordError();
     void onSuccess(LoginBean user);
}
