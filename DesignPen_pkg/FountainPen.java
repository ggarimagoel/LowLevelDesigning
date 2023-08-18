package DesignPen_pkg;

public class FountainPen extends Pen{
    WritingStrategy ws;
    public FountainPen(){
        super();
    }
    public FountainPen( WritingStrategy ws) {
        this();
        this.ws = ws;
    }

    public void write(){
        System.out.println("this is a fountain pen");
    }
}
