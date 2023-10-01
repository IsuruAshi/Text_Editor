package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
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
    public TextArea txtTexthtml;
    public MenuItem mbEditCut;
    public MenuItem mbEditCopy;
    public MenuItem mbEditPaste;

    String selectedText;


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
        if(file!=null){
            FileInputStream fis=new FileInputStream(file);
            BufferedInputStream bis=new BufferedInputStream(fis);
            try{
                byte[] buffer=new byte[1024];
                int read=-1;
                while ((read= bis.read(buffer))!=-1){
                    txtTexthtml.setText(new String(buffer,0,read));
                }
            }finally {
                bis.close();
            }
        }
    }
    public void mbFileSaveOnAction(ActionEvent actionEvent) throws IOException {
        String text=txtTexthtml.getText();
        FileChooser fileChooser=new FileChooser();
        fileChooser.setTitle("Save Location");
        File file=fileChooser.showSaveDialog(root.getScene().getWindow());
        if (file!=null){
            FileOutputStream fos=new FileOutputStream(file);
            BufferedOutputStream bos=new BufferedOutputStream(fos);
            try {
                bos.write(text.getBytes());
            }finally {
                bos.close();
            }
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
        try {
            aboutStage.initStyle(StageStyle.TRANSPARENT);
            root1.setBackground(Background.fill(Color.TRANSPARENT));
            aboutScene.setFill(Color.TRANSPARENT);

        }catch (ClassCastException e){

        }
        aboutStage.show();
    }

    public void mbEditCutOnAction(ActionEvent e) {
        selectedText = txtTexthtml.getSelectedText();
        if(!selectedText.isEmpty()){
            Clipboard clipboard=Clipboard.getSystemClipboard();
            ClipboardContent content=new ClipboardContent();
            content.putString(selectedText);
            clipboard.setContent(content);
            txtTexthtml.deleteText(txtTexthtml.getSelection());
        }
    }

    public void mbEditCopyOnAction(ActionEvent actionEvent) {
        selectedText= txtTexthtml.getSelectedText();
        if(!selectedText.isEmpty()){
            Clipboard clipboard=Clipboard.getSystemClipboard();
            ClipboardContent content=new ClipboardContent();
            content.putString(selectedText);
            clipboard.setContent(content);

        }
    }

    public void mbEditPasteOnAction(ActionEvent actionEvent) {
        Clipboard clipboard=Clipboard.getSystemClipboard();
        if(clipboard.hasString()){
            txtTexthtml.insertText(txtTexthtml.getCaretPosition(),selectedText);
        }
    }

    public void mbEditSelectAllOnAction(ActionEvent e) {
        txtTexthtml.selectAll();
    }
}
