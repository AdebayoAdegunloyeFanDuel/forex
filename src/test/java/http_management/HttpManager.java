package http_management;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import java.util.Arrays;

import java.io.IOException;

public class HttpManager {
    private final HttpClient client;
    private final HttpGet httpGet;
    private HttpResponse httpResponse;


    public HttpManager(String urlString) {
        this.client = HttpClientBuilder.create().build();
        this.httpGet = new HttpGet(urlString);
    }

    public void makeUrlCall(){
        try {
            httpResponse = client.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getResponseBody(){
        try {
            return EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Header[] responseHeader(){
        // The header will return an iterable response
        // a for each loop through the header will return each individual Header
        return httpResponse.getAllHeaders();
    }

//    public static void main(String[] args) {
//        HttpManager httpManager = new HttpManager("https://bbc.co.uk");
//        httpManager.makeUrlCall();
//        for (Header header: httpManager.responseHeader()){
//            System.out.println(Arrays.toString(httpManager.responseHeader()));
//        }
//    }
}
