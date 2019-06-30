package elevator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class DoneLaunchElevator {
    private String launchElevator;//время вызова лифта
    private String doneElevator;//время приезда лифта
    private int floor = 1;

    public DoneLaunchElevator(){
    }
    public String getStartEndElevator(LinkedList<Integer> elevatorCall){ //будет принимать очередь вызовов
        int seconds = 0;

        for(int call : elevatorCall){
            if (call > floor) {
                seconds += 2;
                for (int i = floor; i < call; i++) {
                    if (call > floor) {
                        //ожидание 10 секунд
                        seconds += 10;
                        floor++;
                    }
                }
            } else if (call < floor) {
                seconds += 2;
                for (int i = floor; i > call; i--) {
                    if (call < floor) {
                        //ожидание 10 секунд
                        seconds += 10;
                        floor--;
                    }
                }
            } else if(floor == elevatorCall.getFirst()){
                seconds+=2;
            }
        }

        return convertSeconds(seconds);
    }
    public String convertSeconds(int seconds){

        int hour = seconds / 3600;
        int minute = (seconds - hour * 3600) / 60;
        int second = seconds - hour * 3600 - minute * 60;

        return String.format("Время ожидания лифта: hour: %d, minute: %d, second: %d", hour, minute, second);
    }
    private String setTime(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public void printLaunchElevator() {
        launchElevator = setTime();
        System.out.format("Начало работы лифта %s\n",launchElevator);
    }

    public void printDoneElevator() {
        doneElevator = setTime();
        System.out.format("Конец работы лифта %s\n",doneElevator);
    }
}
