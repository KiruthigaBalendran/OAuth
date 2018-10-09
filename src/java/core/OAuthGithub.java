/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import com.google.gson.Gson;
import model.Repository;

/**
 *
 * @author User
 */
@WebServlet(name = "OAuthGithub", urlPatterns = {"/oauthGithub"})
public class OAuthGithub extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String clientID = "f34996454d36261af087";
    private static final String clientSecret = "5d45eb5c97139422013919666853efed6a5f7c72";
    private static final String redirectURI = "http://localhost:8080/MyGithubRepo/oauthGithub";
    private static final String appName = "MyGithubRepo";
    String accessToken = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String code = request.getParameter("code");
            if (code == null) {
                response.sendRedirect("https://github.com/login/oauth/authorize?client_id="
                        + clientID
                        + "&redirect_uri="
                        + redirectURI
                        + "&scope=user");
            } else {
                URL url = new URL(
                        "https://github.com/login/oauth/access_token?client_id="
                        + clientID + "&redirect_uri=" + redirectURI
                        + "&client_secret=" + clientSecret + "&code="
                        + code);
                HttpURLConnection conn = (HttpURLConnection) url
                        .openConnection();
                conn.setRequestMethod("POST");
                conn.setConnectTimeout(20000);
                String outputString = "";
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    outputString = outputString + line;
                }
                System.out.println(outputString);

                if (outputString.indexOf("access_token") != -1) {
                    accessToken = outputString.substring(13,
                            outputString.indexOf("&"));
                }
                System.out.println(accessToken);

                url = new URL("https://api.github.com/user");
                System.out.println(url);
                String output = getData(url);
                User user = (User) new Gson().fromJson(output,
                        User.class);
                System.out.println(user);
                request.setAttribute("auth", user);

                request.getRequestDispatcher("/Repos.jsp").forward(
                        request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public String getData(URL url) {
        String line;
        try {
            HttpURLConnection myURLConnection = (HttpURLConnection) url
                    .openConnection();
            myURLConnection.setRequestProperty("Authorization", "token "
                    + accessToken);
            myURLConnection.setRequestProperty("User-Agent", appName);
            myURLConnection.setRequestMethod("GET");
            myURLConnection.setUseCaches(false);
            myURLConnection.setDoInput(true);
            myURLConnection.setDoOutput(true);
            myURLConnection.setConnectTimeout(7000);

            String outputString = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    myURLConnection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                outputString = outputString + line;
            }
            reader.close();
            System.out.println(outputString);
            return outputString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
