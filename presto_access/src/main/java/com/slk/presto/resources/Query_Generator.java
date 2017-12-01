package com.slk.presto.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class Query_Generator {
	
	
	JSONObject request ;

	Query_Generator(JSONObject data){
		
		request = data;
	}
	
	
	
	
	
	public 	Map<String,List<Map<String,Object>>> parser() {

		Map<String, Map<String, Object>> data = new HashMap<String, Map<String, Object>>();

		JSONArray alldata = request.getJSONArray("selected_columns");
		Map<String,List<Map<String,Object>>> out_data = new HashMap<String,List<Map<String,Object>>>();
		for (int i = 0; i < alldata.length(); i++) {

			JSONObject source_data = alldata.getJSONObject(i);
			
			
			String source_name = source_data.getString("source");

			JSONArray srcData = source_data.getJSONArray("selected_values");
			
			
			
			
			
			List<Map<String,Object>> source_table_List= new ArrayList<Map<String,Object>>();

			for (int j = 0; j < srcData.length(); j++) {

				JSONObject inn_data = srcData.getJSONObject(j);

				Map<String, Object> data_Map = new HashMap<String, Object>();

				List<String> all_columns_list = new ArrayList<String>();

				JSONArray col_Array = inn_data.getJSONArray("columns");

				for (int z = 0; z < col_Array.length(); z++) {

					all_columns_list.add(col_Array.getString(z));
				}

				data_Map.put("database", inn_data.get("database"));

				data_Map.put("table", inn_data.get("table"));

				data_Map.put("columns", all_columns_list);

				System.out.println(data_Map);
				
				source_table_List.add(data_Map);
				
				
			}
			out_data.put(source_name, source_table_List);
		}

	System.out.println("out_data : " +out_data);
	return out_data;

	}
	
	
	public String generateQuery(Map<String,List<Map<String,Object>>> requestDS){
		
		
		return null;}
	
	
	
	public static void main(String[] args) {
	
		JSONObject request = new JSONObject("{\"selected_columns\":[{\"source\":\"hive\",\"selected_values\":[{\"database\":\"customer_complaints\",\"table\":\"complaints\",\"columns\":[\"Date received\",\"Complaint ID\",\"Account ID\",\"Product\",\"Sub-product\",\"Issue\",\"Sub-issue\",\"Consumer complaint narrative\",\"Company public response\",\"Company\",\"State\",\"ZIP code\",\"Tags\",\"Consumer consent provided?\",\"Submitted via\",\"Date sent to company\",\"Company response to consumer\",\"Timely response?\",\"Consumer disputed?\"]}]},{\"source\":\"cassandra\",\"selected_values\":[{\"database\":\"transactions\",\"table\":\"account_transactions  \",\"columns\":[\"trans_id\",\"account_id\",\"Transaction_date\",\"Type\",\"Operation\",\"Amount\",\"Balance\",\"k_symbol\",\"bank\",\"account\"]}]}]}");
		
		Query_Generator qs = new Query_Generator(request);
		qs.parser();
		
		System.out.println(request);

	}

}
