package jp.ac.uryukyu.ie.e165733;

public class I extends Board {
    public I (String name, String stone) {super(name,stone);}

    public void input(String[][] board, String stone) {
        try {
            int number, number_2;
            System.out.println("置きたい場所(縦,横)を入力してもらいます");
            System.out.println("まずは縦を入力してください");
            number = Board.scan();
            System.out.println("次に横をを入力してください");
            number_2 = Board.scan();
            boolean s = Board.search(board, number, number_2);
            if (s == true) {
                board[number][number_2] = stone;
            } else {
                System.out.println("石はすでに置いてあります");
                input(board, stone);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("その値は範囲外です");
            input(board, stone);
        }
    }
}