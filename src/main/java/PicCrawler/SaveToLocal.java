package PicCrawler;

import java.io.*;

public class SaveToLocal {
    public static void save(InputStream in,String filePath,String fileName) throws IOException {
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdirs();

            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(filePath,fileName)));

            int result;
            while((result = in.read())!=-1){
                dataOutputStream.write(result);
            }
            dataOutputStream.flush();
            dataOutputStream.close();
        }
    }

}
