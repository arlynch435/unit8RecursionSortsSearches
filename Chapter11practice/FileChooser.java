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
            in.useDelimiter(" ");
            Scanner linechecker=new Scanner(text);
            in.useDelimiter("\n");
           int wordCount=0;
           int lines=0;
           int letters=0;
            while (in.hasNext())
            {
                wordCount++;
            }
            System.out.println("Words: "+wordCount);
            while (linechecker.hasNext())
            {
                lines++;
            }
            System.out.println("Lines: "+lines);
      }
      catch(IOException exception)
      {
          System.out.println(exception);
        }
    }

}
