/*
 * RowndSdk
 *
 * This file was automatically generated for rownd-sdk by APIMATIC v2.0 ( https://apimatic.io ).
 */
package io.rownd.platform.sdk.controllers;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import io.rownd.platform.sdk.*;
import io.rownd.platform.sdk.models.*;
import io.rownd.platform.sdk.exceptions.*;
import io.rownd.platform.sdk.http.client.HttpClient;
import io.rownd.platform.sdk.http.client.HttpContext;
import io.rownd.platform.sdk.http.request.HttpRequest;
import io.rownd.platform.sdk.http.response.HttpResponse;
import io.rownd.platform.sdk.http.response.HttpStringResponse;
import io.rownd.platform.sdk.http.client.APICallBack;

public class AddUserDataController extends BaseController {
    //private static variables for the singleton pattern
    private static final Object syncObject = new Object();
    private static AddUserDataController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the AddUserDataController class 
     */
    public static AddUserDataController getInstance() {
        if (null == instance) {
            synchronized (syncObject) {
                if (null == instance) {
                    instance = new AddUserDataController();
                }
            }
        }
        return instance;
    }

    /**
     * Create a user (by entering a new user ID below) or edit an existing user (by passing the previously sent userID) and add data to Rownd.  Note: all data added must be set up in the Rownd Data Privacy and Ownership platform (https://app.rownd.io)
     * @param    app    Required parameter: The ROWND application ID (get it from https://app.rownd.io)
     * @param    user    Required parameter: This is the ROWND user ID (that app passed to Rownd)
     * @param    body    Optional parameter: Pass Personal and Private data to the Rownd server.  Please note: Data type must be added to the app in the Rownd Platform (https://app.rownd.io).
     */
    public void updateApplicationUserDataUpsertAsync(
                final String app,
                final String user,
                final AppUserData body,
                final APICallBack<AppUserData> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildUpdateApplicationUserDataUpsertRequest(app, user, body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            AppUserData returnValue = _handleUpdateApplicationUserDataUpsertResponse(_context);
                            callBack.onSuccess(_context, returnValue);
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
     * Builds the HttpRequest object for updateApplicationUserDataUpsert
     */
    private HttpRequest _buildUpdateApplicationUserDataUpsertRequest(
                final String app,
                final String user,
                final AppUserData body) throws IOException, APIException {
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
        _headers.put("accept", "application/json");
        _headers.put("content-type", "application/json");


        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().putBody(_queryUrl, _headers, APIHelper.serialize(body));

        // Invoke the callback before request if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        // Custom Authentication to be added for authorization
        CustomAuthUtility.appendCustomAuthParams(_request);

        return _request;
    }

    /**
     * Processes the response for updateApplicationUserDataUpsert
     * @return An object of type AppUserData
     */
    private AppUserData _handleUpdateApplicationUserDataUpsertResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        AppUserData _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<AppUserData>(){});

        return _result;
    }

}
