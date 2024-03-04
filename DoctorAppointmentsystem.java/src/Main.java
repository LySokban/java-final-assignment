import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String patientName = "";
        boolean userFound = false;
        boolean loop = true;

        doctor myDoc1 = new doctor("Chew", "Main Doctor", "anytime");
        doctor myDoc2 = new doctor("Chetra", "General Practitioners", "8am ~ 3pm");
        doctor myDoc3 = new doctor("Thyda", "Deneral Practitioners", "3pm ~ 10pm");
        doctor myDoc4 = new doctor("SievHeng", "Primary Care Physicians", "8am ~ 3pm");
        doctor myDoc5 = new doctor("Chou", "Primary Care Physicians", "3pm ~ 10pm");
        doctor myDoc6 = new doctor("Jen", "Specialists", "8am ~ 3pm");
        doctor myDoc7 = new doctor("Sok", "Specialists", "3pm ~ 10pm");
        doctor myDoc8 = new doctor("Theara", "Subspecialists", "8am ~ 3pm");
        doctor myDoc9 = new doctor("Davina", "Subspecialists", "3pm ~ 10pm");
        doctor[] doctors = {myDoc1, myDoc2, myDoc3, myDoc4, myDoc5, myDoc6, myDoc7, myDoc8, myDoc9};

        register account1 = new register("Chea", "1234");
        register account2 = new register("Dara", "9999");
        register account3 = new register("Sitha", "1111");
        register account4 = new register(null, null);
        register[] registers = {account1, account2, account3};

        System.out.println("======================================================");
        System.out.println("Doctor Appointment System.");
        System.out.println("======================================================");
        System.out.println("Do you have account yet (Yes/No)? : ");
        String answer = myScanner.nextLine();
        if (answer.toLowerCase().equals("yes") || answer.toLowerCase().equals("y")) {
            while (loop) {
                System.out.println("======================================================");
                System.out.println("Enter name : ");
                patientName = myScanner.nextLine();
                for (int i = 0; i < registers.length; i++) {
                    // if login account
                    if (patientName.equals(registers[i].getName())) {
                        register account = registers[i];
                        while (true) {
                            System.out.println("Enter password : ");
                            String password = myScanner.nextLine();
                            if (password.equals(account.getPassword())) {
                                System.out.println("login successfully.\n\n\n\n\n");
                                userFound = true;
                                loop = false;
                                break;
                            }
                            System.out.println("incorrect password. Please try again : ");
                        }
                    }
                }
                if (!userFound) {
                    System.out.println("User not found! ");
                }
            }
        } else {
            System.out.println("======================================================");
            System.out.println("Create account  ");
            System.out.println("======================================================");
            System.out.println("Create name : ");
            account4.setName(myScanner.nextLine());
            System.out.println("create password : ");
            account4.setPassword(myScanner.nextLine());
            register[] newRegisters = new register[registers.length + 1];
            for (int i = 0; i < registers.length; i++) {
                newRegisters[i] = registers[i];
            }
            newRegisters[newRegisters.length - 1] = account4;
            registers = newRegisters;
            System.out.println("account create successfully. ");
            System.out.println("======================================================");
            while (loop) {
                System.out.println("Enter name : ");
                patientName = myScanner.nextLine();
                for (int i = 0; i < registers.length; i++) {
                    // if login account
                    if (patientName.equals(registers[i].getName())) {
                        register account = registers[i];
                        while (true) {
                            System.out.println("Enter password : ");
                            String password = myScanner.nextLine();
                            if (password.equals(account.getPassword())) {
                                System.out.println("login successfully.\n\n\n\n\n");
                                userFound = true;
                                loop = false;
                                break;
                            }
                            System.out.println("incorrect password. Please try again ");
                        }
                    }
                }
                if (!userFound) {
                    System.out.println("User not found! ");
                }
            }
        }

        ShowDoctor(doctors);
        doctor chosenDoctor = findDoctor(doctors);
        String Time = bookDoctor(chosenDoctor);
        getInvoid(patientName,chosenDoctor,Time);

   }
   public static void ShowDoctor (doctor[]doctors){
        System.out.println("======================================================");
        System.out.println("\t\t\tDoctor Appointment Schedule System.");
        System.out.println("======================================================");
        System.out.println("\t\t\t\tDoctor's list: ");
        System.out.println("======================================================");
        System.out.println("Doctor's Name   Subject                    Time");
        System.out.println("======================================================");
        for (int i = 0; i < doctors.length; i++) {
            String formattedOutput = String.format("%-15s %-26s %-10s", doctors[i].getDoctorName(), doctors[i].getDoctorSubject(), doctors[i].getDoctorWorkTime());
            System.out.println(formattedOutput);
        }
    }
   public static doctor findDoctor(doctor[] doctors)
   {
       String pTime;
       Scanner myScanner = new Scanner(System.in);
       while (true){

           System.out.println("======================================================");

           System.out.println("Please enter \"name of the  Doctor\" you want to see: ");

           String pDoctor = myScanner.nextLine();

           for (int i = 0; i < doctors.length; i++) {
               if ((pDoctor.toLowerCase()).equals(doctors[i].getDoctorName().toLowerCase())) {
                   System.out.println("======================================================");
                   return doctors[i];
               }
           }
           System.out.println("Sorry, the entered doctor's name was not found.");

       }

   }
   public static String bookDoctor(doctor chosenDoctor){
       String pTime;
       Scanner myScanner = new Scanner(System.in);
       System.out.println("Dr. " + chosenDoctor.getDoctorName() + "\nSubject : " + chosenDoctor.getDoctorSubject());
       System.out.println("Available on : " + chosenDoctor.getDoctorWorkTime());
       System.out.println("\nPlease enter the \"time\" you want to see the Doctor : ");
       pTime = myScanner.nextLine();
       System.out.println("The doctor accepted.");
       System.out.println("======================================================");
       return pTime;
   }
   public static void getInvoid(String name, doctor chosenDoctor, String Time){
       System.out.println(chosenDoctor.getDoctorName());
       System.out.println("\n***Invoice");
       System.out.println("\nName : " +  name);
       System.out.println("Doctor : " + chosenDoctor.getDoctorName());
       System.out.println("Subject : " +chosenDoctor.getDoctorSubject());
       System.out.println("On Time : " + Time);
       System.out.println("\n. . . . .\n");
       System.out.println("======================================================");
   }
}