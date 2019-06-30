package elevator;
import java.util.*;

public class ElevatorMotion { //движение лифта
    private static final ArrayList<Floor> floorList = new ArrayList<>();//лист этажей
    private LinkedList<Integer> elevatorCall = new LinkedList<>();//очередь вызовов лифта
    private LinkedList<DoneLaunchElevator> elevators = new LinkedList<>();
    private DoneLaunchElevator doneLaunchElevator;

    private Elevator elevator ;//лифт

    public ElevatorMotion(String nameElevator){
        elevator = new Elevator(nameElevator);//создаем лифт
        doneLaunchElevator = new DoneLaunchElevator();//создаем логику прибытия лифта

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

    public void launch() {
        try{
            buttonElevator();
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
    public void buttonElevator() throws InterruptedException {
        boolean isTrue = true;
        while (true) {
            if (elevatorCall.peek()==null) {
                isTrue=true;
                Scanner in = new Scanner(System.in);
                System.out.println("На какой этаж желаете приехать(через пробел номера этажей)?:");
                String line = in.nextLine();
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
                if(isTrue){
                    LinkedList<Integer> linkedList = elevatorCall;
                    System.out.println(doneLaunchElevator.getStartEndElevator(linkedList));
                    isTrue=false;
                }
                if(elevatorCall.peek()!=null){//работа лифта
                    doneLaunchElevator.printLaunchElevator();
                    System.out.println("Посадка пассажиров !!!");
                    motionElevator(elevator,(elevatorCall.getFirst()-1));
                    elevatorCall.removeFirst();
                }
            }
        }
    }

    private void motionElevator(Elevator e,int f) throws InterruptedException{ // движение лифта
        Iterator<Floor> floorIterator = floorList.iterator();
        while (floorIterator.hasNext()){ // ходим по этажам
            if(e.getFloor() == floorList.get(f).getFloorIn()){
                System.out.format("Лифт %s на %s этаже !!!%n-------------------%n",e.getName(),e.getFloor());
                System.out.println("Высадка пассажиров !!!");
                Thread.sleep(e.getSleepStoplaunch());//небольшая остановка для высадки пассажиров
                elevators.add(doneLaunchElevator);
                doneLaunchElevator.printDoneElevator();
                break;
            } else if(e.getFloor() < floorList.get(f).getFloorIn()){
                System.out.format("Лифт %s на %s этаже, Едем на %d этаж%n",e.getName(),e.getFloor(),f+1);
                Thread.sleep(e.getSleepMotion());
                e.setUpFloor();
                motionElevator(e,f); // если это не его этаж едет дальше
            }
            else if(e.getFloor()>floorList.get(f).getFloorIn()){
                System.out.format("Лифт %s на %s этаже, Едем на %d этаж %n",e.getName(),e.getFloor(),f+1);
                Thread.sleep(e.getSleepMotion());
                e.setDownFloor();
                motionElevator(e,f); //если это не его этаж едет дальше
            }
            break;
        }
    }
}
/* узнать время вызова лифта подождать две секунды послать лифт на какой либо этаж лифт будет
знать во сколько и где он будет благодаря время вызова лифта + 10 секунд если время натикало то лифт приехал */