/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeffiehellmanKeyExchange;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alamgir Hossain 
 */
public class DeffiehellmanKeyExchange {
    public int getKey(int primeNumber , int primitiveRoot , int privateKey){
       
        return (int)Math.pow(primitiveRoot, privateKey)%primeNumber;
    }
    public boolean checkPrimitiveRoot(int primeNumber , int primitiveRoot)
    {
        List<Integer> numberList = new ArrayList<>();
        
        for(int i=1;i<primeNumber;i++)
        {
            numberList.add(i);
        }
        for(int i=1;i<primeNumber;i++)
        {
            int value = (int)(Math.pow(primitiveRoot,i)%primeNumber);
           
            if(numberList.contains(value))
            {
                numberList.remove(numberList.indexOf(value));
            }
        }
        
        if(numberList.size()==0)
        {
            return true;
        }
        
        else
        {
            return false;
        }
    }
    public DeffiehellmanKeyExchange()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter A Prime Number : ");
        int primeNumber = sc.nextInt();
        
        System.out.println("Enter a Primitive Root : ");
        int primitiveRoot = sc.nextInt();
        
        if(!checkPrimitiveRoot(primeNumber , primitiveRoot))
        {
            System.out.println("Invalid Primitive Root"+primeNumber);
            System.exit(0);
        }
        System.out.println("Enter Private Key Of Alice : ");
        int privateKeyOfAlice = sc.nextInt();
        
        System.out.println("Enter Private Key Of Bob : ");
        int privateKeyOfBob = sc.nextInt();
        
        int pubicKeyOfAlice = getKey(primeNumber , primitiveRoot , privateKeyOfAlice);
        int pubicKeyOfBob = getKey(primeNumber , primitiveRoot , privateKeyOfBob);
        
        System.out.println("Public Key of Alice : "+pubicKeyOfAlice);
        System.out.println("Public Key of Bob : "+pubicKeyOfBob);
        
        System.out.println("Secret Key of Alice : "+getKey(primeNumber , primitiveRoot , privateKeyOfAlice));
        System.out.println("Secret Key of Bob : "+getKey(primeNumber , primitiveRoot , privateKeyOfBob));
        
        sc.close();
    }
    
    public static void main(String[] args) {
        new DeffiehellmanKeyExchange();
    }
}
