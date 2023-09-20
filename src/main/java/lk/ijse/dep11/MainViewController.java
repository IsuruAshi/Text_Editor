package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {
    public AnchorPane root;
    public TextArea txtTextArea;
    public MenuItem mbFileNew;
    public MenuItem mbFileOpen;
    public MenuItem mbFileExit;
    public MenuItem mbHelpUserGuide;
    public MenuItem mbAboutUs;


    public void mbFileNewOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane mainRoot= FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
        Scene newMainScene=new Scene(mainRoot);
        Stage mainStage=new Stage();
        mainStage.setTitle("Untitled Document");
        mainStage.setScene(newMainScene);
        mainStage.centerOnScreen();
        mainStage.show();
    }

    public void mbFileOpenOnAction(ActionEvent actionEvent) {
    }

    public void mbFileExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void mbHelpUserGuideOnAction(ActionEvent actionEvent) {
    }

    public void mbAboutUsOnAction(ActionEvent actionEvent) {
    }
}
