package com.in28.learnspring;

import com.in28.learnspring.game.GameRunner;
import com.in28.learnspring.game.MarioGame;
import com.in28.learnspring.game.PacmanGame;
import com.in28.learnspring.game.SuperContraGame;

public class AppGamingBasicJava {
    public static void main(String[] args) {
//        var game = new MarioGame();
//        var game = new SuperContraGame();
        var game = new PacmanGame();

        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
