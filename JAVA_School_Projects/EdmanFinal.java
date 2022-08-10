import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;


public class EdmanFinal {

    private static String cmk; // make of the vehicle
    private static String cmd; // model of the vehicle
    private static String ccl; // color of the vehicle
    private static int cyr; // year for the vehicle
    private static int cml; // mileage for the vehicle
    private static int vehicleId;
    private static ArrayList<Vehicle> edvehicle = new ArrayList<Vehicle>();
    private static final String FILENAME = "Auto.txt";
    private static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        edmain();
    }

    //MODIFIED
    public static void edmain() {

        Scanner scnr = new Scanner(System.in);

        int choice = 0;
        boolean inputmismatch = false;

        //Using do while loop for menu driven approach 
        do {

            System.out.println("Choose one of the following: ");
            System.out.println("1 to add the new vehicle");
            System.out.println("2 to list all the vehicles");
            System.out.println("3 to remove a vehicle");
            System.out.println("4 to update a vehicle");
            System.out.println("5 to see whether or not we print it to a file");
            System.out.println("6 to exit");
            System.out.println(" ");


            //Using try catch in case user enters alphabets instead of numbers for choice
            try {
                choice = scnr.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                inputmismatch = true;
            }

            //this line will prevent compiler to skip next string inputs
            scnr.nextLine();


            if (choice == 1) {
                edmanaddvehicle();
            } else if (choice == 2) {
                edmanlistvehicle();
            } else if (choice == 3) {
                edmanremovevehicle();
            } else if (choice == 4) {
                edmanupdatevehicle();
            } else if (choice == 5) {
                try {
                    edmanchecktoprint();
                } catch (Exception e) {
                    System.out.println("File Not Created");
                    e.printStackTrace();

                }

            } else if (choice == 6) {
                edmanexit();
            }
            //If inputmismatch is true means if exception occurs or
            //user enters choice value more than 6 or less than 0 print error message
            else if (inputmismatch || choice > 6 || choice < 0) {
                System.out.println("Invalid Input !! Choose From given Options\n");
            }
        
            //When user enters invalid choice ask them to choose again
        } while (inputmismatch || choice > 6 || choice == 0);
    }


    public static void edmanexit() {
        System.exit(0);
    }
    
    //
    public static void edmanaddvehicle() {

        Scanner scnr = new Scanner(System.in);

        System.out.println("Adding A new Vehicle");  // Telling the user what we are doing
        System.out.println(" ");

        boolean inputMistmatch = false;

        //Same as Above to counter input mismatch exception we use do while loop 
        do {
            
            //We have to ask use to enter id to keep records in arraylist
            
            try {
                System.out.println("Enter vehicle Id: ");
                vehicleId = scnr.nextInt();
                inputMistmatch = false;
            } catch (InputMismatchException ime) {
                inputMistmatch = true;
                System.out.println("---- Invalid Input : Please Enter Valid Numbers of Id");
            }
            scnr.nextLine();
        } while (inputMistmatch);

        System.out.println("Let’s enter  the make of the vehicle to add: ");
        cmk = scnr.nextLine();

        System.out.println("Let’s enter the model of the vehicle to add: ");
        cmd = scnr.nextLine();

        System.out.println("Let’s enter the color of the vehicle to add: ");
        ccl = scnr.nextLine();

        //same, if user enters non integer value for year ask to input again 
        do {
            try {
                System.out.println("What year the car was built: ");
                cyr = scnr.nextInt();
                inputMistmatch = false;
            } catch (InputMismatchException ime) {
                inputMistmatch = true;
                System.out.println("---- Invalid Input : Please Enter Valid Numbers of Year");
            }
            scnr.nextLine();
        } while (inputMistmatch);

        do {
            try {
                System.out.println("Let’s enter the number of miles of the car: ");
                cml = scnr.nextInt();
                inputMistmatch = false;
            } catch (InputMismatchException ime) {
                inputMistmatch = true;
                System.out.println("---- Invalid Input : Please Enter Valid Numbers of Miles");
            }
            scnr.nextLine();
        } while (inputMistmatch);

        
        //Creating Vehicle object with value entered by user
        Vehicle vehicle = new Vehicle(vehicleId, cmk, cmd, ccl, cyr, cml);
        
        //add this vehicle object in arraylist
        edvehicle.add(vehicle);

        System.out.println("------------------------------");
        System.out.println("Vehicle Added Successfully");
        System.out.println("------------------------------");
        System.out.println(" ");

        edmain();
    }

    //
    public static void edmanlistvehicle() {
        System.out.println("-----------------");
    
        //Using for loop to read record from each value of arraylist
        //using getter methods
        for (int i = 0; i < edvehicle.size(); i++) {
            System.out.println(edvehicle.get(i).getVehicleId() + " " + edvehicle.get(i).getCmk() + " " +
                    edvehicle.get(i).getCmd() + " " + edvehicle.get(i).getCcl() + " " + edvehicle.get(i).getCyr() + " " +
                    edvehicle.get(i).getCml());
        }
        System.out.println("-----------------");
        edmain();
    }
    
    //
    public static void edmanremovevehicle() {

        Scanner scnr = new Scanner(System.in);

        try {
            
            //When there is no records in list
            if (edvehicle.size() <= 0) {
                System.out.println("\n---- No Vehicles in the list to remove.\n");
            } else {
                
                System.out.println("Let’s enter the id of the vehicle to removed: ");
                vehicleId = scnr.nextInt();

                boolean found = false;
            
                for (int i = 0; i < edvehicle.size(); i++) {
                    if (edvehicle.get(i).getVehicleId() == vehicleId) {
                        found = true;

                        //removing vehicle object from arraylist
                        edvehicle.remove(i);
                        System.out.println("------------------------------");
                        System.out.println("Vehicle Removed Successfully");
                        System.out.println("------------------------------");
                        System.out.println(" ");
                        break;
                    }
                }
                
                //If vehicle id not found in list
                if (!found)
                    System.out.println("\n---- No Vehicle With Id " + vehicleId + " in the list to Update.\n");

            }


        } catch (IndexOutOfBoundsException ioe) {
            System.out.println("\n--s-- No Vehicle With Id " + vehicleId + " in the list to remove.\n");
        }
        edmain();
    }

    //
    public static void edmanupdatevehicle() {

        Scanner scnr = new Scanner(System.in);

        System.out.println("You are about to update a vehicle...");
        System.out.println(" ");

        boolean inputMistmatch = false;

        do {
            try {
                //read which records to be updated
                System.out.println("Let’s enter the Id of the vehicle to be updated: "); // It’s the Id of the vehicle to be updated
                vehicleId = scnr.nextInt();
                inputMistmatch = false;

                if (edvehicle.size() <= 0) {
                    System.out.println("\n---- No Vehicle With Id " + vehicleId + " list to Update.\n");
                } else {
            
                    boolean found = false;

                    //searching for vehicle id in list
                    for (int i = 0; i < edvehicle.size(); i++) {
                        if (edvehicle.get(i).getVehicleId() == vehicleId) {
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("\n---- No Vehicle With Id " + vehicleId + " list to Update.\n");
                    } else {
                        
                        //If vehicleId matches in list 
                        //ask user to enter new values 
                        
                        int vehicleId2;
                        
                        System.out.println("Enter vehicle Id : "); // The new id for our new vehicle
                        vehicleId2 = scnr.nextInt();
                        scnr.nextLine();

                        System.out.println("Let’s enter the make of the vehicle to update: "); 
                        cmk = scnr.nextLine();

                        System.out.println("Let’s enter the model of the vehicle to update: ");
                        cmd = scnr.nextLine();

                        System.out.println("Let’s enter the color of the vehicle to update: ");
                        ccl = scnr.nextLine();

                        inputMistmatch = false;
                        do {

                            try {
                                System.out.println("What year the car was built: ");
                                cyr = scnr.nextInt();
                                inputMistmatch = false;
                            } catch (InputMismatchException ime) {
                                inputMistmatch = true;
                                System.out.println("---- Invalid Input : Please Enter Valid Numbers of Year");
                            }
                            scnr.nextLine();

                        } while (inputMistmatch);

                        do {
                            try {
                                System.out.println("Let’s enter the number of miles of the car: ");
                                cml = scnr.nextInt();
                                inputMistmatch = false;
                            } catch (InputMismatchException ime) {
                                inputMistmatch = true;
                                System.out.println("---- Invalid Input : Please Enter Valid Numbers of Miles");
                            }
                        } while (inputMistmatch);

                        Vehicle vehicle = null;

                        for (int i = 0; i < edvehicle.size(); i++) {

                            if (edvehicle.get(i).getVehicleId() == vehicleId) {
                            
                                //create an object with new values of vehicle
                                vehicle = new Vehicle(vehicleId2, cmk, cmd, ccl, cyr, cml);
                                
                                //Updated record in list
                                edvehicle.set(i, vehicle);

                                System.out.println("------------------------------");
                                System.out.println("Vehicle Updated Successfully");
                                System.out.println("------------------------------");
                                System.out.println(" ");

                            }
                        }
                    }
                }

            } catch (InputMismatchException ime) {
                inputMistmatch = true;
                System.out.println("---- Invalid Input : Please Enter Valid Numbers of Year");
            }
            scnr.nextLine();

        } while (inputMistmatch);


        edmain();

    }

    public static void edmanchecktoprint() throws IOException {

        Scanner scnr = new Scanner(System.in);

        FileOutputStream fileStream = null;
        PrintWriter outFS = null;
        char check;
        System.out.println("Do you want to print to a file y or n: ");
        check = scnr.next().charAt(0);

        if (check == 'y') {
            fileStream = new FileOutputStream(FILENAME);
            outFS = new PrintWriter(fileStream);
        
            //USing for loop to write vehicle details in file 
            for (int i = 0; i < edvehicle.size(); i++) {
                outFS.write(edvehicle.get(i).getVehicleId() + " " + edvehicle.get(i).getCmk() + " " +
                        edvehicle.get(i).getCmd() + " " + edvehicle.get(i).getCcl() + " " + edvehicle.get(i).getCyr() + " " +
                        edvehicle.get(i).getCml() + "\n");
            }

            outFS.close();
            System.out.println("------------------------------");
            System.out.println("Vehicle Printed Successfully");
            System.out.println("------------------------------");
            System.out.println(" ");
        } else if (check == 'n') {

            System.out.println("------------------------------");
            System.out.println("Here is yours vehicles");

            for (int i = 0; i < edvehicle.size(); i++) {
                System.out.println(edvehicle.get(i).getVehicleId() + " " + edvehicle.get(i).getCmk() + " " +
                        edvehicle.get(i).getCmd() + " " + edvehicle.get(i).getCcl() + " " + edvehicle.get(i).getCyr() + " " +
                        edvehicle.get(i).getCml());
            }

            System.out.println("------------------------------");
            System.out.println(" ");

        } else {
            System.out.println("please try again...");
        }
        scnr.nextLine();
        edmain();

    }
}

