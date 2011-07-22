package org.mule.components.siebel.api.opportunity;

import org.mule.components.siebel.siebelCloudConnector;
import org.mule.components.siebel.api.siebelOpportunityInterface;

import com.siebel.data.SiebelDataBean;
import com.siebel.data.SiebelException;

public class siebelOpportunityClient implements siebelOpportunityInterface {
	
	private SiebelDataBean client = null;
	private String siebelOptyObject = "Opportunity";
	private String siebelOptyField = "Name";
	private String siebelAcctObject;
	private String siebelAcctField;
	private String siebelContObject;
	private String siebelContField_FirstName;
	private String siebelContField_LastName;
	
	private siebelCloudConnector createOpty = null;
	private siebelCloudConnector deleteOpty = null;
	private siebelCloudConnector updateOpty = null;
	private String searchSpecOpty;
	private String searchSpecAcct;
	private String searchSpecCont;
	private String MVGBusComp = "Contact Last Name";
	
    /**
     * Creates a new opportunity
     * 
     * Example: {@code <siebel:create-opportunity opportunityName="MuleSoft_Opportunity"/>}
     * @param opportunityName : new opportunity's name (required)
     * @throws SiebelException
     */
	public void createOpportunity(String opportunityName) throws SiebelException {

		createOpty = new siebelCloudConnector();
		searchSpecOpty = "[" + siebelOptyField + "] = '" + opportunityName + "'";
		client = createOpty.login();
		client = createOpty.performCreateOperation(client, siebelOptyObject, siebelOptyField, opportunityName, searchSpecOpty);
		createOpty.saveRecord();
		createOpty.logoff(client);
		createOpty = null;
		client = null;
	}
	
    /**
     * Deletes an opportunity
     * 
     * Example: {@code <siebel:delete-opportunity opportunityName="MuleSoft_Opportunity"/>}
     * @param opportunityName : opportunity's name
     * @throws SiebelException
     */
	public void deleteOpportunity(String opportunityName) throws SiebelException {

		deleteOpty = new siebelCloudConnector();
		searchSpecOpty = "[" + siebelOptyField + "] = '" + opportunityName + "'";
		client = deleteOpty.login();
		deleteOpty.performDeleteOperation(client, siebelOptyObject, siebelOptyField, searchSpecOpty);
		deleteOpty.logoff(client);
		deleteOpty = null;
		client = null;
	}
	
    /**
     * Updates an opportunity's account
     * 
     * Example: {@code <siebel:update-opportunity-account opportunityName="MuleSoft_Opportunity" accountName="MuleSoft_Account" />}
     * @param opportunityName : opportunity's name
     * @param accountName : account's name
     * @throws SiebelException
     */
	public void updateOpportunityAccount(String opportunityName, 
			                             String accountName) throws SiebelException {
		
		updateOpty = new siebelCloudConnector();
		siebelAcctObject = "Account";
		siebelAcctField = "Name";
		searchSpecOpty = "[" + siebelOptyField + "] = '" + opportunityName + "'";
		searchSpecAcct = "[" + siebelAcctField + "] = '" + accountName + "'";
		client = updateOpty.login();
		client = updateOpty.performUpdateOperation(client, siebelOptyObject, siebelOptyField, searchSpecOpty, siebelAcctObject, siebelAcctField, searchSpecAcct, false);
		updateOpty.saveRecord();
		updateOpty.logoff(client);
		updateOpty = null;
		client = null;
	}
	
    /**
     * Updates an opportunity's contact
     * 
     * Example: {@code <siebel:update-opportunity-contact opportunityName="MuleSoft_Opportunity" contactFirstName="MuleSoft_Contact_Firstname" contactLastName="MuleSoft_Contact_Lastname"/>}
     * @param opportunityName : opportunity's name
     * @param contactName : contact's name
     * @throws SiebelException
     */
	public void updateOpportunityContact(String opportunityName, 
			                             String contactFirstName, 
			                             String contactLastName) throws SiebelException {
		
		updateOpty = new siebelCloudConnector();
		updateOpty.setMVGBusComp(MVGBusComp);
		
		siebelContObject = "Contact";
		siebelContField_FirstName = "First Name";
		siebelContField_LastName = "Last Name";
		
		searchSpecOpty = "[" + siebelOptyField + "] = '" + opportunityName + "'";
		searchSpecCont = "[" + siebelContField_FirstName + "] = '" + contactFirstName + "' AND [" + siebelContField_LastName + "] = '" + contactLastName + "'";
		
		client = updateOpty.login();
		client = updateOpty.performUpdateOperation(client, siebelOptyObject, siebelOptyField, searchSpecOpty, siebelContObject, siebelContField_LastName, searchSpecCont, true);
		updateOpty.saveRecord();
		updateOpty.logoff(client);
		updateOpty = null;
		client = null;
	}
}
