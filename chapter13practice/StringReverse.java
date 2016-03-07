public class StringReverse
{
    public static String reverse(String text)
    {
        //terminating case
        if(text.length()==1)
        {
            return text;
        }
        //logique
        char c=text.charAt(0);
        String rest=text.substring(1);
        //actual recursive piece
        String reverseText=reverse(rest);
        reverseText+=c;
        return reverseText;
    }
    public static String reverse2(String text)
    {
        String reverseText="";
        for (int i=text.length()-1;i>=0;i--)
        {
            char c= text.charAt(i);
            reverseText+=c;
        }
        return reverseText;
    }
    public static void main(String[] args)
    {
        System.out.println(StringReverse.reverse("Hello!"));
        System.out.println(StringReverse.reverse2("Hello!"));
        System.out.println("Expected: !olleH");
    }
}