import java.util.Scanner;
import java.io.*;
public class FileChooser
{
    public static void main(String[] args)
    {
        try
        {
            Scanner user=new Scanner(System.in);
            System.out.println("Enter the name of the file");
            String fileName=user.next();
            File text=new File(fileName);
            Scanner in=new Scanner(text);
            Scanner linechecker=new Scanner(text);
            linechecker.useDelimiter("\n");
            Scanner charChecker=new Scanner(text);
            charChecker.useDelimiter("");
           int wordCount=0;
           int lines=0;
           int letters=0;
            while (in.hasNext())
            {
                String word=in.next();
                wordCount++;
            }
            System.out.println("Words: "+wordCount);
            while (linechecker.hasNext())
            {
                String line=linechecker.next();
                lines++;
            }
            System.out.println("Lines: "+lines);
            while (charChecker.hasNext())
            {
                String letter=charChecker.next();
                letters++;
            }
            System.out.println("Letters: "+letters);
            in.close();
            linechecker.close();
            charChecker.close();
      }
      catch(IOException exception)
      {
          System.out.println(exception);
        }
    }

}
