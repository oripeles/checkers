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
    }

    private type type;//עדיף לאתחל את זה בפרטי
    

   
    public type getType() {
        return type;

    }

    public void setType(type type) {//becase type is private
        this.type = type;
    }


}

enum type {//משתנים קבועים בלתי אפשריים לשינוי
    black,
    white,
    kingblack,
    kingwhite,
    e
    

}
  