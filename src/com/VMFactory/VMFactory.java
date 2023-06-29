package com.VMFactory;

import com.RVMachine.*;

import java.util.Scanner;

public class VMFactory {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int nChoice_MainMenu, nChoice_MachineType, nChoice_MachineFeature, nChoice_MaintenanceFeature, nChoice_Stocking, nChoice_ItemSelection, nAnswer1, nAnswer2;
        boolean bChoice_MachineType = false;
        RVMachine regVendingMachine = new RVMachine();
        String strAnswer;
        double dAnswer;

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Vending Machine Factory");
            System.out.println(" [1] Create Vending Machine");
            System.out.println(" [2] Test Vending Machine");
            System.out.println(" [3] Exit");
            System.out.print("Enter choice : ");
            nChoice_MainMenu = sc.nextInt();

            switch (nChoice_MainMenu) {
                case 1:
                    do {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Please select the type of vending machine to create.");
                        System.out.println(" [1] Regular Vending Machine");
                        System.out.println(" [2] Special Vending Machine");
                        System.out.println(" [3] Return to Main Menu");
                        System.out.print("Enter choice : ");
                        nChoice_MachineType = sc.nextInt();

                        switch (nChoice_MachineType) {
                            case 1:
                                regVendingMachine = new RVMachine();
                                nChoice_MachineType = 3;
                                bChoice_MachineType = true;
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.print("A new regular vending machine instance has been created.\nPress enter to continue.");
                                sc.nextLine();
                                sc.nextLine();
                                break;
                            case 2:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.print("This feature is currently not yet implemented.\nPress enter to continue.");
                                sc.nextLine();
                                sc.nextLine();
                                break;
                            case 3:
                                break;
                            default:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.print("Invalid choice. Please try again.\nPress enter to continue.");
                                sc.nextLine();
                                sc.nextLine();
                                break;
                        }
                    } while (nChoice_MachineType != 3);
                    break;
                case 2:
                    if (bChoice_MachineType == false) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.print("Please create a new vending machine instance to use this feature.\nPress enter to continue.");
                                sc.nextLine();
                                sc.nextLine();
                    }
                    else {
                        do {
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            System.out.println("Please select the machine feature to test.");
                            System.out.println(" [1] Vending Features");
                            System.out.println(" [2] Maintenance Features");
                            System.out.println(" [3] Return to Main Menu");
                            System.out.print("Enter choice : ");
                            nChoice_MachineFeature = sc.nextInt();

                            switch (nChoice_MachineFeature) {
                                case 1:
                                    if (regVendingMachine.getItemListSize() < 8) {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();
                                        System.out.println("The Vending Machine must be supplied with at least 8 unique items.");
                                        System.out.println("Currently, the Vending Machine is supplied with " + regVendingMachine.getItemListSize() + " unique items.\n");
                                        System.out.print("Press enter to continue.");
                                        sc.nextLine();
                                        sc.nextLine();
                                    }
                                    else {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();
                                        regVendingMachine.printItemList();
                                        System.out.println("\n");
                                        System.out.println("Please select an item to purchase.");
                                        System.out.print("Enter item index : ");
                                        nChoice_ItemSelection = sc.nextInt();
                                        if (nChoice_ItemSelection < 0 || regVendingMachine.getItemListSize() <= nChoice_ItemSelection) {
                                            do {
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                System.out.println("ERROR: Selected index is out of bounds. Please try again.\n");
                                                regVendingMachine.printItemList();
                                                System.out.println("\n");
                                                System.out.print("Enter item index : ");
                                                nChoice_ItemSelection = sc.nextInt();
                                            } while (nChoice_ItemSelection < 0 || regVendingMachine.getItemListSize() <= nChoice_ItemSelection);
                                        }
                                        do {
                                            System.out.print("\033[H\033[2J");
                                            System.out.flush();
                                            regVendingMachine.printPayment();
                                            System.out.println("Current Balance : " + regVendingMachine.getPaymentBalance());
                                            System.out.println("\n");
                                            System.out.println("Please select an amount to deposit.");
                                            System.out.print("Enter denomination index : ");
                                            nAnswer1 = sc.nextInt();
                                            if (nAnswer1 < 0 || regVendingMachine.getChangeFundSize() <= nAnswer1) {
                                                do {
                                                    System.out.print("\033[H\033[2J");
                                                    System.out.flush();
                                                    System.out.println("ERROR: Selected index is out of bounds. Please try again.\n");
                                                    regVendingMachine.printPayment();
                                                    System.out.println("\n");
                                                    System.out.print("Enter denomination index : ");
                                                    nAnswer1 = sc.nextInt();
                                                } while (nAnswer1 < 0 || regVendingMachine.getChangeFundSize() <= nAnswer1);
                                            }
                                            System.out.print("\033[H\033[2J");
                                            System.out.flush();
                                            System.out.print("Enter the number of denominations to deposit : ");
                                            nAnswer2 = sc.nextInt();
                                            if (nAnswer2 < 0) {
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                System.out.println("ERROR: Invalid number of denominations.");
                                                System.out.print("Enter the number of denominations to deposit : ");
                                                nAnswer2 = sc.nextInt();
                                            }
                                            regVendingMachine.receivePayment(nAnswer1, nAnswer2, false);
                                        } while (regVendingMachine.getPaymentBalance() < regVendingMachine.getItemPrice(nChoice_ItemSelection));
                                        if (regVendingMachine.calculateChange(regVendingMachine.getPaymentBalance()) == true) {
                                            regVendingMachine.finalizePayment();
                                            regVendingMachine.dispenseItem(nChoice_ItemSelection);
                                            System.out.println(regVendingMachine.getItemName(nChoice_ItemSelection) + " has been purchased successfully.");
                                            System.out.println("A change of " + regVendingMachine.getChange() + " has been returned to you.");
                                            System.out.print("\nPress enter to continue.");
                                            sc.nextLine();
                                            sc.nextLine();
                                        }
                                        else {
                                            System.out.println("The Vending Machine does not have enough funds to produce a change. The item cannot be dispensed.");
                                            System.out.println(regVendingMachine.getPaymentBalance() + " has been returned to you.");
                                            regVendingMachine.initPaymentBalance();
                                            System.out.print("\nPress enter to continue.");
                                            sc.nextLine();
                                            sc.nextLine();
                                        }
                                    }
                                    break;
                                case 2:
                                    do {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();
                                        System.out.println("Please select the maintenance feature to execute.");
                                        System.out.println(" [1] List All Existing Items");
                                        System.out.println(" [2] Stock/Restock Items");
                                        System.out.println(" [3] Collect Payment");
                                        System.out.println(" [4] View Change Fund Inventory");
                                        System.out.println(" [5] Replenish Change Fund Inventory");
                                        System.out.println(" [6] Print a Summary of Transactions");
                                        System.out.println(" [7] Return to Main Menu");
                                        System.out.print("Enter choice : ");
                                        nChoice_MaintenanceFeature = sc.nextInt();

                                        switch (nChoice_MaintenanceFeature) {
                                            case 1:
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                regVendingMachine.printItemList();
                                                System.out.println("--end of list--");
                                                System.out.print("\nPress enter to continue.");
                                                sc.nextLine();
                                                sc.nextLine();
                                                break;
                                            case 2:
                                                do {
                                                    System.out.print("\033[H\033[2J");
                                                    System.out.flush();
                                                    System.out.println(" [1] Stock a New Item");
                                                    System.out.println(" [2] Restock an Existing Item");
                                                    System.out.println(" [3] List All Existing Items");
                                                    System.out.println(" [4] Finish Stocking/Restocking Process");
                                                    System.out.print("Enter choice : ");
                                                    nChoice_Stocking = sc.nextInt();

                                                    switch (nChoice_Stocking) {
                                                        case 1:
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
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
                                                                System.out.println("Please enter an item quantity of at least 10");
                                                                System.out.print("Enter item quantity : ");
                                                                nAnswer2 = sc.nextInt();
                                                            } while (nAnswer2 < 10);
                                                            }
                                                            if (regVendingMachine.stockItem(strAnswer, dAnswer, nAnswer1, nAnswer2) == true) {
                                                                System.out.print("\033[H\033[2J");
                                                                System.out.flush();
                                                                System.out.print("Product added successfully.\nPress enter to continue.");
                                                                sc.nextLine();
                                                                sc.nextLine();
                                                            }
                                                            else {
                                                                System.out.print("\033[H\033[2J");
                                                                System.out.flush();
                                                                System.out.print("There is already an existing product registered under the same name.\nProduct addition failed. Press enter to continue.");
                                                                sc.nextLine();
                                                                sc.nextLine();
                                                            }
                                                            break;
                                                        case 2:
                                                            if (regVendingMachine.getItemListSize() == 0) {
                                                                System.out.print("\033[H\033[2J");
                                                                System.out.flush();
                                                                System.out.println("There are no items to restock.");
                                                                System.out.print("Press enter to continue.");
                                                                sc.nextLine();
                                                                sc.nextLine();
                                                            }
                                                            else {
                                                                System.out.print("\033[H\033[2J");
                                                                System.out.flush();
                                                                regVendingMachine.printItemList();
                                                                System.out.println("\n");
                                                                System.out.print("Enter item index : ");
                                                                nAnswer1 = sc.nextInt();
                                                                if (nAnswer1 < 0 || regVendingMachine.getItemListSize() <= nAnswer1) {
                                                                    do {
                                                                        System.out.print("\033[H\033[2J");
                                                                        System.out.flush();
                                                                        System.out.println("ERROR: Selected index is out of bounds. Please try again.\n");
                                                                        regVendingMachine.printItemList();
                                                                        System.out.println("\n");
                                                                        System.out.print("Enter item index : ");
                                                                        nAnswer1 = sc.nextInt();
                                                                    } while (nAnswer1 < 0 || regVendingMachine.getItemListSize() <= nAnswer1);
                                                                }
                                                                System.out.print("\033[H\033[2J");
                                                                System.out.flush();
                                                                System.out.print("Enter item quantity : ");
                                                                nAnswer2 = sc.nextInt();
                                                                if (nAnswer2+regVendingMachine.getItemQuantity(nAnswer1) < 10) {
                                                                    do {
                                                                        System.out.print("\033[H\033[2J");
                                                                        System.out.flush();
                                                                        System.out.println("\nPlease enter an item quantity that would total to at least 10");
                                                                        System.out.print("Enter item quantity : ");
                                                                        nAnswer2 = sc.nextInt();
                                                                    } while (nAnswer2+regVendingMachine.getItemQuantity(nAnswer1) < 10);
                                                                }
                                                                if (regVendingMachine.restockItem(nAnswer1, nAnswer2) == true) {
                                                                    System.out.print("\033[H\033[2J");
                                                                    System.out.flush();
                                                                    System.out.print("Item restocked successfully.\nPress enter to continue.");
                                                                    sc.nextLine();
                                                                    sc.nextLine();
                                                                }
                                                                else {
                                                                    System.out.print("\033[H\033[2J");
                                                                    System.out.flush();
                                                                    System.out.print("Item quantity is invalid.\nItem restock failed. Press enter to continue.");
                                                                    sc.nextLine();
                                                                    sc.nextLine();
                                                                }
                                                            }
                                                            break;
                                                        case 3:
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            regVendingMachine.printItemList();
                                                            System.out.println("--end of list--");
                                                            System.out.print("\nPress enter to continue.");
                                                            sc.nextLine();
                                                            sc.nextLine();
                                                            break;
                                                        case 4:
                                                            regVendingMachine.setStartingInventory();
                                                            break;
                                                    }
                                                } while (nChoice_Stocking!=4);
                                                break;
                                            case 3:
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                System.out.print(regVendingMachine.collectMoney() + " has been collected from the current Vending Machine.\nPress enter to continue.");
                                                sc.nextLine();
                                                sc.nextLine();
                                                break;
                                            case 4:
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                regVendingMachine.printChangeFund();
                                                System.out.println("--end of list--");
                                                System.out.print("\nPress enter to continue.");
                                                sc.nextLine();
                                                sc.nextLine();
                                                break;
                                            case 5:
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                regVendingMachine.printChangeFund();
                                                System.out.println("\n");
                                                System.out.print("Enter denomination index : ");
                                                nAnswer1 = sc.nextInt();
                                                if (nAnswer1 < 0 || regVendingMachine.getChangeFundSize() <= nAnswer1) {
                                                    do {
                                                        System.out.print("\033[H\033[2J");
                                                        System.out.flush();
                                                        System.out.println("ERROR: Selected index is out of bounds. Please try again.\n");
                                                        regVendingMachine.printChangeFund();
                                                        System.out.println("\n");
                                                        System.out.print("Enter denomination index : ");
                                                        nAnswer1 = sc.nextInt();
                                                    } while (nAnswer1 < 0 || regVendingMachine.getChangeFundSize() <= nAnswer1);
                                                }
                                                System.out.print("Enter the number of denominations to replenish : ");
                                                nAnswer2 = sc.nextInt();
                                                if (regVendingMachine.replenishMoney(nAnswer1, nAnswer2) == true) {
                                                    System.out.print("\033[H\033[2J");
                                                    System.out.flush();
                                                    System.out.print("Selected denomination replenished succesfully.\nPress enter to continue.");
                                                    sc.nextLine();
                                                    sc.nextLine();
                                                }
                                                else {
                                                    System.out.print("\033[H\033[2J");
                                                    System.out.flush();
                                                    System.out.print("Denomination quantity is invalid.\nDenomination count restock failed. Press enter to continue.");
                                                    sc.nextLine();
                                                    sc.nextLine();
                                                }
                                                break;
                                            case 6:
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                regVendingMachine.printTransactionSummary();
                                                System.out.println("--end of list--");
                                                System.out.print("\nPress enter to continue.");
                                                sc.nextLine();
                                                sc.nextLine();
                                                break;
                                        }
                                    } while (nChoice_MaintenanceFeature != 7);
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    System.out.print("Invalid choice. Please try again.\nPress enter to continue.");
                                    sc.nextLine();
                                    sc.nextLine();
                                    break;
                            }
                        } while (nChoice_MachineFeature != 3);
                    }
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Terminating program..");
                    break;
                default:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.print("Invalid choice. Please try again.\nPress enter to continue.");
                    sc.nextLine();
                    sc.nextLine();
            }
        } while (nChoice_MainMenu != 3);

        sc.close();
    }
}