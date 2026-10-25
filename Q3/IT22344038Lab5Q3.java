import java.util.Scanner;

public class IT22344038Lab5Q3 {

    static final double ROOM_CHARGE_PER_DAY = 48000.00;
    static final int MIN_DATE = 1;
    static final int MAX_DATE = 31;
    static final int DISCOUNT_THRESHOLD_1 = 3;
    static final int DISCOUNT_THRESHOLD_2 = 5;
    static final double DISCOUNT_RATE_1 = 0.10;
    static final double DISCOUNT_RATE_2 = 0.20;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Start Date (1-31): ");
        int startDate = scanner.nextInt();

        System.out.print("Enter End Date (1-31): ");
        int endDate = scanner.nextInt();

        if (startDate < MIN_DATE || startDate > MAX_DATE || endDate < MIN_DATE || endDate > MAX_DATE) {
            System.out.println("Error: Days must be between 1 and 31");
            scanner.close();
            return;
        }

        if (startDate >= endDate) {
            System.out.println("Error: Start Date must be less than End Date");
            scanner.close();
            return;
        }

        int daysReserved = endDate - startDate;
        double totalAmount = daysReserved * ROOM_CHARGE_PER_DAY;

        if (daysReserved >= DISCOUNT_THRESHOLD_2) {
            totalAmount = totalAmount - (totalAmount * DISCOUNT_RATE_2);
        } else if (daysReserved >= DISCOUNT_THRESHOLD_1) {
            totalAmount = totalAmount - (totalAmount * DISCOUNT_RATE_1);
        }

        System.out.println();
        System.out.println("Room Charge Per Day: Rs. " + ROOM_CHARGE_PER_DAY + "/=");
        System.out.println("Number of Days Reserved: " + daysReserved);
        System.out.println("Total Amount to be Paid: " + totalAmount);

        scanner.close();
    }
}