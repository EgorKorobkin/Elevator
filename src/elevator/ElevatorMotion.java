package elevator;

import java.util.*;

public class ElevatorMotion { //движение лифта
    public LinkedList<Integer> elevatorCall = new LinkedList<>();
    public ArrayList<Floor> floorList = new ArrayList<>();//лист этажей
    public Elevator elevator = new Elevator("Жорик");//лифт

    public ElevatorMotion(){
        /*создаем этажи по заданию их 7*/
        Floor floor = new Floor("Первый этаж",1);
        floorList.add(floor);
        Floor floor2 = new Floor("Второй этаж",2);
        floorList.add(floor2);
        Floor floor3 = new Floor("Третий этаж",3);
        floorList.add(floor3);
        Floor floor4 = new Floor("Четвертый этаж",4);
        floorList.add(floor4);
        Floor floor5 = new Floor("Пятый этаж",5);
        floorList.add(floor5);
        Floor floor6 = new Floor("Шестой этаж",6);
        floorList.add(floor6);
        Floor floor7 = new Floor("Седьмой этаж",7);
        floorList.add(floor7);
    }

    public void motion(){
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("На какой этаж желаете приехать:");
            int floor = in.nextInt();

            if(floor > 0&&floor<=floorList.size()){
                motionElevator(elevator, floor-1);
            } else {
                System.out.println("Этажа под номером "+floor+" нету в нашем доме, наш дом состоит из 7 этажей :)");
            }

        }
    }

    public void motionElevator(Elevator e,int f){ // движение лифта
        Iterator<Floor> iterFlor = floorList.iterator();
        while (iterFlor.hasNext()){
            if(e.getFloor() == floorList.get(f).getFloorIn()){
                System.out.println("Лифт прибыл");
                motion();
            } else if(e.getFloor() < floorList.get(f).getFloorIn()){
                System.out.println( e.toString()+" на "+e.getFloor()+" этаже, Едем на "+(f+1)+" этаж");
                e.setUpFloor();
                motionElevator(e,f);
            } else if(e.getFloor()>floorList.get(f).getFloorIn()){
                System.out.println(e.toString()+" на "+e.getFloor()+" этаже, Едем на "+(f+1)+" этаж");
                e.setDownFloor();
                motionElevator(e,f);
            }
        }
    }
}
