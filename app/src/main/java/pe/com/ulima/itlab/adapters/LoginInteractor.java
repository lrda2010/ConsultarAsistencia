package pe.com.ulima.itlab.adapters;

/**
 * Created by Administrador on 11/10/2015.
 */

interface LoginInteractor {
    void login(String username, String password, OnLoginFinishedListener listener);
}
