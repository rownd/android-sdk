/*
 * RowndSdk
 *
 * This file was automatically generated for rownd-sdk by APIMATIC v2.0 ( https://apimatic.io ).
 */
package io.rownd.platform.sdk.http.client;

import io.rownd.platform.sdk.http.request.HttpRequest;

/**
 * Callback to be called before and after the HTTP call for an endpoint is made 
 */
public interface HttpCallBack {
    /**
     * Callback called just before the HTTP request is sent 
     * @param request The HTTP request to be executed
     */
    public void OnBeforeRequest(HttpRequest request);
    
    /**
     * Callback called just after the HTTP response is received
     * @param context Context for the HTTP call
     */
    public void OnAfterResponse(HttpContext context);
}