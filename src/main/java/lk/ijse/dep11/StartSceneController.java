package lk.ijse.dep11;

import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;


public class StartSceneController {
    public AnchorPane root;
    public Point2D point;

    public void onMouseMove(MouseEvent mouseEvent) {
        Stage primaryStage= (Stage) root.getScene().getWindow();
        primaryStage.setX(mouseEvent.getScreenX()-point.getX());
        primaryStage.setY(mouseEvent.getScreenY()-point.getY());
    }

    public void onMouseClicked(MouseEvent e) {
        point=new Point2D(e.getX(),e.getY());
    }
}
