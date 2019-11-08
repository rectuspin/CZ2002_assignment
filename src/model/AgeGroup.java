<<<<<<< HEAD
package model;

public enum AgeGroup {
    STANDARD("STANDARD", 0),
    STUDENT_PRICE("STUDENT PRICE", 2),
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
=======
package model;

public enum AgeGroup {
    STANDARD("STANDARD", 0),
    STUDENT_PRICE("STUDENT PRICE", 2),
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
>>>>>>> 65ec57ebfe207e969a9d6b86e9c3d8b9d543877a
