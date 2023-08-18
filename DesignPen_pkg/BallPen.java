package DesignPen_pkg;

import java.sql.Ref;

public class BallPen extends Pen{
    WritingStrategy ws;
    Refill refill;
    public BallPen(){
        super();
    }

    public BallPen( WritingStrategy ws , Refill refill) {
        this();
        this.ws = ws;
        this.refill = refill;
    }



    public void write(){
        System.out.println("this is a ball pen");
    }


}
