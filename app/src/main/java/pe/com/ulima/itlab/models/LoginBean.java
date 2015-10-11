package pe.com.ulima.itlab.models;

import java.util.Date;

/**
 * Created by Administrador on 10/10/2015.
 */
public class LoginBean {

    private String username;
    private String password;
    private String tiempo;
    private String asistencia;

    public LoginBean(String username, String password) {
        this.username = username;
        this.password = password;
        this.tiempo = Tiempo();
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    private String Tiempo(){

        String ac;
        Date t = new Date();
        t.getTime();
        ac = String.valueOf(t.getTime());
        return ac;
    }

    public String getTiempo() {
        return tiempo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
