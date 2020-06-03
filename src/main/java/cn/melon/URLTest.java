package cn.melon;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.baidu.com");

            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());

            URLConnection uc = url.openConnection();

            InputStream in = uc.getInputStream();

            byte[] b = new byte[1024];
            int len;
            while ((len = in.read(b)) != -1) {
                System.out.println(new String(b, 0, len));
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
