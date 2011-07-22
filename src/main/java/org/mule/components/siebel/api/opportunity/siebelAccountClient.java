package org.mule.components.siebel.api.opportunity;

import org.mule.components.siebel.siebelCloudConnector;
import org.mule.components.siebel.api.siebelAccountInterface;

import com.siebel.data.SiebelDataBean;
import com.siebel.data.SiebelException;

public class siebelAccountClient implements siebelAccountInterface {
	
	private SiebelDataBean client = null;
	private String siebelObject = "Account";
	private String siebelField = "Name";
	
	private siebelCloudConnector createAccount = null;
	private siebelCloudConnector deleteAccount = null;
	private String searchSpecAcct;
	
    /**
     * Creates a new account
     * 
     * Example: {@code <siebel:create-account accountName="MuleSoft_Account"/>}
     * @param accountName : new account's name (required)
     * @throws SiebelException
     */
	public void createAccount(String accountName) throws SiebelException {

		createAccount = new siebelCloudConnector();
		searchSpecAcct = "[" + siebelField + "] = '" + accountName + "'";
		client = createAccount.login();
		client = createAccount.performCreateOperation(client, siebelObject, siebelField, accountName, searchSpecAcct);
		createAccount.saveRecord();
		createAccount.logoff(client);
		createAccount = null;
		client = null;
	}
	
    /**
     * Deletes an account
     * 
     * Example: {@code <siebel:delete-account accountName="MuleSoft_Account"/>}
     * @param accountName : account's name
     * @throws SiebelException
     */
	public void deleteAccount(String accountName) throws SiebelException {
		
		deleteAccount = new siebelCloudConnector();
		searchSpecAcct = "[" + siebelField + "] = '" + accountName + "'";
		client = deleteAccount.login();
		deleteAccount.performDeleteOperation(client, siebelObject, siebelField, searchSpecAcct);
		deleteAccount.logoff(client);
		deleteAccount = null;
		client = null;
	}
}