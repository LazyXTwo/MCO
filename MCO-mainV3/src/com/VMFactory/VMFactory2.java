package com.VMFactory;

import java.util.Scanner;

import com.Machine.*;

import java.util.ArrayList;
import java.util.Arrays;

public class VMFactory2 {
    Scanner sc = new Scanner(System.in);

    /**
     * clears the console screen.
     */
    private void flush() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * waits for the user to send an "Enter" key.
     */
    private void next() {
        sc.nextLine();
    }

    /**
     * prints a menu using the given array for its contents
     * 
     * @param arrMenu an array of strings used for menu creation
     */
    private static void print(ArrayList<String> arrMenu) {
        for (int i = 0; i < arrMenu.size(); i++)
            System.out.println(" [" + ++i + "] " + arrMenu.get(--i));
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int nChoice_MainMenu, nChoice_MachineType, nChoice_VMType, nRemove_Item, nChoice_MachineFeature,
                nChoice_MaintenanceFeature, nChoice_Stocking,
                nChoice_ItemSelection, nAnswer1, nAnswer2;
        boolean bChoice_MachineType = false, bChoice_MachineTypeS = false;
        RVMachine regVendingMachine = new RVMachine();
        SVMachine spcVendingMachine = new SVMachine();
        String strAnswer;
        double dAnswer;
        VMFactory2 factory = new VMFactory2();
        do {
            factory.flush();
            System.out.println(">> Vending Machine Factory");
            VMFactory2.print(
                    new ArrayList<String>(Arrays.asList("Create Vending Machine", "Test Vending Machine", "Exit")));
            System.out.print("\nEnter choice : ");
            nChoice_MainMenu = sc.nextInt();
            switch (nChoice_MainMenu) {
                case 1:
                    do {
                        factory.flush();
                        System.out.println(
                                ">> Vending Machine Creation Menu\n Please select the type of vending machine to create.");
                        VMFactory2.print(new ArrayList<String>(Arrays.asList("Regular Vending Machine",
                                "Special Vending Machine", "Return to Main Menu")));
                        System.out.print("\nEnter choice : ");
                        nChoice_MachineType = sc.nextInt();
                        switch (nChoice_MachineType) {
                            case 1:
                                regVendingMachine = new RVMachine();
                                bChoice_MachineType = true;
                                factory.flush();
                                System.out.print(
                                        "SUCCESS : A new regular vending machine instance has been created.\n\nPress enter to continue.");
                                factory.next();
                                break;
                            case 2:
                                spcVendingMachine = new SVMachine();
                                bChoice_MachineTypeS = true;
                                factory.flush();
                                System.out.print(
                                        "SUCCESS : A new special vending machine instance has been created. \n\n press enter to continue");
                                factory.next();
                                break;
                            case 3:
                                break;
                            default:
                                factory.flush();
                                System.out
                                        .print("ERROR : Invalid choice. Please try again.\n\nPress enter to continue.");
                                factory.next();
                                break;
                        }
                    } while (nChoice_MachineType != 3
                            && (bChoice_MachineType == false || bChoice_MachineTypeS == false));
                    break;
                case 2:
                    do {
                        factory.flush();
                        System.out.print(
                                ">> Select vending machine type for testing\n");
                        VMFactory2.print(new ArrayList<String>(Arrays.asList("Regular Vending Machine",
                                "Special Vending Machine", "Return to Main Menu")));
                        nChoice_VMType = sc.nextInt();
                        switch (nChoice_VMType) {
                            case 1:
                                System.out.print(
                                        ">>Selected Regular Vending Machine");
                                if (bChoice_MachineType == false) {
                                    factory.flush();
                                    System.out.print(
                                            "ERROR : An exsisting Regular vending machine instance is required to use this feature. \n\n PRess enter to continue");
                                    factory.next();
                                } else {
                                    do {
                                        factory.flush();
                                        System.out.println(
                                                ">> Feature Testing Menu\n Please select the machine feature to test.");
                                        VMFactory2.print(new ArrayList<String>(Arrays.asList("Vending Features",
                                                "Maintenance Features", "Return to Main Menu")));
                                        System.out.print("\nEnter choice : ");
                                        nChoice_MachineFeature = sc.nextInt();
                                        switch (nChoice_MachineFeature) {
                                            case 1:
                                                if (regVendingMachine.getItemListSize() < 8
                                                        || regVendingMachine.getItemListSize() > 26) {
                                                    factory.flush();
                                                    if (regVendingMachine.getItemListSize() < 8) {
                                                        System.out.print(
                                                                "ERROR : At least eight (8) unique items must be supplied into the Vending Machine to access this feature.\nCurrently, the Vending Machine is supplied with ("
                                                                        + regVendingMachine.getItemListSize()
                                                                        + ") unique items.\n\nPress enter to continue.");
                                                    } else if (regVendingMachine.getItemListSize() > 26) {
                                                        System.out.print(
                                                                "ERROR : More than twenty (25) unique items have been supplied into the Vending Machine.\nCurrently, the Vending Machine is supplied with ("
                                                                        + regVendingMachine.getItemListSize()
                                                                        + ") unique items.\n\nSelect which to be removed Press enter to continue.");
                                                        regVendingMachine.removeLast(24);
                                                    }
                                                    factory.next();
                                                } else {
                                                    factory.flush();
                                                    System.out.println("Please select an item to purchase.\n");
                                                    for (int i = 0; i < regVendingMachine.getItemListSize(); i++)
                                                        System.out.println("[" + ++i + "]\tItem Name : "
                                                                + regVendingMachine.getItemName(--i) + "\tPrice : "
                                                                + regVendingMachine.getItemPrice(i)
                                                                + "\tCaloric Value : "
                                                                + regVendingMachine.getItemCaloricValue(i)
                                                                + "\tQuantity : "
                                                                + regVendingMachine.getItemQuantity(i));
                                                    System.out.print("\n\nEnter item index : ");
                                                    nChoice_ItemSelection = sc.nextInt() - 1;
                                                    if (nChoice_ItemSelection < 0 || regVendingMachine
                                                            .getItemListSize() <= nChoice_ItemSelection) {
                                                        do {
                                                            factory.flush();
                                                            System.out.println(
                                                                    "ERROR : Selected index is out of bounds. Please try again.\n");
                                                            for (int i = 0; i < regVendingMachine
                                                                    .getItemListSize(); i++)
                                                                System.out
                                                                        .println("[" + ++i + "]\tItem Name : "
                                                                                + regVendingMachine.getItemName(--i)
                                                                                + "\tPrice : "
                                                                                + regVendingMachine.getItemPrice(i)
                                                                                + "\tCaloric Value : "
                                                                                + regVendingMachine.getItemCaloricValue(
                                                                                        i)
                                                                                + "\tQuantity : "
                                                                                + regVendingMachine.getItemQuantity(i));
                                                            System.out.print("\n\nEnter item index : ");
                                                            nChoice_ItemSelection = sc.nextInt() - 1;
                                                        } while (nChoice_ItemSelection < 0 || regVendingMachine
                                                                .getItemListSize() <= nChoice_ItemSelection);
                                                    }
                                                    do {
                                                        factory.flush();
                                                        System.out.println("Current Balance : "
                                                                + regVendingMachine.getPaymentBalance() + "\n");
                                                        for (int i = 0; i < regVendingMachine.getChangeFundSize(); i++)
                                                            System.out.println("[" + ++i + "]" + "   Amount : "
                                                                    + regVendingMachine.getChangeFundAmount(--i)
                                                                    + "\tCount : "
                                                                    + regVendingMachine.getPaymentCount(i));
                                                        System.out.print(
                                                                "\nPlease select an amount to deposit.\n\nEnter denomination index : ");
                                                        nAnswer1 = sc.nextInt() - 1;
                                                        if (nAnswer1 < 0
                                                                || regVendingMachine.getChangeFundSize() <= nAnswer1) {
                                                            do {
                                                                factory.flush();
                                                                System.out.println(
                                                                        "ERROR : Selected index is out of bounds. Please try again.\n");
                                                                for (int i = 0; i < regVendingMachine
                                                                        .getChangeFundSize(); i++)
                                                                    System.out
                                                                            .println("[" + ++i + "]" + "   Amount : "
                                                                                    + regVendingMachine
                                                                                            .getChangeFundAmount(
                                                                                                    --i)
                                                                                    + "\tCount : "
                                                                                    + regVendingMachine
                                                                                            .getPaymentCount(i));
                                                                System.out.print("\nEnter denomination index : ");
                                                                nAnswer1 = sc.nextInt() - 1;
                                                            } while (nAnswer1 < 0
                                                                    || regVendingMachine
                                                                            .getChangeFundSize() <= nAnswer1);
                                                        }
                                                        factory.flush();
                                                        System.out.print(
                                                                "Enter the number of denominations to deposit : ");
                                                        nAnswer2 = sc.nextInt();
                                                        if (nAnswer2 < 0) {
                                                            factory.flush();
                                                            System.out.print(
                                                                    "ERROR : Invalid number of denominations.\n\nEnter the number of denominations to deposit : ");
                                                            nAnswer2 = sc.nextInt();
                                                        }
                                                        regVendingMachine.receivePayment(nAnswer1, nAnswer2, false);
                                                    } while (regVendingMachine.getPaymentBalance() < regVendingMachine
                                                            .getItemPrice(nChoice_ItemSelection));
                                                    if (regVendingMachine.checkChangeFund(
                                                            regVendingMachine.getPaymentBalance() - regVendingMachine
                                                                    .getItemPrice(nChoice_ItemSelection)) == true) {
                                                        factory.flush();
                                                        regVendingMachine.finalizePayment();
                                                        regVendingMachine.dispenseItem(nChoice_ItemSelection);
                                                        System.out.print(regVendingMachine
                                                                .getItemName(nChoice_ItemSelection)
                                                                + " has been purchased successfully.\nA change of "
                                                                + regVendingMachine.getChange()
                                                                + " has been returned to you.\n\nPress enter to continue.");
                                                        factory.next();
                                                    } else {
                                                        factory.flush();
                                                        System.out.print(
                                                                "ERROR : Insufficient funds. Unable to produce a change.\n"
                                                                        + regVendingMachine.getPaymentBalance()
                                                                        + " has been returned to you.\n\nPress enter to continue.");
                                                        regVendingMachine.initPaymentBalance();
                                                        factory.next();
                                                    }
                                                }
                                                break;
                                            case 2:
                                                do {
                                                    factory.flush();
                                                    System.out.println(
                                                            ">> Maintenance Feature Testing Menu\n Please select the maintenance feature to execute.");
                                                    VMFactory2.print(new ArrayList<String>(Arrays.asList(
                                                            "List All Existing Items", "Stock/Restock Items",
                                                            "Collect Payment", "View Change Fund Inventory",
                                                            "Replenish Change Fund Inventory",
                                                            "Print a Summary of Transactions", "Return to Main Menu")));
                                                    System.out.print("\nEnter choice : ");
                                                    nChoice_MaintenanceFeature = sc.nextInt();
                                                    switch (nChoice_MaintenanceFeature) {
                                                        case 1:
                                                            factory.flush();
                                                            System.out.println(">> Item Inventory");
                                                            for (int i = 0; i < regVendingMachine
                                                                    .getItemListSize(); i++)
                                                                System.out
                                                                        .println("[" + ++i + "]\tItem Name : "
                                                                                + regVendingMachine.getItemName(--i)
                                                                                + "\tPrice : "
                                                                                + regVendingMachine.getItemPrice(i)
                                                                                + "\tCaloric Value : "
                                                                                + regVendingMachine.getItemCaloricValue(
                                                                                        i)
                                                                                + "\tQuantity : "
                                                                                + regVendingMachine.getItemQuantity(i));
                                                            System.out.print(
                                                                    "--end of list--\n\nPress enter to continue.");
                                                            factory.next();
                                                            break;
                                                        case 2:
                                                            do {
                                                                factory.flush();
                                                                System.out.println(">> Item Stocking/Restocking Menu");
                                                                VMFactory2.print(new ArrayList<String>(Arrays.asList(
                                                                        "Stock a New Item", "Restock an Existing Item",
                                                                        "List All Existing Items",
                                                                        "Finish Stocking/Restocking Process")));
                                                                System.out.print("\nEnter choice : ");
                                                                nChoice_Stocking = sc.nextInt();
                                                                switch (nChoice_Stocking) {
                                                                    case 1:
                                                                        factory.flush();
                                                                        System.out.print("Enter item name : ");
                                                                        sc.nextLine();
                                                                        strAnswer = sc.nextLine();
                                                                        System.out.print("Enter item price : ");
                                                                        dAnswer = sc.nextDouble();
                                                                        System.out.print("Enter item caloric value : ");
                                                                        nAnswer1 = sc.nextInt();
                                                                        System.out.print("Enter item quantity : ");
                                                                        nAnswer2 = sc.nextInt();
                                                                        if (nAnswer2 < 10)
                                                                            do {
                                                                                factory.flush();
                                                                                System.out.print("Enter item name : "
                                                                                        + strAnswer
                                                                                        + "\nEnter item price : "
                                                                                        + dAnswer
                                                                                        + "\nEnter item caloric value : "
                                                                                        + nAnswer1
                                                                                        + "\n\nERROR: Stocking of items require a quantity of at least 10.\nEnter item quantity : ");
                                                                                nAnswer2 = sc.nextInt();
                                                                            } while (nAnswer2 < 10);
                                                                        if (regVendingMachine.stockItem(strAnswer,
                                                                                dAnswer, nAnswer1, nAnswer2) == true) {
                                                                            factory.flush();
                                                                            System.out.print(
                                                                                    "SUCCESS : Item registered.\n\nPress enter to continue.");
                                                                            factory.next();
                                                                        } else {
                                                                            factory.flush();
                                                                            System.out.print(
                                                                                    "ERROR : There is already an existing item registered under the same name.\nStocking failed. Press enter to continue.");
                                                                            factory.next();
                                                                        }
                                                                        break;
                                                                    case 2:
                                                                        if (regVendingMachine.getItemListSize() == 0) {
                                                                            factory.flush();
                                                                            System.out.print(
                                                                                    "ERROR : There are no items to restock.\n\nPress enter to continue.");
                                                                            factory.next();
                                                                        } else {
                                                                            factory.flush();
                                                                            for (int i = 0; i < regVendingMachine
                                                                                    .getItemListSize(); i++)
                                                                                System.out.println("[" + ++i
                                                                                        + "]\tItem Name : "
                                                                                        + regVendingMachine
                                                                                                .getItemName(--i)
                                                                                        + "\tPrice : "
                                                                                        + regVendingMachine
                                                                                                .getItemPrice(i)
                                                                                        + "\tCaloric Value : "
                                                                                        + regVendingMachine
                                                                                                .getItemCaloricValue(i)
                                                                                        + "\tQuantity : "
                                                                                        + regVendingMachine
                                                                                                .getItemQuantity(i));
                                                                            System.out.print("\n\nEnter item index : ");
                                                                            nAnswer1 = sc.nextInt() - 1;
                                                                            if (nAnswer1 < 0 || regVendingMachine
                                                                                    .getItemListSize() <= nAnswer1)
                                                                                do {
                                                                                    factory.flush();
                                                                                    System.out.println(
                                                                                            "ERROR : Selected index is out of bounds. Please try again.\n\n");
                                                                                    for (int i = 0; i < regVendingMachine
                                                                                            .getItemListSize(); i++)
                                                                                        System.out.println("[" + ++i
                                                                                                + "]\tItem Name : "
                                                                                                + regVendingMachine
                                                                                                        .getItemName(
                                                                                                                --i)
                                                                                                + "\tPrice : "
                                                                                                + regVendingMachine
                                                                                                        .getItemPrice(i)
                                                                                                + "\tCaloric Value : "
                                                                                                + regVendingMachine
                                                                                                        .getItemCaloricValue(
                                                                                                                i)
                                                                                                + "\tQuantity : "
                                                                                                + regVendingMachine
                                                                                                        .getItemQuantity(
                                                                                                                i));
                                                                                    System.out.print(
                                                                                            "\n\nEnter item index : ");
                                                                                    nAnswer1 = sc.nextInt() - 1;
                                                                                } while (nAnswer1 < 0
                                                                                        || regVendingMachine
                                                                                                .getItemListSize() <= nAnswer1);
                                                                            factory.flush();
                                                                            System.out.print("Enter item quantity : ");
                                                                            nAnswer2 = sc.nextInt();
                                                                            if (nAnswer2 + regVendingMachine
                                                                                    .getItemQuantity(nAnswer1) < 10)
                                                                                do {
                                                                                    factory.flush();
                                                                                    System.out.print(
                                                                                            "ERROR : Retocking of items require a total quantity of at least 10.\n\nEnter item quantity : ");
                                                                                    nAnswer2 = sc.nextInt();
                                                                                } while (nAnswer2 + regVendingMachine
                                                                                        .getItemQuantity(
                                                                                                nAnswer1) < 10);
                                                                            if (regVendingMachine.restockItem(nAnswer1,
                                                                                    nAnswer2) == true) {
                                                                                factory.flush();
                                                                                System.out.print(
                                                                                        "SUCCESS : Item restocked.\n\nPress enter to continue.");
                                                                                factory.next();
                                                                            } else {
                                                                                factory.flush();
                                                                                System.out.print(
                                                                                        "ERROR : Item quantity is invalid.\nItem restock failed. Press enter to continue.");
                                                                                factory.next();
                                                                            }
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        factory.flush();
                                                                        System.out.println(">> Item Inventory");
                                                                        for (int i = 0; i < regVendingMachine
                                                                                .getItemListSize(); i++)
                                                                            System.out.println("[" + ++i
                                                                                    + "]\tItem Name : "
                                                                                    + regVendingMachine.getItemName(--i)
                                                                                    + "\tPrice : "
                                                                                    + regVendingMachine.getItemPrice(i)
                                                                                    + "\tCaloric Value : "
                                                                                    + regVendingMachine
                                                                                            .getItemCaloricValue(i)
                                                                                    + "\tQuantity : "
                                                                                    + regVendingMachine
                                                                                            .getItemQuantity(i));
                                                                        System.out.print(
                                                                                "--end of list--\n\nPress enter to continue.");
                                                                        factory.next();
                                                                        break;
                                                                    case 4:
                                                                        regVendingMachine.initStartingInventory();
                                                                        break;
                                                                    default:
                                                                        factory.flush();
                                                                        System.out.print(
                                                                                "ERROR : Invalid choice. Please try again.\n\nPress enter to continue.");
                                                                        factory.next();
                                                                        break;
                                                                }
                                                            } while (nChoice_Stocking != 4);
                                                            break;
                                                        case 3:
                                                            factory.flush();
                                                            System.out.print("SUCCESS : "
                                                                    + regVendingMachine.collectMoney()
                                                                    + " has been collected from the current Vending Machine.\n\nPress enter to continue.");
                                                            factory.next();
                                                            break;
                                                        case 4:
                                                            factory.flush();
                                                            System.out.println(">> Change Fund Inventory");
                                                            for (int i = 0; i < regVendingMachine
                                                                    .getChangeFundSize(); i++)
                                                                System.out.println("[" + ++i + "]" + "   Amount : "
                                                                        + regVendingMachine.getChangeFundAmount(--i)
                                                                        + "\tRemaining Count : "
                                                                        + regVendingMachine.getChangeFundCount(i));
                                                            System.out.print(
                                                                    "--end of list--\n\nPress enter to continue.");
                                                            factory.next();
                                                            break;
                                                        case 5:
                                                            factory.flush();
                                                            for (int i = 0; i < regVendingMachine
                                                                    .getChangeFundSize(); i++)
                                                                System.out.println("[" + ++i + "]" + "   Amount : "
                                                                        + regVendingMachine.getChangeFundAmount(--i)
                                                                        + "\tRemaining Count : "
                                                                        + regVendingMachine.getChangeFundCount(i));
                                                            System.out.print("\n\nEnter denomination index : ");
                                                            nAnswer1 = sc.nextInt() - 1;
                                                            if (nAnswer1 < 0 || regVendingMachine
                                                                    .getChangeFundSize() <= nAnswer1)
                                                                do {
                                                                    factory.flush();
                                                                    System.out.println(
                                                                            "ERROR : Selected index is out of bounds. Please try again.\n\n");
                                                                    for (int i = 0; i < regVendingMachine
                                                                            .getChangeFundSize(); i++)
                                                                        System.out.println("[" + ++i + "]"
                                                                                + "   Amount : "
                                                                                + regVendingMachine.getChangeFundAmount(
                                                                                        --i)
                                                                                + "\tRemaining Count : "
                                                                                + regVendingMachine
                                                                                        .getChangeFundCount(i));
                                                                    System.out.print("\n\nEnter denomination index : ");
                                                                    nAnswer1 = sc.nextInt() - 1;
                                                                } while (nAnswer1 < 0 || regVendingMachine
                                                                        .getChangeFundSize() <= nAnswer1);
                                                            System.out.print(
                                                                    "Enter the number of denominations to replenish : ");
                                                            nAnswer2 = sc.nextInt();
                                                            if (regVendingMachine.replenishMoney(nAnswer1,
                                                                    nAnswer2) == true) {
                                                                factory.flush();
                                                                System.out.print(
                                                                        "SUCCESS : Selected denomination replenished.\n\nPress enter to continue.");
                                                                factory.next();
                                                            } else {
                                                                factory.flush();
                                                                System.out.print(
                                                                        "ERROR : Denomination quantity is invalid.\nDenomination count restock failed. Press enter to continue.");
                                                                factory.next();
                                                            }
                                                            break;
                                                        case 6:
                                                            factory.flush();
                                                            System.out.println(
                                                                    ">> Transaction Summary since Last Restock");
                                                            for (int i = 0; i < regVendingMachine
                                                                    .getItemListSize(); i++)
                                                                System.out.println("Item Name : "
                                                                        + regVendingMachine.getItemName(i)
                                                                        + "\tPrice : "
                                                                        + regVendingMachine.getItemPrice(i)
                                                                        + "\tOriginal Quantity since Last Restock : "
                                                                        + regVendingMachine
                                                                                .getTransactionSummaryQuantity(i)
                                                                        + "\tCurrent Quantity : "
                                                                        + regVendingMachine.getItemQuantity(i));
                                                            System.out.print(
                                                                    "--end of list--\n\nPress enter to continue.");
                                                            factory.next();
                                                            break;
                                                        case 7:
                                                            break;
                                                        default:
                                                            factory.flush();
                                                            System.out.print(
                                                                    "ERROR : Invalid choice. Please try again.\n\nPress enter to continue.");
                                                            factory.next();
                                                            break;
                                                    }
                                                } while (nChoice_MaintenanceFeature != 7);
                                                break;
                                            case 3:
                                                factory.flush();
                                                System.out.println("Ending Maintinance");
                                                factory.next();
                                                break;

                                            default:
                                                factory.flush();
                                                System.out.print(
                                                        "ERROR : Invalid choice. Please try again.\n\nPress enter to continue.");
                                                factory.next();
                                        }
                                    } while (nChoice_VMType != 3);
                                }
                            case 2:
                                System.out.print(
                                        ">>Selected Special Vending Machine");
                                if (bChoice_MachineTypeS == false) {
                                    factory.flush();
                                    System.out.print(
                                            "ERROR : An exsisting Special vending machine instance is required to use this feature. \n\n PRess enter to continue");
                                    factory.next();
                                } else {
                                    factory.next();
                                }

                            case 3:
                                factory.flush();
                                System.out.println("Ending Maintinance..");
                                break;
                        }
                        factory.next();
                        break;
                    } while (nChoice_VMType != 3);
                case 3:
                    factory.flush();
                    System.out.println("Terminating program..");
                    break;
                default:
                    factory.flush();
                    System.out.print("ERROR : Invalid choice. Please try again.\n\nPress enter to continue.");
                    factory.next();
            }
        } while (nChoice_MainMenu != 3);
        sc.close();
    }
}
