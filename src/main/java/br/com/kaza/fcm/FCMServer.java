package br.com.kaza.fcm;

import java.io.OutputStreamWriter;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;

/**
 * @author arino.godinho
 * 2016
 */
public class FCMServer {

	public final static String KEY_AUTOR_FCM = "AIzaSyB7Irlm6mCvy_3D3SUFZ0usNHqwcB2q5p4";
	public final static String API_URL_FMC = "https://fcm.googleapis.com/fcm/send";
	
	public static void push() throws Exception{
		String key_autor = KEY_AUTOR_FCM;
		String url_FCM = API_URL_FMC;
		
		URL url = new URL(url_FCM);
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		
		con.setUseCaches(false);
		con.setDoInput(true);
		con.setDoOutput(true);
		
		con.setRequestMethod("POST");
		con.setRequestProperty("Authorization", "key=" + key_autor);
		con.setRequestProperty("Content-Type", "application/json");
		
		JSONObject json = new JSONObject();
		json.put("to", "Chave Device");
		JSONObject info = new JSONObject();
		info.put("title", "Notificação Alarme");
		info.put("body", "Alarme disparado!");
		json.put("notification", info);
		
		OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
		wr.write(json.toString());
		wr.flush();
		con.getInputStream();
	}
}
