package AOneQuestionPerDay;
import java.util.Scanner;
public class DateToDays {

        private static void isRun(int year, int month, int day) {
            if (year <= 0 || month <= 0 || month >= 13 || day <= 0 || day >= 32) {
                System.out.println(-1);
                return;
            }
            boolean run = false;
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                run = true;
            }
            if (!run) {
                if (month == 2 && day > 28) {
                    System.out.println(-1);
                    return;
                }
            } else {
                if (month == 2 && day > 29) {
                    System.out.println(-1);
                    return;
                }
            }
            int i = month - 1;
            if (month == 3) {
                i = i - 1;
            }
            int sum = 0;
            switch (i) {
                case 11:
                    sum += 30;
                case 10:
                    sum += 31;
                case 9:
                    sum += 30;
                case 8:
                    sum += 31;
                case 7:
                    sum += 31;
                case 6:
                    sum += 30;
                case 5:
                    sum += 31;
                case 4:
                    sum += 30;
                case 3:
                    sum += 31;
                case 1:
                    sum += 31;

            }
            ;
            if (month >= 3) {
                if (run) {
                    sum += 29;
                } else {
                    sum += 28;
                }
            }
            sum += day;
            System.out.println(sum);

        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                int year = sc.nextInt();
                int month = sc.nextInt();
                int day = sc.nextInt();
                isRun(year, month, day);
            }
        }





}
