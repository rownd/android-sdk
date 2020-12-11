/*
 * RowndSdk
 *
 * This file was automatically generated for rownd-sdk by APIMATIC v2.0 ( https://apimatic.io ).
 */
package io.rownd.platform.sdk.controllers;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import io.rownd.platform.sdk.*;
import io.rownd.platform.sdk.models.*;
import io.rownd.platform.sdk.exceptions.*;
import io.rownd.platform.sdk.http.client.HttpClient;
import io.rownd.platform.sdk.http.client.HttpContext;
import io.rownd.platform.sdk.http.request.HttpRequest;
import io.rownd.platform.sdk.http.response.HttpResponse;
import io.rownd.platform.sdk.http.response.HttpStringResponse;
import io.rownd.platform.sdk.http.client.APICallBack;

public class DeleteUserDataController extends BaseController {
    //private static variables for the singleton pattern
    private static final Object syncObject = new Object();
    private static DeleteUserDataController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the DeleteUserDataController class 
     */
    public static DeleteUserDataController getInstance() {
        if (null == instance) {
            synchronized (syncObject) {
                if (null == instance) {
                    instance = new DeleteUserDataController();
                }
            }
        }
        return instance;
    }

    /**
     * To delete a user's ID and data.
     * @param    app    Required parameter: The ROWND application ID (get it from https://app.rownd.io)
     * @param    user    Required parameter: This is the ROWND user ID (that app passed to Rownd)
     */
    public void deleteApplicationUserDataDeleteAsync(
                final String app,
                final String user,
                final APICallBack<Object> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildDeleteApplicationUserDataDeleteRequest(app, user);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            _handleDeleteApplicationUserDataDeleteResponse(_context);
                            callBack.onSuccess(_context, null);
                        } catch (Exception e) {
                            callBack.onFailure(_context, e);
                        }
                    }

                    public void onFailure(HttpContext _context, Throwable _exception) {
                        // Let the caller know of the failure
                        callBack.onFailure(_context, _exception);
                    }
                });
            }
        };

        // Execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * Builds the HttpRequest object for deleteApplicationUserDataDelete
     */
    private HttpRequest _buildDeleteApplicationUserDataDeleteRequest(
                final String app,
                final String user) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/applications/{app}/users/{user}/data");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("app", app);
        _templateParameters.put("user", user);
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("x-rownd-app-key", Configuration.xRowndAppKey);
        _headers.put("x-rownd-app-secret", Configuration.xRowndAppSecret);

        _headers.put("user-agent", BaseController.userAgent);


        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().delete(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        // Custom Authentication to be added for authorization
        CustomAuthUtility.appendCustomAuthParams(_request);

        return _request;
    }

    /**
     * Processes the response for deleteApplicationUserDataDelete
     */
    private void _handleDeleteApplicationUserDataDeleteResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //handle errors defined at the API level
        validateResponse(_response, _context);


    }

}
