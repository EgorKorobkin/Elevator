package elevator;

public class Elevator {
    private String nameElevator;
    private int floor = 1;// значение этажа на котором находться лифт
    private int upFlor = 7;// кол во этажей по которым ходит лифт

    public Elevator(String nameElevator){
        this.nameElevator = nameElevator;
    }

    public int getFloor() { // узнать где лифт
        return floor;
    }
    public void setUpFloor(){ // повысить этаж
        floor++;
    }
    public void setDownFloor(){ // понизить этаж
        floor--;
    }
    @Override
    public String toString() {
        return "Лифт "+ nameElevator;
    }
    /*на какой этаж надо приехать должен отвечать лифт,
    он хранит в себе информацию куда он едет а этажы это просто этажы они ничего не делают*/
}
