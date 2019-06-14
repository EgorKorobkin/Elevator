package elevator;

public class RunElevator {
    public static void main(String[] args) {
        ElevatorMotion em = new ElevatorMotion();
        for(Floor f:em.floorList){
            System.out.println(f);
        }
        em.motion();
    }
}
