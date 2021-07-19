package budget;

import lombok.Data;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static budget.MessageUtils.*;
@Log
@Data
public class MenuAction {
    private double balance = 0;
    private double expense = 0;
    private int index = 0;
    private List<String> purchaseList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    void chooseYourAction(int action) {
        switch (action) {
            case 1 -> addIncome();
            case 2 -> addPurchase();
            case 3 -> showList();
            case 4 -> balance();
            default -> {
                log.info(WELCOME);
                activationCode();
            }
        }
        MenuAction.log.info(WELCOME);
    }

    // case 1
    private void addIncome() {
        log.info(INCOME_MESSAGE);
        double addedIncome = sc.nextDouble();
        this.balance += addedIncome;
        log.info(INCOME_ADDED);
    }

    // case 2
    private void addPurchase() {
        String[] mes = new String[]{"\nEnter purchase name:", "Enter its price: "};
        Scanner local = new Scanner(System.in);
        for (int i = 0; true; i++) {
            System.out.println(mes[i]);
            String item = local.nextLine();
            if (i == 0) {
                purchaseList.add(item);
            }
            if (i == 1) {
                checkout(item);
                break;
            }
        }
    }

    // case 3
    private void showList() {
        if(!purchaseList.isEmpty()) {
            System.out.println();
            purchaseList.forEach(System.out::println);
            log.info("Total sum: $" + String.format("%.2f", this.expense)+"\n");
        }
        else {
            log.info(EMPTY_PURCHASE_LIST_WARNING);
        }
    }

    // case 4
    private void balance() {
        log.info("\nBalance: $" + String.format("%.2f", this.balance) + "\n");
    }

    private void activationCode() {
        log.info("\n" + WELCOME);
        chooseYourAction(sc.nextInt());
    }

    private void calculateBalances(double price) {
        this.balance-= price;
        this.expense += price;
        purchaseList.set(index, purchaseList.get(index) + " $" + String.format("%.2f", price));
        log.info(PURCHASE_ADDED);
        index++;
    }

    private void checkout(String item) {
        double price;
        price = Double.parseDouble(item);
        if (price <= this.balance) {
            calculateBalances(price);
        } else {
            log.info(INSUFFICIENT_BALANCE_WARNING);
        }
    }
}
