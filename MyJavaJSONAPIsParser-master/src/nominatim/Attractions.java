package nominatim;

import java.util.List;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Attractions {   
	public long place_id; 
	public double lat;  public double lon; 
	public String display_name;  
	public double importance;  
	List<String>l = null;   
	public Attractions(String jsonstring){ 
		l = new ArrayList<String>();  
		try {          
			JSONArray jarr = new JSONArray(jsonstring);  
			System.out.println(jarr.length());    
			for(int i = 0; i < jarr.length(); i++){    
				Object jo = jarr.get(i);    
				JSONObject jso = (JSONObject)jo;    
				
				place_id = jso.getLong("place_id");   
				lat = jso.getDouble("lat");   
				lon = jso.getDouble("lon");        
				importance = jso.getDouble("importance");     
				display_name = jso.getString("display_name");      
				String finresult = place_id+"\t"+display_name+"\t"+lat+"\t"+lon+"\t"+importance;  
				l.add(finresult);    }  
  } catch (JSONException e) {   
	  System.err.println("Can't parse JSON string");   
	  e.printStackTrace();   } 
		}   
} 
