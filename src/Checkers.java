
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
        while (true) {       
        
        
        int i = in.nextInt();
        int j = in.nextInt();
        
        B.move(i, j);
        B.print();
       }
    }
    }
    

