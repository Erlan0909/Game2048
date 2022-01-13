import Model.GameFild;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller();
        controller.doAction(Direction.MOVE_UP);
        controller.doAction(Direction.PRINT);

        System.out.println();

        controller.doAction(Direction.MOVE_LEFT);
        controller.doAction(Direction.PRINT);


    }

}
