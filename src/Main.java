import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;

/**
 * Created by palah on 24.05.2017.
 */
public class Main
{
    public static void main(String[] args) {
        try {
            OutputStream out = new FileOutputStream("out.txt") ;
            String result =String.valueOf(getSumOf(100)+ " " + correctBracket(15 ,3));
            out.write(result.getBytes());
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private static long getSumOf(int n) {
        //initialiaze variable which will have value of factorial 100
        BigInteger fact = BigInteger.ONE;
        //get value of  factorial 100
        fact =  factorial(BigInteger.valueOf(n));
        //initialiaze variable which will have value of sum of digits

        long sum = 0;

        while (fact.compareTo(BigInteger.ZERO) > 0) {
            // sum will have value of real remainder of division by 10
            sum += fact.mod(BigInteger.TEN).longValue();
            // value of factorial becoming less becouse of divide by 10
            fact = fact.divide(BigInteger.TEN);
        }
        return sum;
    }
    private static BigInteger factorial(BigInteger n  )
    {
        if (n.compareTo(BigInteger.ZERO)==0){
        return BigInteger.ONE ; }
        else
            {
                return   factorial(n.subtract(BigInteger.ONE)).multiply(n) ;
            }
    }
    private  static  int correctBracket(int open , int close)
    {        Integer pairs = 0 ;
        //making pairs with open and close bracket
        if (open > close )
        {
            pairs =  close ;
        }
        if(close > open )
        {
         pairs = open ;
        }
        if (open==close )
        {
            pairs = open  ;
        }


        return (int)catalan(pairs) ;
    }
    //special method which calculate Catalan's numbers
   public static int catalan(int n)
    {
        int [] array = new int[n+1] ;

        array[0]=1;
        for (int m=1; m<=n; ++m)   // Вычисляем C[m] для m=1..n
        {
            array[m]=0;
            for (int k=0; k<m; ++k)
                array[m]+=array[k]*array[m-1-k];
        }
        return array[n];
    }
}
