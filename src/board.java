
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
    public board() {//
        init();
    }
    public square[][] matrix = new square[8][8];
    public int color = -1;

    public void init() {

        for (int j = 0; j < 8; j++) {
            if (j % 2 == 0) {
                matrix[0][j] = new square(true, new piece(type.black));
                matrix[1][j] = new square(false);
                matrix[2][j] = new square(true, new piece(type.black));
                matrix[3][j] = new square(false);
                matrix[4][j] = new square(true, null);
                matrix[5][j] = new square(false);
                matrix[6][j] = new square(true, new piece(type.white));
                matrix[7][j] = new square(false);
            } else {
                matrix[0][j] = new square(false);
                matrix[1][j] = new square(true, new piece(type.black));
                matrix[2][j] = new square(false);
                matrix[3][j] = new square(true, null);
                matrix[4][j] = new square(false);
                matrix[5][j] = new square(true, new piece(type.white));
                matrix[6][j] = new square(false);
                matrix[7][j] = new square(true, new piece(type.white));

            }

        }
    }

    public void PriorityAndEat(int i, int j, boolean playerColor) {

        int a, b, q, w, r, t;
        boolean e, z1, z2, z3, z4;
        Scanner eat = new Scanner(System.in);
        if (color == -1) {
            a = check(i + color, j + 1, playerColor, true);

            b = check(i + color, j - 1, playerColor, false);
            e = checklegall(i, j, playerColor);

        } else {
            a = check(i + color, j + 1, !playerColor, false);

            b = check(i + color, j - 1, !playerColor, true);
            e = checklegall(i, j, !playerColor);

        }

        /* if(color==-1 && Win()==4 && a!=2 && b!=2){
      System.out.println("you must to eat,white!!");
      color=1;
      
}
        else if(color==1 && Win()==3 && a!=2 && b!=2 ){
             System.out.println("you must to eat ,black!!");
        // color=-1;
      // }*/
        if (!e) {
            System.out.println("is not legal");
            if (color == -1) {
                color = 1;
            } else {
                color = -1;
            }
      
        } else if (matrix[i][j].getpieceType() == type.kingwhite || matrix[i][j].getpieceType() == type.kingblack) {

            System.out.println("new location to the  king ");
            int c = eat.nextInt();
            int f = eat.nextInt();
            int kingleagl1eat = 0;
            int kingleagl2eat = 0;
            int kingleagl3eat = 0;
            int kingleagl4eat = 0;
            if (color == -1) {
                q = kinglegal1(i, j, playerColor, c, f);
                w = kinglegal2(i, j, playerColor, c, f);
                r = kinglegal3(i, j, playerColor, c, f);
                t = kinglegal4(i, j, playerColor, c, f);

            } else {
                q = kinglegal1(i, j, !playerColor, c, f);
                w = kinglegal2(i, j, !playerColor, c, f);
                r = kinglegal3(i, j, !playerColor, c, f);
                t = kinglegal4(i, j, !playerColor, c, f);

            }
            if (matrix[c][f].getMypiece() != null || (q == 0 && w == 0 && r == 0 && t == 0)) {
                if (color == -1) {
                    color = 1;
                } else {
                    color = -1;
                }
            } else {
                location(i, j, c, f);

                if (q == 1) {
                    kingleagl1eat = kingleagl1eat(i, j, c, f);

                }

                if (w == 1) {
                    kingleagl2eat = kingleagl2eat(i, j, c, f);

                }
                if (r == 1) {

                    kingleagl3eat = kingleagl3eat(i, j, c, f);

                }
                if (t == 1) {

                    kingleagl4eat = kingleagl4eat(i, j, c, f);

                }

                if (kingleagl1eat == 2 || kingleagl2eat == 2 || kingleagl3eat == 2 || kingleagl4eat == 2) {
                    i = c;
                    j = f;
                    if (color == -1) {
                        z1 = checkking1(i, j, playerColor);
                        z2 = checkking2(i, j, playerColor);
                        z3 = checkking3(i, j, playerColor);
                        z4 = checkking4(i, j, playerColor);
                    } else {
                        z1 = checkking1(i, j, !playerColor);
                        z2 = checkking2(i, j, !playerColor);
                        z3 = checkking3(i, j, !playerColor);
                        z4 = checkking4(i, j, !playerColor);

                    }

                    while (z1 || z2 | z3 || z4) {
                        print();
                        System.out.println("new location to the  king 775");
                        int n = eat.nextInt();
                        int m = eat.nextInt();
                        if (matrix[n][m].getMypiece() != null) {
                            continue;
                        }
                        if (color == -1) {
                            q = kinglegal1(i, j, playerColor, n, m);
                            w = kinglegal2(i, j, playerColor, n, m);
                            r = kinglegal3(i, j, playerColor, n, m);
                            t = kinglegal4(i, j, playerColor, n, m);
                        } else {
                            q = kinglegal1(i, j, !playerColor, n, m);
                            w = kinglegal2(i, j, !playerColor, n, m);
                            r = kinglegal3(i, j, !playerColor, n, m);
                            t = kinglegal4(i, j, !playerColor, n, m);
                        }
                        if (z1 && z2 && z3 && z4) {
                            if (q != 1 && w != 1 && r != 1 && t != 1) {
                                System.out.println("you must to eat king  ");
                                continue;
                            }

                        } else if (z1 && z2 && z3) {
                            if (q != 1 && w != 1 && r != 1) {
                                System.out.println("you must to eat king  ");
                                continue;
                            }
                        } else if (z1 && z2 && z4) {
                            if (q != 1 && w != 1 && t != 1) {
                                System.out.println("you must to eat king  ");
                                continue;
                            }

                        } else if (z1 && z3 && z4) {
                            if (q != 1 && r != 1 && t != 1) {
                                System.out.println("you must to eat king  ");
                                continue;
                            }
                        } else if (z2 && z4 && z3) {
                            if (w != 1 && r != 1 && t != 1) {
                                System.out.println("you must to eat king  ");
                                continue;
                            }
                        } else if (z1 && z2) {
                            if (w != 1 && q != 1) {
                                System.out.println("you must to eat king  ");
                                continue;
                            }
                        } else if (z1 && z3) {
                            if (q != 1 && r != 1) {
                                System.out.println("you must to eat king  ");
                                continue;
                            }
                        } else if (z1 && z4) {
                            if (q != 1 && t != 1) {
                                System.out.println("you must to eat king  ");
                                continue;
                            }
                        } else if (z2 && z3) {
                            if (w != 1 && r != 1) {
                                System.out.println("you must to eat king  ");
                                continue;
                            }
                        } else if (z2 && z4) {
                            if (w != 1 && t != 1) {
                                System.out.println("you must to eat king  ");
                                continue;
                            }
                        } else if (z3 && z4) {
                            if (r != 1 && t != 1) {
                                System.out.println("you must to eat king  ");
                                continue;
                            }
                        } else if (z1) {
                            if (q != 1) {
                                System.out.println("you must to eat king  ");
                                continue;
                            }
                        } else if (z2) {
                            if (w != 1) {

                                System.out.println("you must to eat king 22 ");
                                continue;
                            }

                        } else if (z3) {
                            if (r != 1) {
                                System.out.println("you must to eat king  ");
                                continue;
                            }

                        } else if (z4) {
                            if (t != 1) {
                                System.out.println("you must to eat king  ");
                                continue;
                            }

                        }
                        System.out.println("fuck  ");
                        location(i, j, n, m);
                        if (q == 1) {
                            kingleagl1eat(i, j, n, m);
                        }
                        if (w == 1) {
                            kingleagl2eat(i, j, n, m);
                        }
                        if (r == 1) {
                            kingleagl3eat(i, j, n, m);
                        }
                        if (t == 1) {
                            kingleagl4eat(i, j, n, m);
                        }
                        i = n;
                        j = m;
                        if (color == -1) {
                            z1 = checkking1(i, j, playerColor);
                            z2 = checkking2(i, j, playerColor);
                            z3 = checkking3(i, j, playerColor);
                            z4 = checkking4(i, j, playerColor);

                        } else {
                            z1 = checkking1(i, j, !playerColor);
                            z2 = checkking2(i, j, !playerColor);
                            z3 = checkking3(i, j, !playerColor);
                            z4 = checkking4(i, j, !playerColor);

                        }
                    }
                }

            }

        } else if (a == 0 && b == 0) {
            System.out.println("you need play again");
            if (color == -1) {
                color = 1;
            } else {
                color = -1;
            }

        } else if (a == 2 || b == 2) {

            while (a == 2 || b == 2) {
                if (a == 2 && b == 2) {
                    System.out.println("1:" + i + color * 2 + "  " + j + 2 + "2:" + i + color * 2 + " " + (j - 2));
                    System.out.println("left=1 or right=else ");
                    int move = eat.nextInt();
                    if (move == 1) {

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

                } else if (a == 2) {

                    System.out.println("only right! ");

                    location(i, j, i + color * 2, j + 2);
                    matrix[i + color][j + 1].setMypiece(null);

                    i = i + color * 2;
                    j = j + 2;
                } else if (b == 2) {
                    System.out.println("2:" + i + color * 2 + "  " + (j - 2));
                    System.out.println("onlt left! ");

                    location(i, j, i + color * 2, j - 2);
                    matrix[i + color][j - 1].setMypiece(null);
                    i = i + color * 2;
                    j = j - 2;
                }
                if (color == -1) {

                    a = check(i + color, j + 1, playerColor, true);
                    b = check(i + color, j - 1, playerColor, false);
                } else {
                    a = check(i + color, j + 1, !playerColor, false);

                    b = check(i + color, j - 1, !playerColor, true);
                }
            }
        } else if (a == 1 && b == 1) {
            System.out.println("1:" + i + color + " " + j + 1 + " 2:" + i + color + " " + (j - 1));
            System.out.println("left=1 or right=else ");
            int move = eat.nextInt();
            if (move == 1) {
                location(i, j, i + color, j - 1);

            } else {
                location(i, j, i + color, j + 1);
            }
        } else if (a == 1 && b == 0) {
            System.out.println("1:" + i + color + " " + j + 1);
            System.out.println("option only on the right side! ");
            location(i, j, i + color, j + 1);
        } else if (a == 0 && b == 1) {
            System.out.println("2:" + i + color + " " + (j - 1));
            System.out.println("option only on the left side! ");
            location(i, j, i + color, j - 1);
        } else {
            System.out.println(" else ");
        }
        king();
        if (color == -1) {
           // if (Win(i, j) == 2) {
               // System.out.println("you win white !!!");
          //  }
            color = 1;
        } else {
            //if (Win(i, j) == 1) {
              //  System.out.println("you win black !!!");
           // }
            color = -1;
        }

    }

    public int check(int i, int j, boolean playerColor, boolean right) {
        int check;

        if (!squareslegal(i, j)) {//
            System.out.println("123");
            return 0;
        }
        if (matrix[i][j].getMypiece() == null) {//המשבצת שאני הולך אליה ריקה()  
            System.out.println("2");
            return 1;
        }
        if ((playerColor && matrix[i][j].getpieceType() == type.white)
                || (!playerColor && matrix[i][j].getpieceType() == type.black)) {//חסימה על ידי שחקן שלי
            System.out.println("3");
            return 0;
        }

        if (((playerColor && right) || (!playerColor && !right))//בדיקה אם אפשר לאכול אם אני הולך ימין ושמאל בהתאמה
                && squareslegal(i + color, j + 1) && matrix[i + color][j + 1].getMypiece() == null) {
            System.out.println("4");
            return 2;
        }
        if (((playerColor && !right) || (!playerColor && right))
                //
                && squareslegal(i + color, j - 1) && matrix[i + color][j - 1].getMypiece() == null) {
            System.out.println("5");
            return 2;
        }

        return 0;

    }

    public boolean squareslegal(int i, int j) {

        if ((i > 7 || i < 0) || (j > 7 || j < 0)) {
            return false;
        }
        return true;

    }

    public void location(int i, int j, int a, int b) {

        matrix[a][b].setMypiece(matrix[i][j].getMypiece());
        matrix[i][j].setMypiece(null);

    }

    //כדי למחוק את המשבצת במקום הקודם
    public boolean checklegall(int i, int j, boolean playerColor) {//לבדוק ששחור לא ילחץ לבןולהפך
        if (matrix[i][j].getMypiece() == null) {
            return false;
        }
        if (matrix[i][j].getUsed() == false) {
            return false;
        }

        if (playerColor && (matrix[i][j].getpieceType() == type.black || matrix[i][j].getpieceType() == type.kingblack)) {
            return false;
        }
        if (!playerColor && (matrix[i][j].getpieceType() == type.white || matrix[i][j].getpieceType() == type.kingwhite)) {
            return false;
        }

        return true;
    }

    public void king() {
        for (int j = 0; j < 8; j++) {
            if (matrix[7][j].getpieceType() == type.black) {
                matrix[7][j].setTypePiece(type.kingblack);

            }
            if (matrix[0][j].getpieceType() == type.white) {
                matrix[0][j].setTypePiece(type.kingwhite);

            }
        }
    }

    public int kinglegal1(int i, int j, boolean playerColor, int c, int f) {

        if ((i - c == j - f) && (i - c > 0) && (j - f > 0)) {
            for (i -= 1, j -= 1; squareslegal(i, j) && i > c && j > f; j--, i--) {
                if (playerColor) {
                    if (matrix[i][j].getpieceType() == type.kingwhite || matrix[i][j].getpieceType() == type.white) {
                        System.out.println("is imposible 1");
                        return 0;
                    }
                    if ((matrix[i][j].getpieceType() == type.kingblack || matrix[i][j].getpieceType() == type.black)
                            && (matrix[i - 1][j - 1].getpieceType() == type.kingblack || matrix[i - 1][j - 1].getpieceType() == type.black)) {
                        System.out.println("is imposible 2");
                        return 0;
                    }
                }
                if (!playerColor) {
                    if (matrix[i][j].getpieceType() == type.kingblack || matrix[i][j].getpieceType() == type.black) {
                        System.out.println("is imposible 1");
                        return 0;
                    }
                    if ((matrix[i][j].getpieceType() == type.kingwhite || matrix[i][j].getpieceType() == type.white)
                            && (matrix[i - 1][j - 1].getpieceType() == type.kingwhite || matrix[i - 1][j - 1].getpieceType() == type.white)) {
                        System.out.println("is imposible 2");
                        return 0;
                    }
                }

            }
            System.out.println("ok 1");
            return 1;

        }
        return 0;
    }

    public int kinglegal2(int i, int j, boolean playerColor, int c, int f) {
        if ((i - c == (j - f) * -1) && (i - c > 0) && (j - f < 0)) {
            for (i -= 1, j += 1; squareslegal(i, j) && i > c && j < f; j++, i--) {
                if (playerColor) {
                    if (matrix[i][j].getpieceType() == type.kingwhite || matrix[i][j].getpieceType() == type.white) {
                        System.out.println("is imposible 1");
                        return 0;
                    }
                    if ((matrix[i][j].getpieceType() == type.kingblack || matrix[i][j].getpieceType() == type.black)
                            && (matrix[i - 1][j + 1].getpieceType() == type.kingblack || matrix[i - 1][j + 1].getpieceType() == type.black)) {
                        System.out.println("is imposible 2");
                        return 0;
                    }
                }
                if (!playerColor) {
                    if (matrix[i][j].getpieceType() == type.kingblack || matrix[i][j].getpieceType() == type.black) {
                        System.out.println("is imposible 1");
                        return 0;
                    }
                    if ((matrix[i][j].getpieceType() == type.kingwhite || matrix[i][j].getpieceType() == type.white)
                            && (matrix[i - 1][j + 1].getpieceType() == type.kingwhite || matrix[i - 1][j + 1].getpieceType() == type.white)) {
                        System.out.println("is imposible 2");
                        return 0;
                    }
                }
            }
            System.out.println("ok 2");
            return 1;

        }
        return 0;
    }

    public int kinglegal3(int i, int j, boolean playerColor, int c, int f) {
        if ((i - c) * -1 == j - f && (i - c < 0) && (j - f > 0)) {
            for (i += 1, j -= 1; squareslegal(i, j) && i < c && j > f; j--, i++) {
                if (playerColor) {
                    if (matrix[i][j].getpieceType() == type.kingwhite || matrix[i][j].getpieceType() == type.white) {
                        System.out.println("is imposible 1");
                        return 0;
                    }
                    if ((matrix[i][j].getpieceType() == type.kingblack || matrix[i][j].getpieceType() == type.black)
                            && (matrix[i + 1][j - 1].getpieceType() == type.kingblack || matrix[i + 1][j - 1].getpieceType() == type.black)) {
                        System.out.println("is imposible 2");
                        return 0;
                    }
                }
                if (!playerColor) {
                    if (matrix[i][j].getpieceType() == type.kingblack || matrix[i][j].getpieceType() == type.black) {
                        System.out.println("is imposible 1");
                        return 0;
                    }
                    if ((matrix[i][j].getpieceType() == type.kingwhite || matrix[i][j].getpieceType() == type.white)
                            && (matrix[i + 1][j - 1].getpieceType() == type.kingwhite || matrix[i + 1][j - 1].getpieceType() == type.white)) {
                        System.out.println("is imposible 2");
                        return 0;
                    }
                }
            }
            System.out.println("ok 3");

            return 1;
        }
        return 0;
    }

    public int kinglegal4(int i, int j, boolean playerColor, int c, int f) {
        if ((i - c == j - f) && (i - c < 0) && (j - f < 0)) {
            for (i += 1, j += 1; squareslegal(i, j) && i < c && j < f; j++, i++) {
                if (playerColor) {
                    if (matrix[i][j].getpieceType() == type.kingwhite || matrix[i][j].getpieceType() == type.white) {
                        System.out.println("is imposible 1");
                        return 0;
                    }
                    if ((matrix[i][j].getpieceType() == type.kingblack || matrix[i][j].getpieceType() == type.black)
                            && (matrix[i + 1][j + 1].getpieceType() == type.kingblack || matrix[i + 1][j + 1].getpieceType() == type.black)) {
                        System.out.println("is imposible 2");
                        return 0;
                    }
                }
                if (!playerColor) {
                    if (matrix[i][j].getpieceType() == type.kingblack || matrix[i][j].getpieceType() == type.black) {
                        System.out.println("is imposible 1");
                        return 0;
                    }
                    if ((matrix[i][j].getpieceType() == type.kingwhite || matrix[i][j].getpieceType() == type.white)
                            && (matrix[i + 1][j + 1].getpieceType() == type.kingwhite || matrix[i + 1][j + 1].getpieceType() == type.white)) {
                        System.out.println("is imposible 2");
                        return 0;
                    }
                }
            }
            System.out.println("ok 4");
            return 1;

        }
        return 0;
    }

    public int kingleagl1eat(int i, int j, int c, int f) {
        int num = 0;
        for (i -= 1, j -= 1; squareslegal(i, j) && i > c && j > f; j--, i--) {
            if (matrix[i][j].getMypiece() != null) {
                num++;
            }
            matrix[i][j].setMypiece(null);
        }
        if (num > 0) {
            return 2;
        }
        return 1;
    }

    public int kingleagl2eat(int i, int j, int c, int f) {
        int num = 0;
        for (i -= 1, j += 1; squareslegal(i, j) && i > c && j < f; j++, i--) {
            if (matrix[i][j].getMypiece() != null) {
                num++;
            }
            matrix[i][j].setMypiece(null);
        }
        if (num > 0) {
            return 2;
        }
        return 1;
    }

    public int kingleagl3eat(int i, int j, int c, int f) {
        int num = 0;
        for (i += 1, j -= 1; squareslegal(i, j) && i < c && j > f; j--, i++) {
            if (matrix[i][j].getMypiece() != null) {
                num++;
            }
            matrix[i][j].setMypiece(null);
        }
        if (num > 0) {
            return 2;
        }
        return 1;
    }

    public int kingleagl4eat(int i, int j, int c, int f) {
        int num = 0;
        for (i += 1, j += 1; squareslegal(i, j) && i < c && j < f; j++, i++) {
            if (matrix[i][j].getMypiece() != null) {
                num++;
            }
            matrix[i][j].setMypiece(null);
        }
        if (num > 0) {
            return 2;
        }
        return 1;
    }

    public boolean checkking1(int i, int j, boolean playercolor) {
if(!squareslegal(i-1, j-1)){
    return false;
}
else{
        if (playercolor) {
            if ((matrix[i - 1][j - 1].getpieceType() == type.kingblack || matrix[i - 1][j - 1].getpieceType() == type.black)
                    && matrix[i - 2][j - 2].getMypiece() == null && squareslegal(i - 2, j - 2)) {
                return true;
            }
        }
        if (!playercolor) {
            if ((matrix[i - 1][j - 1].getpieceType() == type.kingwhite || matrix[i - 1][j - 1].getpieceType() == type.white)
                    && matrix[i - 2][j - 2].getMypiece() == null && squareslegal(i - 2, j - 2)) {
                return true;
            }
        }
        return false;
    }
    }

    public boolean checkking2(int i, int j, boolean playercolor) {
        if(!squareslegal(i-1, j+1)){
            return false;
        }
        else{
        if (playercolor) {
            if ((matrix[i - 1][j + 1].getpieceType() == type.kingblack || matrix[i - 1][j + 1].getpieceType() == type.black)
                    && matrix[i - 2][j + 2].getMypiece() == null && squareslegal(i - 2, j + 2)) {
                return true;
            }
        }
        if (!playercolor) {
            
            if ( matrix[i - 1][j + 1].getpieceType() == type.kingwhite ||
                    matrix[i - 1][j + 1].getpieceType() == type.white
                    && matrix[i - 2][j + 2].getMypiece() == null && squareslegal(i - 2, j + 2)) {
                return true;
            }
        
        }
       
       return  false;
    }
    }
    public boolean checkking3(int i, int j, boolean playercolor) {
        if(!squareslegal(i+1, j-1)){
            return false;
        }
        else{
        if (playercolor) {
            if ((matrix[i + 1][j - 1].getpieceType() == type.kingblack || matrix[i + 1][j - 1].getpieceType() == type.black)
                    && matrix[i + 2][j - 2].getMypiece() == null && squareslegal(i + 2, j - 2)) {
                return true;
            }
        }
        if (!playercolor) {
            if ((matrix[i + 1][j - 1].getpieceType() == type.kingwhite || matrix[i + 1][j - 1].getpieceType() == type.white)
                    && matrix[i + 2][j - 2].getMypiece() == null && squareslegal(i + 2, j - 2)) {
                return true;
            }
        }
        return false;
    }
    }
    public boolean checkking4(int i, int j, boolean playercolor) {
        if(!squareslegal(i+1, j+1)){
            return false;
        }
        else{
        if (playercolor) {
            if ((matrix[i + 1][j + 1].getpieceType() == type.kingblack || matrix[i + 1][j + 1].getpieceType() == type.black)
                    && matrix[i + 2][j + 2].getMypiece() == null && squareslegal(i + 2, j + 2)) {
                return true;
            }
        }
        if (!playercolor) {
            if ((matrix[i + 1][j + 1].getpieceType() == type.kingwhite || matrix[i + 1][j + 1].getpieceType() == type.white)
                    && matrix[i + 2][j + 2].getMypiece() == null && squareslegal(i + 2, j + 2)) {
                return true;
            }
        }
        return false;
    }
    }

   /* public int Win(int i, int j) {
        int sumofblack = 0, sumofwhite = 0;
        int w, e, r, t;
        int flagwhite = 0, musteatwhite = 0, flagblack = 0, musteatblack = 0;
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {

                if (matrix[i][j].getpieceType() == type.white) {
                    sumofwhite = 1;
                    w = check(i - 1, j + 1, true, true);
                    e = check(i - 1, j - 1, true, false);
                    if ((w == 1 || w == 2) || (e == 1 || e == 2)) {
                        flagwhite = 1;
                    }
                    if (w == 2 || e == 2) {
                        musteatwhite = 1;
                    }
                }

                if (matrix[i][j].getpieceType() == type.black) {
                    sumofblack = 1;
                    r = check(i + 1, i + 1, false, false);
                    t = check(j + 1, j - 1, false, true);
                    if ((r == 1 || r == 2) || (t == 1 || t == 2)) {
                        flagblack = 1;
                    }
                    if (r == 2 || t == 2) {
                        musteatblack = 1;
                    }

                }
                if (matrix[i][j].getpieceType() == type.kingwhite) {
                    sumofwhite = 1;

                    if (checkking1(i, j, true) || checkking2(i, j, true)
                            || checkking3(i, j, true) || checkking4(i, j, true)) {
                        musteatwhite = 1;
                    }
                }
                if (matrix[i][j].getpieceType() == type.kingblack) {
                    sumofblack = 1;
                    if (checkking1(i, j, false) || checkking2(i, j, false)
                            || checkking3(i, j, false) || checkking4(i, j, false)) {
                        musteatblack = 1;
                    }
                }

            }
        }

        if (musteatwhite == 1) {
            return 4;
        }
        if (musteatblack == 1) {
            return 3;
        }
        if (sumofwhite == 0) {
            return 1;
        }
        if (sumofblack == 0) {
            return 2;
        }

        return 0;
    }*/

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
                        case kingwhite: {
                            System.out.print("kw");
                            break;
                        }
                        case kingblack: {
                            System.out.print("kb");
                            break;
                        }
                        default:
                            System.out.print("!");
                    }
                } else {
                    System.out.print("#");
                }

                System.out.print("     ");
            }
            System.out.println("  ");

        }
    }

}
