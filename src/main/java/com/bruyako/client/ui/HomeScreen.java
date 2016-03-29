package com.bruyako.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by brunyatko on 24.03.16.
 */
public class HomeScreen extends Composite {

    @UiField
    Button button;

    @UiField
    Label label;

    private static HomeScreenUiBinder ourUiBinder = GWT.create(HomeScreenUiBinder.class);

    interface HomeScreenUiBinder extends UiBinder<Widget, HomeScreen> {
    }

    public HomeScreen() {
        initWidget(ourUiBinder.createAndBindUi(this));

        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                Window.alert("Hello");
            }
        });
    }

    public void setUpdateName(String name) {
        label.setText("Hello " + name + " !");
    }
}