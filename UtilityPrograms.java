  public class NumPatterns
  {
      public static void displayTheBinaryPatterns()
      {
          for(int i=1;i<=7;i++)
          {
              for(int j=1;j<=i;j++)
              {
                  if(j%2==0)
                  {
                      System.out.print("0 ");
                  }
                  else
                  {
                      System.out.print("1 ");
                  }
              }
              System.out.println();
          }
      }
/*
1
1 0
1 0 1
1 0 1 0
1 0 1 0 1
1 0 1 0 1 0
1 0 1 0 1 0 1
*/
      public static void displayThePattern2()
      {
          for(int i=1;i<=5;i++)
          {
              for (int j=i;j>=1;j--)
              {
                  System.out.print(j+" ");
              }
              System.out.println();
          }
      }
      public static void main(String [] args)
      {
          NumPatterns.displayTheBinaryPatterns();
          System.out.println();
          NumPatterns.displayThePattern2();
      }

  }
  /*
How to create our own immutale class :
--------------------------------------
- Once we create an object, we can't perform any change to the excisting object. If we try to
perform any change then with those cahnges a nwe object will be created. This is known as
immutability.
- We can create cutomized immutale object.
- In the following application we are overriding equals() method,toString() method 
, so that we can compare objects based on content comparison and whenever we try to 
print the reference variable of the object, instead of printing the hashcode it will
print the content.
*/

public class ImmutableObject
{
    private int i;
    ImmutableObject(int i)
    {
        this.i=i;
    }
    public boolean equals(Object o)
    {
        if(o instanceof ImmutableObject)
        {
            ImmutableObject io=(ImmutableObject)o;
            
            if(this.i==io.i)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    public String toString()
    {
        Integer in=new Integer(i);
        return in.toString();
    }
    public ImmutableObject modify(int i)
    {
        if(this.i==i)
        {
            return this;
        }
        else
        {
            return new ImmutableObject(i);
        }
    }
    public static void main(String []args)
    {
        ImmutableObject io1=new ImmutableObject(10);
        ImmutableObject io2=new ImmutableObject(20);
        ImmutableObject io3=new ImmutableObject(10);
        
        ImmutableObject io4=io1.modify(50);
        ImmutableObject io5=io1.modify(20);
        
        System.out.println(io1==io2);
        System.out.println(io1.equals(io2));
        System.out.println(io1==io3);
        System.out.println(io1.equals(io3));
        System.out.println(io1==io4);
        System.out.println(io2.equals(io4));
        System.out.println(io2==io5);
        System.out.println(io3.equals(io5));
        System.out.println(io2.equals(io5));
        
        
        
        System.out.println(io1);
        System.out.println(io2);
        System.out.println(io3);
        System.out.println(io4);
        /*
        false
        false
        false
        true
        false
        false
        false
        false
        10
        20
        10
        50
        */
        
    }
}
/*
 Write a Java Program to reverse a string without using String inbuilt function.
 */
 public class StringReverse
 {
     public static String reverse(String str)
     {
         int len=str.length();
         char [] ch=new char[len];
         for(int i=len-1;i>=0;i--)
         {
             ch[i]=str.charAt(i);
         }
         String reverse_string="";
         for(int i=len-1;i>=0;i--)
         {
             reverse_string=reverse_string.concat(String.valueOf(ch[i]));
         }
         return reverse_string;
     }
     public static void main(String [] args)
     {
         String str="reverse me";
         String reverse_string=StringReverse.reverse(str);
         System.out.println(reverse_string);
     }
 }
/*
(1)  Check whether two Strings are anagrams or not ?
anagrams : If Two Strings have same and identical characters then both String are
said to be anagrams.

ex: -Listen, Silent (ignore the case of the letters)
    - state, taste
*/
import java.util.*;

class UtilityPrograms
{
    // checking if two Strings are anagrams or not ?
    static boolean areAnagrams(String s1,String s2)
    {
        if(s1.length()!=s2.length())
        {
            return false;
        }
        else
        {
            char [] ch1=s1.toCharArray();
            char [] ch2=s2.toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            String str1=new String(ch1);
            String str2=new String(ch2);
            
            if(str1.equalsIgnoreCase(str2))
            {
                return true;   
            }
            else
            {
                return false;
            }
        }
    }
    
    
    // to get all prime numbers upto a given range using arrayList.
    static ArrayList getTotalPrimeNumbers(int range)
    {
        ArrayList<Integer> PrimeNos=new ArrayList<Integer>();
        for(int i=1;i<=range;i++)
        {
            int total_divisors=0;
            for(int j=i;j>=1;j--)
            {
                if(i%j==0)
                {
                   total_divisors++; 
                }
            }
            if(total_divisors==2)
            {
                PrimeNos.add(i);
            }
        }
         return PrimeNos;
    }
    public static void main(String [] args)
    {
        boolean b;
        int range;
        
        try(Scanner scan=new Scanner(System.in))
        {
            String s1=scan.nextLine();
            String s2=scan.nextLine();
            range=scan.nextInt();
            b=UtilityPrograms.areAnagrams(s1,s2);
            if(b==true)
            {
                System.out.println("Both Strings are anagrams");
            }
            else
            {
                System.out.println("Both Strings are not anagrams");
            }
        }
        System.out.println(UtilityPrograms.getTotalPrimeNumbers(range));
    }
}
