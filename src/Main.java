/**
 * Question One: Replacing characters in place
 *
 * Given an array of characters, write a method to replace all the spaces with “&32”.
 * You may assume that the array has sufficient slots at the end to hold the additional
 * characters, and that you are given the “true” length of the array. (Please perform this
 * operation in place with no other auxiliary structure).
 */
public class Main {

    public static void main(String[] args) {

        final String strInput = "User is not allowed      ";
        final ReplacingCharacterUtil util = new ReplacingCharacterUtil();

        try {
            String strOutput = util.replaceSourceByCharacter(strInput, 19);

            System.out.println("Input: " + strInput);
            System.out.println("Output: " + strOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
