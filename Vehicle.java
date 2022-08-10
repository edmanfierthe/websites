public class Vehicle {

    String cmk; // make of the vehicle
    String cmd; // model of the vehicle
    String ccl; // color of the vehicle
    int cyr; // year for the vehicle
    int cml; // mileage for the vehicle
    int vehicleId;

    //Creating constructor with arguments
    public Vehicle(int vehicleId, String cmk, String cmd, String ccl, int cyr, int cml) {
        this.cmk = cmk;
        this.cmd = cmd;
        this.ccl = ccl;
        this.cyr = cyr;
        this.cml = cml;
        this.vehicleId = vehicleId;
    }

    //getter and setter methods for all variables
    public String getCmk() {
        return cmk;
    }

    public void setCmk(String cmk) {
        this.cmk = cmk;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getCcl() {
        return ccl;
    }

    public void setCcl(String ccl) {
        this.ccl = ccl;
    }

    public int getCyr() {
        return cyr;
    }

    public void setCyr(int cyr) {
        this.cyr = cyr;
    }

    public int getCml() {
        return cml;
    }

    public void setCml(int cml) {
        this.cml = cml;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
}