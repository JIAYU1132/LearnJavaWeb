package Java06_05;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static int PORT = 9999; // 定义一个端口号

    private static ExecutorService POOL = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT); // 启动了服务端程序
        // 在命令行输入 netstat -ano/findstr "9999" 可以显示这个进程的 pid
        // pid 是系统管理进程的方式, 数据还是发送到端口中, pid 是进程启动随机分配的
        // 网络传输数据, 使用端口号来定位程序, 指定端口号启动程序就保证了服务器是固定端口
        while (true) {
            Socket client = server.accept(); // 阻塞等待客户端连接, 有新的连接进来, 往下执行
            POOL.submit(new ServerTask(client));
        }
    }

    private static class ServerTask implements Runnable {
        private Socket client;

        public ServerTask(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                // 处理 cilent 中的输入输出流, 也就是发送/读取网络数据包
                InputStream is = client.getInputStream();
                InputStreamReader isr = new InputStreamReader(is, "UTF-8") ;
                BufferedReader br = new BufferedReader(isr);

                OutputStream os = client.getOutputStream();
                PrintWriter pw = new PrintWriter(os, true);

                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println("接受客户端的数据: " + line);
                    pw.println("响应: " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
