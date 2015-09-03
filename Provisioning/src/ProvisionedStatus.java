



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;

public class ProvisionedStatus {
	public static void main(String[] args) throws IOException{
		String str="";
		ProvisionedStatus ls = new ProvisionedStatus();
		str = ls.CheckProvisioningStatus();
	}
	public String CheckProvisioningStatus(String json){
		String str ="";

		try {
			String urlStr = "http://localhost:8080/TestRestServ/rest/om/placeOrder";
			URL urlToRequest = new URL(urlStr);
			HttpURLConnection httpConnection = (HttpURLConnection) urlToRequest
					.openConnection();
			httpConnection.setDoOutput(true);
			httpConnection.setRequestMethod("POST");
			httpConnection.setRequestProperty("Content-Type","application/json");

		   // JSONObject returnObject = Returnfxn();
			//String input = "{\"id\":1,\"firstName\":\"Liam\",\"age\":22,\"lastName\":\"Marco\"}";
			JSONObject returnObject;
			//String input = returnObject.toString();
	//	System.out.println(input);
			//OutputStream outputStream = httpConnection.getOutputStream();
		//	outputStream.write(input.getBytes());
		//	outputStream.flush();

			if (httpConnection.getResponseCode() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ httpConnection.getResponseCode());
			}

			BufferedReader responseBuffer = new BufferedReader(
					new InputStreamReader((httpConnection.getInputStream())));

			String output;
			System.out.println("Output from Server:\n");
			while ((output = responseBuffer.readLine()) != null) {
				System.out.println(output);
			}
			httpConnection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return str;
	}
	
}


