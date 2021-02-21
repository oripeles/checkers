
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lee
 */
public class Checkers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        Scanner in = new Scanner(System.in);

        board B = new board();
        B.init();
        B.print();

        int i, j;
        while (true) {

            i = in.nextInt();
            j = in.nextInt();
            
            B.PriorityAndEat(i, j, true);
            B.print();
            
            i = in.nextInt();
            j = in.nextInt();
           B.PriorityAndEat(i, j, true);
            B.print();
        }
    }

}
