package com.leadingagile.ticktactoenotdd;

import java.util.Arrays;

public class GameBoard {

    private Marker[] spaces;
    private Marker markerCurrentTurn;
    public GameBoard(){
        this.markerCurrentTurn = Marker.X;
        this.spaces = new Marker[9];
        //initialize to nothing
        for(int i = 0; i < this.spaces.length; i++){
            this.spaces[i] = Marker.Empty;
        }
    }

    public Marker[] getSpaces(){
        return this.spaces;
    }
    public Marker getMarkerCurrentTurn(){
        return this.markerCurrentTurn;
    }

    public void move(int index) throws CheatingException{
        if(this.spaces[index] != Marker.Empty){
            throw new CheatingException();
        }else{
            this.spaces[index] = this.getMarkerCurrentTurn();

            this.markerCurrentTurn = this.getMarkerCurrentTurn() == Marker.X ? Marker.O : Marker.X;
        }
    }

    public  boolean hasWinner(){
        Marker[] row1 = new Marker[] { this.getSpaces()[0], this.getSpaces()[1], this.getSpaces()[2] };
        Marker[] row2 = new Marker[] { this.getSpaces()[3], this.getSpaces()[4], this.getSpaces()[5] };
        Marker[] row3 = new Marker[] { this.getSpaces()[6], this.getSpaces()[7], this.getSpaces()[8] };

        Marker[] col1 = new Marker[] { this.getSpaces()[0], this.getSpaces()[3], this.getSpaces()[6] };
        Marker[] col2 = new Marker[] { this.getSpaces()[1], this.getSpaces()[4], this.getSpaces()[7] };
        Marker[] col3 = new Marker[] { this.getSpaces()[2], this.getSpaces()[5], this.getSpaces()[8] };

        Marker[] diag1 = new Marker[] { this.getSpaces()[0], this.getSpaces()[4], this.getSpaces()[8] };
        Marker[] diag2 = new Marker[] { this.getSpaces()[6], this.getSpaces()[4], this.getSpaces()[2] };

        if (this.isWinner(row1))
        {
            return true;
        }

        if (this.isWinner(row2))
        {
            return true;
        }

        if (this.isWinner(row3))
        {
            return true;
        }

        if (this.isWinner(col1))
        {
            return true;
        }

        if (this.isWinner(col2))
        {
            return true;
        }

        if (this.isWinner(col3))
        {
            return true;
        }

        if (this.isWinner(diag1))
        {
            return true;
        }

        if (this.isWinner(diag2))
        {
            return true;
        }

        return false;
    }

    private   boolean isWinner(Marker[] markers){
    	for(Marker mark : markers){
    		System.out.println(mark);
    	}
    	System.out.println(Arrays.stream(markers).filter((x)->x != Marker.Empty).count() == 3);
    	
        if(Arrays.stream(markers).filter((x)->x != Marker.Empty).count() == 3){
            return Arrays.stream(markers).distinct().count() == 1;
        }
        return false;
    }

    public  Marker getWinner(){
        if(this.hasWinner()){
            return this.getMarkerCurrentTurn() == Marker.X ? Marker.O : Marker.X;
        }
        return Marker.Empty;
    }

    public  boolean IsGameOver(){
        if(this.hasWinner()){
            return true;
        }
        return Arrays.stream(this.getSpaces()).filter((x)->x != Marker.Empty).count() == this.getSpaces().length;
    }

    public  class CheatingException extends Exception{
        public  CheatingException(){
            super("This space is occupied, cheater!");
        }
    }
}
