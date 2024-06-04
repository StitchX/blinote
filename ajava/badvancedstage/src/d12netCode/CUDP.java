package d12netCode;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Description: UDP协议的网络编程
 * @Author Eva
 * @Date 2023/7/7 10:26 -> 2024/6/4 21:05
 */

public class CUDP {


    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str = "jjjj";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,9090);

        socket.send(packet);
        socket.close();
    }

    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));
        socket.close();
    }
}
