package edu.chl.hajo.td.model;

import edu.chl.hajo.td.util.Point2D;
import lombok.Getter;


/*
     The logical Map

     This map uses (x, y) with y pointing down because
     "Tiled" library uses same and also graphics output
 */
public class TDMap {

    private final int tileSize;
    @Getter
    private final TDTile[][] tiles;


    public TDMap(TDTile[][] logicTiles, int tileSize) {
        this.tiles = logicTiles;
        this.tileSize = tileSize;
    }

    // TODO Replace with your class

}
