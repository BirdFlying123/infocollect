package uestc.common;

public enum Mapper {
    USERROLE1(0, "false"),
    USERROLE2(1,"true");


    private int number;
    private String message;

    private Mapper(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
