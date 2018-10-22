package jsoup;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class JsoupUrl {
    public static void main(String[] args) throws Exception {

        //解析URL地址，第一个参数是URL，第二个为超时时间
        Document dom = Jsoup.parse(new URL("https://www.autohome.com.cn/bestauto"),100000);

        //获取页面信息，输出为html文件
        //FileUtils.writeStringToFile(new File("C:/我的文件/test.html"),dom.html(),"UTF-8");

        //使用dom对象解析文件，获取title标签内容
        String title = dom.getElementsByTag("title").first().text();

        System.out.println(title);
    }
}
