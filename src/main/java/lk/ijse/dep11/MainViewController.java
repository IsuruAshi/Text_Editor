package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.*;

public class MainViewController {
    public AnchorPane root;
    //public TextArea txtTextArea;
    public MenuItem mbFileNew;
    public MenuItem mbFileOpen;
    public MenuItem mbFileExit;
    public MenuItem mbHelpUserGuide;
    public MenuItem mbAboutUs;
    public MenuItem mbFileSave;
    public MenuItem mbEditSelectAll;
    public HTMLEditor txtTexthtml;


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
                txtTexthtml.setHtmlText(new String(buffer,0,read));
            }
//        txtTexthtml.setHtmlText(new String(bis.readAllBytes()));

        }finally {
            bis.close();
        }

    }
    public void mbFileSaveOnAction(ActionEvent actionEvent) throws IOException {
        String text=txtTexthtml.getHtmlText();
        FileChooser fileChooser=new FileChooser();
        fileChooser.setTitle("Save Location");
        File file=fileChooser.showOpenDialog(root.getScene().getWindow());
        FileOutputStream fos=new FileOutputStream(file);
        BufferedOutputStream bos=null;
        try {

            bos = new BufferedOutputStream(fos);
            bos.write(text.getBytes());
        }finally {
            bos.close();
        }
    }

    public void mbFileExit(ActionEvent actionEvent) {
       Stage stage= (Stage) root.getScene().getWindow();
       stage.close();
    }

    public void mbHelpUserGuideOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane root2=FXMLLoader.load(getClass().getResource("/view/UserGuideView.fxml"));
        Scene userScene=new Scene(root2);
        Stage userStage=new Stage();
        userStage.setScene(userScene);
        userStage.initModality(Modality.APPLICATION_MODAL);
        userStage.centerOnScreen();
        userStage.show();
    }

    public void mbAboutUsOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane root1=FXMLLoader.load(getClass().getResource("/view/AboutUsView.fxml"));
        Scene aboutScene=new Scene(root1);
        Stage aboutStage=new Stage();
        aboutStage.setScene(aboutScene);
        aboutStage.setTitle("About Us");
        aboutStage.centerOnScreen();
        aboutStage.initStyle(StageStyle.TRANSPARENT);
        root1.setBackground(Background.fill(Color.TRANSPARENT));
        aboutScene.setFill(Color.TRANSPARENT);
        aboutStage.show();
    }


}
