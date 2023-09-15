package ParkingLot.models;

import java.util.List;

public class Levels extends Base{
    private int number;
    private List<Slot> slotList;
    private LevelStatus levelStatus;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Slot> getSlotList() {
        return slotList;
    }

    public void setSlotList(List<Slot> slotList) {
        this.slotList = slotList;
    }

    public LevelStatus getLevelStatus() {
        return levelStatus;
    }

    public void setLevelStatus(LevelStatus levelStatus) {
        this.levelStatus = levelStatus;
    }

}
