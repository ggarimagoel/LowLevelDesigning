package DesignPen_pkg;

abstract class Pen {
    private String brand;
    private int price;
    String MaterialType;
    private String InkType;
    private boolean refillable;

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public String getMaterialType() {
        return MaterialType;
    }

    public String getInkType() {
        return InkType;
    }

    public boolean isRefillable(boolean b) {
        return refillable;
    }

    public Pen() {

    }
    abstract void write();

    public Pen( String brand, int price, String MaterialType,String InkType, boolean refillable){
        this.brand = brand;
        this.price = price;
        this.MaterialType = MaterialType;
        this.InkType = InkType;
        this.refillable = refillable;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setMaterialType(String materialType) {
        MaterialType = materialType;
    }

    public void setInkType(String inkType) {
        InkType = inkType;
    }

    public void setRefillable(boolean refillable) {
        this.refillable = refillable;
    }

    public void print(){
        System.out.println( "Brand " + brand + "    " + "price " + price + "    " + "InkType" + InkType + "     " + " Material" + MaterialType    );
    }

}
