package HttpClient;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;

public class HttpClientRequestConfig {
    public static void main (String[] args) throws Exception {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        //HttpGet httpGet = new HttpGet("https://www.baidu.com/s?wd=python");
        //创建URI Builder设置参数
        URIBuilder uriBuilder = new URIBuilder("https://sou.autohome.com.cn/zonghe").setParameter("q","golf");
        URI uri = uriBuilder.build();
        System.out.println(uri);

        HttpGet httpGet = new HttpGet(uri);

        //创建连接请求参数
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(1000)    //创建连接池的最长时间
                .setConnectionRequestTimeout(500) //从连接池中获取到连接的最长时间
                .setSocketTimeout(10*1000) //数据传输的最长时间
                .build();

        //把请求参数设置到请求对象httpGet
        httpGet.setConfig(config);

        CloseableHttpResponse response = null;
        try {
             response = httpClient.execute(httpGet);

            //System.out.println(response.getStatusLine().getStatusCode());
            if(response.getStatusLine().getStatusCode() == 200){
                String html = EntityUtils.toString(response.getEntity(),"UTF-8");
                System.out.println(html);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

                if(response != null){
                    try {
                        response.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
