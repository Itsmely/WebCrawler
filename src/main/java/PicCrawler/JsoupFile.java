package PicCrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.File;
import java.io.IOException;

public class JsoupFile {

    public static void main(String[] args) throws IOException {
        String filePath = "D:/html/img/";
        Document doc = Jsoup.parse(new File("D:/html/a.html"),"UTF-8");
        Elements elements = doc.getElementsByTag("img");
        System.out.println("开始下载....");

        for(Element element : elements){
            String imgScr = element.attr("abs:src");
            //System.out.println(imgScr);

            DowloadImgs.dowloadImgs(filePath,imgScr);

        }
       // System.out.println("下载完成");


    }

}
