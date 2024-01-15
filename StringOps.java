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
        System.out.println(capVowelsLowRest("Hello World"));
        System.out.println(capVowelsLowRest("One two tHRee world"));
        System.out.println(capVowelsLowRest("vowels are fun"));
        System.out.println(capVowelsLowRest("intro"));
        System.out.println(capVowelsLowRest("yellow"));

    }

    public static String capVowelsLowRest (String string) {
        String str = "";
        for(int i = 0; i< string.length(); i++){
            char ch = string.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i'|| ch == 'o' || ch == 'u'){
                ch = ToUpper(ch);
                str += ch;
            }
            else if(ch >= 97 && ch<= 122 || ch>= 65 && ch <=90){
                ch = ToLower(ch);
                str += ch;
            }
            else{
                str += ch; 
            }

        }
        return str;
    }

    public static String camelCase (String string) {
        // Write your code here:
        return "";
    }

    public static int[] allIndexOf (String string, char chr) {
        // Write your code here:
        return new int[1];
    }


    public static char ToLower(char c){
        char ch = c;
        if(ch >='A' && ch <= 'Z'){
            ch = (char)(ch+32);
        }
        return ch;
    }
    public static char ToUpper(char c){
        char ch = c;
        if(ch >='a' && ch <= 'z'){
            ch = (char)(ch-32);
        }
        return ch;
    }
}
