package elevator;

public class Floor { // этаж
    private String floor; // название этажа
    private int numFlor = 1; //номер этажа

    public Floor(String floor,int numFlor){
        this.floor = floor;
        this.numFlor = numFlor;
    }

    public String getFloor() {
        return floor;
    }
    public int getFloorIn() {
        return numFlor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return floor;
    }
}
