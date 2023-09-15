package ParkingLot.models;

public class Gate extends Base{
    private Operator operator;
    private GateType gatetype;
    private int gateNumber;
    private  GateStatus gateStatus;

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public GateType getGatetype() {
        return gatetype;
    }

    public void setGatetype(GateType gatetype) {
        this.gatetype = gatetype;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}
