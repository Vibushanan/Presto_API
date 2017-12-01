package com.slk.Neo.FraudRing.Templates;

import java.sql.Time;


import org.neo4j.driver.v1.Session;

public interface SessionHandler {
	
	public Session getCurrentSession();
	
	public void initializeSession(String bolt_url,String userName, String Password);
	
	public void closeCurrentSession();
	
	public void modifySessionTimeOut(Time time);
	
	public void getSessionTimeOut();

}
