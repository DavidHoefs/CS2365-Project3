/*
 * CS2365 FALL 2020 GRROUP PROJECT 3
 * Members: Javier Vasquez, Blane Brown, David Hoefs, Cole Townsend, Zach Hunt 
 */
package myproject3;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * Is the class for the base game JavaFX 
 * @author Blane Brown
 */
public class BangFXMain extends Application {
    //Data Members
    
    //array of player objects
    ArrayList<MyPlayer> players;
    
    //index is a players poition in the array of player objects
    //playerCount is the number of chosen players for the game
    //the rest of the counters keep track of how many of each a player has rolled
    //and they reset back to 0 after their turn
    //arrowPile starts at 9 and is put back to 9 once all arrows are taken
    int index = 0;
    boolean gameOver = false;
    int playerCount = 0;
    int dynamiteCount = 0;
    int arrowPile = 9;
    int beerCount = 0;
    int gatCount = 0;
    
    //used to determine if a player just died of if they've been dead
    boolean p1dead = false;
    boolean p2dead = false;
    boolean p3dead = false;
    boolean p4dead = false;
    boolean p5dead = false;
    boolean p6dead = false;
    boolean p7dead = false;
    boolean p8dead = false;
    
    
    //everything below is all FX related and used to change labels and disable
    //certain buttons
    Button saveRolls;
    Button p4;
    Button p5;
    Button p6;
    Button p7;
    Button p8;
    Button rollDice;
    Button nextPlayer;
    Label p1t;
    Label p2t;
    Label p3t;
    Label p4t;
    Label p5t;
    Label p6t;
    Label p7t;
    Label p8t;
    Label roll1;
    Label roll2;
    Label roll3;
    Label roll4;
    Label roll5;
    Label p1hp;
    Label p2hp;
    Label p3hp;
    Label p4hp;
    Label p5hp;
    Label p6hp;
    Label p7hp;
    Label p8hp;
    Label p1c;
    Label p2c;
    Label p3c;
    Label p4c;
    Label p5c;
    Label p6c;
    Label p7c;
    Label p8c;
    Label p1arrow;
    Label p2arrow;
    Label p3arrow;
    Label p4arrow;
    Label p5arrow;
    Label p6arrow;
    Label p7arrow;
    Label p8arrow;
    Label winner;
    CheckBox dice1;
    CheckBox dice2;
    CheckBox dice3;
    CheckBox dice4;
    CheckBox dice5;
    
    //used for re-rolling
    int[] rolls;
    Button reRoll;
    int reRollCount = 0;
    
    //used for giving beer to other players or yourself
    Button giveBeer;
    CheckBox p1b;
    CheckBox p2b;
    CheckBox p3b;
    CheckBox p4b;
    CheckBox p5b;
    CheckBox p6b;
    CheckBox p7b;
    CheckBox p8b;
    
    //used for shooting logic
    Button oneShotLeft;
    Button oneShotRight;
    Button twoShotLeft;
    Button twoShotRight;
    int twoShot = 0;
    int oneShot = 0;
    
    //used to organize all the labels for each player
    VBox player1 = new VBox(2);
    VBox player2 = new VBox(2);
    VBox player3 = new VBox(2);
    VBox player4 = new VBox(2);
    VBox player5 = new VBox(2);
    VBox player6 = new VBox(2);
    VBox player7 = new VBox(2);
    VBox player8 = new VBox(2);
    
    //used for ai so they can keep track of the sheriff
    int sheriffIndex;
    
    //used for chosing old saloon
    Button btn;
    
    @Override
    /**
     * Is the method that controls the primary window of the game
     */
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bang! The Dice Game");
        btn = new Button("Old Saloon");
        btn.setOnAction((e)->
    {
        new OldSaloonFX();
    });

        //below is where the above labels and buttons are created
        //roll 1 - 5 is where a d
        roll1 = new Label();
        roll2 = new Label();
        roll3 = new Label();
        roll4 = new Label();
        roll5 = new Label();
        
        //these are the titles of each player
        p1t = new Label("");
        p2t = new Label("");
        p3t = new Label("");
        p4t = new Label("");
        p5t = new Label("");
        p6t = new Label("");
        p7t = new Label("");
        p8t = new Label("");
        
        //these are the hp of each player
        p1hp = new Label();
        p2hp = new Label();
        p3hp = new Label();
        p4hp = new Label();
        p5hp = new Label();
        p6hp = new Label();
        p7hp = new Label();
        p8hp = new Label();
        
        //these are the number of arrows on a player for each player
        p1arrow = new Label();
        p2arrow = new Label();
        p3arrow = new Label();
        p4arrow = new Label();
        p5arrow = new Label();
        p6arrow = new Label();
        p7arrow = new Label();
        p8arrow = new Label();
        
        //used to show whos turn it is
        p1c = new Label("");
        p2c = new Label("");
        p3c = new Label("");
        p4c = new Label("");
        p5c = new Label("");
        p6c = new Label("");
        p7c = new Label("");
        p8c = new Label("");
        
        //checkboxes so the user can chose which dice to re-roll
        dice1 = new CheckBox("Dice 1");
        dice2 = new CheckBox("Dice 2");
        dice3 = new CheckBox("Dice 3");
        dice4 = new CheckBox("Dice 4");
        dice5 = new CheckBox("Dice 5");
        reRoll = new Button("Re-Roll");
        
        dice1.setDisable(true);
        dice2.setDisable(true);
        dice3.setDisable(true);
        dice4.setDisable(true);
        dice5.setDisable(true);
        reRoll.setDisable(true);
        
        //checkboxes so the user can chose who to give beer to
        p1b = new CheckBox("P1");
        p2b = new CheckBox("P2");
        p3b = new CheckBox("P3");
        p4b = new CheckBox("P4");
        p5b = new CheckBox("P5");
        p6b = new CheckBox("P6");
        p7b = new CheckBox("P7");
        p8b = new CheckBox("P8");
        giveBeer = new Button("Give Beer");
        
        p1b.setDisable(true);
        p2b.setDisable(true);
        p3b.setDisable(true);
        p4b.setDisable(true);
        p5b.setDisable(true);
        p6b.setDisable(true);
        p7b.setDisable(true);
        p8b.setDisable(true);
        giveBeer.setDisable(true);
        
        //used for shooting
        oneShotLeft = new Button("1 Left");
        twoShotLeft = new Button("2 Left");
        oneShotRight = new Button("1 Right");
        twoShotRight = new Button("2 Right");
        
        oneShotLeft.setDisable(true);
        oneShotRight.setDisable(true);
        twoShotLeft.setDisable(true);
        twoShotRight.setDisable(true);
        
        //used to move to next player
        nextPlayer = new Button("Start Game");
        nextPlayer.setDisable(true);
        
        //used for rolling dice and saving those rolls
        rollDice = new Button("Roll Dice");
        saveRolls = new Button("Save Rolls");
        
        rollDice.setDisable(true);
        saveRolls.setDisable(true);
        
        //displays who won
        winner = new Label("");
        String expansion = checkExpansion();
        //selection of how many players the user wants including themselves takes place below 
        p4 = new Button(" 4 ");
        p4.setOnAction((e -> {
            MyProject3 game = new MyProject3(4,expansion);
            this.players = game.getPlayers();
            disable();
            nextPlayer.setDisable(false);
            this.playerCount = 4;
            playerLabels();
            sheriffIndex = index + 1;
            btn.setDisable(true);
                
        }));
        
        p5 = new Button(" 5 ");
        p5.setOnAction((e -> {
            MyProject3 game = new MyProject3(5,expansion);
            this.players = game.getPlayers();
            disable();
            nextPlayer.setDisable(false);
            this.playerCount = 5;
            playerLabels();
            sheriffIndex = index + 1;
            btn.setDisable(true);
          
        }));
        
        p6 = new Button(" 6 ");
        p6.setOnAction((e -> {
            MyProject3 game = new MyProject3(6,expansion);
            this.players = game.getPlayers();
            disable();
            nextPlayer.setDisable(false);
            this.playerCount = 6;
            playerLabels();
            sheriffIndex = index + 1;
            btn.setDisable(true);
           
        }));
        
        p7 = new Button(" 7 ");
        p7.setOnAction((e -> {
            MyProject3 game = new MyProject3(7,expansion);
            this.players = game.getPlayers();
            disable();
            nextPlayer.setDisable(false);
            this.playerCount = 7;
            playerLabels();
            sheriffIndex = index + 1;
            btn.setDisable(true);
         
        }));
        
        p8 = new Button(" 8 ");
        p8.setOnAction((e -> {
            MyProject3 game = new MyProject3(8,expansion);
            this.players = game.getPlayers();
            disable();
            nextPlayer.setDisable(false);
            this.playerCount = 8;
            playerLabels();
            sheriffIndex = index + 1;
            btn.setDisable(true);
           
        }));
        
        //below the scene is set-up and all the boxes are put in one vertical box
        HBox hbox1 = new HBox(20);
        hbox1.getChildren().addAll(p4, p5, p6, p7, p8,btn);
        hbox1.setAlignment(Pos.CENTER);
        
        HBox hbox2 = new HBox(20);
        hbox2.getChildren().addAll(rollDice, reRoll, saveRolls);
        hbox2.setAlignment(Pos.CENTER);
        
        HBox hbox3 = new HBox(25);
        hbox3.getChildren().addAll(roll1, roll2, roll3, roll4, roll5);
        hbox3.setAlignment(Pos.CENTER);
        
        HBox hboxD = new HBox(20);
        hboxD.getChildren().addAll(dice1, dice2, dice3, dice4, dice5);
        hboxD.setAlignment(Pos.CENTER);
        
