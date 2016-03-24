import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BabyNames
{
   public static final double LIMIT = 50;

   public static void main(String[] args) throws FileNotFoundException
   {  
      File babies=new File("babynames80s.txt");
//        Scanner in = new Scanner(new File("babynames.txt"));
       Scanner topBaby=new Scanner(babies);
      Scanner lineChecker=new Scanner(babies);
      lineChecker.useDelimiter("\n");
      int lines=0;
      while (lineChecker.hasNext())
      {
        String line=lineChecker.next();
        lines++;
      }
      int topHalf=lines/2 *5;
      for (int i=0;i<topHalf; i++)
      {
        String line=topBaby.next();
        System.out.print(line);
      }
      
//       RecordReader boys = new RecordReader(LIMIT);
//       RecordReader girls = new RecordReader(LIMIT);
//       
//       while (boys.hasMore() || girls.hasMore())
//       {
//          int rank = in.nextInt();
//          System.out.print(rank + " ");
//          boys.process(in);
//          girls.process(in);
//          System.out.println();
//       }
      topBaby.close();
      lineChecker.close();
//       in.close();
   }
}   
