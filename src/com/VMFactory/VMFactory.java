package com.VMFactory;

import com.RVMachine.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class VMFactory {
    Scanner sc = new Scanner(System.in);

    private void flush () {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void next () {
        sc.nextLine();
    }

    private static void print (ArrayList<String> strArray) {
        for (int i = 0 ; i < strArray.size() ; i++)
            System.out.println(" [" + ++i + "] " + strArray.get(--i));
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int nChoice_MainMenu, nChoice_MachineType, nChoice_MachineFeature, nChoice_MaintenanceFeature, nChoice_Stocking, nChoice_ItemSelection, nAnswer1, nAnswer2;
        boolean bChoice_MachineType = false;
        RVMachine regVendingMachine = new RVMachine();
        String strAnswer;
        double dAnswer;

        VMFactory factory = new VMFactory();

        do {
            factory.flush();
            System.out.println("Vending Machine Factory");
            VMFactory.print(new ArrayList<String>(Arrays.asList("Create Vending Machine","Test Vending Machine","Exit")));
            System.out.print("Enter choice : ");
            nChoice_MainMenu = sc.nextInt();

            switch (nChoice_MainMenu) {
                case 1:
                    do {
                        factory.flush();
                        System.out.println("Please select the type of vending machine to create.");
                        VMFactory.print(new ArrayList<String>(Arrays.asList("Regular Vending Machine","Special Vending Machine","Return to Main Menu")));
                        System.out.print("Enter choice : ");
                        nChoice_MachineType = sc.nextInt();

                        switch (nChoice_MachineType) {
                            case 1:
                                regVendingMachine = new RVMachine();
                                bChoice_MachineType = true;
                                factory.flush();
                                System.out.print("A new regular vending machine instance has been created.\n\nPress enter to continue.");
                                factory.next();
                                break;
                            case 2:
                                factory.flush();
                                System.out.print("This feature is currently not yet implemented.\n\nPress enter to continue.");
                                factory.next();
                                break;
                            case 3:
                                break;
                            default:
                                factory.flush();
                                System.out.print("Invalid choice. Please try again.\n\nPress enter to continue.");
                                factory.next();
                                break;
                        }
                    } while (nChoice_MachineType != 3 && bChoice_MachineType == false);
                    break;
                case 2:
                    if (bChoice_MachineType == false) {
                                factory.flush();
                                System.out.print("Please create a new vending machine instance to use this feature.\n\nPress enter to continue.");
                                factory.next();
                    }
                    else {
                        do {
                            factory.flush();
                            System.out.println("Please select the machine feature to test.");
                            VMFactory.print(new ArrayList<String>(Arrays.asList("Vending Features","Maintenance Features","Return to Main Menu")));
                            System.out.print("Enter choice : ");
                            nChoice_MachineFeature = sc.nextInt();

                            switch (nChoice_MachineFeature) {
                                case 1:
                                    if (regVendingMachine.getItemListSize() < 8) {
                                        factory.flush();
                                        System.out.print("The Vending Machine must be supplied with at least 8 unique items to access this feature.\nCurrently, the Vending Machine is supplied with " + regVendingMachine.getItemListSize() + " unique items.\n\nPress enter to continue.");
                                        factory.next();
                                    }
                                    else {
                                        factory.flush();
                                        System.out.println("Please select an item to purchase.\n");
                                        regVendingMachine.printItemList();
                                        System.out.print("\n\nEnter item index : ");
                                        nChoice_ItemSelection = sc.nextInt()-1;
                                        if (nChoice_ItemSelection < 0 || regVendingMachine.getItemListSize() <= nChoice_ItemSelection) {
                                            do {
                                                factory.flush();
                                                System.out.println("ERROR: Selected index is out of bounds. Please try again.\n");
                                                regVendingMachine.printItemList();
                                                System.out.print("\n\nEnter item index : ");
                                                nChoice_ItemSelection = sc.nextInt()-1;
                                            } while (nChoice_ItemSelection < 0 || regVendingMachine.getItemListSize() <= nChoice_ItemSelection);
                                        }
                                        do {
                                            factory.flush();
                                            System.out.println("Current Balance : " + regVendingMachine.getPaymentBalance() + "\n");
                                            regVendingMachine.printPayment();
                                            System.out.print("\nPlease select an amount to deposit.\n\nEnter denomination index : ");
                                            nAnswer1 = sc.nextInt()-1;
                                            if (nAnswer1 < 0 || regVendingMachine.getChangeFundSize() <= nAnswer1) {
                                                do {
                                                    factory.flush();
                                                    System.out.println("ERROR: Selected index is out of bounds. Please try again.\n");
                                                    regVendingMachine.printPayment();
                                                    System.out.print("\nEnter denomination index : ");
                                                    nAnswer1 = sc.nextInt()-1;
                                                } while (nAnswer1 < 0 || regVendingMachine.getChangeFundSize() <= nAnswer1);
                                            }
                                            factory.flush();
                                            System.out.print("Enter the number of denominations to deposit : ");
                                            nAnswer2 = sc.nextInt();
                                            if (nAnswer2 < 0) {
                                                factory.flush();
                                                System.out.print("ERROR: Invalid number of denominations.\n\nEnter the number of denominations to deposit : ");
                                                nAnswer2 = sc.nextInt();
                                            }
                                            regVendingMachine.receivePayment(nAnswer1, nAnswer2, false);
                                        } while (regVendingMachine.getPaymentBalance() < regVendingMachine.getItemPrice(nChoice_ItemSelection));
                                        if (regVendingMachine.calculateChange(regVendingMachine.getPaymentBalance()-regVendingMachine.getItemPrice(nChoice_ItemSelection)) == true) {
                                            factory.flush();
                                            regVendingMachine.finalizePayment();
                                            regVendingMachine.dispenseItem(nChoice_ItemSelection);
                                            System.out.print(regVendingMachine.getItemName(nChoice_ItemSelection) + " has been purchased successfully.\nA change of " + regVendingMachine.getChange() + " has been returned to you.\n\nPress enter to continue.");
                                            factory.next();
                                        }
                                        else {
                                            factory.flush();
                                            System.out.print("The Vending Machine does not have enough funds to produce a change. The item cannot be dispensed.\n" + regVendingMachine.getPaymentBalance() + " has been returned to you.\n\nPress enter to continue.");
                                            regVendingMachine.initPaymentBalance();
                                            factory.next();
                                        }
                                    }
                                    break;
                                case 2:
                                    do {
                                        factory.flush();
                                        System.out.println("Please select the maintenance feature to execute.");
                                        VMFactory.print(new ArrayList<String>(Arrays.asList("List All Existing Items","Stock/Restock Items","Collect Payment","View Change Fund Inventory","Replenish Change Fund Inventory","Print a Summary of Transactions","Return to Main Menu")));
                                        System.out.print("Enter choice : ");
                                        nChoice_MaintenanceFeature = sc.nextInt();

                                        switch (nChoice_MaintenanceFeature) {
                                            case 1:
                                                factory.flush();
                                                regVendingMachine.printItemList();
                                                System.out.print("--end of list--\n\nPress enter to continue.");
                                                factory.next();
                                                break;
                                            case 2:
                                                do {
                                                    factory.flush();
                                                    VMFactory.print(new ArrayList<String>(Arrays.asList("Stock a New Item","Restock an Existing Item","List All Existing Items","Finish Stocking/Restocking Process")));
                                                    System.out.print("Enter choice : ");
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
                                                            if (nAnswer2 < 10) {
                                                            do {
                                                                factory.flush();
                                                                System.out.print("Enter item name : " + strAnswer + "\nEnter item price : " + dAnswer + "\nEnter item caloric value : " + nAnswer1 + "\n\nERROR: Stocking of items require a quantity of at least 10.\nEnter item quantity : ");
                                                                nAnswer2 = sc.nextInt();
                                                            } while (nAnswer2 < 10);
                                                            }
                                                            if (regVendingMachine.stockItem(strAnswer, dAnswer, nAnswer1, nAnswer2) == true) {
                                                                factory.flush();
                                                                System.out.print("Product added successfully.\n\nPress enter to continue.");
                                                                factory.next();
                                                            }
                                                            else {
                                                                factory.flush();
                                                                System.out.print("There is already an existing product registered under the same name.\nProduct addition failed. Press enter to continue.");
                                                                factory.next();
                                                            }
                                                            break;
                                                        case 2:
                                                            if (regVendingMachine.getItemListSize() == 0) {
                                                                factory.flush();
                                                                System.out.print("There are no items to restock.\n\nPress enter to continue.");
                                                                factory.next();
                                                            }
                                                            else {
                                                                factory.flush();
                                                                regVendingMachine.printItemList();
                                                                System.out.print("\n\nEnter item index : ");
                                                                nAnswer1 = sc.nextInt()-1;
                                                                if (nAnswer1 < 0 || regVendingMachine.getItemListSize() <= nAnswer1) {
                                                                    do {
                                                                        factory.flush();
                                                                        System.out.println("ERROR: Selected index is out of bounds. Please try again.\n\n");
                                                                        regVendingMachine.printItemList();
                                                                        System.out.print("\n\nEnter item index : ");
                                                                        nAnswer1 = sc.nextInt()-1;
                                                                    } while (nAnswer1 < 0 || regVendingMachine.getItemListSize() <= nAnswer1);
                                                                }
                                                                factory.flush();
                                                                System.out.print("Enter item quantity : ");
                                                                nAnswer2 = sc.nextInt();
                                                                if (nAnswer2+regVendingMachine.getItemQuantity(nAnswer1) < 10) {
                                                                    do {
                                                                        factory.flush();
                                                                        System.out.print("ERROR: Retocking of items require a total quantity of at least 10.\n\nEnter item quantity : ");
                                                                        nAnswer2 = sc.nextInt();
                                                                    } while (nAnswer2+regVendingMachine.getItemQuantity(nAnswer1) < 10);
                                                                }
                                                                if (regVendingMachine.restockItem(nAnswer1, nAnswer2) == true) {
                                                                    factory.flush();
                                                                    System.out.print("Item restocked successfully.\n\nPress enter to continue.");
                                                                    factory.next();
                                                                }
                                                                else {
                                                                    factory.flush();
                                                                    System.out.print("Item quantity is invalid.\nItem restock failed. Press enter to continue.");
                                                                    factory.next();
                                                                }
                                                            }
                                                            break;
                                                        case 3:
                                                            factory.flush();
                                                            regVendingMachine.printItemList();
                                                            System.out.print("--end of list--\n\nPress enter to continue.");
                                                            factory.next();
                                                            break;
                                                        case 4:
                                                            regVendingMachine.initStartingInventory();
                                                            break;
                                                        default:
                                                            factory.flush();
                                                            System.out.print("Invalid choice. Please try again.\n\nPress enter to continue.");
                                                            factory.next();
                                                            break;
                                                    }
                                                } while (nChoice_Stocking!=4);
                                                break;
                                            case 3:
                                                factory.flush();
                                                System.out.print(regVendingMachine.collectMoney() + " has been collected from the current Vending Machine.\n\nPress enter to continue.");
                                                factory.next();
                                                break;
                                            case 4:
                                                factory.flush();
                                                regVendingMachine.printChangeFund();
                                                System.out.print("--end of list--\n\nPress enter to continue.");
                                                factory.next();
                                                break;
                                            case 5:
                                                factory.flush();
                                                regVendingMachine.printChangeFund();
                                                System.out.println("\n");
                                                System.out.print("Enter denomination index : ");
                                                nAnswer1 = sc.nextInt()-1;
                                                if (nAnswer1 < 0 || regVendingMachine.getChangeFundSize() <= nAnswer1) {
                                                    do {
                                                        factory.flush();
                                                        System.out.println("ERROR: Selected index is out of bounds. Please try again.\n\n");
                                                        regVendingMachine.printChangeFund();
                                                        System.out.print("\n\nEnter denomination index : ");
                                                        nAnswer1 = sc.nextInt()-1;
                                                    } while (nAnswer1 < 0 || regVendingMachine.getChangeFundSize() <= nAnswer1);
                                                }
                                                System.out.print("Enter the number of denominations to replenish : ");
                                                nAnswer2 = sc.nextInt();
                                                if (regVendingMachine.replenishMoney(nAnswer1, nAnswer2) == true) {
                                                    factory.flush();
                                                    System.out.print("Selected denomination replenished succesfully.\n\nPress enter to continue.");
                                                    factory.next();
                                                }
                                                else {
                                                    factory.flush();
                                                    System.out.print("Denomination quantity is invalid.\nDenomination count restock failed. Press enter to continue.");
                                                    factory.next();
                                                }
                                                break;
                                            case 6:
                                                factory.flush();
                                                regVendingMachine.printTransactionSummary();
                                                System.out.print("--end of list--\n\nPress enter to continue.");
                                                factory.next();
                                                break;
                                            case 7:
                                                break;
                                            default:
                                                factory.flush();
                                                System.out.print("Invalid choice. Please try again.\n\nPress enter to continue.");
                                                factory.next();
                                                break;
                                        }
                                    } while (nChoice_MaintenanceFeature != 7);
                                    break;
                                case 3:
                                    break;
                                default:
                                    factory.flush();
                                    System.out.print("Invalid choice. Please try again.\n\nPress enter to continue.");
                                    factory.next();
                                    break;
                            }
                        } while (nChoice_MachineFeature != 3);
                    }
                    break;
                case 3:
                    factory.flush();
                    System.out.println("Terminating program..");
                    break;
                default:
                    factory.flush();
                    System.out.print("Invalid choice. Please try again.\n\nPress enter to continue.");
                    factory.next();
            }
        } while (nChoice_MainMenu != 3);

        sc.close();
    }
}