
package model;

public enum AgeGroup {
    STANDARD("STANDARD", 0),
    STUDENT_PRICE("STUDENT PRICE", 0),
    SENIOR_CITIZEN("SENIOR CITIZEN",0),
    CHILDREN("CHILDREN", 0);

    private String groupType;
    private double price;
    AgeGroup(String groupType, double price){
        this.groupType = groupType;
        this.price = price;
    }

    public String getGroupType(){ return this.groupType; }

    public double getTicketPrice(){
        return this.price;
    }

    public void setTicketPrice(double price){
        this.price = price;
    }
}