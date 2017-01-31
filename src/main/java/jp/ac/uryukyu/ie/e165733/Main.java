package jp.ac.uryukyu.ie.e165733;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String[][] board = new String[8][8];
        String empty = "□";
        String black = "●";
        String white = "○";

        String My_stone = judge(black,white); //自分の石をランダムで決めている
        String Your_stone = judge_opposition(My_stone); //自分の決めた石と反対の石を出力している

        Board I = new I("自分","○");
        Board You = new I("相手","●");

        System.out.printf("%sの石は%sです\n",I.getName(),My_stone);

        String First = judge(I.getName(),You.getName()); //最初にやる人を決める
        First = I.getName();

        System.out.printf("%sが先行でゲームスタート！\n",First);

        System.out.println("最初の配置はこのようになります");
        make(board,empty,white,black);
        view(board);
        System.out.println();

        if(First == I.getName()){
            while(end(board,empty)==true) {
                System.out.println("自分のターンです\n");
                I.input(board, My_stone);
                view(board);
                while(end(board,empty)==true) {
                    System.out.println();
                    System.out.println("相手のターンです\n");
                    You.input(board, Your_stone);
                    view(board);
                    System.out.println();
                    break;
                }
            }
        }else{
            while(end(board,empty)==true) {
                System.out.println("相手のターンです\n");
                You.input(board, Your_stone);
                view(board);
                while(end(board,empty)==true){
                    System.out.println();
                    System.out.println("自分のターンです\n");
                    I.input(board, My_stone);
                    view(board);
                    System.out.println();
                    break;
                }
            }
        }
        total(board,My_stone,Your_stone);
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
        int S = (int)(Math.random()*10);
        if(S<5){
            c = a;
        }else{
            c = b;
        }
        return c;
    }

    public static String judge_opposition(String a){
        String b;
        if(a=="○"){
            b = "●";
        }else{
            b = "○";
        }
        return b;
    }

    public static boolean end(String[][] board,String empty){
        for(int a=0;a<8;a++){
            for(int b=0;b<8;b++){
                if(board[a][b]==empty){
                    return true;
                }
            }
        }
        return false;
    }

    public static void total(String[][] board,String My_stone,String Your_stone){
        int I = 0;
        int You = 0;
        for(int a=0;a<8;a++){
            for(int b=0;b<8;b++){
                if(board[a][b]==My_stone){
                    I++;
                }
                if(board[a][b]==Your_stone){
                    You++;
                }
            }
        }
        int total = I+You;
        System.out.println();
        System.out.printf("%s = %d\n",My_stone,I);
        System.out.printf("%s = %d\n",Your_stone,You);
        System.out.println(total);
        if(You<I){
            System.out.println("自分の勝ちです");
        }else if(I<You){
            System.out.println("相手の勝ちです");
        }else{
            System.out.println("引き分けです");
        }
    }
}