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

        Board I = new You("自分",My_stone);
        Board You = new You("相手",Your_stone);

        System.out.println("対戦モードを選択してもらいます");
        System.out.println("Player対CPUなら 0 を入力してください");
        System.out.println("Player対Playerなら 1 を入力してください");
        System.out.println("CPU対CPUなら 2 を入力してください");
        //int scan = scan();
        //I = select(scan,I,My_stone);
        //You = select_2(scan,You,Your_stone);


        System.out.printf("%sの石は%sです\n",I.getName(),My_stone);
        System.out.printf("%sの石は%sです\n",You.getName(),Your_stone);
        System.out.println();

        String First = judge(I.getName(),You.getName()); //最初にやる人を決める

        System.out.printf("%sが先行でゲームスタート！\n",First);
        System.out.println();
        System.out.println("最初の配置はこのようになります");
        make(board,empty);
        view(board);
        System.out.println();

        if(First == I.getName()){
            while(end(board,empty)==true) {
                System.out.printf("自分(%s)のターンです\n", My_stone);
                I.input(board, My_stone);
                view(board);
                System.out.println();
                if(end(board,empty)==true){
                    if(I.put_judge2(board,My_stone)==false) {
                        if (You.put_judge2(board, Your_stone) == false) {
                            both_pass(board,You.getName(),Your_stone,I.getName(),My_stone);
                            break;
                        }
                    }
                }
                while (end(board, empty) == true) {
                    System.out.println();
                    System.out.printf("相手(%s)のターンです\n", Your_stone);
                    You.input(board, Your_stone);
                    view(board);
                    System.out.println();
                    break;
                }
                if(end(board,empty)==true){
                    if(I.put_judge2(board,My_stone)==false) {
                        if (You.put_judge2(board, Your_stone) == false) {
                            both_pass(board,I.getName(),My_stone,You.getName(),Your_stone);
                            break;
                        }
                    }
                }
            }
        }else{
            while (end(board, empty) == true) {
                System.out.printf("相手(%s)のターンです\n", Your_stone);
                You.input(board, Your_stone);
                view(board);
                System.out.println();
                if(end(board,empty)==true){
                    if(I.put_judge2(board,My_stone)==false) {
                        if (You.put_judge2(board, Your_stone) == false) {
                            both_pass(board,I.getName(),My_stone,You.getName(),Your_stone);
                            break;
                        }
                    }
                }
                while (end(board, empty) == true) {
                    System.out.println();
                    System.out.printf("自分(%s)のターンです\n", My_stone);
                    I.input(board, My_stone);
                    view(board);
                    System.out.println();
                    break;
                }
                if(end(board,empty)==true){
                    if(I.put_judge2(board,My_stone)==false) {
                        if (You.put_judge2(board, Your_stone) == false) {
                            both_pass(board,You.getName(),Your_stone,I.getName(),My_stone);
                            break;
                        }
                    }
                }
            }
        }
        total(board,My_stone,Your_stone);
    }

    public static void make(String[][] board, String stone_1) {
        for (int a = 0; a < 8; a++) {
            for (int b = 0; b < 8; b++) {
                board[a][b] = stone_1;
            }
        }
        board[3][3] = "○";
        board[4][4] = "○";
        board[3][4] = "●";
        board[4][3] = "●";
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
    public static int scan() {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        if(a!=0 && a!=1 && a!=2){
            System.out.println("0か1か2を選択して下さい");
            scan();
        }
        return a;
    }
    public static Board select(int a,Board I,String My_stone){
        if(a==0){
        }else if(a==1){
            I = new I("Player1",My_stone);
            return I;
        }else if(a==2){
            I = new You("CPU1",My_stone);
            return I;
        }
        return I;
    }
    public static Board select_2(int a,Board You,String Your_stone){
        if(a==0){
        }else if(a==1){
            You = new I("Player2",Your_stone);
            System.out.println();
            return You;
        }else if(a==2) {
            You = new You("CPU1", Your_stone);
            return You;
        }
        return You;
    }
    public static void both_pass(String[][] board,String a,String b,String c,String d){
        System.out.printf("%s(%s)のターンです\n", a,b);
        System.out.println("パスします");
        view(board);
        System.out.println();
        System.out.printf("%s(%s)のターンです\n", c,d);
        System.out.println("パスします");
        view(board);
    }
}