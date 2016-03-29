package com.bruyako.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

/**
 * Created by brunyatko on 23.03.16.
 */
@RemoteServiceRelativePath("remoteService")
public interface MainRpcService extends RemoteService {
    String gwtAppCallServer(String data) throws IllegalArgumentException;
}
