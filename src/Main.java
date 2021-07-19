import budget.Menu;
import budget.MenuImpl;
import lombok.extern.java.Log;

import java.util.Scanner;
@Log
public class Main {
    public static void main(String[] args) {
        Menu menu = new MenuImpl();
        Scanner sc = new Scanner(System.in);

        log.info(menu.printWelcomeMessage());

        while (sc.hasNext()) {
            int action = sc.nextInt();
            if (action!=0) {
                menu.getAction(action);
            }
            else
            {
                System.out.println("\nBye!");
                break;
            }
        }
    }
}
