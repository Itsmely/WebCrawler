package jsoup;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class JsoupString {
    public static void main(String[] args) throws IOException {
        //使用工具类，读取文件获取字符串
        String html = FileUtils.readFileToString(new File("C:/我的文件/test.html"),"UTF-8");

        //使用 jsoup解析字符串
        Document dom = Jsoup.parse(html);

        //获取title标签内容
        String title = dom.getElementsByTag("title").first().text();
        System.out.println(title);
    }

}