        HBox hbox4 = new HBox(20);
        hbox4.getChildren().add(nextPlayer);
        hbox4.setAlignment(Pos.CENTER);
        
        HBox hbox5 = new HBox(20);
        hbox5.getChildren().addAll(player1, player2, player3, player4, player5, player6, player7, player8);
        hbox5.setAlignment(Pos.CENTER);
        
        HBox hboxB = new HBox(20);
        hboxB.getChildren().addAll(p1b, p2b, p3b, p4b, p5b, p6b, p7b, p8b, giveBeer);
        hboxB.setAlignment(Pos.CENTER);
        
        HBox hboxS = new HBox(20);
        hboxS.getChildren().addAll(twoShotLeft, oneShotLeft, oneShotRight, twoShotRight);
        hboxS.setAlignment(Pos.CENTER);
        
        //space hboxs used for spacing out the GUI
        HBox space = new HBox(0);
        space.getChildren().add(new Label(""));
        space.setAlignment(Pos.CENTER);
        
        HBox space2 = new HBox(0);
        space2.getChildren().add(new Label(""));
        space2.setAlignment(Pos.CENTER);
        
        HBox space3 = new HBox(0);
        space3.getChildren().add(new Label(""));
        space3.setAlignment(Pos.CENTER);
        
        HBox space4 = new HBox(0);
        space4.getChildren().add(new Label(""));
        space4.setAlignment(Pos.CENTER);
        
        //final vertical box that holds every other box
        VBox layout = new VBox(5);
        layout.getChildren().add(new Label("Player Count"));
        layout.getChildren().add(hbox1);
        layout.getChildren().add(space);
        layout.getChildren().add(new Label("Dice Rolls"));
        layout.getChildren().add(hbox2);
        layout.getChildren().add(hboxD);
        layout.getChildren().add(hbox3);
        layout.getChildren().add(space2);
        layout.getChildren().add(new Label("Shooting"));
        layout.getChildren().add(hboxS);
        layout.getChildren().add(space4);
        layout.getChildren().add(new Label("Give Beer (select one at a time)"));
        layout.getChildren().add(hboxB);
        layout.getChildren().add(space3);
        layout.getChildren().add(hbox4);
        layout.getChildren().add(hbox5);
        layout.getChildren().add(winner);
        layout.setAlignment(Pos.TOP_CENTER);
        
