public class StringOps {

    public static void main(String[] args) {
        String word = "MMMM";
        char chr = 'M';
        int[] indexes = allIndexOf(word, chr);
        for (int index : indexes) {
            System.out.println(index);
        }
    }

    // Function to count occurrences of chr in a string
    public static int countOccurrences(String str, char chr) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (chr == str.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    // Function to get all indexes of chr in string
    public static int[] allIndexOf(String str, char chr) {
        int[] indexes = new int[countOccurrences(str, chr)];
        int currentIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (chr == str.charAt(i)) {
                indexes[currentIndex++] = i;
            }
        }
        return indexes;
    }

    // Function to check if a char is lower case
    public static boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    // Function to check if a char is upper case
    public static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    // Function to convert char to lower case
    public static char toLowerCase(char c) {
        return isUpperCase(c) ? (char) (c + 32) : c;
    }

    // Function to convert char to upper case
    public static char toUpperCase(char c) {
        return isLowerCase(c) ? (char) (c - 32) : c;
    }

    // Function to capitalize vowels and lowercase other chars
    public static String capVowelsLowRest(String str) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (indexOf(vowels, currentChar) != -1) {
                newStr.append(isLowerCase(currentChar) ? toUpperCase(currentChar) : currentChar);
            } else {
                newStr.append(isUpperCase(currentChar) ? toLowerCase(currentChar) : currentChar);
            }
        }
        return newStr.toString();
    }

    // Function to get index of char in array
    public static int indexOf(char[] array, char c) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == c) {
                return i;
            }
        }
        return -1;
    }

    // Function to convert string to camel case
    public static String camelCase(String str) {
        StringBuilder camelCaseStr = new StringBuilder();
        boolean newWord = true;
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (newWord && isLowerCase(currentChar)) {
                camelCaseStr.append(toUpperCase(currentChar));
                newWord = false;
            } else if (!newWord && isUpperCase(currentChar)) {
                camelCaseStr.append(toLowerCase(currentChar));
            } else {
                camelCaseStr.append(currentChar);
                newWord = (currentChar == ' ');
            }
        }
        return camelCaseStr.toString();
    }
}
