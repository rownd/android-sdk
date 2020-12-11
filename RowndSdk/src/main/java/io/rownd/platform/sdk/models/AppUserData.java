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
public class AppUserData 
        extends java.util.Observable
        implements java.io.Serializable {
    private static final long serialVersionUID = -5559602634275416433L;
    private String rowndUser;
    private Object data;
    private List<String> redacted;
    private LinkedHashMap<String, String> revokeAfter;
    private LinkedHashMap<String, String> retainUntil;
    /** GETTER
     * User name that was send to Rownd
     */
    @JsonGetter("rownd_user")
    public String getRowndUser ( ) { 
        return this.rowndUser;
    }
    
    /** SETTER
     * User name that was send to Rownd
     */
    @JsonSetter("rownd_user")
    public void setRowndUser (String value) { 
        this.rowndUser = value;
        notifyObservers(this.rowndUser);
    }
 
    /** GETTER
     * The data that Rownd been sent.  Note: Data may have been redacted (see below)
     */
    @JsonGetter("data")
    public Object getData ( ) { 
        return this.data;
    }
    
    /** SETTER
     * The data that Rownd been sent.  Note: Data may have been redacted (see below)
     */
    @JsonSetter("data")
    public void setData (Object value) { 
        this.data = value;
        notifyObservers(this.data);
    }
 
    /** GETTER
     * Data that has been revoked by the end-user
     */
    @JsonGetter("redacted")
    public List<String> getRedacted ( ) { 
        return this.redacted;
    }
    
    /** SETTER
     * Data that has been revoked by the end-user
     */
    @JsonSetter("redacted")
    public void setRedacted (List<String> value) { 
        this.redacted = value;
        notifyObservers(this.redacted);
    }
 
    /** GETTER
     * Data that is going to be automatically revoked after the timestamps.
     */
    @JsonGetter("revoke_after")
    public LinkedHashMap<String, String> getRevokeAfter ( ) { 
        return this.revokeAfter;
    }
    
    /** SETTER
     * Data that is going to be automatically revoked after the timestamps.
     */
    @JsonSetter("revoke_after")
    public void setRevokeAfter (LinkedHashMap<String, String> value) { 
        this.revokeAfter = value;
        notifyObservers(this.revokeAfter);
    }
 
    /** GETTER
     * How long the data-type is guaranteed to be available (before end-users can revoke it)
     */
    @JsonGetter("retain_until")
    public LinkedHashMap<String, String> getRetainUntil ( ) { 
        return this.retainUntil;
    }
    
    /** SETTER
     * How long the data-type is guaranteed to be available (before end-users can revoke it)
     */
    @JsonSetter("retain_until")
    public void setRetainUntil (LinkedHashMap<String, String> value) { 
        this.retainUntil = value;
        notifyObservers(this.retainUntil);
    }
 
}
