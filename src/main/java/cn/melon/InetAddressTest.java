package cn.melon;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress ia1 = InetAddress.getByName("www.qq.com");

            System.out.println(Arrays.toString(ia1.getAddress()));
            System.out.println(ia1.getCanonicalHostName());
            System.out.println(ia1.getHostAddress());
            System.out.println(ia1.getHostName());


            InetAddress ia2 = InetAddress.getByName("61.151.166.146");


            System.out.println(Arrays.toString(ia2.getAddress()));
            System.out.println(ia2.getCanonicalHostName());
            System.out.println(ia2.getHostAddress());
            System.out.println(ia2.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
