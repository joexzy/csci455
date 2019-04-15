import java.util.ArrayList;
import java.io.FileNotFoundException;

public class SorterTester{
   public static void main(String[] args){
      try{
      Rack r = new Rack("aestnrl");
      AnagramDictionary dictionary = new AnagramDictionary("sowpods.txt");
      WordSorter a = new WordSorter(r, dictionary);
      ArrayList<String> arr = new ArrayList<>(a.wordSort());
      
      for(int i = 0; i < arr.size(); i++){
         System.out.println(i+1 + arr.get(i));
      }
      }
      catch(FileNotFoundException e){
         System.out.println("aaaa");
      
      
   }
}
}