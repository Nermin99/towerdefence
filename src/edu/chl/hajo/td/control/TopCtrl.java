package edu.chl.hajo.td.control;

import edu.chl.hajo.td.event.EventBus;
import edu.chl.hajo.td.event.IEventHandler;
import edu.chl.hajo.td.event.ModelEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/*
        Control to display data coming from model (points, damage)
        See top.fxml
 */
public class TopCtrl implements IEventHandler {
    @FXML
    private Label points;
    @FXML
    private Label damage;

    // To be able to get ModelEvents
    public void initialize() {
        EventBus.INSTANCE.register(this);
    }

    @Override
    public void onModelEvent(ModelEvent evt) {
        // TODO set points and damage
    }
}
