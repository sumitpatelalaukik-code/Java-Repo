import java.util.Scanner;

class Utilities{

    void reverseString(String a){
        String originalString = a;
        int i = 0;
        int j = a.length() - 1;
        char[] arr = a.toCharArray();
        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        String reversedString = new String(arr);
        System.out.println("Reversed String: " + reversedString);

        isPalindrome(originalString, reversedString);
    }

    void isPalindrome(String originalString, String reversedString){
        if(originalString == reversedString) System.out.println("String is a Palindrome");
        else System.out.println("String is not a Palindrome");
    }

    void countCharacters(String a){
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            count++;
        }
        System.out.println("Number of Characters: " + count);
    }

    void countWords(String a){
        int count = 1;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) == ' '){
                count++;
            }
        }
        System.out.println("Number of Words: " + count);
    }

    void removeDuplicates(String a){
        String result = "";
        for(int i = 0; i < a.length(); i++){
            char ch = a.charAt(i);
            if(result.indexOf(ch) == -1){
                result += ch;
            }
        }
        System.out.println("String without Duplicates: " + result);
    }
}

class TextProcessingUtility{
    public static void main(String[] args){
        Utilities s1 = new Utilities();
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the String : ");
        String str = s.nextLine();

        s1.reverseString(str);
        s1.countCharacters(str);
        s1.countWords(str);
        s1.removeDuplicates(str);
    }
}