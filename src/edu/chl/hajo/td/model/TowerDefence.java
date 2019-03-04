package edu.chl.hajo.td.model;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/*

    Class representing the full Game

    GUI class will go to this class
    GUI need some getters to display the model (parts)

 */
public class TowerDefence {

    //TODO Replace with your class

    public static final long ONE_SEC = 1_000_000_000;
    public static final long TENTH_SEC = 100_000_000;

    @Getter
    private final List<Object> towers = new ArrayList<>();
    @Getter
    private final List<Object> waves = new ArrayList<>();

    public void update(long now) {
    }




}
