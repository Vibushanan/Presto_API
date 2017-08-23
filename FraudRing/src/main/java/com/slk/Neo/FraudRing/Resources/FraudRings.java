package com.slk.Neo.FraudRing.Resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.slk.Neo.FraudRing.Model.FraudRingModel;
import com.slk.Neo.FraudRing.Service.FraudRing_Calculation;
import org.apache.log4j.Logger;

/**
 * @author vibushanan.somasundaram
 * 
 * Description:
 * 		This class is used to handle all the webapi requests on the fraud ring data
 * 
 * Method: 
 * 		getFraudRing()
 * 		
 * 		Calls FraudRing_Calculation module to get all the fraud ring in the database
 * 
 * 		Input : None
 * 		Output : returns the list of fraud rings as JSON.	
 *
 */
@Path("allfraudrings")
@Produces(MediaType.APPLICATION_JSON)

public class FraudRings {
	
	final static Logger logger = Logger.getLogger(FraudRings.class);
	
	

	@GET
	public List<FraudRingModel> getFraudRing(){
		logger.info("getting fraud rings");
		System.out.println("sdsdsefefef");
		FraudRing_Calculation fc = new FraudRing_Calculation();
		
		return fc.getAllFraudRings();
		
	}
	
}
