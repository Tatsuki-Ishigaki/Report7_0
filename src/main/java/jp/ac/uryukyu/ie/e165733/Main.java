package jp.ac.uryukyu.ie.e165733;

import java.util.Scanner;

//aaa
public class Main {
    public static void main(String[] args){
        int S = (int) (Math.random() * 10);
        String stone_I,stone_Y;

        if(S<5){
            stone_I = "●";
            stone_Y = "○";
        }else{
            stone_I = "○";
            stone_Y = "●";
        }

        I I = new I("自分",stone_I);
        You You = new You("相手",stone_Y);

        System.out.printf("あなたの石は%sです\n",stone_I);

        S = (int) (Math.random() * 10);
        String a,b;
        if(S<5){
            System.out.printf("%sが先行でゲームスタート！\n",I.getName());
            a = I.getName();
            b = You.getName();
        }else{
            System.out.printf("%sが先行でゲームスタート！\n", You.getName());
            a = You.getName();
            b = I.getName();
        }

        System.out.println("最初の配置はこのようになります\n");
        Board board = new Board();
        System.out.println();

    }
}