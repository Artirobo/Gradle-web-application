package spring.gradle.dto;


import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arti on 8/19/17.
 */
public class ApacheHttpRestClient1 {
   public static void main(String[] args) {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        try {


            // specify the host, protocol, and port
            HttpHost target = new HttpHost("samples.openweathermap.org", 80, "http");

            // specify the get request
            HttpGet getRequest = new HttpGet("/data/2.5/history/city?id=2885679&type=hour&appid=b1b15e88fa797225412429c1c50c122a1");

            System.out.println("executing request to " + target);

            HttpResponse httpResponse = httpclient.execute(target, getRequest);
            HttpEntity entity = httpResponse.getEntity();

            System.out.println("----------------------------------------");
            System.out.println(httpResponse.getStatusLine());
            Header[] headers = httpResponse.getAllHeaders();
            for (int i = 0; i < headers.length; i++) {
                System.out.println(headers[i]);
            }
            System.out.println("----------------------------------------");

            if (entity != null) {

                System.out.println(EntityUtils.toString(entity));

            }



            ApacheHttpRestClient1 client1=new ApacheHttpRestClient1();
            String url="http://samples.openweathermap.org/data/2.5/history/city?id=2885679&type=hour&appid=b1b15e88fa797225412429c1c50c122a1";
            client1.httpGet(url);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
    }


    //this is useful method
    public  String httpGet(String urlStr) throws IOException {
        //yo aarko tariak  api call and get json file
        URL url = new URL(urlStr);
        HttpURLConnection conn =
                (HttpURLConnection) url.openConnection();

        if (conn.getResponseCode() != 200) {
            throw new IOException(conn.getResponseMessage());
        }

        // Buffer the result into a string
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        System.out.println("yo pasrse garda=="+sb);



        ParseJsonMethod(sb.toString());

        rd.close();

        conn.disconnect();
        return sb.toString();
    }

    private void ParseJsonMethod(String s) {

        ApicallerDto apicallerDto=new ApicallerDto();

        JSONObject jsonObj = new JSONObject(s);
//        System.out.println("yo json object ma halda"+jsonObj);
//        Double Status = jsonObj.getDouble("calctime");
        apicallerDto.setCalctime(jsonObj.getDouble("calctime"));
//        System.out.println(Status);

//        String SessionId = jsonObj.getString("cod");
        apicallerDto.setCod(jsonObj.getString("cod"));
//        System.out.println(SessionId);



        JSONArray ja = jsonObj.getJSONArray("list"); // get the JSONArray
        List<String> keys = new ArrayList<>();

        for(int i=0;i<ja.length();i++){
            System.out.println(ja.get(i));

        }

        JSONArray results = jsonObj.getJSONArray("list");
        JSONObject first = results.getJSONObject(0);
        double dtso=first.getDouble("dt");
        System.out.println(dtso);
    }


}