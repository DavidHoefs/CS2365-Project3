/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author hoefs
 */
public class Project3GUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
         ArrayList<String> cards = new ArrayList<>();

        for (int i = 0; i < 52; i++) {
            cards.add(String.valueOf(i + 1));
        }
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        java.util.Collections.shuffle(cards);

        ImageView view1 = new ImageView(
                new Image("https://liveexample.pearsoncmg.com/book/image/card/" + cards.get(0) + ".png"));
        ImageView view2 = new ImageView(
                new Image("https://liveexample.pearsoncmg.com/book/image/card/" + cards.get(1) + ".png"));
        ImageView view3 = new ImageView(
                new Image("https://liveexample.pearsoncmg.com/book/image/card/" + cards.get(2) + ".png"));
        
        grid.add(view1, 0, 0);
        grid.add(view2,0,1);
        grid.add(view3,0,2);
        grid.setAlignment(Pos.TOP_LEFT);
        HBox root = new HBox();
        
//        root.getChildren().add(view1);
//        root.getChildren().add(view2);
//        root.getChildren().add(view3);

        Scene scene = new Scene(grid);

        primaryStage.setTitle("BANG!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
