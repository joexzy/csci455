import java.util.ArrayList;
import java.io.FileNotFoundException;

public class DictionaryTester{
   public static void main(String[] args){
      try{
         AnagramDictionary dic = new AnagramDictionary("sowpods.txt");
         ArrayList<String> x = dic.getAnagramsOf("aestnlr");
         for(int i = 0; i < x.size(); i++){
            System.out.println(x.get(i));
         }
      }
      catch(FileNotFoundException exception){
         System.out.println("file not found");
      }
      
      
      
   }
}