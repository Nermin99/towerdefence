package edu.chl.hajo.td.model;

import edu.chl.hajo.td.model.creeps.AbstractCreep;
import edu.chl.hajo.td.model.creeps.Creep;
import edu.chl.hajo.td.util.Point2D;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 *    A Wave of creeps
 *    - All creeps of same kind
 *    - All follow same path.
 *
 */

public class Wave implements Iterable<Creep> {
    private final AbstractCreep prototype;

    // TODO
    private long lastSpawned = 0;

    @Getter
    private int  nCreeps;

    @Getter
    private long waveDelay;
    private long spawnRate;

    @Getter
    private List<Creep> creepList      = new ArrayList<>();

    private List<Creep> deadCreeps     = new ArrayList<>();
    private List<Creep> finishedCreeps = new ArrayList<>();


    public Wave(int nCreeps, long waveDelay, long spawnRate, AbstractCreep creep) {
        this.nCreeps   = nCreeps;
        this.waveDelay = waveDelay;
        this.spawnRate = spawnRate;
        this.prototype = creep;
    }

    public void move() {
        for (Creep c : creepList) {
            Point2D nextCheckPoint = c.getNextCheckPoint(c.getCurrentCheckPoint());
            boolean reachedEnd = nextCheckPoint == c.getNextCheckPoint(nextCheckPoint);

            if (reachedEnd) {
                finishedCreeps.add(c);
                nCreeps--;
            } else if (c.getHp() <= 0) {
                deadCreeps.add(c);
                nCreeps--;
            }
        }
        creepList.removeAll(finishedCreeps);
        creepList.removeAll(deadCreeps);

        for (Creep c : creepList) {
            c.move();
        }
    }

    public int getPoints() {
        int points = 0;

        for (Creep c : deadCreeps) {
            points += c.getKillPoints();
        }

        deadCreeps.clear();
        return points;
    }

    public int getDamage() {
        int damage = 0;

        for (Creep c : finishedCreeps) {
            damage += c.getDamage();
        }

        finishedCreeps.clear();
        return damage;
    }

    public void spawn(long now) {
        lastSpawned = lastSpawned == 0 ? now : lastSpawned;

        long delta = now - lastSpawned;

        long delay = creepList.size() == 0 ? waveDelay : spawnRate;

        if (creepList.size() < nCreeps && delta >= delay) {
            creepList.add(prototype.copyOf());
            lastSpawned = now;
        }
    }

    @Override
    public Iterator<Creep> iterator() {
        return creepList.iterator();
    }
}
