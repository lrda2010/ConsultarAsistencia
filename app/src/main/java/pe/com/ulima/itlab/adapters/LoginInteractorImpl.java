package pe.com.ulima.itlab.adapters;

import android.os.Handler;
import android.text.TextUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.Objects;
import pe.com.ulima.itlab.models.LoginBean;


public class LoginInteractorImpl implements LoginInteractor {

    private LoginBean user;

    @Override
    public void login(final String usuario, final String password, final OnLoginFinishedListener listener) {

        user = new LoginBean(usuario, password);

        try {
            String url = "https://webaloe.ulima.edu.pe/portalUL/j_security_check";
            String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36";

            Connection.Response response;

            response = Jsoup
                    .connect(url)
                    .userAgent(userAgent)
                    .data("ac", user.getTiempo())
                    .data("url2", "")
                    .data("j_username", user.getUsername())
                    .data("j_password", user.getPassword())
                    .userAgent(userAgent)
                    .method(Connection.Method.POST)
                    .followRedirects(true)
                    .execute();

            if (Objects.equals(response.url().toString(), "https://webaloe.ulima.edu.pe/portalUL/errorLogin.jsp")){
                listener.onPasswordError();
            }
            else {
                Document doc = Jsoup.connect("http://webaloe.ulima.edu.pe/portalUL/rh/servlets/ComandoConsultarAsistenciaMes")
                    .cookies(response.cookies())
                    .userAgent(userAgent)
                    .get();

                doc.head().getElementsByTag("link").remove();
                doc.head().appendElement("link").attr("rel", "stylesheet").attr("type",
                        "text/css").attr("href", "style.css");

                doc.body().getElementsByTag("table").append("class=CSSTableGenerator");

                user.setAsistencia(doc.html());
                System.out.println(doc.html());

                listener.onSuccess(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}