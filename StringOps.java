public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
       
      //  String word = "aaa";
       // char chr = 'a';
       // int[] indexes = allIndexOf(word, chr);
       // for (int i = 0; i < indexes.length; i++) {
        //    System.out.println(indexes[i]);
       // }
    }

    //returns the index of c in the given array
    //if c is not in array, returns -1
    public static int indexOf(char[] array, char c) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == c) {
                return i;
            }
        }
        return -1;
    }



    //checks if a char is upper case
    public static boolean IsUpperCase(char c) {
        boolean IsUp = false;
        if(c >= 'A' && c <= 'Z'){
            IsUp = true;
        }
        return IsUp;
    }

    //checks if a char is lower case
    public static boolean IsLowerCase(char c) {
        boolean IsLow = false; 
        if(c >= 'a' && c <= 'z'){
            IsLow = true;
        }

        return IsLow;
    }


    //returns the upper case of a char
    public static char ToUpperCase(char c) {
        char NewChar = c;
        NewChar = (char)(c-32);
        return NewChar ;
    }


    //returns the lower case of a char
    public static char ToLowerCase(char c) {
        char NewChar = c;
        NewChar = (char)(c+32);
        return NewChar ;
    }


    //if a char is one of (a,e,i,o,u) than it's uppercased
    //any other char is lowercased
    public static String capVowelsLowRest (String string) {

        char[] vowels = new char[] {'a','e','i','o','u', 'A', 'E', 'I', 'O', 'U'};
        String newString = "";

        for (int i = 0; i < string.length(); i++) {
            if (indexOf(vowels, string.charAt(i)) != -1) {
                if (IsLowerCase(string.charAt(i))) {
                    newString += ToUpperCase(string.charAt(i));
                }
                else {
                    newString += string.charAt(i);
                }
            }
            else if (string.charAt(i) == ' ') {
                newString += string.charAt(i);
            }
            else {
                if (IsUpperCase(string.charAt(i))) {
                    newString += ToLowerCase(string.charAt(i));
                }
                else {
                    newString += string.charAt(i);
                }
            }
        }
        
        return newString;
    }

    //returns the first index after a space in a  given string
    public static int indexAfterSpace(String string) {

        int FIndex = 0;

        for (int i = 0; i < string.length(); i++) {

            if (string.charAt(i) != ' ') {
                FIndex = i;
                break;
            }
        }

        return FIndex;
    }

    //returns the first index of a space in a given string
    public static int indexTillSpace(String string) {

        int FIndex = 0;

        for (int i = 0; i < string.length(); i++) {

            if (string.charAt(i) == ' ') {
                FIndex = i;
                break;
            }
        }

        return FIndex;
    }

    //return a new string with lowered case string
    public static String lowerCaseWord(String string) {
        String lowCaseStr = "";

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                return lowCaseStr;
            }
            
            if (IsUpperCase(string.charAt(i))) {
                lowCaseStr += ToLowerCase(string.charAt(i));
            }
            else {
                lowCaseStr += string.charAt(i);
            }
        }

        return lowCaseStr;
    }

    //returns a new string with first letter upper case than lower case 
    public static String UpAndLow(String string) {
        
        String lowCaseString = "";
        if (string.length() > 0) {

            if (IsLowerCase(string.charAt(0))) {
                lowCaseString += ToUpperCase(string.charAt(0));
            }
            else {
                lowCaseString += string.charAt(0);
            }

            for (int i = 1; i < string.length(); i++) {
                if (string.charAt(i) == ' ') {
                    return lowCaseString;
                }

                if (IsUpperCase(string.charAt(i))) {
                    lowCaseString += ToLowerCase(string.charAt(i));
                }
                else {
                    lowCaseString += string.charAt(i);
                }
            }

            return lowCaseString;
        }

        return lowCaseString;
    }

    //returns the number of words in a string
    public static int WordCounter(String string) {

        int count = 1;
        boolean isWord = true;

        string = string.substring(indexAfterSpace(string), string.length());

        for (int i = 0; i < string.length(); i++) {
            if (isWord) { 
                if (string.charAt(i) == ' ') {
                    count++;
                    isWord = false;
                }
            }
            if (!isWord) {
                if (string.charAt(i) != ' ') {
                    isWord = true;
                }
            }
        }
        
        return count;
    }

    public static String[] wordsInString(String string) {

        String[] words = new String[WordCounter(string)];

        for (int i = 0; i < words.length; i++) { 
            words[i] = "";
        }

        int wordsIndex = 0;
        boolean isWord = true;

        string = string.substring(indexAfterSpace(string), string.length());

        for (int i = 0; i < string.length(); i++) {
            if (isWord) { 
                if (string.charAt(i) == ' ') {
                    isWord = false;
                    wordsIndex++;
                }
                else {
                    words[wordsIndex] += string.charAt(i);
                }
            }
            if (!isWord) {
                if (string.charAt(i) != ' ') {
                    isWord = true;
                    words[wordsIndex] += string.charAt(i);
                }
            }
        }
        
        return words;
    }

    //returns the camel case of a string
    public static String camelCase (String string) {
        
        String camelCaseStr = "";
        String[] words = wordsInString(string);

        camelCaseStr += lowerCaseWord(words[0]);

        for  (int i = 1; i < words.length; i++) {
            camelCaseStr += UpAndLow(words[i]);
        }
        
        return camelCaseStr;
    }

    //checks how many times chr appears in string
    public static int CountStr (String string, char chr) {
        
        int count = 0;

        for (int i = 0; i < string.length(); i++) {
            if (chr == string.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    //returns the indexes of chr appears in string
    public static int[] allIndexOf (String string, char chr) {
        
        int[] indexes = new int[CountStr(string, chr)];
        int currentIndex = 0;

        for (int i = 0; i < string.length(); i++) {
            if (chr == string.charAt(i)) {
                indexes[currentIndex] = i;
                currentIndex++;
            }
        }

        return indexes;
    }
}