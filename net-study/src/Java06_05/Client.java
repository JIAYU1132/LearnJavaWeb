package Java06_05;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    // 本地IP: 特殊的一种IP. 127.0.0.1
    // 本机域名, 默认: localhost
    private static String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        // 创建基于TCP协议的客户端到服务端的连接
        Socket client = new Socket(HOST, Server.PORT);
        InputStream is = client.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "UTF-8") ;
        BufferedReader br = new BufferedReader(isr);

        OutputStream os = client.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);

        // 从控制台按行接受字符串
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            // 接收到的控制台字符串, 发送到服务端
            String line = sc.nextLine();
            pw.println(line);
            // 获取服务端响应的一行字符串
            String response = br.readLine();
            System.out.println("服务端响应的内容: " + response);
        }
    }
}
