package provis;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/prov")
public class ProvRequestReciever {
	@POST
	@Path("/acceptRequest")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createResponse(String product) {
		
		
		HashMap<String, Object> mapObject = new HashMap<String, Object>();
		
				CreateHashMap.createHashMapFromJsonString(product, mapObject);
				if( mapObject.containsKey("customertype") && mapObject.containsValue("new")){
					//insertIntoCustomer(mapObject);
				}
				//else
					//insertIntoOrder(mapObject);
		return "acknowledge";
	}
}
