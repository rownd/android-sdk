/*
 * RowndSdk
 *
 * This file was automatically generated for rownd-sdk by APIMATIC v2.0 ( https://apimatic.io ).
 */
package io.rownd.platform.sdk;

import io.rownd.platform.sdk.controllers.*;
import io.rownd.platform.sdk.http.client.HttpClient;

public class RowndSdkClient {
    /**
     * Singleton access to AddUserData controller
     * @return	Returns the AddUserDataController instance 
     */
    public AddUserDataController getAddUserData() {
        return AddUserDataController.getInstance();
    }

    /**
     * Singleton access to GetUserData controller
     * @return	Returns the GetUserDataController instance 
     */
    public GetUserDataController getGetUserData() {
        return GetUserDataController.getInstance();
    }

    /**
     * Singleton access to DeleteUserData controller
     * @return	Returns the DeleteUserDataController instance 
     */
    public DeleteUserDataController getDeleteUserData() {
        return DeleteUserDataController.getInstance();
    }

    /**
     * Get the shared http client currently being used for API calls
     * @return The http client instance currently being used
     */
    public HttpClient getSharedHttpClient() {
        return BaseController.getClientInstance();
    }
    
    /**
     * Set a shared http client to be used for API calls
     * @param httpClient The http client to use
     */
    public void setSharedHttpClient(HttpClient httpClient) {
        BaseController.setClientInstance(httpClient);
    }

    /**
     * Default constructor 
     */     
    public RowndSdkClient() {
        Configuration.xRowndAppKey = "\"TODO: Replace\"";
        Configuration.xRowndAppSecret = "\"TODO: Replace\"";
    }

    /**
     * Client initialization constructor 
     */     
    public RowndSdkClient(String xRowndAppKey, String xRowndAppSecret) {
        this();
        if(xRowndAppKey != null) Configuration.xRowndAppKey = xRowndAppKey;
        if(xRowndAppSecret != null) Configuration.xRowndAppSecret = xRowndAppSecret;
    }
}