        Scene scene = new Scene(layout, 950, 650);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //BELOW IS WHERE GAME LOGIC STARTS
        //game begins with the sheriff           
        nextPlayer.setOnAction((e -> {
            nextPlayer.setText("Next Player");
            roll1.setText("");
            roll2.setText("");
            roll3.setText("");
            roll4.setText("");
            roll5.setText("");
            rollDice.setDisable(true);
            saveRolls.setDisable(true);
            
            //used for checking whos alive and if anyone has won
            int alive = 0;
            for(MyPlayer player : players){
                if(player.getHp() > 0){
                    alive = alive + 1;
                }
            }
            if(alive > 1){
                int deathIndex = 0;
                for(MyPlayer player : players){
                    updateHp(deathIndex);
                    deathIndex++;
                }
            }
            
            
            //resets the index back at 0 if it hits the playerCount - 1
            if(this.index + 1 == playerCount){
                this.index = 0;
                while(players.get(this.index).getHp() <= 0){
                    index++;
                }
            }
            else{
                index = index + 1;
                while(players.get(this.index).getHp() <= 0){
                    if(this.index + 1 == playerCount){
                        this.index = 0;
                    }
                    else{
                        index++;
                    }
                }
            }
            
            //if a player is alive, it will become their turn once it hits their index
            if(players.get(this.index).getHp() != 0){
                p1c.setText("");
                p2c.setText("");
                p3c.setText("");
                p4c.setText("");
                p5c.setText("");
                p6c.setText("");
                p7c.setText("");
                p8c.setText("");
                
                switch(this.index){
                    case 0:
                        p1c.setText("Player 1's Turn");
                        break;
                    case 1:
                        p2c.setText("Player 2's Turn");
                        //p2t.setText(players.get(index).getRole());
                        break;
                    case 2:
                        p3c.setText("Player 3's Turn");
                        //p3t.setText(players.get(index).getRole());
                        break;
                    case 3:
                        p4c.setText("Player 4's Turn");
                        //p4t.setText(players.get(index).getRole());
                        break;
                    case 4:
                        p5c.setText("Player 5's Turn");
                        //p5t.setText(players.get(index).getRole());
                        break;
                    case 5:
                        p6c.setText("Player 6's Turn");
                        //p6t.setText(players.get(index).getRole());
                        break;
                    case 6:
                        p7c.setText("Player 7's Turn");
                        //p7t.setText(players.get(index).getRole());
                        break;
                    case 7:
                        p8c.setText("Player 8's Turn");
                        //p8t.setText(players.get(index).getRole());
                        break;
                }
                //each player thats alive gets a turn
                turn(players.get(this.index));
                
                //if the player is a human then it calls the roll function where
                //the human player will roll and solve their dice
                if(players.get(this.index).getHuman() == true){
                    roll(players.get(this.index));
                }
            }          
        }));
    }
    
    /**
     * Disables the player count buttons so that player count can only be seleected once
     */
    public void disable(){
        p4.setDisable(true);
        p5.setDisable(true);
        p6.setDisable(true);
        p7.setDisable(true);
        p8.setDisable(true);
    }
    
    /**
     * Every player gets a turn, if the one getting a turn is a human, the dice buttons become available to them
     * @param currPlayer provides which players turn it is
     */
    public void turn(MyPlayer currPlayer){
        if(currPlayer.getHuman() == true){
            rollDice.setDisable(false);
            dice1.setDisable(false);
            dice2.setDisable(false);
            dice3.setDisable(false);
            dice4.setDisable(false);
            dice5.setDisable(false);
            nextPlayer.setDisable(true);
            
        }
        else{
            AIroll(currPlayer);
        }
        
    }
    
    /**
     * Logic for the AI, they roll their dice and then perform the actions as if they were a human
     * @param currPlayer provides which players turn it is
     */
    public void AIroll(MyPlayer currPlayer){
        //start with the AI rolling their dice
        MyDice aiRoll = new MyDice(5);
        this.rolls = aiRoll.getRolls();
        roll1.setText(aiRoll.getRollsString(rolls[0]));
        roll2.setText(aiRoll.getRollsString(rolls[1]));
        roll3.setText(aiRoll.getRollsString(rolls[2]));
        roll4.setText(aiRoll.getRollsString(rolls[3]));
        roll5.setText(aiRoll.getRollsString(rolls[4]));
        for(int i = 0; i < this.rolls.length; i++){
            if(rolls[i] == 0){
                arrow(currPlayer);
            }
            if(rolls[i] == 1){
                dynamiteCount++;
            }
            if(rolls[i] == 2){
                oneShot++;
            }
            if(rolls[i] == 3){
                twoShot++;
            }
            if(rolls[i] == 4){
                gatCount++;
            }
            if(rolls[i] == 5){
                beerCount++;
            }
        }
        
        //if they rolled 3 dynamite they lose 1hp
        if(dynamiteCount >= 3){
            currPlayer.loseHp(1);
            updateHp(index);
            if("Pedro Ramirez".equals(currPlayer.getCharacterName()) && currPlayer.getArrows() > 0)
                dropArrow(currPlayer);
        }
        
        if(oneShot == 0 && twoShot == 0 && "Suzy Lafayette".equals(currPlayer.getCharacterName())){
            currPlayer.gainHp(2);
            updateHp(index);
        }
        
        //if they rolled a shoot 1 dice
        while(oneShot > 0){
            int leftTarget = checkTarget("checkOneLeft", currPlayer);
            int rightTarget = checkTarget("checkOneRight", currPlayer);
            
            int aliveCount = 0;
            for(MyPlayer player : players){
                if(player.getHp() > 0){
                    aliveCount++;
                }
            }
            if(aliveCount <= 1){
                break;
            }
            
            //attack anyone except the person who has healed him the most, unless all deputies are dead
            if("Sheriff".equals(currPlayer.getRole())){
                int deputyAliveCount = 0;
                    for(MyPlayer player : players){
                        if("Deputy".equals(player.getRole()) && player.getHp() > 0){
                            deputyAliveCount++;
                        }
                    }
                if(deputyAliveCount > 0){
                    if(players.get(leftTarget).getHealOther() > players.get(rightTarget).getHealOther()){
                        shoot("oneRight", currPlayer);
                    }
                    else if(players.get(leftTarget).getHealOther() < players.get(rightTarget).getHealOther()){
                        shoot("oneLeft", currPlayer);
                    }
                    else{
                        if(players.get(leftTarget).getHp() > players.get(rightTarget).getHp()){
                            shoot("oneLeft", currPlayer);
                        }
                        else{
                            shoot("oneRight", currPlayer);
                        }
                    }
                }
                else{
                    if(players.get(leftTarget).getHp() > players.get(rightTarget).getHp()){
                        shoot("oneLeft", currPlayer);
                    }
                    else{
                        shoot("oneRight", currPlayer);
                    }
                }
            }
            
            //always attacks sheriff if he can, otherwise attacks anyone
            if("Outlaw".equals(currPlayer.getRole())){
                if("Sheriff".equals(players.get(leftTarget).getRole())){
                    shoot("oneLeft", currPlayer);
                }
                else if("Sheriff".equals(players.get(rightTarget).getRole())){
                    shoot("oneRight", currPlayer);
                }
                else{
                    if(players.get(leftTarget).getHp() > players.get(rightTarget).getHp()){
                        shoot("oneLeft", currPlayer);
                    }
                    else{
                        shoot("oneRight", currPlayer);
                    }
                }
            }
            
            //if outlaws are alive, try to not attack sheriff, otherwise, kill him
            if("Renegade".equals(currPlayer.getRole())){
                int outlawAliveCount = 0;
                for(MyPlayer player : players){
                    if("Outlaw".equals(player.getRole()) && player.getHp() > 0){
                        outlawAliveCount++;
                    }
                }
                if(outlawAliveCount > 0){
                    if("Sheriff".equals(players.get(leftTarget).getRole())){
                        shoot("oneRight", currPlayer);
                    }
                    else if("Sheriff".equals(players.get(rightTarget).getRole())){
                       shoot("oneLeft", currPlayer);
                    }
                    else{
                        shoot("oneRight", currPlayer);
                    }
                }
                else{
                    if(players.get(leftTarget).getHp() > players.get(rightTarget).getHp()){
                        shoot("oneLeft", currPlayer);
                    }
                    else{
                        shoot("oneRight", currPlayer);
                    }
                }
                
            }
            
            //deputy will never shoot the sheriff, if other deputies are alive they try not
            //to shoot them either
            if("Deputy".equals(currPlayer.getRole())){
                if("Sheriff".equals(players.get(leftTarget).getRole())){
                    shoot("oneRight", currPlayer);
                }
                else if("Sheriff".equals(players.get(rightTarget).getRole())){
                    shoot("oneLeft", currPlayer);
                }
                else{
                    int deputyAliveCount = 0;
                    for(MyPlayer player : players){
                        if("Deputy".equals(player.getRole()) && player.getHp() > 0){
                            deputyAliveCount++;
                        }
                    }
                    if(deputyAliveCount > 1){
                        //then shoot target whos helped less
                        int leftHeal = players.get(leftTarget).getHealOther();
                        int rightHeal = players.get(rightTarget).getHealOther();
                        if(leftHeal < rightHeal){
                            shoot("oneLeft", currPlayer);
                        }
                        else{
                            shoot("oneRight", currPlayer);
                        }
                        
                    }
                    else{
                    if(players.get(leftTarget).getHp() > players.get(rightTarget).getHp()){
                        shoot("oneLeft", currPlayer);
                    }
                    else{
                        shoot("oneRight", currPlayer);
                    }
                }
                }
            }
            oneShot--;
        }
        
        //exact same logic as shoot 1 except now its for 2
        while(twoShot > 0){
            int aliveCount = 0;
            for(MyPlayer player : players){
                if(player.getHp() > 0){
                    aliveCount++;
                }
            }
            if(aliveCount <= 1){
                break;
            }
            
            int leftTarget = checkTarget("checkTwoLeft", currPlayer);
            int rightTarget = checkTarget("checkTwoRight", currPlayer);
            
            //attack anyone except the person who has healed him the most, unless all deputies are dead
            if("Sheriff".equals(currPlayer.getRole())){
                int deputyAliveCount = 0;
                    for(MyPlayer player : players){
                        if("Deputy".equals(player.getRole()) && player.getHp() > 0){
                            deputyAliveCount++;
                        }
                    }
                if(deputyAliveCount > 0){
                    if(players.get(leftTarget).getHealOther() > players.get(rightTarget).getHealOther()){
                        shoot("twoRight", currPlayer);
                    }
                    else if(players.get(leftTarget).getHealOther() < players.get(rightTarget).getHealOther()){
                        shoot("twoLeft", currPlayer);
                    }
                    else{
                        if(players.get(leftTarget).getHp() > players.get(rightTarget).getHp()){
                            shoot("twoLeft", currPlayer);
                        }
                        else{
                            shoot("twoRight", currPlayer);
                        }
                    }
                }
                else{
                    if(players.get(leftTarget).getHp() > players.get(rightTarget).getHp()){
                        shoot("twoLeft", currPlayer);
                    }
                    else{
                        shoot("twoRight", currPlayer);
                    }
                }
            }
            
            //always attacks sheriff if he can, otherwise attacks anyone
            if("Outlaw".equals(currPlayer.getRole())){
                if("Sheriff".equals(players.get(leftTarget).getRole())){
                    shoot("twoLeft", currPlayer);
                }
                else if("Sheriff".equals(players.get(rightTarget).getRole())){
                    shoot("twoRight", currPlayer);
                }
                else{
                    if(players.get(leftTarget).getHp() > players.get(rightTarget).getHp()){
                        shoot("twoLeft", currPlayer);
                    }
                    else{
                        shoot("twoRight", currPlayer);
                    }
                }
            }
            
            //if outlaws are alive, try to not attack sheriff, otherwise, kill him
            if("Renegade".equals(currPlayer.getRole())){
                int outlawAliveCount = 0;
                for(MyPlayer player : players){
                    if("Outlaw".equals(player.getRole()) && player.getHp() > 0){
                        outlawAliveCount++;
                    }
                }
                if(outlawAliveCount > 0){
                    if("Sheriff".equals(players.get(leftTarget).getRole())){
                        shoot("twoRight", currPlayer);
                    }
                    else if("Sheriff".equals(players.get(rightTarget).getRole())){
                       shoot("twoLeft", currPlayer);
                    }
                    else{
                        shoot("twoRight", currPlayer);
                    }
                }
                else{
                    if(players.get(leftTarget).getHp() > players.get(rightTarget).getHp()){
                        shoot("twoLeft", currPlayer);
                    }
                    else{
                        shoot("twoRight", currPlayer);
                    }
                }
                
            }
            
            //deputy will never shoot the sheriff, if other deputies are alive they try not
            //to shoot them either
            if("Deputy".equals(currPlayer.getRole())){
                if("Sheriff".equals(players.get(leftTarget).getRole())){
                    shoot("twoRight", currPlayer);
                }
                else if("Sheriff".equals(players.get(rightTarget).getRole())){
                    shoot("twoLeft", currPlayer);
                }
                else{
                    int deputyAliveCount = 0;
                    for(MyPlayer player : players){
                        if("Deputy".equals(player.getRole()) && player.getHp() > 0){
                            deputyAliveCount++;
                        }
                    }
                    if(deputyAliveCount > 1){
                        //then shoot target whos helped less
                        int leftHeal = players.get(leftTarget).getHealOther();
                        int rightHeal = players.get(rightTarget).getHealOther();
                        if(leftHeal < rightHeal){
                            shoot("twoLeft", currPlayer);
                        }
                        else{
                            shoot("twoRight", currPlayer);
                        }
                        
                    }
                    else{
                    if(players.get(leftTarget).getHp() > players.get(rightTarget).getHp()){
                        shoot("twoLeft", currPlayer);
                    }
                    else{
                        shoot("twoRight", currPlayer);
                    }
                }
                }
            }
            twoShot--;
        }
        
        //if they rolled any beer it is solved here
        while(beerCount > 0 && currPlayer.getHp() > 0){ 
            int aliveCount = 0;
            for(MyPlayer player : players){
                if(player.getHp() > 0){
                    aliveCount++;
                }
            }
            if(aliveCount <= 1){
                break;
            }
            if("Sheriff".equals(currPlayer.getRole())){
                int gaveHealthIndex = 0;
                int healthGave = 0;
                int playerIndex = 0;
                int deputyAliveCount = 0;
                for(MyPlayer player : players){
                    if(player.getHealOther() > healthGave){
                        gaveHealthIndex = playerIndex;
                        healthGave = player.getHealOther();
                    }
                    if("Deputy".equals(player.getRole()) && player.getHp() > 0){
                        deputyAliveCount++;
                    }
                    playerIndex++;
                }
                //if sheriff is high hp and he thinks he knows who deputy is, heal deputy
                if(currPlayer.getHp() > 8 && players.get(gaveHealthIndex).getHp() < 6 && players.get(gaveHealthIndex).getHp() != 0 && deputyAliveCount != 0){
                    players.get(gaveHealthIndex).gainHp(1);
                    updateHp(gaveHealthIndex);
                }
                //heals himself
                else{
                    currPlayer.gainHp(1);
                    updateHp(index);
                }
            }
            if("Outlaw".equals(currPlayer.getRole())){
                currPlayer.gainHp(1);
                updateHp(index);
            }
            if("Renegade".equals(currPlayer.getRole())){
                int outlawCount = 0;
                for(MyPlayer player : players){
                    if("Outlaw".equals(player.getRole()) && player.getHp() > 0){
                        outlawCount++;
                    }
                }
                //if the sheriff is low and all outlaws arnt dead yet he heals sheriff so the outlaws dont win
                if(players.get(sheriffIndex).getHp() < 5 && outlawCount > 0){
                    players.get(sheriffIndex).gainHp(1);
                    updateHp(sheriffIndex);
                    currPlayer.increaseHealOther();
                }
                //he heals himself
                else{
                    currPlayer.gainHp(1);
                    updateHp(index);
                }
            }
            if("Deputy".equals(currPlayer.getRole())){
                //if sheriff is low heal him
                if(players.get(sheriffIndex).getHp() < 5 || players.get(sheriffIndex).getHp() < currPlayer.getHp()){
                    players.get(sheriffIndex).gainHp(1);
                    updateHp(sheriffIndex);
                    currPlayer.increaseHealOther();
                    
                }
                else{
                    currPlayer.gainHp(1);
                    updateHp(index);
                }
            }
            beerCount--;
        }
        
        //if 3 gatling guns were rolled make everyone lose 1hp and lose arrows
        if(gatCount >= 3 || (gatCount > 1 && "Willy The Kid".equals(currPlayer.getCharacterName()))){
            for(int i = 0; i < playerCount; i++){
                if(players.get(i) != currPlayer && !"Paul Regret".equals(players.get(i).getCharacterName())){
                    players.get(i).loseHp(1);
                    updateHp(i);
                    if("El Gringo".equals(players.get(i).getCharacterName()))
                        arrow(currPlayer);
                    else if("Pedro Ramirez".equals(players.get(i).getCharacterName()) && players.get(i).getArrows() > 0 && i == 0){
                            int dropResponse = JOptionPane.showConfirmDialog(null, "You took damage!\nDrop an arrow?", "Pedro Ability", JOptionPane.YES_NO_OPTION);
                            if(dropResponse == JOptionPane.YES_OPTION)
                                dropArrow(players.get(i));
                        }
                    else if("Pedro Ramirez".equals(players.get(i).getCharacterName()) && players.get(i).getArrows() > 0)
                        dropArrow(players.get(i));
                }
                else{
                    arrowPile = arrowPile + currPlayer.getArrows();
                    currPlayer.setArrows(0);
                    switch(index){
                        case 1:
                            p2arrow.setText("Arrows: 0");
                            break;
                        case 2:
                            p3arrow.setText("Arrows: 0");
                            break;
                        case 3:
                            p4arrow.setText("Arrows: 0");
                            break;
                        case 4:
                            p5arrow.setText("Arrows: 0");
                            break;
                        case 5:
                            p6arrow.setText("Arrows: 0");
                            break;
                        case 6:
                            p7arrow.setText("Arrows: 0");
                            break;
                        case 7:
                            p8arrow.setText("Arrows: 0");
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        
        //reset the values for the next player
        gatCount = 0;
        dynamiteCount = 0;
        beerCount = 0;
        twoShot = 0;
        oneShot = 0;
        
    }
    
    /**
     * Where the majority of the game logic for a HUMAN rolling the dice lives
     * @param currPlayer provides which players turn it is
     */
    public void roll(MyPlayer currPlayer){
        //if the player clicks roll dice, 5 dice are rolled for them and the 
        //values are displayed. If any of the first 5 dice rolled are arrows the
        //player immediatly gets an arrow, if any of the first 3 dice are 
        //dynamite then their turn ends immediatly
        rollDice.setOnAction((e -> {
            saveRolls.setDisable(false);
            MyDice firstRoll = new MyDice(5);
            this.rolls = firstRoll.getRolls();
            roll1.setText(firstRoll.getRollsString(rolls[0]));
            roll2.setText(firstRoll.getRollsString(rolls[1]));
            roll3.setText(firstRoll.getRollsString(rolls[2]));
            roll4.setText(firstRoll.getRollsString(rolls[3]));
            roll5.setText(firstRoll.getRollsString(rolls[4]));
            rollDice.setDisable(true);
            reRoll.setDisable(false);
            
            //checking all 5 of the rolls for arrows and dynamite
            for(int i = 0; i < this.rolls.length; i++){
                //if a roll is a 0 a arrow is added to the player and drawn from
                //the pile, however if the last arrow is drawn from the pile
                //then the players get attacked by indians and the arrow pile resets
                if(rolls[i] == 0){
                    arrow(currPlayer);
                }
                //if the roll is a 1 then it means it was a dynamite, a 1 is added
                //to the dynamite counter, if it hits 3 their dice rolling is over
                if(rolls[i] == 1){
                    dynamiteCount = dynamiteCount + 1;
                    if(dynamiteCount >= 3){
                        reRoll.setDisable(true);
                        dice1.setDisable(true);
                        dice2.setDisable(true);
                        dice3.setDisable(true);
                        dice4.setDisable(true);
                        dice5.setDisable(true);
                        currPlayer.loseHp(1);
                        updateHp(0);
                        if("Pedro Ramirez".equals(currPlayer.getCharacterName()) && currPlayer.getArrows() > 0)
                            dropArrow(currPlayer);
                    }
                    //a dynamite rolled is not allowed to be re-rolled, so here 
                    //the re-roll button for a certain dice is disabled if a 
                    //dynamite is rolled
                    switch(i){
                        case 0:
                            dice1.setDisable(true);
                            dice1.setSelected(false);                            
                            break;
                        case 1:
                            dice2.setDisable(true);
                            dice2.setSelected(false);
                            break;
                        case 2:
                            dice3.setDisable(true);
                            dice3.setSelected(false);
                            break;
                        case 3:
                            dice4.setDisable(true);
                            dice4.setSelected(false);
                            break;
                        case 4:
                            dice5.setDisable(true);
                            dice5.setSelected(false);
                            break;
                    }
                }
            }
            
        }));
        //this is the action for the re-roll button, if a dice is selected to 
        //re-roll then it is rolled here once this button is clicked
        reRoll.setOnAction((e -> {
            reRollCount++;
            if(reRollCount == 2 ){
            reRoll.setDisable(true);
            dice1.setDisable(true);
            dice2.setDisable(true);
            dice3.setDisable(true);
            dice4.setDisable(true);
            dice5.setDisable(true);
            reRollCount = 0;
            }
                
            if(dice1.isSelected()){
                MyDice reRoll1 = new MyDice();
                this.rolls[0] = reRoll1.getRoll();
                roll1.setText(reRoll1.getRollString());
                if(this.rolls[0] == 0){
                    arrow(currPlayer);        
                }
                if(this.rolls[0] == 1){
                    dynamiteCount = dynamiteCount + 1;
                    if(dynamiteCount == 3){
                        reRoll.setDisable(true);
                        dice1.setDisable(true);
                        dice2.setDisable(true);
                        dice3.setDisable(true);
                        dice4.setDisable(true);
                        dice5.setDisable(true);
                        currPlayer.loseHp(1);
                        updateHp(0);
                        if("Pedro Ramirez".equals(currPlayer.getCharacterName()) && currPlayer.getArrows() > 0){
                            int dropResponse = JOptionPane.showConfirmDialog(null, "You took damage!\nDrop an arrow?", "Pedro Ability", JOptionPane.YES_NO_OPTION);
                            if(dropResponse == JOptionPane.YES_OPTION)
                                dropArrow(currPlayer);
                        }
                    }
                    dice1.setDisable(true);
                    dice1.setSelected(false);
                }
            }
            else{
                dice1.setDisable(true);
            }
            if(dice2.isSelected()){
                MyDice reRoll2 = new MyDice();
                this.rolls[1] = reRoll2.getRoll();
                roll2.setText(reRoll2.getRollString());
                if(this.rolls[1] == 0){
                    arrow(currPlayer);                    
                }
                if(this.rolls[1] == 1){
                    dynamiteCount = dynamiteCount + 1;
                    if(dynamiteCount == 3){
                        reRoll.setDisable(true);
                        dice1.setDisable(true);
                        dice2.setDisable(true);
                        dice3.setDisable(true);
                        dice4.setDisable(true);
                        dice5.setDisable(true);
                        currPlayer.loseHp(1);
                        updateHp(0);
                        if("Pedro Ramirez".equals(currPlayer.getCharacterName()) && currPlayer.getArrows() > 0){
                            int dropResponse = JOptionPane.showConfirmDialog(null, "You took damage!\nDrop an arrow?", "Pedro Ability", JOptionPane.YES_NO_OPTION);
                            if(dropResponse == JOptionPane.YES_OPTION)
                                dropArrow(currPlayer);
                        }
                    }
                    dice2.setDisable(true);
                    dice2.setSelected(false);
                }
            }
            else{
                dice2.setDisable(true);
            }
            if(dice3.isSelected()){
                MyDice reRoll3 = new MyDice();
                this.rolls[2] = reRoll3.getRoll();
                roll3.setText(reRoll3.getRollString());
                if(this.rolls[2] == 0){
                    arrow(currPlayer);
                }
                if(this.rolls[2] == 1){
                    dynamiteCount = dynamiteCount + 1;
                    if(dynamiteCount == 3){
                        reRoll.setDisable(true);
                        dice1.setDisable(true);
                        dice2.setDisable(true);
                        dice3.setDisable(true);
                        dice4.setDisable(true);
                        dice5.setDisable(true);
                        currPlayer.loseHp(1);
                        updateHp(0);
                        if("Pedro Ramirez".equals(currPlayer.getCharacterName()) && currPlayer.getArrows() > 0){
                            int dropResponse = JOptionPane.showConfirmDialog(null, "You took damage!\nDrop an arrow?", "Pedro Ability", JOptionPane.YES_NO_OPTION);
                            if(dropResponse == JOptionPane.YES_OPTION)
                                dropArrow(currPlayer);
                        }
                    }
                    dice3.setDisable(true);
                    dice3.setSelected(false);
                }
            }else{
                dice3.setDisable(true);
            }
            if(dice4.isSelected()){
                MyDice reRoll4 = new MyDice();
                this.rolls[3] = reRoll4.getRoll();
                roll4.setText(reRoll4.getRollString());
                if(this.rolls[3] == 0){
                    arrow(currPlayer);
                }
                if(this.rolls[3] == 1){
                    dynamiteCount = dynamiteCount + 1;
                    if(dynamiteCount == 3){
                        reRoll.setDisable(true);
                        dice1.setDisable(true);
                        dice2.setDisable(true);
                        dice3.setDisable(true);
                        dice4.setDisable(true);
                        dice5.setDisable(true);
                        currPlayer.loseHp(1);
                        updateHp(0);
                        if("Pedro Ramirez".equals(currPlayer.getCharacterName()) && currPlayer.getArrows() > 0){
                            int dropResponse = JOptionPane.showConfirmDialog(null, "You took damage!\nDrop an arrow?", "Pedro Ability", JOptionPane.YES_NO_OPTION);
                            if(dropResponse == JOptionPane.YES_OPTION)
                                dropArrow(currPlayer);
                        }
                    }
                    dice4.setDisable(true);
                    dice4.setSelected(false);
                }
            }else{
                dice4.setDisable(true);
            }
            if(dice5.isSelected()){
                MyDice reRoll5 = new MyDice();
                this.rolls[4] = reRoll5.getRoll();
                roll5.setText(reRoll5.getRollString());
                if(this.rolls[4] == 0){
                    arrow(currPlayer);
                }
                if(this.rolls[4] == 1){
                    dynamiteCount = dynamiteCount + 1;
                    if(dynamiteCount == 3){
                        reRoll.setDisable(true);
                        dice1.setDisable(true);
                        dice2.setDisable(true);
                        dice3.setDisable(true);
                        dice4.setDisable(true);
                        dice5.setDisable(true);
                        currPlayer.loseHp(1);
                        updateHp(0);
                        if("Pedro Ramirez".equals(currPlayer.getCharacterName()) && currPlayer.getArrows() > 0){
                            int dropResponse = JOptionPane.showConfirmDialog(null, "You took damage!\nDrop an arrow?", "Pedro Ability", JOptionPane.YES_NO_OPTION);
                            if(dropResponse == JOptionPane.YES_OPTION)
                                dropArrow(currPlayer);
                        }
                    }
                    dice5.setDisable(true);
                    dice5.setSelected(false);
                }
            }else{
                dice5.setDisable(true);
            }           
        }));
        
        saveRolls.setOnAction((e -> {
            reRoll.setDisable(true);
            dice1.setDisable(true);
            dice2.setDisable(true);
            dice3.setDisable(true);
            dice4.setDisable(true);
            dice5.setDisable(true);
            saveRolls.setDisable(true);
            dice1.setSelected(false);
            dice2.setSelected(false);
            dice3.setSelected(false);
            dice4.setSelected(false);
            dice5.setSelected(false);
            dynamiteCount = 0;
            reRollCount = 0;
            for(int i = 0; i < this.rolls.length; i++){
                if(this.rolls[i] == 5){
                    beerCount = beerCount + 1;
                }
                if(this.rolls[i] == 4){
                    gatCount = gatCount + 1;
                }
                if(this.rolls[i] == 3){
                    twoShot++;
                }
                if(this.rolls[i] == 2){
                    oneShot++;
                }
            }
            if(twoShot > 0 || oneShot > 0){
                if(twoShot > 0){
                    twoShotLeft.setDisable(false);
                    twoShotRight.setDisable(false);
                }
                if(oneShot > 0){
                    oneShotLeft.setDisable(false);
                    oneShotRight.setDisable(false);
                }
            }
            else{
                if(gameOver == false){
                    if("Suzy Lafayette".equals(currPlayer.getCharacterName())){
                        currPlayer.gainHp(2);
                        updateHp(index);
                    }
                    beerAndGat(currPlayer);
                }
            }
        }));
        
        oneShotLeft.setOnAction((e -> {
            shoot("oneLeft", currPlayer);
            oneShot = oneShot - 1;
            if(oneShot == 0){
                oneShotLeft.setDisable(true);
                oneShotRight.setDisable(true);
            }
            if(oneShot == 0 && twoShot == 0){
                if(gameOver == false){
                    beerAndGat(currPlayer);
                }
            }
        }));
        
        twoShotLeft.setOnAction((e -> {
            shoot("twoLeft", currPlayer);
            twoShot = twoShot - 1;
            if(twoShot == 0){
                twoShotLeft.setDisable(true);
                twoShotRight.setDisable(true);
            }
            if(oneShot == 0 && twoShot == 0){
                if(gameOver == false){
                    beerAndGat(currPlayer);
                }
            }
        }));
        
        oneShotRight.setOnAction((e -> {
            shoot("oneRight", currPlayer);
            oneShot = oneShot - 1;
            if(oneShot == 0){
                oneShotLeft.setDisable(true);
                oneShotRight.setDisable(true);
            }
            if(oneShot == 0 && twoShot == 0){
                if(gameOver == false){
                    beerAndGat(currPlayer);
                }
            }
        }));
        
        twoShotRight.setOnAction((e -> {
            shoot("twoRight", currPlayer);
            twoShot = twoShot - 1;
            if(twoShot == 0){
                twoShotLeft.setDisable(true);
                twoShotRight.setDisable(true);
            }
            if(oneShot == 0 && twoShot == 0){
                if(gameOver == false){
                    beerAndGat(currPlayer);
                }
            }
        }));
        
        giveBeer.setOnAction((e -> {
                if(p1b.isSelected()){
                    if("Sheriff".equals(players.get(0).getRole())){
                        currPlayer.increaseHealOther();
                    }
                    players.get(0).gainHp(1);
                    p1hp.setText("Health: " + players.get(0).getHp());
                }
                if(p2b.isSelected()){
                    if("Sheriff".equals(players.get(1).getRole())){
                        currPlayer.increaseHealOther();
                    }
                    players.get(1).gainHp(1);
                    p2hp.setText("Health: " + players.get(1).getHp());
                }
                if(p3b.isSelected()){
                    if("Sheriff".equals(players.get(2).getRole())){
                        currPlayer.increaseHealOther();
                    }
                    players.get(2).gainHp(1);
                    p3hp.setText("Health: " + players.get(2).getHp());
                }
                if(p4b.isSelected()){
                    if("Sheriff".equals(players.get(3).getRole())){
                        currPlayer.increaseHealOther();
                    }
                    players.get(3).gainHp(1);
                    p4hp.setText("Health: " + players.get(3).getHp());
                }
                if(p5b.isSelected()){
                    if("Sheriff".equals(players.get(4).getRole())){
                        currPlayer.increaseHealOther();
                    }
                    players.get(4).gainHp(1);
                    p5hp.setText("Health: " + players.get(4).getHp());
                }
                if(p6b.isSelected()){
                    if("Sheriff".equals(players.get(5).getRole())){
                        currPlayer.increaseHealOther();
                    }
                    players.get(5).gainHp(1);
                    p6hp.setText("Health: " + players.get(5).getHp());
                }
                if(p7b.isSelected()){
                    if("Sheriff".equals(players.get(6).getRole())){
                        currPlayer.increaseHealOther();
                    }
                    players.get(6).gainHp(1);
                    p7hp.setText("Health: " + players.get(6).getHp());
                }
                if(p8b.isSelected()){
                    if("Sheriff".equals(players.get(7).getRole())){
                        currPlayer.increaseHealOther();
                    }
                    players.get(7).gainHp(1);
                    p8hp.setText("Health: " + players.get(7).getHp());
                }
                beerCount = beerCount - 1;
                
                if(beerCount == 0){
                    giveBeer.setDisable(true);
                    p1b.setDisable(true);
                    p2b.setDisable(true);
                    p3b.setDisable(true);
                    p4b.setDisable(true);
                    p5b.setDisable(true);
                    p6b.setDisable(true);
                    p7b.setDisable(true);
                    p8b.setDisable(true);
                    p1b.setSelected(false);
                    p2b.setSelected(false);
                    p3b.setSelected(false);
                    p4b.setSelected(false);
                    p5b.setSelected(false);
                    p6b.setSelected(false);
                    p7b.setSelected(false);
                    p8b.setSelected(false);
                    
                    if(this.gatCount >= 3 || (this.gatCount > 1 && "Willy The Kid".equals(currPlayer.getCharacterName()))){
                        for(int i = 0; i < playerCount; i++){
                            if(players.get(i) != currPlayer && !"Paul Regret".equals(players.get(i).getCharacterName())){
                                players.get(i).loseHp(1);
                                updateHp(i);
                                if("El Gringo".equals(players.get(i).getCharacterName()))
                                    arrow(currPlayer);
                                else if("Pedro Ramirez".equals(players.get(i).getCharacterName()) && players.get(i).getArrows() > 0)
                                    dropArrow(players.get(i));
                            }
                            else{
                                arrowPile = arrowPile + currPlayer.getArrows();
                                currPlayer.setArrows(0);
                                p1arrow.setText("Arrows: 0");
                            }
                        }
                    }
                    this.gatCount = 0;
                    if(gameOver == false){
                        nextPlayer.setDisable(false);
                    }
                }
            }));     
        
    }
    
    /**
     * Used by the AI to check their two options when shooting, much like how a human would
     * @param checkDirectionLength
     * @param currPlayer provides which players turn it is
     * @return returns an integer of which target to shoot
     */
    public int checkTarget(String checkDirectionLength, MyPlayer currPlayer){
        int alive = 0;
        for(MyPlayer player : players){
            if(player.getHp() > 0){
                alive = alive + 1;
            }
        }
        if(alive < 1){
            
        }
        else if("checkOneLeft".equals(checkDirectionLength)){
            int shotIndex = index;
            if(shotIndex - 1 < 0){
                shotIndex = playerCount - 1;
            }
            else{
                shotIndex = index - 1;
            }
            while(players.get(shotIndex).getHp() <= 0 || players.get(shotIndex) == currPlayer){
                if(shotIndex - 1 < 0){
                    shotIndex = playerCount - 1;
                }
                else{
                    shotIndex--;
                }
            }
            return shotIndex;
        }
        else if("checkOneRight".equals(checkDirectionLength)){
            int shotIndex = index;
            if(shotIndex + 1 == playerCount){
                shotIndex = 0;
            }
            else{
                shotIndex = index + 1;
            }
            while(players.get(shotIndex).getHp() <= 0 || players.get(shotIndex) == currPlayer){
                if(shotIndex + 1 == playerCount){
                    shotIndex = 0;
                }
                else{
                    shotIndex++;
                }
            }
            return shotIndex;                   
        }
        else if("checkTwoLeft".equals(checkDirectionLength)){
            int shotIndex = index;
            int tempIndex = 0;
            if(shotIndex - 2 == -2){
                shotIndex = playerCount - 2;
                //if there is a dead player between
                if(players.get(shotIndex + 1).getHp() == 0){
                    shotIndex = shotIndex - 1;
                }
            }
            else if(shotIndex - 2 == -1){
                shotIndex = playerCount - 1;
                //if there is a dead player between
                if(shotIndex + 1 == playerCount && players.get(0).getHp() == 0){
                    shotIndex = shotIndex - 1;
                }
            }
            else{

                tempIndex = shotIndex - 1;
                
                while(players.get(tempIndex).getHp() == 0){
                    if(tempIndex - 1 < 0){
                        tempIndex = playerCount - 1;
                    }
                    else{
                        tempIndex--;
                    }
                }
                if(tempIndex - 1 < 0){
                    shotIndex = playerCount - 1;
                }
                else{
                    shotIndex = tempIndex - 1;
                }
                
            }
            while(players.get(shotIndex).getHp() <= 0 || players.get(shotIndex) == currPlayer){

                    if(shotIndex - 1 < 0){
                        shotIndex = playerCount -1;
                    }
                    else{
                        shotIndex--;
                    }
                }
                //once its found the 2nd left target, shoot them!

                if("Sheriff".equals(players.get(shotIndex).getRole())){
                    currPlayer.decreaseHealOther();
                }
                return shotIndex;
                                     
        }
        else if("checkTwoRight".equals(checkDirectionLength)){
            int shotIndex = index;
            int tempIndex = 0;
            if(shotIndex + 2 == playerCount + 1){
                shotIndex = 1;
                //if there is a dead player between
                if(players.get(shotIndex - 1).getHp() == 0){
                    shotIndex = shotIndex + 1;
                }
            }
            else if(shotIndex + 2 == playerCount){
                shotIndex = 0;
                //if there is a dead player between
                if(players.get(playerCount - 1).getHp() == 0){
                    shotIndex = shotIndex + 1;
                }
            }
            else{

                tempIndex = shotIndex + 1;
                
                while(players.get(tempIndex).getHp() == 0){
                    if(tempIndex + 1 == playerCount){
                        tempIndex = 0;
                    }
                    else{
                        tempIndex++;
                    }
                }
                if(tempIndex + 1 == playerCount){
                    shotIndex = 0;
                }
                else{
                    shotIndex = tempIndex + 1;
                }
                
            }
            while(players.get(shotIndex).getHp() <= 0 || players.get(shotIndex) == currPlayer){

                    if(shotIndex + 1 == playerCount){
                        shotIndex = 0;
                    }
                    else{
                        shotIndex++;
                    }
                }
                //once its found the 2nd left target, shoot them!
                
                if("Sheriff".equals(players.get(shotIndex).getRole())){
                    currPlayer.decreaseHealOther();
                }
                return shotIndex;
                
                
            
        }  
        return 0;
    }
    
    /**
     * Used for shooting.
     * @param directionLength is the direction and length that you want to shoot
     * @param currPlayer provides which players turn it is
     */
    public void shoot(String directionLength, MyPlayer currPlayer){
        int alive = 0;
        for(MyPlayer player : players){
            if(player.getHp() > 0){
                alive = alive + 1;
            }
        }
        if(alive < 1){
            
        }
        else if("oneLeft".equals(directionLength)){
            int shotIndex = index;
            if(shotIndex - 1 < 0){
                shotIndex = playerCount - 1;
            }
            else{
                shotIndex = index - 1;
            }
            while(players.get(shotIndex).getHp() <= 0 || players.get(shotIndex) == currPlayer){
                if(shotIndex - 1 < 0){
                    shotIndex = playerCount - 1;
                }
                else{
                    shotIndex--;
                }
            }
            //once its found the first left target, shoot them!
            if("Sheriff".equals(players.get(shotIndex).getRole())){
                currPlayer.decreaseHealOther();
            }
            players.get(shotIndex).loseHp(1);
            updateHp(shotIndex);
            if("El Gringo".equals(players.get(shotIndex).getCharacterName()))
                arrow(currPlayer);
            else if("Pedro Ramirez".equals(players.get(shotIndex).getCharacterName()) && players.get(shotIndex).getArrows() > 0 && shotIndex == 0){
                int dropResponse = JOptionPane.showConfirmDialog(null, "You took damage!\nDrop an arrow?", "Pedro Ability", JOptionPane.YES_NO_OPTION);
                if(dropResponse == JOptionPane.YES_OPTION)
                    dropArrow(players.get(shotIndex));
            }
            else if("Pedro Ramirez".equals(players.get(shotIndex).getCharacterName()) && players.get(shotIndex).getArrows() > 0)
                dropArrow(players.get(shotIndex));
            
        }
        else if("twoLeft".equals(directionLength)){
            int shotIndex = index;
            int tempIndex = 0;
            if(shotIndex - 2 == -2){
                shotIndex = playerCount - 2;
                //if there is a dead player between
                if(players.get(shotIndex + 1).getHp() == 0){
                    shotIndex = shotIndex - 1;
                }
            }
            else if(shotIndex - 2 == -1){
                shotIndex = playerCount - 1;
                //if there is a dead player between
                if(shotIndex + 1 == playerCount && players.get(0).getHp() == 0){
                    shotIndex = shotIndex - 1;
                }
            }
            else{
                tempIndex = shotIndex - 1;
                while(players.get(tempIndex).getHp() == 0){
                    if(tempIndex - 1 < 0){
                        tempIndex = playerCount - 1;
                    }
                    else{
                        tempIndex--;
                    }
                }
                if(tempIndex - 1 < 0){
                    shotIndex = playerCount - 1;
                }
                else{
                    shotIndex = tempIndex - 1;
                }
            }
            boolean alreadyshot = false;
            while(players.get(shotIndex).getHp() <= 0 || players.get(shotIndex) == currPlayer){
                if(alive == 2){
                    shoot("oneLeft", currPlayer);
                    alreadyshot = true;
                    break;
                }
                if(shotIndex - 1 < 0){
                    shotIndex = playerCount -1;
                }
                else{
                    shotIndex--;
                }
            }
            //once its found the 2nd left target, shoot them!
            if(alive != 2){
                if("Sheriff".equals(players.get(shotIndex).getRole())){
                    currPlayer.decreaseHealOther();
                }
                players.get(shotIndex).loseHp(1);
                updateHp(shotIndex);
                if("El Gringo".equals(players.get(shotIndex).getCharacterName()))
                    arrow(currPlayer);
                else if("Pedro Ramirez".equals(players.get(shotIndex).getCharacterName()) && players.get(shotIndex).getArrows() > 0 && shotIndex == 0){
                    int dropResponse = JOptionPane.showConfirmDialog(null, "You took damage!\nDrop an arrow?", "Pedro Ability", JOptionPane.YES_NO_OPTION);
                    if(dropResponse == JOptionPane.YES_OPTION)
                        dropArrow(players.get(shotIndex));
                }
                else if("Pedro Ramirez".equals(players.get(shotIndex).getCharacterName()) && players.get(shotIndex).getArrows() > 0)
                    dropArrow(players.get(shotIndex));
            }
            else{
                if(alive == 2 && alreadyshot == false){
                    shoot("oneLeft", currPlayer);
                }
            }
            
        }
        else if("oneRight".equals(directionLength)){
            int shotIndex = index;
            if(shotIndex + 1 == playerCount){
                shotIndex = 0;
            }
            else{
                shotIndex = index + 1;
            }
            while(players.get(shotIndex).getHp() <= 0 || players.get(shotIndex) == currPlayer){
                if(shotIndex + 1 == playerCount){
                    shotIndex = 0;
                }
                else{
                    shotIndex++;
                }
                }
            //once its found the first left target, shoot them!
            if("Sheriff".equals(players.get(shotIndex).getRole())){
                currPlayer.decreaseHealOther();
            }
            players.get(shotIndex).loseHp(1);
            updateHp(shotIndex); 
            if("El Gringo".equals(players.get(shotIndex).getCharacterName()))
                arrow(currPlayer);
            else if("Pedro Ramirez".equals(players.get(shotIndex).getCharacterName()) && players.get(shotIndex).getArrows() > 0 && shotIndex == 0){
                int dropResponse = JOptionPane.showConfirmDialog(null, "You took damage!\nDrop an arrow?", "Pedro Ability", JOptionPane.YES_NO_OPTION);
                if(dropResponse == JOptionPane.YES_OPTION)
                    dropArrow(players.get(shotIndex));
            }
            else if("Pedro Ramirez".equals(players.get(shotIndex).getCharacterName()) && players.get(shotIndex).getArrows() > 0)
                dropArrow(players.get(shotIndex));
        }
        else if("twoRight".equals(directionLength)){
            int shotIndex = index;
            int tempIndex = 0;
            if(shotIndex + 2 == playerCount + 1){
                shotIndex = 1;
                //if there is a dead player between
                if(players.get(shotIndex - 1).getHp() == 0){
                    shotIndex = shotIndex + 1;
                }
            }
            else if(shotIndex + 2 == playerCount){
                shotIndex = 0;
                //if there is a dead player between
                if(players.get(playerCount - 1).getHp() == 0){
                    shotIndex = shotIndex + 1;
                }
            }
            else{

                tempIndex = shotIndex + 1;
                
                while(players.get(tempIndex).getHp() == 0){
                    if(tempIndex + 1 == playerCount){
                        tempIndex = 0;
                    }
                    else{
                        tempIndex++;
                    }
                }
                if(tempIndex + 1 == playerCount){
                    shotIndex = 0;
                }
                else{
                    shotIndex = tempIndex + 1;
                }
                
            }
            boolean alreadyshot = false;
            while(players.get(shotIndex).getHp() <= 0 || players.get(shotIndex) == currPlayer){
                    if(alive == 2){
                        shoot("oneRight", currPlayer);
                        alreadyshot = true;
                        break;
                    }
                    if(shotIndex + 1 == playerCount){
                        shotIndex = 0;
                    }
                    else{
                        shotIndex++;
                    }
                }
                //once its found the 2nd left target, shoot them!
                if(alive != 2){
                    if("Sheriff".equals(players.get(shotIndex).getRole())){
                        currPlayer.decreaseHealOther();
                    }
                    players.get(shotIndex).loseHp(1);
                    updateHp(shotIndex);
                    if("El Gringo".equals(players.get(shotIndex).getCharacterName()))
                        arrow(currPlayer);
                    else if("Pedro Ramirez".equals(players.get(shotIndex).getCharacterName()) && players.get(shotIndex).getArrows() > 0 && shotIndex == 0){
                        int dropResponse = JOptionPane.showConfirmDialog(null, "You took damage!\nDrop an arrow?", "Pedro Ability", JOptionPane.YES_NO_OPTION);
                        if(dropResponse == JOptionPane.YES_OPTION)
                            dropArrow(players.get(shotIndex));
                    }
                    else if("Pedro Ramirez".equals(players.get(shotIndex).getCharacterName()) && players.get(shotIndex).getArrows() > 0)
                        dropArrow(players.get(shotIndex));
                }
                else{
                    if(alive == 2 && alreadyshot == false){
                        shoot("oneRight", currPlayer);
                    }
                }    
            
        }
        
    }
    
    /**
     * Used for dropping an arrow (Pedro Ramirez's ability)
     * @param currPlayer provides which players turn it is
     */
    public void dropArrow(MyPlayer currPlayer){
        currPlayer.setArrows((currPlayer.getArrows() - 1));
        switch(index){
            case 0:
                p1arrow.setText("Arrows: " + currPlayer.getArrows());
                break;
            case 1:
                p1arrow.setText("Arrows: " + currPlayer.getArrows());
                break;
            case 2:
                p1arrow.setText("Arrows: " + currPlayer.getArrows());
                break;
            case 3:
                p1arrow.setText("Arrows: " + currPlayer.getArrows());
                break;
            case 4:
                p1arrow.setText("Arrows: " + currPlayer.getArrows());
                break;
            case 5:
                p1arrow.setText("Arrows: " + currPlayer.getArrows());
                break;
            case 6:
                p1arrow.setText("Arrows: " + currPlayer.getArrows());
                break;
            case 7:
                p1arrow.setText("Arrows: " + currPlayer.getArrows());
                break;
        }
        arrowPile++;
    }
    
    /**
     * Used for rolling arrow and indian attacks
     * @param currPlayer provides which players turn it is
     */
    public void arrow(MyPlayer currPlayer){
        int alive = 0;
        for(MyPlayer player : players){
            if(player.getHp() > 0){
                alive = alive + 1;
            }
        }
        if(alive < 1){
            
        }
        //if the next arrow drawn doesnt empty the pile (start an indian attack)
        else if(arrowPile != 1 && currPlayer.getHp() > 0){
            currPlayer.setArrows(currPlayer.getArrows() + 1);
            switch(index){
                case 0:
                    p1arrow.setText("Arrows: " + currPlayer.getArrows());
                    break;
                case 1:
                    p2arrow.setText("Arrows: " + currPlayer.getArrows());
                    break;
                case 2:
                    p3arrow.setText("Arrows: " + currPlayer.getArrows());
                    break;
                case 3:
                    p4arrow.setText("Arrows: " + currPlayer.getArrows());
                    break;
                case 4:
                    p5arrow.setText("Arrows: " + currPlayer.getArrows());
                    break;
                case 5:
                    p6arrow.setText("Arrows: " + currPlayer.getArrows());
                    break;
                case 6:
                    p7arrow.setText("Arrows: " + currPlayer.getArrows());
                    break;
                case 7:
                    p8arrow.setText("Arrows: " + currPlayer.getArrows());
                    break;
            }
            arrowPile--;
        }
        //indians attack because pile became empty
        else{
            currPlayer.setArrows(currPlayer.getArrows() + 1);
            int playerIndex = 0;
            for(MyPlayer player : players){
                if("Jourdonnais".equals(player.getCharacterName()) && player.getArrows() > 0){
                    player.loseHp(1);
                    updateHp(playerIndex);
                }
                else if(player.getArrows() > 0){
                    player.loseHp(player.getArrows());
                    if(player.getHp() < 0){
                        player.setHp(0);
                    }
                    updateHp(playerIndex);
                }
                player.setArrows(0);
                switch(playerIndex){
                    case 0:
                        p1arrow.setText("Arrows: " + player.getArrows());
                        break;
                    case 1:
                        p2arrow.setText("Arrows: " + player.getArrows());
                        break;
                    case 2:
                        p3arrow.setText("Arrows: " + player.getArrows());
                        break;
                    case 3:
                        p4arrow.setText("Arrows: " + player.getArrows());
                        break;
                    case 4:
                        p5arrow.setText("Arrows: " + player.getArrows());
                        break;
                    case 5:
                        p6arrow.setText("Arrows: " + player.getArrows());
                        break;
                    case 6:
                        p7arrow.setText("Arrows: " + player.getArrows());
                        break;
                    case 7:
                        p8arrow.setText("Arrows: " + player.getArrows());
                        break;
                }
                playerIndex++;
            }
            arrowPile = 9;
        }
    }
    
    /**
     * Used for disabling dead players from getting beer and resolves gatling gun if there was any
     * @param currPlayer provides which players turn it is
     */
    public void beerAndGat(MyPlayer currPlayer){
        if(beerCount > 0){
            int playerIndex = 0;
            for(MyPlayer player : players){
                if(player.getHp() == 0){   
                }
                else{
                    switch(playerIndex){
                        case 7:
                            p8b.setDisable(false);
                            break;
                        case 6: 
                            p7b.setDisable(false);
                            break;
                        case 5:
                            p6b.setDisable(false);
                            break;
                        case 4:
                            p5b.setDisable(false);
                            break;
                        case 3:
                            p4b.setDisable(false);
                            break;
                        case 2:
                            p3b.setDisable(false);
                            break;
                        case 1:
                            p2b.setDisable(false);
                            break;
                        case 0:
                            p1b.setDisable(false);
                            break;
                        default:
                            break;
                    }
                }
                playerIndex++;
            }

            giveBeer.setDisable(false);
        }
        
        //if no beer, go straight to gatling gun
        else{
            if(this.gatCount >= 3 || (this.gatCount > 1 && "Willy The Kid".equals(currPlayer.getCharacterName()))){
                for(int i = 0; i < playerCount; i++){
                    if(players.get(i) != currPlayer && !"Paul Regret".equals(players.get(i).getCharacterName())){
                        players.get(i).loseHp(1);
                        updateHp(i);
                        if("El Gringo".equals(players.get(i).getCharacterName()))
                            arrow(currPlayer);
                        else if("Pedro Ramirez".equals(players.get(i).getCharacterName()) && players.get(i).getArrows() > 0 && i == 0){
                            int dropResponse = JOptionPane.showConfirmDialog(null, "You took damage!\nDrop an arrow?", "Pedro Ability", JOptionPane.YES_NO_OPTION);
                            if(dropResponse == JOptionPane.YES_OPTION)
                                dropArrow(players.get(i));
                        }
                        else if("Pedro Ramirez".equals(players.get(i).getCharacterName()) && players.get(i).getArrows() > 0)
                            dropArrow(players.get(i));
                    }
                    else{
                        arrowPile = arrowPile + currPlayer.getArrows();
                        currPlayer.setArrows(0);
                        p1arrow.setText("Arrows: 0");
                    }
                }
            }
            this.gatCount = 0;
            if(gameOver == false){
                nextPlayer.setDisable(false);
            }
        }
    }
    
    /**
     * Vulture Sam's ability that lets him heal if another player dies.
     */
    public void samAbility(){
        for(int i = 0; i < playerCount; i++){
            if("Vulture Sam".equals(players.get(i).getCharacterName()) && players.get(i).getHp() > 0){
                players.get(i).gainHp(2);
                updateHp(i);
            }
        }
    }
    
    /**
     * Updates a players hp to the GUI after something happens to them.
     * If you want to update multiple peoples hp use a loop
     * Will also check if the game has been won every time a player dies
     * @param i is the index of the player whos hp you want to update
     */
    public void updateHp(int i){
        //dont lower health if already dead
        if(players.get(i).getHp() < 0){
            players.get(i).setHp(0);
        }
 
            //sets new hp for the player shot
            switch(i){
                case 0:
                    p1hp.setText("Health: " + players.get(i).getHp() + "/" + players.get(i).getMaxHp());
                    if(players.get(i).getHp() == 0){
                        if(!p1dead){
                            p1dead = true;
                            samAbility();
                        }
                        p1t.setText("DEAD - " + players.get(i).getRole());
                        disableAll();
                        nextPlayer.setDisable(false);
                        arrowPile = arrowPile + players.get(i).getArrows();
                            players.get(i).setArrows(0);
                            p1arrow.setText("Arrows: 0");
                    }
                    break;
                case 1:
                    p2hp.setText("Health: " + players.get(i).getHp() + "/" + players.get(i).getMaxHp());
                    if(players.get(i).getHp() == 0){
                        if(!p2dead){
                            p2dead = true;
                            samAbility();
                        }
                        p2t.setText("DEAD - " + players.get(i).getRole());
                        arrowPile = arrowPile + players.get(i).getArrows();
                            players.get(i).setArrows(0);
                            p2arrow.setText("Arrows: 0");
                    }
                    break;
                case 2:
                    p3hp.setText("Health: " + players.get(i).getHp() + "/" + players.get(i).getMaxHp());
                    if(players.get(i).getHp() == 0){
                        if(!p3dead){
                            p3dead = true;
                            samAbility();
                        }
                        p3t.setText("DEAD - " + players.get(i).getRole());
                        arrowPile = arrowPile + players.get(i).getArrows();
                            players.get(i).setArrows(0);
                            p3arrow.setText("Arrows: 0");
                    }
                    break;
                case 3:
                    p4hp.setText("Health: " + players.get(i).getHp() + "/" + players.get(i).getMaxHp());
                    if(players.get(i).getHp() == 0){
                        if(!p4dead){
                            p4dead = true;
                            samAbility();
                        }
                        p4t.setText("DEAD - " + players.get(i).getRole());
                        arrowPile = arrowPile + players.get(i).getArrows();
                            players.get(i).setArrows(0);
                            p4arrow.setText("Arrows: 0");
                    }
                    break;
                case 4:
                    p5hp.setText("Health: " + players.get(i).getHp() + "/" + players.get(i).getMaxHp());
                    if(players.get(i).getHp() == 0){
                        if(!p5dead){
                            p5dead = true;
                            samAbility();
                        }
                        p5t.setText("DEAD - " + players.get(i).getRole());
                        arrowPile = arrowPile + players.get(i).getArrows();
                            players.get(i).setArrows(0);
                            p5arrow.setText("Arrows: 0");
                    }
                    break;
                case 5:
                    p6hp.setText("Health: " + players.get(i).getHp() + "/" + players.get(i).getMaxHp());
                    if(players.get(i).getHp() == 0){
                        if(!p6dead){
                            p6dead = true;
                            samAbility();
                        }
                        p6t.setText("DEAD - " + players.get(i).getRole());
                        arrowPile = arrowPile + players.get(i).getArrows();
                            players.get(i).setArrows(0);
                            p6arrow.setText("Arrows: 0");
                    }
                    break;
                case 6:
                    p7hp.setText("Health: " + players.get(i).getHp() + "/" + players.get(i).getMaxHp());
                    if(players.get(i).getHp() == 0){
                        if(!p7dead){
                            p7dead = true;
                            samAbility();
                        }
                        p7t.setText("DEAD - " + players.get(i).getRole());
                        arrowPile = arrowPile + players.get(i).getArrows();
                            players.get(i).setArrows(0);
                            p7arrow.setText("Arrows: 0");
                    }
                    break;
                case 7:
                    p8hp.setText("Health: " + players.get(i).getHp() + "/" + players.get(i).getMaxHp());
                    if(players.get(i).getHp() == 0){
                        if(!p8dead){
                            p8dead = true;
                            samAbility();
                        }
                        p8t.setText("DEAD - " + players.get(i).getRole());
                        arrowPile = arrowPile + players.get(i).getArrows();
                            players.get(i).setArrows(0);
                            p8arrow.setText("Arrows: 0");
                    }
                    break;
                default:
                    break;                               
            }

        int sheriffAlive = 0;
        int outlawAlive = 0;
        int deputyAlive = 0;
        int renegadeAlive = 0;
        for(MyPlayer player : players){
            String role = player.getRole();
            if("Sheriff".equals(role) && player.getHp() > 0)
                sheriffAlive = sheriffAlive + 1;
            if("Deputy".equals(role) && player.getHp() > 0)
                deputyAlive = deputyAlive + 1;
            if("Renegade".equals(role) && player.getHp() > 0)
                renegadeAlive = renegadeAlive + 1;
            if("Outlaw".equals(role) && player.getHp() > 0)
                outlawAlive = outlawAlive + 1;
        }
        if(sheriffAlive == 0 && outlawAlive > 0){
            winner.setText("THE WINNER IS THE OUTLAWS");
            disableAll();
        }
        if(outlawAlive == 0 && renegadeAlive == 0){
            winner.setText("THE WINNER IS THE SHERIFF");
            disableAll();
        }
        if(outlawAlive == 0 && sheriffAlive == 0 && deputyAlive == 0 && renegadeAlive == 1){
            winner.setText("THE WINNER IS THE RENEGADE");
            disableAll();
        }
        
                
    }
    
    /**
     * Disables all buttons after someone has won
     */
    public void disableAll(){
        reRoll.setDisable(true);
        dice1.setDisable(true);
        dice2.setDisable(true);
        dice3.setDisable(true);
        dice4.setDisable(true);
        dice5.setDisable(true);
        nextPlayer.setDisable(true);
        giveBeer.setDisable(true);
        saveRolls.setDisable(true);
        oneShotLeft.setDisable(true);
        oneShotRight.setDisable(true);
        twoShotLeft.setDisable(true);
        twoShotRight.setDisable(true);
        rollDice.setDisable(true);
        p1b.setDisable(true);
        p2b.setDisable(true);
        p3b.setDisable(true);
        p4b.setDisable(true);
        p5b.setDisable(true);
        p6b.setDisable(true);
        p7b.setDisable(true);
        p8b.setDisable(true);      
        this.gameOver = true;
    }
    
    /**
     * Creates the players labels and sets the values
     * Only does it depending on player count
     */
    public void playerLabels(){
        switch(playerCount){
            case 8:
                p8t.setText("Player 8 (CPU)");
                p8hp.setText("Health: " + players.get(7).getHp());
                p8arrow.setText("Arrows: " + players.get(7).getArrows());
                player8.getChildren().addAll(p8t, new Label(players.get(7).getName()), p8hp, p8arrow, p8c);
                if("Sheriff".equals(players.get(7).getRole())){
                    p8t.setText("Player 8 (CPU) - Sheriff");
                    p8hp.setText("Health: " + players.get(7).getHp());
                    this.index = 6;
                }
            case 7:
                p7t.setText("Player 7 (CPU)");
                p7hp.setText("Health: " + players.get(6).getHp());
                p7arrow.setText("Arrows: " + players.get(6).getArrows());
                player7.getChildren().addAll(p7t, new Label(players.get(6).getName()), p7hp, p7arrow, p7c);
                if("Sheriff".equals(players.get(6).getRole())){
                    p7t.setText("Player 7 (CPU) - Sheriff");
                    p7hp.setText("Health: " + players.get(6).getHp());
                    this.index = 5;
                }
            case 6:
                p6t.setText("Player 6 (CPU)");
                p6hp.setText("Health: " + players.get(5).getHp());
                p6arrow.setText("Arrows: " + players.get(5).getArrows());
                player6.getChildren().addAll(p6t, new Label(players.get(5).getName()), p6hp, p6arrow, p6c);
                if("Sheriff".equals(players.get(5).getRole())){
                    p6t.setText("Player 6 (CPU) - Sheriff");
                    p6hp.setText("Health: " + players.get(5).getHp());
                    this.index = 4;
                }
            case 5:
                p5t.setText("Player 5 (CPU)");
                p5hp.setText("Health: " + players.get(4).getHp());
                p5arrow.setText("Arrows: " + players.get(4).getArrows());
                player5.getChildren().addAll(p5t, new Label(players.get(4).getName()), p5hp, p5arrow, p5c);
                if("Sheriff".equals(players.get(4).getRole())){
                    p5t.setText("Player 5 (CPU) - Sheriff");
                    p5hp.setText("Health: " + players.get(4).getHp());
                    this.index = 3;
                }
            case 4:
                p1t.setText("Player 1 (You) - " + players.get(0).getRole());
                p1hp.setText("Health: " + players.get(0).getHp());
                p1arrow.setText("Arrows: " + players.get(0).getArrows());
                player1.getChildren().addAll(p1t, new Label(players.get(0).getName()), p1hp, p1arrow, p1c);         
                if("Sheriff".equals(players.get(0).getRole())){
                    p1hp.setText("Health: " + players.get(0).getHp());
                    this.index = -1;
                }

                p2t.setText("Player 2 (CPU)");
                p2hp.setText("Health: " + players.get(1).getHp());
                p2arrow.setText("Arrows: " + players.get(1).getArrows());
                player2.getChildren().addAll(p2t, new Label(players.get(1).getName()), p2hp, p2arrow, p2c);
                if("Sheriff".equals(players.get(1).getRole())){
                    p2t.setText("Player 2 (CPU) - Sheriff");
                    p2hp.setText("Health: " + players.get(1).getHp());
                    this.index = 0;
                }

                p3t.setText("Player 3 (CPU)");
                p3hp.setText("Health: " + players.get(2).getHp());
                p3arrow.setText("Arrows: " + players.get(2).getArrows());
                player3.getChildren().addAll(p3t, new Label(players.get(2).getName()), p3hp, p3arrow, p3c);
                if("Sheriff".equals(players.get(2).getRole())){
                    p3t.setText("Player 3 (CPU) - Sheriff");
                    p3hp.setText("Health: " + players.get(2).getHp());
                    this.index = 1;
                }

                p4t.setText("Player 4 (CPU)");
                p4hp.setText("Health: " + players.get(3).getHp());
                p4arrow.setText("Arrows: " + players.get(3).getArrows());
                player4.getChildren().addAll(p4t, new Label(players.get(3).getName()), p4hp, p4arrow, p4c);
                if("Sheriff".equals(players.get(3).getRole())){
                    p4t.setText("Player 4 (CPU) - Sheriff");
                    p4hp.setText("Health: " + players.get(3).getHp());
                    this.index = 2;
                }
                break;
            default:
                break;
        }
    }
    
    /**
     * 
     * @return 
     */
    public String checkExpansion(){
        
            return "Old Saloon";
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
