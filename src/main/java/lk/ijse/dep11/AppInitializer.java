package lk.ijse.dep11;

import javafx.animation.PauseTransition;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        AnchorPane root= FXMLLoader.load(getClass().getResource("/view/StartView.fxml"));
        Scene startScene=new Scene(root);
        primaryStage.setScene(startScene);
        primaryStage.setTitle("Text Editor");

        primaryStage.initStyle(StageStyle.TRANSPARENT);
        root.setBackground(Background.fill(Color.TRANSPARENT));
        startScene.setFill(Color.TRANSPARENT);
        primaryStage.centerOnScreen();
        primaryStage.show();

        PauseTransition delay=new PauseTransition(Duration.seconds(1.0));
        delay.setOnFinished(e->{
            primaryStage.close();
            AnchorPane rootMain= null;
            try {
                rootMain = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
                Scene mainScene=new Scene(rootMain);
                Stage mainStage=new Stage();
                mainStage.setScene(mainScene);
                mainStage.setTitle("Text Editor");
                mainStage.centerOnScreen();
                mainStage.show();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        delay.play();
    }
}
