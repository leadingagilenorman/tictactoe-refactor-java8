package com.leadingagile.ticktactoenotdd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    /*******************
     * 0 #  1 #2
     * ###############
     * 3 # 4  # 5
     * ##############
     * 6 # 7 # 8
     *
     *
     *
     *
     * *******************/
    public static void main(String[] args) throws IOException{
	// write your code here
        GameBoard gameboard = new GameBoard();

        System.out.println("Norman's Game of Tic Tac Toe!");
        while (true)
        {
            System.out.printf("%s what is your move?", gameboard.getMarkerCurrentTurn().toString());
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));

            String input = reader.readLine();

            int index = Integer.MIN_VALUE;

            try
            {
                index = Integer.parseInt(input);
            } catch( NumberFormatException e){
                System.out.println("Stop cheating!!! You lose!");
                break;
            }

            if(index < 0 || index > 8){
                System.out.println("Stop cheating!!! You lose!");
                break;
            }

            try{

                gameboard.move(index);

            }catch(GameBoard.CheatingException ex){
                System.out.println(ex.getMessage());
                break;
            }

            if(gameboard.IsGameOver()){
                //figure out who won!

                System.out.printf("%s is winner", gameboard.getWinner());
                break;

            }

        }
    }
}
