package com.bruyako.client.ui;

import com.bruyako.client.ui.string.HomeMessages;
import com.bruyako.server.HomeServlet;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by brunyatko on 24.03.16.
 */
public class HomeScreen extends Composite {

    @UiField
    Button buttonSubmit;

    @UiField
    Label helloText;

    private static HomeScreenUiBinder ourUiBinder = GWT.create(HomeScreenUiBinder.class);
    private final Logger logger = Logger.getLogger(HomeScreen.class.getName());
    private static HomeMessages messages = GWT.create(HomeMessages.class);

    interface HomeScreenUiBinder extends UiBinder<Widget, HomeScreen> {
    }

    public HomeScreen() {
        initWidget(ourUiBinder.createAndBindUi(this));

        buttonSubmit.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                Window.Location.replace("/j_spring_security_logout");
            }
        });
    }

    public void setUpdateName(String name) {
        helloText.setText(getLocalizableMessage(name));
    }

    private String getLocalizableMessage(String userName) {

        Date date = new Date();
        int hours = date.getHours();
        if (hours >= 6 && hours < 9) {
            logger.log(Level.INFO, "Hello message was: " + messages.morning(userName));
            return messages.morning(userName);
        } else if (hours >= 9 && hours < 19) {
            logger.log(Level.INFO, "Hello message was: " + messages.day(userName));
            return messages.day(userName);
        } else if (hours >= 19 && hours < 23) {
            logger.log(Level.INFO, "Hello message was: " + messages.evening(userName));
            return messages.evening(userName);
        } else {
            logger.log(Level.INFO, "Hello message was: " + messages.night(userName));
            return messages.night(userName);
        }
    }
}