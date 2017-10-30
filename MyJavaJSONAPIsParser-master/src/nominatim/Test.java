package nominatim;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Test {  
 public static String [] attractions = {"restaurant", "theatre"};   
 public static String[] piemonte = {"7.3389,44.8383,8.3496,45.1917"};   
 
 
 public static void main (String [] args) throws Exception{  
  NominatimAttractions nominatim = new NominatimAttractions();   
  File f = new File("POI_Piedmont");  
  f.mkdir();   
  int counter = 0;   
  for(int c = 0; c < piemonte.length; c++){  
   String [] r = piemonte[c].split(","); 
   if(r.length== 0)continue; 
   double lat1 = Double.parseDouble(r[0]);   
   double lon1 = Double.parseDouble(r[1]);  
   double lat2 = Double.parseDouble(r[2]);  
   double lon2 = Double.parseDouble(r[3]);  
   for(int i = 0; i < attractions.length; i++){  
	   counter++;    
	   List<String>list = new ArrayList<String>();                        
	   Attractions result =  nominatim.getAttractions(lat1,lon1,lat2,lon2, attractions[i]);           //returns Address object for the given position  
   
    for(int j = 0; j < result.l.size(); j++){  
    	//System.out.println("-->  "+result.l.get(i).toString());     
    	list.add(result.l.get(j).toString());     
    	}    
    System.out.println(attractions[i]);   
    print(f+"/"+attractions[i]+","+c+".csv", list);  
   } 
   } 
  }  
 public static void print(String file, List<String>list) throws Exception{  
	 PrintWriter out = new PrintWriter(new FileWriter(new File(file), true));  
	 for(int i = 0; i < list.size(); i++){ 
   out.println(list.get(i));   
   } 
	 out.close(); 
	 }
 }  