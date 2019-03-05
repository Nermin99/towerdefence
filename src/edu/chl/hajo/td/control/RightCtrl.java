package edu.chl.hajo.td.control;


import edu.chl.hajo.td.IRenderer;
import edu.chl.hajo.td.ServiceLocator;
import edu.chl.hajo.td.event.EventBus;
import edu.chl.hajo.td.event.IEventHandler;
import edu.chl.hajo.td.event.ModelEvent;
import edu.chl.hajo.td.file.LevelData;
import edu.chl.hajo.td.file.MapData;
import edu.chl.hajo.td.file.TDReader;
import edu.chl.hajo.td.model.TDBuilder;
import edu.chl.hajo.td.model.TowerDefence;
import edu.chl.hajo.td.model.towers.TowerFactory;
import edu.chl.hajo.td.view.Renderer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

import static edu.chl.hajo.td.model.towers.TowerFactory.Type.NONE;

/*
           Main control for starting game, selecting towers.
           See right.fxml
 */
public class RightCtrl implements IEventHandler {
    private TowerDefence td;

    @FXML
    private Button start;  // GUI components
    @FXML
    private VBox towerBtns;

    // Should come from config file
    private final List<String> levels = Arrays.asList("level1.json" /*,"level2.json", etc */);
    private final int currentLevelIndex = 0;
    private GameLoop gameLoop;

    public void initialize() {
        EventBus.INSTANCE.register(this);
    }

    @FXML
    public void start(MouseEvent mouseEvent) {
        try {
            LevelData levelData = TDReader.readLevel(levels.get(currentLevelIndex));
            MapData mapData = TDReader.readMap(levelData.tileMapFileName);
            // TODO Create model
            td = TDBuilder.build(levelData, mapData);
            ServiceLocator.INSTANCE.getRenderer().renderBackground(mapData.visualMap);
            // TODO Create GameLoop
            gameLoop = new GameLoop(td, ServiceLocator.INSTANCE.getRenderer());
            // TODO Start game loop
            gameLoop.start();

            fixButtons();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Something went wrong");
            alert.setHeaderText("Possible corrupt JSON or other file: " + e.getMessage());
            alert.setContentText("Will abort");
            alert.showAndWait();
            System.exit(1);
        }
    }

    // ---------------  Selected tower handling -------------------------

    @Getter  // Getter for other controls
    private static TowerFactory.Type selectedTower = NONE;

    // NOTE: Will reset selection!
    public static TowerFactory.Type getSelectedTowerType() {
        TowerFactory.Type tmp = selectedTower;
        selectedTower = NONE;
        return tmp;
    }

    @FXML
    public void selectTower(ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        selectedTower = TowerFactory.Type.valueOf(b.getId());
    }

    // --------------- Events from model -----------------------------

    @Override
    public void onModelEvent(ModelEvent evt) {
        // TODO
        if (evt.getType() == ModelEvent.Type.NEW_TOWER) {

//            GameLoop.getTowerDefence();

        }
    }

    // ----------- Fix buttons --------------

    private void fixButtons() {
        start.setDisable(gameLoop.isRunning());
        towerBtns.setDisable(!gameLoop.isRunning());
    }


}
