import java.util.ArrayList;
import java.util.Arrays;

public class RackTest{
   public static void main(String[] args){
      Rack a = new Rack("calm");
      //a.getAllSubsets();
      String b = a.getAllSubsets().toString();
      System.out.println(b);
   }
}