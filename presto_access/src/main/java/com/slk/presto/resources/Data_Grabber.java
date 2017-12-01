package com.slk.presto.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class Data_Grabber {
	
	JSONObject request;
	Map<String,Map<String,List<String>>> request_data;
	
	public Data_Grabber(JSONObject request){
		this.request=request;	
		parser(request);
		
	}
	
	
	private void  parser (JSONObject request){
		
		Map<String, Map<String, Object>>  data = new HashMap<String,Map<String,Object>> ();
		
		JSONArray alldata = request.getJSONArray("selected_columns");
		
		for(int i = 0 ; i< alldata.length() ; i++){
			
			JSONObject source_data = alldata.getJSONObject(i);
			
			JSONArray srcData = source_data.getJSONArray("selected_values");
			
			for(int j = 0 ; j< alldata.length() ; j++){
				
				JSONObject inn_data = srcData.getJSONObject(j);
				
				
				Map<String,Object> data_Map  = new HashMap<String,Object>();
				
				
				List<String> all_columns_list = new ArrayList<String>();
				
				
				JSONArray col_Array = inn_data.getJSONArray("columns");
				
				for(int z=0;z<col_Array.length();z++){
					
					all_columns_list.add(col_Array.getString(z));
				}
				
				data_Map.put("database", inn_data.get("database"));
				
				data_Map.put("table", inn_data.get("table"));
				
				data_Map.put("columns", all_columns_list);
			
				System.out.println(data_Map);
			}
			
					
					
			
			
		}
		
		
		
		
		
	}
	

	public static void main(String[] args) {
		

	}

}
