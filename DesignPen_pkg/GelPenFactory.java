package DesignPen_pkg;
public class GelPenFactory implements PenFactory{
    public Pen getPen(){
        return  new GelPen();
    }
}
