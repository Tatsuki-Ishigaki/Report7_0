package jp.ac.uryukyu.ie.e165733;

public class I extends Board {
    public I (String name, String stone) {super(name,stone);}

    public void input(String[][] board, String stone) {    //ユーザ入力を使って石を置く

        try {                                         //入力した場所がボードの範囲外の場合の例外処理
            boolean n = put_judge2(board,stone);
            if(n==true){
                int number, number_2;
                System.out.println("置きたい場所(縦,横)を入力してもらいます");
                System.out.println("まずは縦を入力してください");
                number = scan();
                System.out.println("次に横をを入力してください");
                number_2 = scan();
                boolean t = put_judge(board,number,number_2,stone);
                if (t == true) {
                    board[number][number_2] = stone;
                    reverse(board, number, number_2, stone);
                }else{
                    System.out.println("その場所には置けません");
                    input(board,stone);
                }
            }else{
                System.out.println("パスします");
            }
        }catch (IndexOutOfBoundsException e) {
            System.out.println("その値は範囲外です");
            input(board, stone);
        }
    }
}