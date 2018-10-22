package HttpClient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import static org.apache.http.impl.client.HttpClients.custom;


public class Pool {
    public static void main(String[] args) throws Exception {
        //创建连接池管理器
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();

        //设置最大连接数
        cm.setMaxTotal(200);

        //设置每个主机最大连接数
        cm.setDefaultMaxPerRoute(20);

        //使用连接池管理器发起请求
        get(cm);
        get(cm);
    }

    private static void get(PoolingHttpClientConnectionManager cm) throws Exception{
        //使用连接池管理器获取连接
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();

        HttpGet httpGet = new HttpGet("https://www.baidu.com");
        CloseableHttpResponse response = httpClient.execute(httpGet);

        System.out.println(response);

    }

}
