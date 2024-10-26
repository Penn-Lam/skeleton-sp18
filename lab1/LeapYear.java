/** Class that determines whether or not a year is a leap year.
 *  @author Penn_Lam
 */
public class LeapYear {

    /** 调用isLeapYear来打印正确的语句。
     *  @param  year to be analyzed
     */
    private static void checkLeapYear(int year) {
        if (isLeapYear(year)) {
            System.out.printf("%d is a leap year.\n", year);
        } else {
            System.out.printf("%d is not a leap year.\n", year);
        }
    }

    /**
     * 判断给定的年份是否是闰年。
     * @param year 要判断的年份
     * @return 如果是闰年返回true，否则返回false
     */
    public static boolean isLeapYear(int year){
        if(year%400==0) return true;
        else if(year%4==0 && year%100!=0) return true;
        else return false;
    }

    /** Must be provided an integer as a command line argument ARGS. */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter command line arguments.");
            System.out.println("e.g. java Year 2000");
        }
        for (int i = 0; i < args.length; i++) {
            try {
                int year = Integer.parseInt(args[i]);
                checkLeapYear(year);
            } catch (NumberFormatException e) {
                System.out.printf("%s is not a valid number.\n", args[i]);
            }
        }
    }
}

