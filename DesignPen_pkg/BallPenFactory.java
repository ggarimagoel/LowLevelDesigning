package DesignPen_pkg;
public class BallPenFactory implements PenFactory {
    //    public Pen getPen(String brand, int price, String MaterialType,String InkType, boolean refillable, WritingStrategy ws, Refill refill){
//
//        return new BallPen(brand, price, "PLASTIC",InkType, refillable, ws,refill);
//    }
    public Pen getPen() {

        return new BallPen();
    }


}
