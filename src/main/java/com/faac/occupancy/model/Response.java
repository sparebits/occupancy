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
    private Object item;
    
    public Response() {
        this.responseType = ResponseType.ok;
    }
    
    public Response(ResponseType type) {
        this.responseType = type;
    }
    
    public Response(Object item, ResponseType type) {
        this.item = item;
        this.responseType = type;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

}
