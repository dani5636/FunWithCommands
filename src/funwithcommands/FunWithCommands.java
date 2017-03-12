/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithcommands;

import java.io.IOException;
import java.net.URISyntaxException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Stegger
 */
public class FunWithCommands extends Application
{

    @Override
    public void start(Stage primaryStage) throws IOException, URISyntaxException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/funwithcommands/gui/view/MainView.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setTitle("Command - Execute 'n' undo!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}
