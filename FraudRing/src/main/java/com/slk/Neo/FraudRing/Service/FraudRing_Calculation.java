package com.slk.Neo.FraudRing.Service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

import com.slk.Neo.FraudRing.Model.FraudRingModel;
import com.slk.Neo.FraudRing.Resources.FraudRings;


/**
 * @author vibushanan.somasundaram
 * 
 * Description:
 * 
 * 		This module is used to find all the fraud ring in the neo4j database.
 *            
 *  Methods : 
 *  
 *      getAllFraudRings() : Will get all the fraud ring data
 *      Input  : none
 *      Output : returns a list of FraudRingModel object.
 *
 */
public class FraudRing_Calculation {
	
	final static Logger logger = Logger.getLogger(FraudRing_Calculation.class);
	
	public List<FraudRingModel> getAllFraudRings(){
		
		logger.info("Getting Fraud Rings");
		
		List<FraudRingModel> allRings = new ArrayList<FraudRingModel>();
		Driver driver = GraphDatabase.driver( "bolt://10.41.2.15:7687", AuthTokens.basic( "neo4j", "slk" ) );
		Session session = driver.session();

		StatementResult result = session.run( "MATCH 		(accountHolder:Client)-[]->(contactInformation)"+
" WITH 		contactInformation, count(accountHolder) AS RingSize" +
" MATCH 		(contactInformation)<-[]-(accountHolder) "+
" WITH 		collect(accountHolder.client_id) AS AccountHolders, contactInformation, RingSize "+
" WHERE 		RingSize > 1 "+
" RETURN 		AccountHolders AS FraudRing, labels(contactInformation) AS ContactType, RingSize "+
" ORDER BY 	RingSize DESC");
		
		while ( result.hasNext() )
		{
		    Record record = result.next();
		    
		    FraudRingModel f1 = new FraudRingModel();
		    
		    f1.setClient_id(record.get("FraudRing").asList());
		    f1.setContactType(record.get("ContactType").asList());
		    f1.setRing_size(record.get("RingSize").asInt());
		    
		    allRings.add(f1);
		    
		}

		logger.info("Fraud Rings"+allRings);
		session.close();
		driver.close();
		
		
		
		
		
		return allRings;
			
	}

	
	public static void main(String[] args) {
		FraudRing_Calculation fc = new FraudRing_Calculation();
		System.out.println(fc.getAllFraudRings().get(0).getRing_size());

	}

}
