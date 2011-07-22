package org.mule.components.siebel.api;

import com.siebel.data.SiebelException;

public interface siebelOpportunityInterface {

    /**
     * Creates a new opportunity
     * 
     * Example: {@code <siebel:create-opportunity opportunityName="MuleSoft_Opportunity"/>}
     * @param opportunityName : new opportunity's name (required)
     * @throws SiebelException
     */
	public void createOpportunity(String opportunityName) throws SiebelException;
	
    /**
     * Deletes an opportunity
     * 
     * Example: {@code <siebel:delete-opportunity opportunityName="MuleSoft_Opportunity"/>}
     * @param opportunityName : opportunity's name
     * @throws SiebelException
     */
	public void deleteOpportunity(String opportunityName) throws SiebelException;
	
    /**
     * Updates an opportunity's account
     * 
     * Example: {@code <siebel:update-opportunity-account opportunityName="MuleSoft_Opportunity" accountName="MuleSoft_Account" />}
     * @param opportunityName : opportunity's name
     * @param accountName : account's name
     * @throws SiebelException
     */
	public void updateOpportunityAccount(String opportunityName,
			                             String accountName) throws SiebelException;
	
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
			                             String contactLastName) throws SiebelException;
}
