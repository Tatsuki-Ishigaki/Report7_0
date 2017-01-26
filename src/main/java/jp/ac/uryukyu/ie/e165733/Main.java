package jp.ac.uryukyu.ie.e165733;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String[][] board = new String[8][8];
        String empty = "□";
        String black = "●";
        String white = "○";

        String My_stone = judge(black,white); //自分の石をランダムで決めている
        String Your_stone = judge_opposition(black,white); //自分の決めた石と反対の石を出力している

        Board I = new I("自分",My_stone);
        Board You = new You("相手",Your_stone);

        System.out.printf("%sの石は%sです\n",I.getName(),My_stone);

        String First = judge(I.getName(),You.getName()); //最初にやる人を決める

        System.out.printf("%sが先行でゲームスタート！\n",First);

        System.out.println("最初の配置はこのようになります");
        make(board,empty,white,black);
        view(board);

        if(First == I.getName()){
            System.out.println("自分のターンです");
            I.input(board,My_stone);
            view(board);
        }else{
            System.out.println("相手ののターンです");
            You.input(board,Your_stone);
            view(board);
        }
    }

    public static void make(String[][] board, String stone_1, String stone_2, String stone_3) {
        for (int a = 0; a < 8; a++) {
            for (int b = 0; b < 8; b++) {
                board[a][b] = stone_1;
            }
        }
        board[3][3] = stone_2;
        board[4][4] = stone_2;
        board[3][4] = stone_3;
        board[4][3] = stone_3;
    }

    public static void view(String board[][]) {
        System.out.println("  0 1 2 3 4 5 6 7");
        for (int line = 0; line < 8; line++) {
            System.out.print(line + " ");
            for (int row = 0; row < 8; row++) {
                System.out.print(board[line][row] + " ");
            }
            System.out.println();
        }
    }

    public static String judge(String a,String b){
        String c;
        int S = (int) Math.random()*10;
        if(S<5){
            c = a;
        }else{
            c = b;
        }
        return c;
    }
    public static String judge_opposition(String a,String b){
        String c,d;
        c = judge(a,b);
        if(c==a){
            d = b;
        }else{
            d = a;
        }
        return d;
    }
}