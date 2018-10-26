package PicCrawler;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DowloadImgs {
    public static void dowloadImgs(String filePath,String imgURL) throws IOException {
        File file = new File(filePath);
        if(!file.exists()) {
            file.mkdirs();
        }
            //截取图片名字
           String imgName = imgURL.substring(imgURL.lastIndexOf('/'),imgURL.length());

           File file1 = new File(filePath,imgName);
           System.out.println(file1);

           URL url = new URL(imgURL);
           DataInputStream dataInputStream = new DataInputStream(url.openStream());
           FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath,imgName));

           ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
           byte[] buffer = new byte[1024];
           int size;
           while((size = dataInputStream.read(buffer)) != -1){
               byteArrayOutputStream.write(buffer,0,size);
           }
           fileOutputStream.write(byteArrayOutputStream.toByteArray());
           dataInputStream.close();
           fileOutputStream.close();
        }
}
