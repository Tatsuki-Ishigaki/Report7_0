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

        Board I = new I("自分",My_stone);
        Board You = new You("相手",Your_stone);

        System.out.println("対戦モードを選択してもらいます");
        System.out.println("Player対CPUなら 0 を入力してください");
        System.out.println("Player対Playerなら 1 を入力してください");
        System.out.println("CPU対CPUなら 2 を入力してください");
        int scan = scan(); //ユーザ入力で対戦モードを決める
        I = select(scan,I,My_stone);
        You = select_2(scan,You,Your_stone);


        System.out.printf("%sの石は%sです\n",I.getName(),My_stone);
        System.out.printf("%sの石は%sです\n",You.getName(),Your_stone);
        System.out.println();

        String First = judge(I.getName(),You.getName()); //最初にやる人を決める

        System.out.printf("%sが先行でゲームスタート！\n",First);
        System.out.println();
        System.out.println("最初の配置はこのようになります");
        make(board,empty); //ボードを初期化＆作成
        view(board); //ボードを表示
        System.out.println();

        if(First == I.getName()){     //ゲームを実行する
            player(board,I,You,empty,My_stone,Your_stone);
        }else{
            player(board,You,I,empty,Your_stone,My_stone);
        }
        total(board,My_stone,Your_stone,I.getName(),You.getName()); //勝敗を判定し出力する
    }

    public static void make(String[][] board, String stone_1) {     //ボードを作る
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

    public static void view(String board[][]) {     //ボードを表示する
        System.out.println("  0 1 2 3 4 5 6 7");
        for (int line = 0; line < 8; line++) {
            System.out.print(line + " ");
            for (int row = 0; row < 8; row++) {
                System.out.print(board[line][row] + " ");
            }
            System.out.println();
        }
    }

    public static String judge(String a,String b){         //最初にやる人をランダムで判定する
        String c;
        int S = (int)(Math.random()*10);
        if(S<5){
            c = a;
        }else{
            c = b;
        }
        return c;
    }

    public static String judge_opposition(String a){        //最初にやらない人を出力する
        String b;
        if(a=="○"){
            b = "●";
        }else{
            b = "○";
        }
        return b;
    }

    public static boolean end(String[][] board,String empty){         //ボードがからか判定する
        for(int a=0;a<8;a++){
            for(int b=0;b<8;b++){
                if(board[a][b]==empty){
                    return true;
                }
            }
        }
        return false;
    }

    public static void total(String[][] board,String My_stone,String Your_stone,String c,String d){  //スコアを出す
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
        System.out.printf("%s = %d\n",My_stone,I);
        System.out.printf("%s = %d\n",Your_stone,You);
        System.out.println(total);
        if(You<I){
            System.out.printf("%sの勝ちです!!",c);
        }else if(I<You){
            System.out.printf("%sの勝ちです!!",d);
        }else{
            System.out.println("引き分けです");
        }
    }

    public static int scan() {         //対戦モードをユーザ入力で選択する
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        while (a != 0 && a != 1 && a != 2) {
            System.out.println("0か1か2を入力してください");
            a = scan.nextInt();
        }
        return a;
    }

    public static Board select(int a,Board I,String My_stone){         //ユーザ入力に従いPlayerの種類を決める
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
    public static Board select_2(int a,Board You,String Your_stone){        //ユーザ入力に従いPlayerの種類を決める
        if(a==0){
        }else if(a==1){
            You = new I("Player2",Your_stone);
            System.out.println();
            return You;
        }else if(a==2) {
            You = new You("CPU2", Your_stone);
            return You;
        }
        return You;
    }
    //ゲームの実行　ボードが空の時かどちらも置けない時実行を終了する
    public static void player(String[][] board,Board name,Board name2,String empty,String stone,String stone2){
        while(end(board,empty)==true) {
            System.out.printf("%s(%s)のターンです\n",name.getName(), stone);
            name.input(board, stone);
            view(board);
            System.out.println();
            if (end(board, empty) == true) {
                if (name.put_judge2(board, stone) == false && name2.put_judge2(board, stone2) == false) {
                    both_pass(board, name2.getName(), stone2,name.getName(),stone);
                    break;
                }
            }
            while(end(board,empty)==true) {
                System.out.printf("%s(%s)のターンです\n", name2.getName(), stone2);
                name2.input(board, stone2);
                view(board);
                System.out.println();
                break;
            }
            if (end(board, empty) == true) {
                if (name.put_judge2(board, stone) == false && name2.put_judge2(board, stone2) == false) {
                    both_pass(board, name.getName(), stone,name2.getName(),stone2);
                    break;
                }
            }
        }
    }
    public static void both_pass(String[][] board,String a,String b,String c,String d){    //両方パスの場合に出力
        System.out.printf("%s(%s)のターンです\n", a,b);
        System.out.println("パスします");
        view(board);
        System.out.println();
        System.out.printf("%s(%s)のターンです\n", c,d);
        System.out.println("パスします");
        view(board);
    }
}