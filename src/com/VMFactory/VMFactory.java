package com.VMFactory;

import java.util.Scanner;

public class VMFactory {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int nChoice_MainMenu, nChoice_MachineType, nChoice_MachineFeature;

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
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.print("This feature is currently not yet implemented.\nPress enter to continue.");
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
                    } while (nChoice_MachineFeature != 3);
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Terminating program...");
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
