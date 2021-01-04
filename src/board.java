
import static java.lang.System.in;
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
public class board {

//
    public board(piece piece) {//
        init();
    }
    private square[][] matrix = new square[8][8];
    public int color = 1;

    board() {
    }

    public void init() {

        for (int j = 0; j < 8; j++) {
            if (j % 2 == 0) {
                matrix[0][j] = new square(true, new piece(type.black));
                matrix[1][j] = new square(false);
                matrix[2][j] = new square(true, new piece(type.black));
                matrix[3][j] = new square(false);
                matrix[4][j] = new square(true, new piece(type.empty));
                matrix[5][j] = new square(false);
                matrix[6][j] = new square(true, new piece(type.white));
                matrix[7][j] = new square(false);
            } else {
                matrix[0][j] = new square(false);
                matrix[1][j] = new square(true, new piece(type.black));
                matrix[2][j] = new square(false);
                matrix[3][j] = new square(true, new piece(type.empty));
                matrix[4][j] = new square(false);
                matrix[5][j] = new square(true, new piece(type.white));
                matrix[6][j] = new square(false);
                matrix[7][j] = new square(true, new piece(type.white));

            }

        }
    }

    public void move(int i, int j) {
        Scanner in = new Scanner(System.in);

        type tmp = matrix[i][j].getpieceType();

        if (j - 1 < 0) {

            matrix[i + color][j + 1].setTypePiece(tmp);
            matrix[i][j].setTypePiece(type.empty);//כדי למחוק את המשבצת במקום הקודם

        } else if (j + 1 > 7) {

            matrix[i + color][j - 1].setTypePiece(tmp);
            matrix[i][j].setTypePiece(type.empty);//כדי למחוק את המשבצת במקום הקודם

        } else {
            System.out.println("left or right ");
            if (in.nextLine() == "l") {
                matrix[i + color][j - 1].setTypePiece(tmp);
            } else {
                matrix[i + color][j + 1].setTypePiece(tmp);
            }
            matrix[i][j].setTypePiece(type.empty);//כדי למחוק את המשבצת במקום הקודם

        }
        if (color == 1) {
            color = -1;
        } else {
            color = 1;
        }

    }

    public int check(int i, int j, boolean playerColor, boolean right) {
        int check;

        if (!squareslegal(i, j)) {//
            return 0;
        }

        if (matrix[i][j].getMypiece() == null) {//המשבצת שאני הולך אליה ריקה()  
            return 1;
        }
        if ((playerColor && matrix[i][j].getpieceType() == type.white)
                || (!playerColor && matrix[i][j].getpieceType() == type.black)) {//חסימה על ידי שחקן שלי

            return 0;
        }

        if (((playerColor && right) || (!playerColor && !right))//בדיקה אם אפשר לאכול אם אני הולך ימין ושמאל בהתאמה
                && squareslegal(i + color, j + 1)
                && matrix[i + color][j + 1].getpieceType() == null) {
            return 2;
        }
        if (((playerColor && !right) || (!playerColor && right))
                &&//בדיקה אם אני יכול לאכול ימין ושמאל בהתאמה
                squareslegal(i + color, j - 1)
                && matrix[i + color][j - 1].getpieceType() == null) {
            return 2;
        }

        ///if (right && ((playerColor && matrix[i + color][j + 1].getpieceType() == null)//בדיקה אם יש משבצת פנויה בשחור ולבן
        // || (!playerColor && matrix[i + color][j - 1].getpieceType() == null))) {
        //return 2;
        // }
        // if (!right && ((playerColor && matrix[i + color][j - 1].getpieceType() == null)//אותו דבר רק בצד שמאל
        //  || (!playerColor && matrix[i + color][j + 1].getpieceType() == null))) {
        //  return 2;
        //  }
        return 0;
    }

    public int checklegall(int i, int j, boolean playerColor) {//לבדוק ששחור לא ילחץ לבןולהפך
        int right, left;
        if (matrix[i][j].getpieceType() == null) {
            return 0;
        }
        if (playerColor && matrix[i][j].getpieceType() == type.black) {
            return 0;
        }
        if (!playerColor && matrix[i][j].getpieceType() == type.white) {
            return 0;
        }
        //if (!right&&((playerColor && matrix[i][j].getpieceType()==type.white)&&
        //(matrix[i][j].getpieceType()==type.black)))//
        return 1;
    }

    public boolean squareslegal(int i, int j) {

        if ((i > 7 || i < 0) || (j > 7 || j < 0)) {
            return false;
        }
        return true;

    }

    public void PriorityAndEat(int i, int j, boolean playerColor, boolean right, int a, int b) {

        Scanner eat = new Scanner(System.in);
        a = check(i + color, j + 1, playerColor, true);

        b = check(i + color, j - 1, playerColor, false);

        if (a + b == 0) {
            System.out.println("0 ");
        }
        
        if (a == 2 || b == 2) {

            while (a == 2 || b == 2) {
                if (a + b == 4) {
                    System.out.println("1:" + i + color * 2 + "  " + j + 2 + "2:" + i + color * 2 + " " + (j - 2));
                    System.out.println("left=1 or right=else ");
                    if (eat.nextLine() == "l") {

                        location(i, j, i + color * 2, j - 2);
                        matrix[i + color][j - 1].setMypiece(null);
                        i = i + color * 2;
                        j = j - 2;
                    } else {
                        location(i, j, i + color * 2, j + 2);
                        matrix[i + color][j + 1].setMypiece(null);
                        i = i + color * 2;
                        j = j + 2;

                    }
                }
                if (a == 2) {
                    System.out.println("1:" + i + color * 2 + "  " + j + 2);
                    System.out.println("only right! ");

                    location(i, j, i + color * 2, j + 2);
                    matrix[i + color][j + 1].setMypiece(null);
                    i = i + color * 2;
                    j = j + 2;
                }
                if (b == 2) {
                    System.out.println("2:" + i + color * 2 + "  " + (j - 2));
                    System.out.println("onlt left! ");

                    location(i, j, i + color * 2, j - 2);
                    matrix[i + color][j - 1].setMypiece(null);
                    i = i + color * 2;
                    j = j - 2;
                }
                a = check(i + color, j + 1, playerColor, true);

                b = check(i + color, j - 1, playerColor, false);
            }
            return;
        }

        if (a + b == 2) {
            System.out.println("1:" + i + color + " " + j + 1 + " 2:" + i + color + " " + (j - 1));
            System.out.println("left=1 or right=else ");
            if (eat.nextLine() == "l") {
                location(i, j, i + color, j - 1);

            } else {
                location(i, j, i + color, j + 1);
            }
        }

        if (a == 1 && b == 0) {
            System.out.println("1:" + i + color + " " + j + 1);
            System.out.println("option only on the right side! ");
            location(i, j, i + color, j + 1);
        }
        if (a == 0 && b == 1) {
            System.out.println("2:" + i + color + " " + (j - 1));
            System.out.println("option only on the left side! ");
            location(i, j, i + color, j - 1);
        }

    }

    public void location(int i, int j, int a, int b) {

        matrix[a][b].setMypiece(matrix[i][j].getMypiece());
        matrix[i][j].setMypiece(null);

    }
    

    public void print() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (matrix[i][j].getUsed()) {
                    switch (matrix[i][j].getpieceType()) {
                        case black: {
                            System.out.print("1");
                            break;
                        }
                        case white: {
                            System.out.print("2");
                            break;
                        }
                        default:
                            System.out.print("!");
                    }
                } else {
                    System.out.print("#");
                }

                System.out.print("   ");
            }
            System.out.println("");

        }
    }

}
