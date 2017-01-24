package jp.ac.uryukyu.ie.e165733;



import java.util.Scanner;

public class Board {
    public Board(){
        String[][] board = new String[8][8];
        String empty = "□";
        String black = "●";
        String white = "○";
        make(board,empty,black,white);
        view(board);

        for(int a=0;a<8;a++){
            for(int b=0;b<8;b++){
                if(board[a][b]=="□"){
                    input(board,black);
                    view(board);
                    input(board,white);
                    view(board);
                }
            }
        }
    }


    public static void make(String[][] board,String stone_1,String stone_2,String stone_3){
        for(int a = 0; a < 8; a++) {
            for (int b = 0; b < 8; b++) {
                board[a][b] = stone_1;
            }
        }
        board[3][3] = stone_2;
        board[4][4] = stone_2;
        board[3][4] = stone_3;
        board[4][3] = stone_3;
    }

    public static void view(String board[][]){
        System.out.println("  0 1 2 3 4 5 6 7");
        for(int line=0;line<8;line++){
            System.out.print(line+" ");
            for(int row=0;row<8;row++){
                System.out.print(board[line][row]+" ");
            }
            System.out.println();
        }
    }
    public static int scan(){
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        return number;
    }
    public static boolean search(String[][] board,int c,int d){
        boolean judge;
        if(board[c][d]=="□"){
            judge = true;
        }else{
            judge = false;
        }
        return judge;
    }

    public static void input(String[][] board,String stone){
        try {
            int number,number_2;
            System.out.println("置きたい場所(縦,横)を入力してください\n");
            System.out.println("まずは縦を入力してください");
            number = scan();
            System.out.println("次に横をを入力してください");
            number_2 = scan();
            boolean s = search(board,number,number_2);
            if(s==true){
                board[number][number_2] = stone;
            }else {
                System.out.println("石はすでに置いてあります");
                input(board, stone);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("その値は範囲外です");
            input(board,stone);
        }
    }
}