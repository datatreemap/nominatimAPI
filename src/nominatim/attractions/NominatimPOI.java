package nominatim.attractions;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

public class NominatimPOI {  

	public NominatimPOI(){}  
	public static String standardURL = "http://nominatim.openstreetmap.org/search?q=";   

	public POI getAttractions(double latlow, double lonlow, double latup, double  lonup, String paramType){ 

		POI result = null;    
		String urlString = standardURL+paramType+"&format=json&viewbox="+latlow+","+lonlow+","+latup+","
				+ ""+lonup+"&bounded=1&limit=1000"; 
		System.out.println(urlString);  
		try {    
			result =  new POI(getJSON(urlString));   
		} 
		catch (IOException e) {    System.err.println("Can't connect to server.");  
		e.printStackTrace();   }   
		return result; 
	}   
	
private String getJSON(String urlString) throws IOException{ 
		URL url = new URL(urlString); 
		URLConnection conn = url.openConnection();  
		
		InputStream is = conn.getInputStream();   
		String json = IOUtils.toString(is, "UTF-8");  
		is.close();    
		return json; 
		}  
}
