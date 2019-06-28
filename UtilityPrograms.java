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
import java.util.*;
class UtilityPrograms
{
    // get all duplicate elements of a String using.
    static ArrayList getDuplicatesCharacters(String s)
    {
        ArrayList ar=new ArrayList();
        char [] ch=s.toCharArray();
        
        for(int i=0;i<=ch.length-1;i++)
        {
            for(int j=ch.length-1;j>=0;j--)
            {
                if(i!=j)
                {
                    if(ch[i]==ch[j])
                    {
                        ar.add(ch[j]);
                        break;
                    }
                }
            }
        }
        return ar;
    }
    //checking if the given String is palindrome or not.
    static boolean isTheStringPalindrome(String s)
    {
        StringBuffer sb=new StringBuffer(s);
        sb.reverse();
        String s1=sb.toString();
        System.out.println(s1);
        //String reverse_s=s.reverse();
        if(s1.equals(s))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    // checking if a given number is armstrong or not.
    static boolean isArmstrong(int n)
    {
        int Qube_sum=0;
        int m=n;
        int remainder;
         while(n!=0)
         {
            remainder=n%10;
            Qube_sum=Qube_sum+(remainder*remainder*remainder);
            n=n/10;
         }
         if(Qube_sum==m)
         {
             return true;
         }
         else
         {
             return false;
         }
    }
   // print all the armstrong numbers upto a given range.
    static ArrayList getAllArmstrongNumbers(int range)
    {
        ArrayList ar=new ArrayList();
        int Qube_sum=0;
        int remainder;
        int d=1;
        int n;
        for(int i=1;i<=range;i++)
        {
            n=i;
            while(n!=0)
            {
                remainder=n%10;
                Qube_sum=Qube_sum+(remainder*remainder*remainder);
                n=n/10;
            }
            if(Qube_sum==i)
            {
                ar.add(i);
            }
            Qube_sum=0;
            d++;
        }
         return ar;
    }
    // print the palindrome 
    static boolean getPalindromNumber(int number)
    {
        int reverse=0;
        int remainder=0;
        int n=number;
        while(number!=0)
        {
            remainder=number%10;
            reverse=reverse*10 + remainder;
            number=number/10;
        }
       if (reverse==n)
       {
           return true;
       }
       else
       {
           return false;
       }
        
    }
    public static void main (String []args)
    {
        System.out.println(UtilityPrograms.getPalindromNumber(41014));
        System.out.println();
        System.out.println(UtilityPrograms.getAllArmstrongNumbers(4000));
        System.out.println();
        System.out.println(UtilityPrograms.isArmstrong(8));
        System.out.println();
        System.out.println(UtilityPrograms.isTheStringPalindrome("sadds"));
        System.out.println();
        System.out.println(UtilityPrograms.getDuplicatesCharacters("rrtonecoarg"));
    }
}
import java.util.*;
public class HashMapDemo
{
    public static void main (String[] args)
    {
        HashMap hm=new HashMap();
        // values can be dulicated but duplicate keys are not allowed.
        hm.put("c",101);
        hm.put("a",100);
        hm.put("z",101);
        hm.put("k",140);
        hm.put("p",150);
        hm.put("l",120);
        hm.put("t",130);
        hm.put("r",1140);
        System.out.println(hm);
        //if we put a duplicate key then then that key willn't be added but the value associated with 
        //the old previous key will be changed.
        hm.put("p",200);
        System.out.println(hm);
        Set s=hm.keySet();
        System.out.println(s);
        Collection c=hm.values();
        System.out.println(c);
        Set s2=hm.entrySet();
        System.out.println(s2);
        Iterator i=s2.iterator();
        while(i.hasNext())
        {
            Map.Entry e=(Map.Entry)i.next();
            System.out.println(e.getKey()+"---"+e.getValue());
            if(e.getKey().equals("l"))
            {
                e.setValue("sssss");
            }
        }
        System.out.println(hm);
    }
}
import java.util.*;
class IdentityHashMap
{
    public static void main (String[] args)
    {
        /*
        unlike HashMap , IdentityHashMap compares duplicate keys by using "==* operator i.e. if two obects
        are are different then those objects are elligible to be inserted into IdentityHashMap.*/
        Integer i1=new Integer(10);
        Integer i2=new Integer(20);
        Integer i3=new Integer(30);
        Integer i4=new Integer(30);
        Integer i5=new Integer(10);
        Integer i6=i2;
        Integer i7=i4;
        HashMap hm=new HashMap();
        hm.put(i1,"aaa");
        hm.put(i2,"bbb");
        hm.put(i3,"ccc");
        hm.put(i4,"ttt");
        hm.put(i5,"aaa");
        hm.put(i6,"ppp");
        hm.put(i7,"qqq");
        System.out.println(hm);
    }
}
import java.util.*;
class Test
{
    public String toString()
    {
        return "Test";
    }
    public void finalize()
    {
        System.out.println("finalize method is called");
    }
}
public class WeakHashMapDemo
{
    public static void main (String[] args)
    {
        /*
        WeakHashMap is almost same as HashMap but there is a small didfderence
        
        In case of HashMap, if any object doesn't have any reference , then it isn't elligible for 
        garbage collection if that object is associated with HashMap.
        
        But in case of WeakHashMap, if any object doesn't have refernce variable then that object will
        be elligible for garbage collection eventhough that object is associated with WeakHashMap.*/
        Test t=new Test();
        HashMap hm=new HashMap();
        hm.put(t,"xyz");
        System.out.println(hm);
        t=null// here we are reassigning the value to t so now, Test object isn't associated with refernce 
        System.gc();
        System.out.println(hm);
        
        // lets see what happens in case of WeakHashMap
        Test t2=new Test();
        WeakHashMap whm=new WeakHashMap();
        whm.put(t2,"ttttt");
        System.out.println(whm);
        
        t2=null;
        System.gc();
        System.out.println(whm);
    }
}
/*
How to genetate random numbers ?

- There are 3 ways to get a random Number
                        (1) by using Random class.
                        - In this method we have to create the object of Random class which is available
                        inside java.util package.
                        - Then we have to call nextInt(int u) method through that object and this method
                        takes a parameter which is the upper limit of the Numbers i.e if we pass 10 as
                        argument then that method will return any number between 0 to 9 both inclusive
                        but we can't expect the exact output.
                        
                        (2) By using Math class.
                        -In this method we have to call random() method which is static type . This method
                        returns double value between 0.0 to 1.0. In this method we don't require to pass
                        any upper limit.
                        
                        (3) By using ThreadLocalRandom class.
                        - In this method we can get random numbers(int and double type) and random boolean values
                        - We can achieve these by using current() method which is static type.

*/import java.util.*;
class UtilityPrograms
{
    //to generate random Number
    public static int getRandomNumberUsingRandomClass(int upper_limit)
    {
        Random r=new Random();
        int random_number=r.nextInt(upper_limit);
        return random_number;
    }
    //to genetate random double values.
    public static double getRandomNumberUsingMathClass()
    {
        double random_number=Math.random();
        return random_number;
    }
    //to generate random Numbes as int type , double type and to generate random boolean values.
    public static void getRandomValueUsingThreadLocalRandomClass()
    {
        int val1=java.util.concurrent.ThreadLocalRandom.current().nextInt();
        double val2=java.util.concurrent.ThreadLocalRandom.current().nextDouble();
        boolean val3=java.util.concurrent.ThreadLocalRandom.current().nextBoolean();
        System.out.println(val1+"---"+val2+"---"+val3);
    }
    public static void main (String[] args)
    {
        System.out.println(UtilityPrograms.getRandomNumberUsingRandomClass(1000));
        System.out.println(UtilityPrograms.getRandomNumberUsingMathClass());
        UtilityPrograms.getRandomValueUsingThreadLocalRandomClass();
        
        
        //logic for fibonacci series
        int x=0;
        int y=1;
        int val=0;
       /* for (int i=0;i<=15;i++)
        {
            val=x+y;
           //System.out.print(val+" ");
            x=y;
            y=val;
            
        }*/
    }
}
