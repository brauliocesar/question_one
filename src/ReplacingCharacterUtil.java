/**
 * Class to replace characters
 */
public class ReplacingCharacterUtil {

    private String szReplaceCharacters = "&32";

    /**
     * Set the replaced characters
     *
     * @param szReplaceCharacters
     */
    public void setCharacter(String szReplaceCharacters) {
        this.szReplaceCharacters = szReplaceCharacters;
    }

    /**
     * Replacing Character In Place
     * Replace all the spaces with &32 character
     *
     * @param source
     * @return
     */
    public String replaceSourceByCharacter(final String source) throws Exception {
        return replaceSourceByCharacter(source, szReplaceCharacters);
    }

    /**
     * Replacing Character In Place
     * Replace all the spaces with &32 character
     *
     * @param source
     * @return
     */
    public String replaceSourceByCharacter(final String source, String szReplaceChar) throws Exception {
        // Check if source has null
        if (source == null) {
            throw new Exception("Error: Source String Is Null");
        }

        String strOut = "";
        String strWithoutEndSpace = source.trim();
        char chWithEndSpace[] = source.toCharArray();
        char chWithoutEndSpace[] = strWithoutEndSpace.toCharArray();

        // Start Of End Characters To Count Spaces
        int iSpaceAtEnd = countSpacesAtEnd(chWithoutEndSpace.length, chWithEndSpace);
        int iSpacesInnerString = countSpacesInnerString(chWithoutEndSpace);
        int iCountReplacedString = szReplaceChar.length();

        if (iSpaceAtEnd > 0
                && ((iCountReplacedString + iSpacesInnerString) == iSpaceAtEnd)) {
            strOut = strWithoutEndSpace.replace(" ", szReplaceChar);
        } else {
            throw new Exception("Error: Insufficient space at the end of");
        }

        return strOut;
    }

    /**
     * Count spaces at end string
     *
     * @param iStartOf
     * @param chWithEndSpace
     * @return
     */
    private int countSpacesAtEnd(int iStartOf, char[] chWithEndSpace) {
        int countSpacesAtEnd = 0;

        for (int iIndex = iStartOf; iIndex < chWithEndSpace.length; iIndex++) {
            // Check character is empty
            if (chWithEndSpace[ iIndex ] == ' ') {
                countSpacesAtEnd++;
            }
        }

        return countSpacesAtEnd;
    }

    /**
     * Count Spaces at inner string
     * @param chWithoutEndSpace
     * @return
     */
    private int countSpacesInnerString(char[] chWithoutEndSpace) {
        int iCountInnerSpaces = 0;
        for (int iIndex = 0 ; iIndex < chWithoutEndSpace.length; iIndex++) {

            if (chWithoutEndSpace[iIndex] == ' ') {
                iCountInnerSpaces++;
            }
        }

        return  iCountInnerSpaces;
    }
}
