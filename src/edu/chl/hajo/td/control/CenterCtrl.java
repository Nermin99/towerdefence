package edu.chl.hajo.td.control;

import edu.chl.hajo.td.ServiceLocator;
import edu.chl.hajo.td.model.TowerDefence;
import edu.chl.hajo.td.model.towers.AbstractTower;
import edu.chl.hajo.td.model.towers.TowerFactory;
import edu.chl.hajo.td.util.Point2D;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import static edu.chl.hajo.td.model.towers.TowerFactory.Type.NONE;

/*
        Controller for center drawing/animation area
        See center.fxml
 */
public class CenterCtrl {

    @FXML
    public void handleMouseClicked(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        TowerFactory.Type selectedTowerType = RightCtrl.getSelectedTowerType();
        // TODO
        System.out.println(selectedTowerType);
        tryPlaceTower(selectedTowerType, x, y);
    }

    private void tryPlaceTower(TowerFactory.Type selectedTowerType, double x, double y) {
        // TODO
        GameLoop.getTowerDefence().addTower(TowerFactory.getTower(selectedTowerType, new Point2D(x, y)));

    }
}





