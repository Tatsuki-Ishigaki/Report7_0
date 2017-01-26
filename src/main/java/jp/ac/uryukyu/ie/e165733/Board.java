package jp.ac.uryukyu.ie.e165733;

import java.util.Scanner;

public class Board {
    private String name;
    private String stone;
    private boolean dead;

    public Board(String name,String stone) {
        this.name = name;
        this.stone = stone;
        dead = false;
    }

    public String getName() {return name;}
    public void setName() {this.name = name;}
    public String getStone() {return stone;}
    public void setStone() {this.stone = stone;}
    public boolean isDead() {
        return dead;
    }
    public void setDead(boolean dead) {
        this.dead = dead;
    }


    public static int scan() {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        return number;
    }

    public static boolean search(String[][] board, int c, int d) {
        boolean judge;
        if (board[c][d] == "□") {
            judge = true;
        } else {
            judge = false;
        }
        return judge;
    }

    public void input(String[][] board, String stone) {
    }

    public void game(String[][] board,String c){
        for(int a=0;a<8;a++){
            for(int b=0;b<8;b++){
                if(board[a][b]=="□"){
                    input(board,c);
                }
            }
        }
    }

}