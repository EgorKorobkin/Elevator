package elevator;

public class Floor { // этаж
    private final String floor; // название этажа
    private final int numberFloor; //номер этажа

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

    @Override
    public String toString() {
        return floor;
    }
}
