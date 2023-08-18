package DesignPen_pkg;

public class FountainPenFactory implements PenFactory{
    public Pen getPen(){
        return  new FountainPen();
    }

}
