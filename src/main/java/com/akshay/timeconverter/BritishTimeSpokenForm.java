package com.akshay.timeconverter;

import java.util.Scanner;

public class BritishTimeSpokenForm {

    private static final String[] numbers = {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
        "twenty one", "twenty two", "twenty three", "twenty four", "twenty five",
        "twenty six", "twenty seven", "twenty eight", "twenty nine", "thirty", "thirty one", "thirty two", "thirty three", "thirty four", "thirty five", "thirty six", "thirty seven", "thirty eight", "thirty nine", "forty", "forty one", "forty two", "forty three", "forty four", "forty five", "forty six", "forty seven", "forty eight", "forty nine", "fifty", "fifty one", "fifty two", "fifty three", "fifty four", "fifty five", "fifty six", "fifty seven", "fifty eight", "fifty nine"
    };

    public static String toBritishTime(int h, int m) {
        if (h == 12 && m == 0) return "noon";
        if (h == 0 && m == 0) return "midnight";

        int hour = h % 12 == 0 ? 12 : h % 12;
        int nextHour = (h + 1) % 12 == 0 ? 12 : (h + 1) % 12;

        if (m == 0) return numbers[hour] + " o'clock";
        if (m == 15) return "quarter past " + numbers[hour];
        if (m == 30) return "half past " + numbers[hour];
        if (m == 45) return "quarter to " + numbers[nextHour];

        if (m >= 31 && m <= 34) {
            return numbers[hour] + " " + numbers[m]; // e.g., "six thirty-two"
        } else if (m < 30) {
            return numbers[m] + (m == 1 ? " minute past " : " minutes past ") + numbers[hour];
        } else {
            return numbers[60 - m] + ((60 - m) == 1 ? " minute to " : " minutes to ") + numbers[nextHour];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter time in HH:mm format (24-hour) or 'exit' to quit: ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            if (!input.matches("([01]?\\d|2[0-3]):[0-5]\\d")) {
                System.out.println("Invalid time format! Example: 09:15, 23:45, 00:00");
                continue;
            }

            String[] parts = input.split(":");
            int h = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);

            System.out.println("British spoken form: " + toBritishTime(h, m));
        }

        sc.close();
    }
}
