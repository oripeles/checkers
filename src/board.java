
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leethi
 */
public class board {//

    private square[][] matrix = new square[8][8];

    public board(piece piece) {//
        init();
    }
private int color=1;
    public void init() {

        boolean t = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                if (t) {
                    matrix[i][j]=new square(true,new piece(type.black));
                } else {
                    matrix[i][j]=new square(false);
                }
                t = !t;
            }
           t = !t;
        }

        t = false;
        for (int i = 5; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (t==true) {
                  matrix[i][j]=new square(true,new piece(type.white));
                } else {
                    matrix[i][j]=new square(false);
                }
                t = !t;
            }
            t = !t;
        }


        for (int i = 3; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                matrix[i][j]=new square(false);
            }
            
        }
        
        
    }

    public void move(int i, int j,boolean playerColor) {
    Scanner in= new Scanner(System.in);

        piece tmp=matrix[i][j].getMypiece();
        
        if (j - 1 < 0) {
            
                matrix[i + color][j + 1].setMypiece(tmp);
            
            }

         else if (j + 1 > 7) {
          
            matrix[i+color][j-1].setMypiece(tmp);
             
        }
         else {
             System.out.println("left or right ");
             if(in.nextLine()=="l"){
                 matrix[i+color][j-1].setMypiece(tmp);
             }
             else {
              matrix[i+color][j+1].setMypiece(tmp);
             }       
                  matrix[i][j].setMypiece(null);//כדי למחוק את המשבצת במקום הקודם
                     
               }
        
}
    public int  check(int i,int j,boolean playerColor,int chad){
        int check;
        if(matrix [i][j].getMypiece()==null){
            return 1;
        }
        if((playerColor&&matrix[i][j].getpieceType()==type.white)||
                (!playerColor&&matrix[i][j].getpieceType()==type.black)){
        
            return 0;
        }

        if(i+color>7||i+color<0||j+)
        if(matrix [i+color][j+chad].getMypiece()==null){
        return 2;
        }
        return 0;
        }
            
        
        
    
    
}
}

