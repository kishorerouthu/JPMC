import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Find the longest common suffix between two Strings
 * If there is not such common suffix then print NULL
 *
 * Input : Two string separated by comma
 *
 * Input1 :
 *  Cornfield, outfield
 *
 * Output1 :
 *  field
 *
 * Input2 :
 *  Manhours, manhole
 *
 * Output2 :
 *  NULL
 *
 *
 * @author Kishore Routhu on 13/1/18 11:27 AM.
 */
public class FindLongestCommonSuffix {

    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            String str[] = line.split(",");
            String commonSuffix = "NULL";
            if (str.length >= 2) {
                commonSuffix = commonSuffix(str[0].trim(), str[1].trim());
            }
            System.out.println(commonSuffix);
        }
    }

    private static String commonSuffix(String s1, String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            if (s1.charAt(i) != s2.charAt(j)) {
                break;
            }
            sb.append(s1.charAt(i));
            i--;
            j--;
        }
        String suffix = sb.reverse().toString();
        return suffix.isEmpty() ? "NULL" : suffix;
    }
}
