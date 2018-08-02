/**
 * 
 */
package com.faac.occupancy.model;

/**
 * @author nneikov
 *
 */
public class Response {
    
    private ResponseType responseType;
    
    public Response() {
        this.responseType = ResponseType.ok;
    }
    
    public Response(ResponseType type) {
        this.responseType = type;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

}
