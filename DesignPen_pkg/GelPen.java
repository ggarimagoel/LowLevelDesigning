package DesignPen_pkg;

public class GelPen extends Pen{
        WritingStrategy ws;
        Refill refill;

    public GelPen( WritingStrategy ws , Refill  refill) {
        this();
        this.ws = ws;
        this.refill  = refill;
    }

    public GelPen() {
        super();
    }

    public void write(){
            System.out.println("this is a gel pen");
        }
    }

