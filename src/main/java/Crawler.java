import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Crawler {

    public static void main(String[] args) throws Exception {
        //创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //声明httpGet对象
        HttpGet httpGet = new HttpGet("https://www.autohome.com.cn/bestauto");

        //使用httpClient发起请求，获得response
        CloseableHttpResponse response = httpClient.execute(httpGet);

        //判断响应状态码是否为200
        if(response.getStatusLine().getStatusCode() == 200){

            String html = EntityUtils.toString(response.getEntity(),"UTF-8");
            System.out.println(html);

        }
    }
}
