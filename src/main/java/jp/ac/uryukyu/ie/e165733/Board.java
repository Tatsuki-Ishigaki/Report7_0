package jp.ac.uryukyu.ie.e165733;

import java.util.Scanner;

public class Board {
    private String name;
    private String stone;

    public Board(String name,String stone) {

        this.name = name;
        this.stone = stone;

    }

    public String getName() {return name;}
    public void setName() {this.name = name;}
    public String getStone() {return stone;}
    public void setStone() {this.stone = stone;}

    public static int scan() {        //ユーザ入力で置く場所を選択
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        return number;
    }

    public static boolean search(String[][] board, int a, int b) {        //置く場所が空いてるかを判定
        boolean judge;
        if (board[a][b] == "□") {
            judge = true;
        }else{
            judge = false;
        }
        return judge;
    }

    public static boolean range(String[][] board,int a,int b){        //置く場所がボードの範囲内かを判定
        if(0<=a && a<=7 && 0<=b && b<=7){
            return true;
        }else{
            return false;
        }
    }

    //置く場所から8方向を探ってひっくり返せるか調べる
    public static boolean put_direction(String[][] board,int a,int b,int c,int d,String stone){
        if (range(board, a+c, b+d) == true) {
            if (board[a+c][b+d] != stone && board[a+c][b+d] != "□") {
                    while (range(board, a + c, b + d) == true && board[a + c][b + d] != "□") {
                    if (board[a + c][b + d] == stone) {
                        return true;
                    }
                    if (c < 0 && d < 0) {
                        c--;
                        d--;
                    }
                    if (c < 0 && d == 0) {
                        c--;
                    }
                    if (c < 0 && d > 0) {
                        c--;
                        d++;
                    }
                    if (c == 0 && d < 0) {
                        d--;
                    }
                    if (c == 0 && d > 0) {
                        d++;
                    }
                    if (c > 0 && d < 0) {
                        c++;
                        d--;
                    }
                    if (c > 0 && d == 0) {
                        c++;
                    }
                    if (c > 0 && d > 0) {
                        c++;
                        d++;
                    }
                }

            }
        }
        return false;
    }

    public static boolean put_judge(String[][] board,int a,int b,String stone){   //置く場所がひっくり返せる場所か判定
        if(search(board,a,b)==true) {
            if (put_direction(board, a, b, -1, -1, stone) == true) {
                return true;
            }
            if (put_direction(board, a, b, -1, 0, stone) == true) {
                return true;
            }
            if (put_direction(board, a, b, -1, 1, stone) == true) {
                return true;
            }
            if (put_direction(board, a, b, 0, -1, stone) == true) {
                return true;
            }
            if (put_direction(board, a, b, 0, 1, stone) == true) {
                return true;
            }
            if (put_direction(board, a, b, 1, -1, stone) == true) {
                return true;
            }
            if (put_direction(board, a, b, 1, 0, stone) == true) {
                return true;
            }
            if (put_direction(board, a, b, 1, 1, stone) == true) {
                return true;
            }
        }
        return false;
    }
    //ボードの内に8方向ひっくり返せてかつ置けるところがあるかを判定する
    public static boolean put_judge2(String[][] board,String stone){
        for(int a=0;a<8;a++){
            for(int b=0;b<8;b++){
                if (put_judge(board, a, b, stone) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public void input(String[][] board,String stone) {  //置く場所に石を置く　PlayerとCPUの処理をオーバーライド
    }

    //石をひっくり返す
    public static void reverse_direction(String[][] board,int a,int b,int c,int d,String stone) {
        if (put_direction(board, a, b, c, d, stone) == true) {
            while (board[a + c][b + d] != stone) {
                board[a + c][b + d] = stone;
                if (c < 0 && d < 0) {
                    c--;
                    d--;
                }
                if (c < 0 && d == 0) {
                    c--;
                }
                if (c < 0 && d > 0) {
                    c--;
                    d++;
                }
                if (c == 0 && d < 0) {
                    d--;
                }
                if (c == 0 && d > 0) {
                    d++;
                }
                if (c > 0 && d < 0) {
                    c++;
                    d--;
                }
                if (c > 0 && d == 0) {
                    c++;
                }
                if (c > 0 && d > 0) {
                    c++;
                    d++;
                }
            }
        }
    }
    //置く場所から8方向調べてひっくり返す
    public static void reverse(String[][] board,int a,int b,String stone){
        reverse_direction(board,a,b,-1,-1,stone);
        reverse_direction(board,a,b,-1,0,stone);
        reverse_direction(board,a,b,-1,1,stone);
        reverse_direction(board,a,b,0,-1,stone);
        reverse_direction(board,a,b,0,1,stone);
        reverse_direction(board,a,b,1,-1,stone);
        reverse_direction(board,a,b,1,0,stone);
        reverse_direction(board,a,b,1,1,stone);
    }
}