package elevator;

public class Floor { // этаж
    private String floor; // название этажа
    private int numberFloor; //номер этажа

    public Floor(String floor,int numFlor){
        this.floor = floor;
        this.numberFloor = numFlor;
    }

    public String getFloor() {
        return floor;
    }
    public int getFloorIn() {
        return numberFloor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return floor;
    }
}
