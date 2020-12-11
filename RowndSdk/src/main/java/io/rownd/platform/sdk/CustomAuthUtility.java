/*
 * RowndSdk
 *
 * This file was automatically generated for rownd-sdk by APIMATIC v2.0 ( https://apimatic.io ).
 */
package io.rownd.platform.sdk;

import io.rownd.platform.sdk.http.request.HttpRequest;

public class CustomAuthUtility {
    /**
    * Appends the necessary Custom Authentication credentials for making this authorized call
    * @param request The out going request to access the resource
    */
    public static void appendCustomAuthParams(HttpRequest request) {
        // TODO: Add your custom authentication here
        // The following properties are available to use
        //     Configuration.xRowndAppKey
        //     Configuration.xRowndAppSecret
        // 
        // ie. Add a header through:
        //     request.getHeaders().put("Key", "Value");
    }
}