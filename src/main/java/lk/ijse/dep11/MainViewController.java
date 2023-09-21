package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainViewController {
    public AnchorPane root;
    public TextArea txtTextArea;
    public MenuItem mbFileNew;
    public MenuItem mbFileOpen;
    public MenuItem mbFileExit;
    public MenuItem mbHelpUserGuide;
    public MenuItem mbAboutUs;
    public MenuItem mbFileSave;


    public void mbFileNewOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane mainRoot= FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
        Scene newMainScene=new Scene(mainRoot);
        Stage mainStage=new Stage();
        mainStage.setTitle("Untitled Document");
        mainStage.setScene(newMainScene);
        mainStage.centerOnScreen();
        mainStage.show();
    }

    public void mbFileOpenOnAction(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser=new FileChooser();
        fileChooser.setTitle("Open Text File");
        File file=fileChooser.showOpenDialog(root.getScene().getWindow());

        FileInputStream fis=new FileInputStream(file);
        BufferedInputStream bis=new BufferedInputStream(fis);
        try{
            byte[] buffer=new byte[1024];
            int read=-1;
            while ((read= bis.read(buffer))!=-1){
                txtTextArea.setText(new String(buffer,0,read));
            }
        }finally {
            bis.close();
        }

    }

    public void mbFileExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void mbHelpUserGuideOnAction(ActionEvent actionEvent) {
    }

    public void mbAboutUsOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane root1=FXMLLoader.load(getClass().getResource("/view/AboutUsView.fxml"));
        Scene aboutScene=new Scene(root1);
        Stage aboutStage=new Stage();
        aboutStage.setScene(aboutScene);
        aboutStage.setTitle("About Us");
        aboutStage.centerOnScreen();
        aboutStage.initModality(Modality.APPLICATION_MODAL);
        aboutStage.show();
    }

    public void mbFileSaveOnAction(ActionEvent actionEvent) {

    }
}
