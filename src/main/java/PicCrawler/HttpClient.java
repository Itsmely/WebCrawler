package PicCrawler;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

public class HttpClient {

    private static String fileName = "a.html";
    private static String filePath = "D:\\html";

    public static void main(String[] args) throws IOException {
        String URL = "https://www.duitang.com/search/?kw=%E5%AE%8B%E6%99%BA%E5%AD%9D&type=feed";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(URL);

        CloseableHttpResponse response = httpClient.execute(httpGet);

        if(response.getStatusLine().getStatusCode() == 200){

            HttpEntity entity = response.getEntity();
            InputStream in = entity.getContent();

            SaveToLocal.save(in,filePath,fileName);


        } else{

            System.out.println("code=" + response.getStatusLine().getStatusCode());
        }
        if(response != null){
            response.close();
        }
        if(httpClient != null){
            httpClient.close();
        }
    }
}
