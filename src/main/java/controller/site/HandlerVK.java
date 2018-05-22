package controller.site;

import org.json.JSONObject;
import org.json.JSONTokener;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HandlerVK{
    private String clientId = "6477941";
    private String redirectUri = "http://localhost:8080/authorization";
    private String display = "popup";
    private String clientSecret = "t5RP75zqqWiebJK1jczk";

    public void authorize(HttpServletResponse response) throws IOException {
        String url= String.format("https://oauth.vk.com/authorize" +
                "?client_id="+ clientId +
                "&display=page" +
                "&redirect_uri=" + redirectUri +
                "&scope=users" +
                "&response_type=code" +
                "&v=5.74");

        response.sendRedirect(url);
    }

    public String getAccessToken(String code) throws IOException {
        String url= String.format("https://oauth.vk.com/access_token" +
                        "?client_id=" + clientId +
                        "&client_secret=" + clientSecret +
                        "&redirect_uri=" + redirectUri +
                        "&code=" + code);

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String str;

        while((str = reader.readLine())!=null){
            builder.append(str);
        }

        JSONObject responce = new JSONObject(builder.toString());
        String accessToken = responce.getString("access_token");
        reader.close();
        return accessToken;
    }

    public String getUser(String token) throws IOException {
        String url= "https://api.vk.com/method/users.get?access_token="+ token +"&v=5.74";

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        StringBuilder builder = new StringBuilder();
        String str;

        while((str = reader.readLine())!=null){
            builder.append(str);
        }

        JSONTokener jsonTokener = new JSONTokener(builder.toString());
        JSONObject userInfoResponse = new JSONObject(jsonTokener).getJSONArray("response").getJSONObject(0);
        String firstName = userInfoResponse.getString("first_name");
        String lastName = userInfoResponse.getString("last_name");
        reader.close();
        return firstName+" "+lastName;
    }
}
