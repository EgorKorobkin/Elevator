package elevator;

import java.util.*;

public class ElevatorMotion extends Thread { //движение лифта
    private static final ArrayList<Floor> floorList = new ArrayList<>();//лист этажей
    private LinkedList<Integer> elevatorCall = new LinkedList<>();//очередь вызовов лифта

    private Elevator elevator ;//лифт

    public ElevatorMotion(String nameElevator){
        elevator = new Elevator(nameElevator);
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

    @Override
    public void run() {
        try{
            buttonElevator();
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
    public void buttonElevator() throws InterruptedException {
        while (true) {
            if (elevatorCall.peek()==null) {
                Scanner in = new Scanner(System.in);
                System.out.println("На какой этаж желаете приехать:");
                String line = in.nextLine();
                Thread.sleep(elevator.getSleepStoplaunch());
                line = line.replaceAll("\\s+"," ");
                for (String s : line.split(" ")) {
                    Integer num = Integer.parseInt(s);
                    if (num > 0 && num <= floorList.size()) {
                        elevatorCall.add(num);
                    } else {
                        System.out.format("Этажа под номером %d нету в нашем доме, наш дом состоит из 7 этажей :)%n",num);
                    }
                }
            } else {
                motionElevator(elevator,(elevatorCall.getFirst()-1));
                elevatorCall.removeFirst();
            }
        }
    }

    private void motionElevator(Elevator e,int f) throws InterruptedException{ // движение лифта
        Iterator<Floor> floorIterator = floorList.iterator();
        while (floorIterator.hasNext()){ // ходим по этажам
            if(e.getFloor() == floorList.get(f).getFloorIn()){
                System.out.format("Лифт %s на %s этаже !!!%n-------------------%n",e.getName(),e.getFloor());
                break;
            } else if(e.getFloor() < floorList.get(f).getFloorIn()){
                System.out.format("Лифт %s на %s этаже, Едем на %d этаж%n",e.getName(),e.getFloor(),f+1);
                Thread.sleep(e.getSleepMotion());
                e.setUpFloor();
                motionElevator(e,f); // если это не его этаж едет дальше
            }
            else if(e.getFloor()>floorList.get(f).getFloorIn()){
                System.out.format("Лифт %s на %s этаже, Едем на %d этаж%n",e.getName(),e.getFloor(),f+1);
                Thread.sleep(e.getSleepMotion());
                e.setDownFloor();
                motionElevator(e,f); //если это не его этаж едет дальше
            }
            break;
        }
    }
}
