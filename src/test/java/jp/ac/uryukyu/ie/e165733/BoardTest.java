package jp.ac.uryukyu.ie.e165733;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void put_judge2() throws Exception {  // パスが実装できているかどうかのテスト
        String[][] board = new String[8][8];
        You I = new You("テスト自分","●");
        You You = new You("テスト相手","○");

        for (int c = 0; c < 8; c++) {          //○が打てない盤面を作る
            for (int d = 0; d < 8; d++) {
                board[c][d] = "●";
            }
        }
        board[7][7] = "□";
        board[7][5] = "□";
        board[7][4] = "○";
        System.out.println("  0 1 2 3 4 5 6 7");

        for (int line = 0; line < 8; line++) {    //boardを表示する
            System.out.print(line + " ");
            for (int row = 0; row < 8; row++) {
                System.out.print(board[line][row] + " ");
            }
            System.out.println();
        }

        boolean B = Board.put_judge2(board,You.getStone()); //○がおけないことを確認する  置けない場合falseを返す
        assertEquals(B,false); //ちゃんとfalseを返すかを調べる
    }
}