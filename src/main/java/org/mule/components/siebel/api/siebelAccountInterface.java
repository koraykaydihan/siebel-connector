package org.mule.components.siebel.api;

import com.siebel.data.SiebelException;

public interface siebelAccountInterface {

    /**
     * Creates a new account
     * 
     * Example: {@code <siebel:create-account accountName="MuleSoft_Account"/>}
     * @param accountName : new account's name (required)
     * @throws SiebelException
     */
	public void createAccount(String accountName) throws SiebelException;
	
    /**
     * Deletes an account
     * 
     * Example: {@code <siebel:delete-account accountName="MuleSoft_Account"/>}
     * @param accountName : account's name
     * @throws SiebelException
     */
	public void deleteAccount(String accountName) throws SiebelException;
}