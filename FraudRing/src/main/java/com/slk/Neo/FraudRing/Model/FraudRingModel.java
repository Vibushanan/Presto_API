package com.slk.Neo.FraudRing.Model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author vibushanan.somasundaram
 * 
 * Description:
 * 	
 * 	 POJO class to hold the entire fraud ring data.
 * 
 * Data:
 * 	 client_id : Holds the list of client ID, participating in the fraud ring		
 *   contactType: Holds the list of contactType the clients share
 *   ring_size : Size of the fraud ring 
 */
public class FraudRingModel {
	
	List<Object> client_id;
	List<Object> contactType;
	int ring_size;

	public FraudRingModel(List<Object> client_id, List<Object> contactType,
			int ring_size) {
		super();
		this.client_id = client_id;
		this.contactType = contactType;
		this.ring_size = ring_size;
	}

	public FraudRingModel() {
		// TODO Auto-generated constructor stub
	}
	public List<Object> getClient_id() {
		return client_id;
	}
	public void setClient_id(List<Object> client_id) {
		this.client_id = client_id;
	}
	public List<Object> getContactType() {
		return contactType;
	}
	public void setContactType(List<Object> contactType) {
		this.contactType = contactType;
	}
	public int getRing_size() {
		return ring_size;
	}
	public void setRing_size(int ring_size) {
		this.ring_size = ring_size;
	}
	
	
	
	

}
