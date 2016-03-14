import java.util.*;

public class ListMethods
{
   public static ArrayList<Integer> makeList(int n)
   {
      ArrayList<Integer> tempList = null;
      if (n <= 0)  // The smallest list we can make
      {
          tempList=new ArrayList<Integer>();
      }
      else        // All other size lists are created here
      {
          tempList=makeList(n-1);
          tempList.add(n);
      }
      return tempList;
   }
   public static ArrayList<Integer> deepClone(ArrayList<Integer> tList)
    {
       ArrayList<Integer> list = new ArrayList<Integer>(); 
       for (Integer i : tList)
       {
          list.add(new Integer(i));
       }
       return list;
    }
   public static ArrayList<Integer> reverseList(ArrayList<Integer> tList)
    {
       ArrayList<Integer> list = ListMethods.deepClone(tList); 
       if (list.size()<=1)// The list is empty or has one element
       {
          return list;
       }
       else
       {
          // Use the solution to a smaller version of the problem
          int n= list.get(0);
          list.remove(0);
          list=reverseList(list);
          list.add(n);
          // to solve the general problem
       }
       return list;
    }
   public static ArrayList<Integer> even(ArrayList<Integer> tList)
   {
       ArrayList<Integer> list = ListMethods.deepClone(tList);
       if (list.size()<=1)
       {
           return list;
        }
        else
        {
            int n=list.get(0);
            list.remove(0);
            list.remove(0);
            list=even(list);
            list.add(0,n);
        }
        return list;
    }
    public static void main(String[] args)
   {
      ArrayList<Integer> tempList = ListMethods.makeList(100);
      if (tempList.size() == 0)
      {
          System.out.println("The list is empty");
      }
      else
      {
         for (Integer i : tempList)
         {
            System.out.println(i);
         }
      }
      tempList=ListMethods.reverseList(tempList);
      if (tempList.size() == 0)
      {
          System.out.println("The list is empty");
      }
      else
      {
         for (Integer i : tempList)
         {
            System.out.println(i);
         }
      }
      tempList=ListMethods.reverseList(tempList);
      tempList=ListMethods.even(tempList);
      if (tempList.size() == 0)
      {
          System.out.println("The list is empty");
      }
      else
      {
         for (Integer i : tempList)
         {
            System.out.println(i);
         }
      }
   }
}
