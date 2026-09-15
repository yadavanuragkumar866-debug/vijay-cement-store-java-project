import java.util.Scanner;

public class project {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("enter your choice");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    showStoreinformation();
                    break;

                case 2:
                    showProductmenu();
                    break;

                case 3:
                    customerOrder(sc);
                    break;

                case 0:
                    System.out.println("Thank you for visiting Vijay Cement Store!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();

    }

    public static void showStoreinformation() {
        System.out.println("=================================================");
        System.out.println("             VIJAY CEMENT STORE");
        System.out.println("                  CHAKRAHI");
        System.out.println("=================================================");
        System.out.println("Owner Name      : Vijay Kumar Singh");
        System.out.println("Address         : Chakrahi, Ara, Bihar");
        System.out.println("Contact No.     : +91 6202450514");
        System.out.println("Opening Time    : 7:00 AM");
        System.out.println("Closing Time    : 8:00 PM");
        System.out.println("Home Delivery   : Available");
        System.out.println("Payment         : Cash | UPI | Card");
        System.out.println("=================================================");
    }

    public static void showProductmenu() {

        System.out.println("=============== MATERIAL MENU ===============");
        System.out.println("1. jk super                   ₹320/Bag");
        System.out.println("2. jk super strong            ₹410/Bag");
        System.out.println("3. jk super protect           ₹415/Bag");
        System.out.println("4. jsw cement                 ₹405/Bag");
        System.out.println("5. neelkamal-TMT              ₹600/100-kg");
        System.out.println("6. kay2-TMT                   ₹600/100-kg");
        System.out.println("0. Exit");
        System.out.println("===========================================");
    }

    public static void customerOrder(Scanner sc) {

        char continueOrder;

        do {

            System.out.print("Enter Customer Name : ");
            String name = sc.next();
            System.out.println("Customer Name : " + name);

            System.out.print("Enter Village Name : ");
            String villageName = sc.next();
            System.out.println("Village Name : " + villageName);

            String mob;

            do {
                System.out.print("Enter Mobile Number : ");
                mob = sc.next();

                if (!mob.matches("\\d{10}")) {
                    System.out.println("Invalid Mobile Number!");
                    System.out.println("Please enter exactly 10 digits.");
                }

            } while (!mob.matches("\\d{10}"));

            System.out.println("Mobile Number : " + mob);

            System.out.println("\n------ Cement Menu ------");
            System.out.println("1. JK Super");
            System.out.println("2. JK Super Strong");
            System.out.println("3. JK Super Protect");
            System.out.println("4. JSW Cement");

            System.out.print("Enter Cement Choice : ");
            int cementChoice = sc.nextInt();

            String cementName = "";
            int cementPrice = 0;

            switch (cementChoice) {

                case 1:
                    cementName = "JK Super";
                    cementPrice = 330;
                    break;

                case 2:
                    cementName = "JK Super Strong";
                    cementPrice = 430;
                    break;

                case 3:
                    cementName = "JK Super Protect";
                    cementPrice = 450;
                    break;

                case 4:
                    cementName = "JSW Cement";
                    cementPrice = 405;
                    break;

                default:
                    System.out.println("Invalid Cement Choice");
                    return;
            }

            int cementQuantity;

            do {
                System.out.print("Enter Cement Quantity : ");
                cementQuantity = sc.nextInt();

                if (cementQuantity < 30) {
                    System.out.println("Minimum Cement Order is 30 Bags");
                }

            } while (cementQuantity < 30);

            System.out.println("Cement Order Accepted");

            System.out.println("\n------ Steel Menu ------");
            System.out.println("1. Neelkamal TMT");
            System.out.println("2. Kay2 TMT");

            System.out.print("Enter Steel Choice : ");
            int steelChoice = sc.nextInt();

            String steelName = "";
            int steelPrice = 0;

            switch (steelChoice) {

                case 1:
                    steelName = "Neelkamal TMT";
                    steelPrice = 60;
                    break;

                case 2:
                    steelName = "Kay2 TMT";
                    steelPrice = 60;
                    break;

                default:
                    System.out.println("Invalid Steel Choice");
                    return;
            }

            int steelQuantity;

            do {
                System.out.print("Enter Steel Quantity (kg) : ");
                steelQuantity = sc.nextInt();

                if (steelQuantity < 200) {
                    System.out.println("Minimum Steel Order is 200 kg");
                }

            } while (steelQuantity < 200);

            System.out.println("Steel Order Accepted");

            int totalBill = calculateBill(
                    cementPrice,
                    cementQuantity,
                    steelPrice,
                    steelQuantity
            );

            System.out.println("\n========== ORDER DETAILS ==========");
            System.out.println("Customer Name : " + name);
            System.out.println("Village       : " + villageName);
            System.out.println("Mobile No.    : " + mob);
            System.out.println("Cement        : " + cementName);
            System.out.println("Cement Qty    : " + cementQuantity);
            System.out.println("Steel         : " + steelName);
            System.out.println("Steel Qty     : " + steelQuantity);
            System.out.println("Total Bill    : ₹" + totalBill);
            System.out.println("===================================");

            System.out.print("\nDo you want to enter another customer? (yes/no): ");
            continueOrder = sc.next().charAt(0);

        } while (continueOrder == 'Y' || continueOrder == 'y');

    }

    public static int calculateBill(
            int cementPrice,
            int cementQty,
            int steelPrice,
            int steelQty) {

        int cementBill = cementPrice * cementQty;
        int steelBill = steelPrice * steelQty;

        return cementBill + steelBill;
    }
}






    
    

