/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lee
 */
public class piece {

    public piece(type type) {

        this.type=type;
        if (type == type.white) {
            color = -1;
        } else {
            color = 1;
        }
    }

    private type type;//עדיף לאתחל את זה בפרטי
    private int color = 1;

   
    public type getType() {
        return type;

    }

    public void setType(type type) {//becase type is private
        this.type = type;
    }

    public void print() {
        switch (type) {
            case empty:
                System.out.println(1);

            case black:
                System.out.println(9);

            case white:
                System.out.println("*");

        }
    }

    private static class matrix {

        public matrix() {
        }
    }
}

enum type {//משתנים קבועים בלתי אפשריים לשינוי
    empty,
    black,
    white,
    kingblack,
    kingwhite,

}
