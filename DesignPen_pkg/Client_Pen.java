package DesignPen_pkg;

public class Client_Pen {
    public static void main(String[] args) {
        WritingStrategy smooth = new SmoothWriting();
        WritingStrategy hard = new HardWriting();

        Nib ballnib = new Nib(7);
        Refill refill = new Refill("blue" , ballnib);

        Pen pen = new BallPen(smooth , refill);
        pen.setBrand("Flair");
        pen.setPrice(10);
        pen.setBrand("Flair");
        pen.setMaterialType("PLASTIC");
        pen.setInkType("SPARKLE");
        pen.setRefillable(true);

//        System.out.println(pen);
          pen.print();


    }
}
