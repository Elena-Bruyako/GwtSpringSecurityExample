package com.bruyako.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by brunyatko on 23.03.16.
 */
public interface MainRpcServiceAsync {
    void gwtAppCallServer(String data, AsyncCallback<String> callback) throws IllegalArgumentException;
}
