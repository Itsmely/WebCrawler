package HttpClient;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpClientPost {
    public static void main (String[] args) throws Exception {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("https://www.oschina.net/");
        //设置用户代理信息
        httpPost.setHeader("User-Agent","");

        //创建List集合封装请求参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("scope","project"));
        params.add(new BasicNameValuePair("q","python"));

        //使用封装请求参数的List集合，创建表单实体对象
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params,"UTF-8");

        //把表单实体设置到httpPost中
        httpPost.setEntity(formEntity);

        CloseableHttpResponse response = null;
        try {
             response = httpClient.execute(httpPost);
            System.out.println(httpPost);
            System.out.println(response.getStatusLine().getStatusCode());
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
