package com.bruyako.client;

import com.bruyako.client.ui.HomeScreen;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.logging.client.SimpleRemoteLogHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * Created by brunyatko on 23.03.16.
 */
public class Main implements EntryPoint{

    private final SimpleRemoteLogHandler remoteLog = new SimpleRemoteLogHandler();
    private HomeScreen homeScreen = new HomeScreen();

    private final MainRpcServiceAsync gwtTestService = GWT.create(MainRpcService.class);

    public void onModuleLoad() {
        RootLayoutPanel.get().add(homeScreen);

        gwtTestService.gwtAppCallServer("", new AsyncCallback<String>() {

            @Override
            public void onSuccess(String result) {
                homeScreen.setUpdateName(result);
                remoteLog.publish(new LogRecord(Level.INFO, "User " + result + " successfully logged in"));
            }

            @Override
            public void onFailure(Throwable caught) {

            }
        });
    }
}
