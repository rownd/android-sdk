/*
 * RowndSdk
 *
 * This file was automatically generated for rownd-sdk by APIMATIC v2.0 ( https://apimatic.io ).
 */
package io.rownd.platform.sdk.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class AppUserDataList 
        extends java.util.Observable
        implements java.io.Serializable {
    private static final long serialVersionUID = -7920081949430474593L;
    private Double totalResults;
    private AppUserData results;
    /** GETTER
     * Number of total users
     */
    @JsonGetter("total_results")
    public Double getTotalResults ( ) { 
        return this.totalResults;
    }
    
    /** SETTER
     * Number of total users
     */
    @JsonSetter("total_results")
    public void setTotalResults (Double value) { 
        this.totalResults = value;
        notifyObservers(this.totalResults);
    }
 
    /** GETTER
     * The user data from the query.
     */
    @JsonGetter("results")
    public AppUserData getResults ( ) { 
        return this.results;
    }
    
    /** SETTER
     * The user data from the query.
     */
    @JsonSetter("results")
    public void setResults (AppUserData value) { 
        this.results = value;
        notifyObservers(this.results);
    }
 
}
