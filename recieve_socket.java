package filetranser;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class recieve_socket {
	Socket server;
	
	public static void main(String[] args) {
		new recieve_socket();
	}
	public recieve_socket() {
		// TODO Auto-generated constructor stub
		try {
			server = new Socket("127.0.0.1",10086);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		do_tansfer();
		
		try {
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void do_tansfer() {
		try {
			
			InputStream in = server.getInputStream();
			DataInputStream dis=new DataInputStream(in);
			String filename=dis.readUTF();
			File file = new File("/home/impressionyang/Desktop/test/"+"copy__"+filename);
			if (file.exists()) {

			} else {
				file.createNewFile();
			}
			OutputStream out = new FileOutputStream(file);

			// 建立数组
			byte[] buf = new byte[100];
			int len = 0;
			int progress=0;
			
			
			long all=dis.readLong();
			
			
			System.out.println("recieve=" +all);
			
			boolean key=true;
			if(all>=100) {
				key=false;
			}
			// 判断是否读到文件末尾
			while ((len = in.read(buf)) != -1) {
				out.write(buf, 0, len);
				out.flush();
				if(key) {
					System.out.println("recieve progress: "+100);
				}else {
					progress+=100;
					System.out.println("recieve progress: "+(int)(100*((double)progress/all)));
				}
			}
			
			dis.close();
			
			in.close();
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
