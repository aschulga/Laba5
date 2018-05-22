package controller.site;

import org.json.JSONObject;
import org.json.JSONTokener;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HandlerGitHub {
    private String clientId = "938f9cf419e7c88fe7d8";
    private String redirect_uri = "http://localhost:8080/authorization";
    private String scope = "read:user";
    private String clientSecret = "93edc47b226e72dba2ebcb4317ed928f019fadc5";
    private int indexStartToken = 13;
    private int indexEndToken = 53;

    public void authorize(HttpServletResponse response) throws IOException {
        String url = String.format("https://github.com/login/oauth/authorize?" +
                        "client_id=" + clientId +
                        "&redirect_uri=" + redirect_uri +
                        "&scope=" + scope);

        response.sendRedirect(url);
    }

    public String getAccessToken(String code) throws IOException {
        String url = String.format("https://github.com/login/oauth/access_token?" +
                "client_id=" + clientId +
                "&client_secret=" + clientSecret +
                "&grant_type=authorization_code" +
                "&code=" + code);

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        StringBuilder builder = new StringBuilder();
        String str;

        while ((str = reader.readLine()) != null) {
            builder.append(str);
        }
        reader.close();
        return builder.toString().substring(indexStartToken, indexEndToken);
    }


    public String getUser(String token) throws IOException {
        String url = String.format("https://api.github.com/user?access_token=" + token);

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        StringBuilder builder = new StringBuilder();
        String str;

        while((str = reader.readLine()) != null){
            builder.append(str);
        }

        JSONTokener jsonTokener = new JSONTokener(builder.toString());
        JSONObject jsonObject = new JSONObject(jsonTokener);
        String login = jsonObject.getString("login");
        reader.close();
        return login;
    }
}
