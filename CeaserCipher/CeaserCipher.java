
package CeaserCipher;

import java.util.Scanner;

public class CeaserCipher {
    public String getCiperText(String plainText,int shift){
        String cipherText = "";
        for(int i=0;i<plainText.length();i++){
            if(Character.isUpperCase(plainText.charAt(i))){
                char ch = (char)(((int)plainText.charAt(i)+shift-65)%26+65);
                cipherText = cipherText + ch;
            }
            else {
                char ch = (char)(((int)plainText.charAt(i)+shift-97)%26+97);
                cipherText = cipherText + ch;
            }
        }
        return cipherText;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Plaintext : ");
        String inputString = sc.next();
        System.out.print("Shift : ");
        int shift = sc.nextInt();
        System.out.println("Ciper Text = "+new CeaserCipher().getCiperText(inputString, shift));
        sc.close();
    }
        
    }

