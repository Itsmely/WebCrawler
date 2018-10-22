package jsoup;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class JsoupFile {
    public static void main(String[] args) throws IOException {
        //使用 jsoup解析字符串
        Document dom = Jsoup.parse(new File("C:/我的文件/test.html"),"UTF-8");

        //获取title标签内容
        String title = dom.getElementsByTag("title").first().text();
        System.out.println(title);

    }

}
