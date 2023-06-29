package com.VMFactory;

import com.RVMachine.*;

import java.util.Scanner;

public class VMFactory {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int nChoice_MainMenu, nChoice_MachineType, nChoice_MachineFeature, nChoice_MaintenanceFeature, nChoice_Stocking, nAnswer1, nAnswer2;
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
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    System.out.print("This feature is currently not yet implemented.\nPress enter to continue.");
                                    sc.nextLine();
                                    sc.nextLine();
                                    break;
                                case 2:
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    System.out.println("Please select the maintenance feature to execute.");
                                    System.out.println(" [1] List All Existing Products");
                                    System.out.println(" [2] Stock/Restock Products");
                                    System.out.println(" [3] Collect Payment");
                                    System.out.println(" [4] View Change Funds");
                                    System.out.println(" [5] Replenish Change Funds");
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
                                                System.out.println(" [1] Stock a New Product");
                                                System.out.println(" [2] Restock an Existing Product");
                                                System.out.println(" [3] List All Existing Products");
                                                System.out.println(" [4] Finish Stocking/Restocking Process");
                                                System.out.print("Enter choice : ");
                                                nChoice_Stocking = sc.nextInt();

                                                switch (nChoice_Stocking) {
                                                    case 1:
                                                        System.out.print("\033[H\033[2J");
                                                        System.out.flush();
                                                        System.out.print("Enter the product name : ");
                                                        sc.nextLine();
                                                        strAnswer = sc.nextLine();
                                                        System.out.print("Enter the product price : ");
                                                        dAnswer = sc.nextDouble();
                                                        System.out.print("Enter the product caloric value : ");
                                                        nAnswer1 = sc.nextInt();
                                                        System.out.print("Enter the product quantity : ");
                                                        nAnswer2 = sc.nextInt();
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
                                                        System.out.print("\033[H\033[2J");
                                                        System.out.flush();
                                                        regVendingMachine.printItemList();
                                                        System.out.println("\n");
                                                        System.out.print("Enter the product index : ");
                                                        nAnswer1 = sc.nextInt();
                                                        System.out.print("Enter the product quantity : ");
                                                        nAnswer2 = sc.nextInt();
                                                        if (regVendingMachine.restockItem(nAnswer1, nAnswer2) == true) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            System.out.print("Product restocked successfully.\nPress enter to continue.");
                                                            sc.nextLine();
                                                            sc.nextLine();
                                                        }
                                                        else {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            System.out.print("At least one of the given inputs is considered invalid.\nProduct restock failed. Press enter to continue.");
                                                            sc.nextLine();
                                                            sc.nextLine();
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
                                            System.out.print("Enter the donomination index : ");
                                            nAnswer1 = sc.nextInt();
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
                                                System.out.print("At least one of the given inputs is considered invalid.\nDenomination count restock failed. Press enter to continue.");
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
