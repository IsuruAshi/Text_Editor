package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class AboutUsSceneController {
    public AnchorPane root;
    public Button btnClose;
    Point2D point;

    public void onMouseMove(MouseEvent mouseEvent) {
        try {
            Stage stage= (Stage) root.getScene().getWindow();
            stage.setX(mouseEvent.getScreenX()-point.getX());
            stage.setY(mouseEvent.getScreenY()-point.getY());
        }catch (NullPointerException|ClassCastException e){

        }

    }


    public void KeyReleasedOnAction(KeyEvent e) {
        Stage stage= (Stage) root.getScene().getWindow();
        if(e.getCode()==KeyCode.ESCAPE)  stage.close();
    }

    public void OnMouseClicked(MouseEvent e) {
        point=new Point2D(e.getX(),e.getY());
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        Stage stage= (Stage) root.getScene().getWindow();
        stage.close();
    }
}
