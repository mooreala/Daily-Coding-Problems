package February;

import java.util.HashSet;
import java.util.Set;

public class P480 {
    private static Set<String> dictionary = new HashSet<>();

    public static void main(String args[]) {
        new P480().printDesc();

        /* set up dictionary */
        String dict[] = { "bed", "bath", "bedbath", "and", "beyond" };
        for (int i = 0; i < dict.length; i++) {
            dictionary.add(dict[i]);
        }

        /* set up inputs */
        String input = "bedbathandbeyond";

        /* output */
        System.out.println("Example input: " + input);
        System.out.println("Solutions:");
        /* get solution list */
        wordFindUtil(dictionary, "", input);
    }

    public void printDesc() {
        System.out.println("Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.");
    }

    public static void wordFindUtil(Set<String> dictionary, String solution, String input) {
        if (input.length() == 0) {
            System.out.println(solution);
            return;
        }
        
        for (int i = 1; i <= input.length(); i++) {
            // get substring from 0 to i
            String inputSub = input.substring(0, i);

            if (dictionary.contains(inputSub)) {
                // recursive call to find remaining substrings from input
                wordFindUtil(dictionary, solution + " " + inputSub, input.substring(i));
            }
        }
    }
}
