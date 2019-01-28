package filetranser;
//this is server port

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class sent_socket {
	ServerSocket s_socket;
	Socket client;
	
	public static void main(String[] args) {
		new sent_socket();
	}

	public sent_socket() {
		// TODO Auto-generated constructor stub
		try {
			s_socket = new ServerSocket(10086);
			client = s_socket.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		do_tansfer();
		
		try {
			s_socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void do_tansfer() {
		try {
			OutputStream out = client.getOutputStream();
			File file = new File("/home/impressionyang/Desktop/test/cpptest");
			
			
			if (file.exists()) {

			} else {
				file.createNewFile();
			}
			InputStream in = new FileInputStream(file);

			// 建立数组
			byte[] buf = new byte[100];
			int len = 0;
			int progress=0;
			long all=file.length();
			System.out.println("sent="+all);
			boolean key=true;
			if(all>=100) {
				key=false;
			}
			
			DataOutputStream dos=new DataOutputStream(out);
			dos.writeUTF(file.getName());
			dos.flush();
			dos.writeLong(all);
			dos.flush();
			
			
			// 判断是否读到文件末尾
			while ((len = in.read(buf, 0, buf.length))!= -1) {
				out.write(buf, 0, len);
				if(key) {
					System.out.println("sent progress: "+100);
				}else {
					progress+=100;
					System.out.println("sent progress: "+(int)(100*((double)progress/all)));
				}
				
			}
			
			dos.close();
			
			in.close();
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
