package Day7;

import java.util.Scanner;

public class Demo13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name and last name");
        String firstName = scanner.next();
        String lastName = scanner.next();
        System.out.println("FullName: " + (firstName + lastName));
    }
}

