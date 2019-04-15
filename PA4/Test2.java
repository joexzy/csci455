import java.util.ArrayList;
import java.util.Arrays;

public class Test2{
   public static void main(String[] args){
      String str = "cba";
      String[] s = new String[str.length()];
      for(int i = 0; i < s.length; i++){
         s[i] ="" + str.charAt(i);
         System.out.println(s[i]);
      }
      
      Arrays.sort(s);
      System.out.println(Arrays.toString(s));
      
      char a = 'a';
      int x;
      x = a - 'a';
      System.out.println(x);
      
      String s2 = "abc";
      String s3 = s2.toLowerCase();
      System.out.println(s3);
   }
}