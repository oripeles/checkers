/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lee
 */
public class square {
    

    public square(boolean used,piece mypiece) {
        this.used = used;
        this.mypiece=mypiece;
    }

    public square(boolean used) {
        this.used = used;
        this.mypiece=null;
    }
    
    private boolean used;
    private piece mypiece; 
    public square() {
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public piece getMypiece() {
        return mypiece;
    }

    public void setMypiece(piece mypiece) {
        this.mypiece = mypiece;
    }
    public type getpieceType(){
    return mypiece.getType();
    }
    
}
