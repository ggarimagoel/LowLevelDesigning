package DesignPen_pkg;

public class Refill {
    private String colour;
    private Nib nib;
    public Refill(String colour, Nib nib){
        this.colour = colour;
        this.nib = nib;
    }
    public String getColour(){
        return colour;
    }
    public Nib getNib(){
        return nib;
    }
}
