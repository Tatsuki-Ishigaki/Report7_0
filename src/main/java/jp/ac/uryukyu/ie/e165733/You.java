package jp.ac.uryukyu.ie.e165733;

public class You extends Board {
    public You (String name, String stone) {super(name,stone);}

    public void input(String[][] board, String stone) {

        boolean n = put_judge2(board,stone);
        if(n==true){
            int S = (int) (Math.random() * 8);
            int number, number_2;
            number = S;
            S = (int) (Math.random() * 8);
            number_2 = S;
            boolean s = search(board, number, number_2);
            boolean t = put_judge(board, number, number_2, stone);
            if (s == true && t == true) {
                board[number][number_2] = stone;
                reverse(board, number, number_2, stone);
            } else {
                input(board, stone);
            }
        }else{
            System.out.println("パスします");
        }
    }
}