package com.bruyako.server;

import com.bruyako.client.MainRpcService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by brunyatko on 23.03.16.
 */
public class HomeServlet extends RemoteServiceServlet implements MainRpcService {

    public String gwtAppCallServer(String data) throws IllegalArgumentException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        return name;
    }

}
