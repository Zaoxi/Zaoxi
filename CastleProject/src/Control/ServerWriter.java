package Control;

import com.google.gson.*;
import java.io.*;

// 클라이언트나 호스트로 데이터를 송신하는 클래스
public class ServerWriter {
	private static ServerWriter instance = null;
	
	private PrintWriter pw;
	private Gson gson;
	
	private ServerWriter(PrintWriter _pw) {
		instance = this;
		pw = _pw;
		gson = new Gson();
	}
	
	public static ServerWriter getInstance(PrintWriter _pw) {
		if(instance == null) new ServerWriter(_pw);
		return instance;
	}
	
	public void send(GsonInfo info) {
		String json = gson.toJson(info);
		pw.println(json);
		pw.flush();
		System.out.println(json);
	}
	public void close() {
		pw.close();
		instance = null;
	}
}

