package cn.melon;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CoderTest {
    public static void main(String[] args) {
        try {
            String en = URLEncoder.encode("你好", "UTF-8");
            System.out.println(en);
            String en2 = URLEncoder.encode("你好", "GBK");
            System.out.println(en2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
