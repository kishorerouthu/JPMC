import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author Kishore Routhu on 13/1/18 12:12 PM.
 * <p>
 * Programming Challenge Description:
 * Write a program that, given an integer, inserts a '*' between adjacent digits
 * that are both even and a '-' between adjacent digits that are both odd. Zero should not
 * be considered even or odd.
 * <p>
 * Input:
 * Your program should read lines from standard input. Each line contains a positive integer.
 * <p>
 * Output:
 * For each line from standard input, print to standard output the input string with '*' and '-' properly inserted as described above, one string per line
 *
 * Input1 : 1234567
 * Output1 : 1234567
 *
 * Input2 : 12467930
 * Output2 : 12*4*67-9-3
 */
public class InsertSpecialCharacters {

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            String specialNumber = specialNumber(line);
            System.out.println(specialNumber);
        }
    }


    private static String specialNumber(String line) {

        if (line.trim().isEmpty()) {
            return line;
        }

        if (Integer.parseInt(line) == 0) {
            return line;
        }

        char nums[] = line.toCharArray();
        String firstChar = String.valueOf(nums[0]);
        StringBuilder sb = new StringBuilder(firstChar);
        int prev = Integer.parseInt(firstChar);
        int curr;
        for (int i = 1; i < nums.length; i++) {
            curr = Integer.parseInt(String.valueOf(nums[i]));
            if (areEven(prev, curr)) {
                sb.append('*');
            } else if (areOdd(prev, curr)) {
                sb.append('-');
            }

            sb.append(curr);
            prev = curr;
        }
        return sb.toString();
    }

    private static boolean areOdd(int a, int b) {
        return !areZeros(a, b) && ((a % 2 != 0) && (b % 2 != 0));
    }

    private static boolean areEven(int a, int b) {
        return !areZeros(a, b) && ((a % 2 == 0) && (b % 2 == 0));
    }

    private static boolean areZeros(int a, int b) {
        return (a == 0 || b == 0);
    }


}
