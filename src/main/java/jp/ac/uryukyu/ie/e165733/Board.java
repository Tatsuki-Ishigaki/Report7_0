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

    public static int scan() {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        return number;
    }

    public static boolean search(String[][] board, int a, int b) {
        boolean judge;
        if (board[a][b] == "□") {
            judge = true;
        }else{
            judge = false;
        }
        return judge;
    }

    public static boolean range(String[][] board,int a,int b){
        if(0<=a && a<=7 && 0<=b && b<=7){
            return true;
        }else{
            return false;
        }
    }

    public static boolean put_judge(String[][] board,int a,int b,String stone){
        if (range(board, a - 1, b - 1) == true) {
            if (board[a - 1][b - 1] != stone && board[a - 1][b - 1] != "□") {
                if (put_judge3(board, a, b, -1, -1, stone) == true) {
                    return true;
                }
            }
        }
        if (range(board, a - 1, b) == true) {
            if (board[a - 1][b] != stone && board[a - 1][b] != "□") {
                if (put_judge7(board, a, b, -1, 0, stone) == true) {
                    return true;
                }
            }
        }
        if (range(board, a - 1, b + 1) == true) {
            if (board[a - 1][b + 1] != stone && board[a - 1][b + 1] != "□") {
                if (put_judge5(board, a, b, -1, 1, stone) == true) {
                    return true;
                }
            }
        }
        if (range(board, a, b - 1) == true) {
            if (board[a][b - 1] != stone && board[a][b - 1] != "□") {
                if (put_judge9(board, a, b, 0, -1, stone) == true) {
                    return true;
                }
            }
        }
        if (range(board, a, b + 1) == true) {if (board[a][b + 1] != stone && board[a][b + 1] != "□") {
                if (put_judge10(board, a, b, 0, 1, stone) == true) {
                    return true;
                }
            }
        }
        if (range(board, a + 1, b - 1) == true) {
            if (board[a + 1][b - 1] != stone && board[a + 1][b - 1] != "□") {
                if (put_judge6(board, a, b, 1, -1, stone) == true) {
                    return true;
                }
            }
        }
        if (range(board, a + 1, b) == true) {
            if (board[a + 1][b] != stone && board[a + 1][b] != "□") {
                if (put_judge8(board, a, b, 1, 0, stone) == true) {
                    return true;
                }
            }
        }
        if (range(board, a + 1, b + 1) == true) {
            if (board[a + 1][b + 1] != stone && board[a + 1][b + 1] != "□") {
                if (put_judge4(board, a, b, 1, 1, stone) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean put_judge2(String[][] board,String stone){
        for(int a=0;a<8;a++){
            for(int b=0;b<8;b++){
                if(search(board,a,b)==true) {
                    if (put_judge(board, a, b, stone) == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean put_judge3(String[][] board,int a,int b,int c,int d,String stone){
        while(range(board,a+c,b+d)==true && board[a+c][b+d]!="□"){
            if(board[a+c][b+d]==stone){
                return true;
            }
            c--;
            d--;
        }
        return false;
    }

    public static boolean put_judge4(String[][] board,int a,int b,int c,int d,String stone){
        while(range(board,a+c,b+d)==true && board[a+c][b+d]!="□"){
            if(board[a+c][b+d]==stone){
                return true;
            }
            c++;
            d++;
        }
        return false;
    }

    public static boolean put_judge5(String[][] board,int a,int b,int c,int d,String stone){
        while(range(board,a+c,b+d)==true && board[a+c][b+d]!="□"){
            if(board[a+c][b+d]==stone){
                return true;
            }
            c--;
            d++;
        }
        return false;
    }

    public static boolean put_judge6(String[][] board,int a,int b,int c,int d,String stone){
        while(range(board,a+c,b+d)==true && board[a+c][b+d]!="□"){
            if(board[a+c][b+d]==stone){
                return true;
            }
            c++;
            d--;
        }
        return false;
    }

    public static boolean put_judge7(String[][] board,int a,int b,int c,int d,String stone){
        while(range(board,a+c,b+d)==true && board[a+c][b+d]!="□"){
            if(board[a+c][b+d]==stone){
                return true;
            }
            c--;
        }
        return false;
    }

    public static boolean put_judge8(String[][] board,int a,int b,int c,int d,String stone){
        while(range(board,a+c,b+d)==true && board[a+c][b+d]!="□"){
            if(board[a+c][b+d]==stone){
                return true;
            }
            c++;
        }
        return false;
    }

    public static boolean put_judge9(String[][] board,int a,int b,int c,int d,String stone){
        while(range(board,a+c,b+d)==true && board[a+c][b+d]!="□"){
            if(board[a+c][b+d]==stone){
                return true;
            }
            d--;
        }
        return false;
    }

    public static boolean put_judge10(String[][] board,int a,int b,int c,int d,String stone){
        while(range(board,a+c,b+d)==true && board[a+c][b+d]!="□"){
            if(board[a+c][b+d]==stone){
                return true;
            }
            d++;
        }
        return false;
    }

    public void input(String[][] board,String stone) {
    }

    public static void reverse(String[][] board,int a,int b,String stone){
        if(put_judge3(board,a,b,-1,-1,stone)==true){
            int c=-1;
            int d=-1;
            while(board[a+c][b+d]!=stone){
                board[a+c][b+d]=stone;
                c--;
                d--;
            }
        }
        if(put_judge7(board,a,b,-1,0,stone)==true){
            int c=-1;
            int d=0;
            while(board[a+c][b+d]!=stone){
                board[a+c][b+d]=stone;
                c--;
            }
        }
        if(put_judge5(board,a,b,-1,1,stone)==true){
            int c=-1;
            int d=1;
            while(board[a+c][b+d]!=stone){
                board[a+c][b+d]=stone;
                c--;
                d++;
            }
        }
        if(put_judge9(board,a,b,0,-1,stone)==true){
            int c=0;
            int d=-1;
            while(board[a+c][b+d]!=stone){
                board[a+c][b+d]=stone;
                d--;
            }
        }
        if(put_judge10(board,a,b,0,1,stone)==true){
            int c=0;
            int d=1;
            while(board[a+c][b+d]!=stone){
                board[a+c][b+d]=stone;
                d++;
            }
        }
        if(put_judge6(board,a,b,1,-1,stone)==true){
            int c=1;
            int d=-1;
            while(board[a+c][b+d]!=stone){
                board[a+c][b+d]=stone;
                c++;
                d--;
            }
        }
        if(put_judge8(board,a,b,1,0,stone)==true){
            int c=1;
            int d=0;
            while(board[a+c][b+d]!=stone){
                board[a+c][b+d]=stone;
                c++;
            }
        }
        if(put_judge4(board,a,b,1,1,stone)==true){
            int c=1;
            int d=1;
            while(board[a+c][b+d]!=stone){
                board[a+c][b+d]=stone;
                c++;
                d++;
            }
        }
    }
}