/*
 * RowndSdk
 *
 * This file was automatically generated for rownd-sdk by APIMATIC v2.0 ( https://apimatic.io ).
 */
package io.rownd.platform.sdk.controllers;


import io.rownd.platform.sdk.exceptions.*;
import io.rownd.platform.sdk.http.client.HttpClient;
import io.rownd.platform.sdk.http.client.HttpContext;
import io.rownd.platform.sdk.http.client.HttpCallBack;
import io.rownd.platform.sdk.http.client.OkClient;
import io.rownd.platform.sdk.http.response.HttpResponse;

public abstract class BaseController {
    /**
     * Private variable to keep shared reference of client instance
     */
    private static HttpClient clientInstance = null;
    private static final Object syncObject = new Object();
    protected static final String userAgent = "Android";

    /**
     * Protected variable to keep reference of httpCallBack instance if user provides any
     */
    protected HttpCallBack httpCallBack = null;
    
    /**
     * Get httpCallBack associated with this controller
     * @return HttpCallBack
     */
    public HttpCallBack getHttpCallBack() {
        return httpCallBack;
    }
    
    /**
     * Set the httpCallBack for this controller
     * @param httpCallBack
     */
    public void setHttpCallBack(HttpCallBack httpCallBack) {
        this.httpCallBack = httpCallBack;
    }

    /**
     * Shared instance of the Http client
     * @return The shared instance of the http client 
     */
    public static HttpClient getClientInstance() {
        if (null == clientInstance) {
            synchronized (syncObject) {
                if (null == clientInstance) {
                    clientInstance = OkClient.getSharedInstance();
                }
            }
        }
        return clientInstance;
    }

    /**
     * Shared instance of the Http client
     * @param    client    The shared instance of the http client 
     */
    public static void setClientInstance(HttpClient client) {
        if (null != client) {
            synchronized (syncObject) {
                if (null != client) {
                    clientInstance = client;
                }
            }
        }
    }
    /**
     * Validates the response against HTTP errors defined at the API level
     * @param   _response    The response recieved
     * @param   context     Context of the request and the recieved response 
     */
    protected void validateResponse(HttpResponse _response, HttpContext context) 
            throws APIException {
        //get response status code to validate
        int responseCode = _response.getStatusCode();
        if ((responseCode < 200) || (responseCode > 208)) { //[200,208] = HTTP OK
            throw new APIException("HTTP Response Not OK", context);
        }
    }
}
