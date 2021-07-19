package budget;

import lombok.Data;
import lombok.extern.java.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static budget.MessageUtils.*;

@Log
@Data
public class MenuImpl implements Menu{
    private MenuAction menuAction = new MenuAction();

    public String printWelcomeMessage() {
        return WELCOME;
    }

    public void getAction(int action) {
        menuAction.chooseYourAction(action);
    }
}