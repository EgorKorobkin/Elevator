package elevator;

import java.util.LinkedList;

public class Elevator {
    public LinkedList<DoneLaunchElevator> launchElevators = new LinkedList<>();
    private final String NAME_ELEVATOR;
    private final int sleepMotion = 10000; //время езды один этаж
    private final int sleepStoplaunch = 2000; //запуск
    private final int upFlor = 7;// кол во этажей по которым ходит лифт
    private final int firstFloor = 1;//первый этаж
    private int floor = 1;// значение этажа на котором находться лифтa
    private int seconds = 0;//секунды в пути



    public Elevator(String nameElevator){
        this.NAME_ELEVATOR = nameElevator;
    }

    public int getFloor() { // узнать где лифт
        return floor;
    }
    public void setUpFloor(){ // повысить этаж
        if(upFlor != floor){
            floor++;
        }
    }
    public void setDownFloor(){ // понизить этаж
        if(firstFloor != floor){
            floor--;
        }
    }
    public String getName(){
        return NAME_ELEVATOR;
    }

    public int getSleepMotion() {
        return sleepMotion;
    }

    public int getSleepStoplaunch() {
        return sleepStoplaunch;
    }
    public void elevatorReset(){
        seconds = 0;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds += seconds;
    }
    /*на какой этаж надо приехать должен отвечать лифт,
    он хранит в себе информацию куда он едет а этажы это просто этажы они ничего не делают*/
}
