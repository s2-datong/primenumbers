package numbers.prime.samwul.myapplication.generator;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
    private int size;
    private int[] xaxis;
    private int[] yaxis;

    private List<int[]> productList;

    public PrimeNumbers(){
        this(10);
    }
    public PrimeNumbers(int size){
        this.size = size;
        xaxis = new int[this.size];
        yaxis = new int[this.size];
        productList = new ArrayList<>();
    }

    public void generate(){
        int count = 0;
        for(int i = 1; count < size; i++){
            if(isPrime(i)){
                xaxis[count] = i;
                yaxis[count] = i;
                count++;
            }
        }

        // populate list
        productList.add(xaxis);
        for(int y = 0; y < yaxis.length; y++){
            int[] products = new int[size + 1];
            products[0] = yaxis[y];
            for(int x = 0; x < xaxis.length; x++){
                products[x+1] = yaxis[y] * xaxis[x];
            }
            productList.add(products);
        }
    }

    public boolean isPrime(int x){
        if(x == 0 || x == 1){ return false; }
        if(x == 2 || x == 3 || x == 5 || x == 7){ return true;} // prime numbers less than 10

        // check for x greater than 7
        if(x % 2 == 0){ return false;}

        int loopMax = (int)Math.ceil( x / 2);
        boolean prime = true;
        for( int y = 2; y <= loopMax; y++){
            if(x % y == 0){ prime = false; return prime;}
        }

        return prime;
    }

    public int[] getGeneratedPrimes(){ return xaxis; }
    public List<int[]> getList(){ return productList; }
}
