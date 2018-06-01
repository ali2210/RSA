/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbit;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Ali Hassan
 */
public class RSA {

            private int p = 0;
            private int q = 0;
            private int e = 0;
            private int $N = 0;

    // prime no's set through constructor
    public RSA(int p, int q) {
        this.p = p;
        this.q = q;
    }
    
    
    /**
             *this method return product of two prime no which 
             * is used in encryption for more 
             * information read RSA Algorithm or RSA encryption 
             * technique in cryptography
             * if the numbers are not even then it's throws exception
     * @return 
             */
    
    public int ProductOfPrimeNo(){
        Exception failure = null;
        
        if((p+1)%2 == 0 && (q+1)%2 == 0)
            throw new RuntimeException("Invalid information", failure);
        else
            return p * q;
        
    }
                
    
    /**
     * this method same like Product of two prime numbers
     * but it take product of previous values for more information check the 
     * implementation
     */
    
    public void ProductOfPrevNo(){
        Exception failure = null;
        
        if((p-1) > 0 && (q-1) > 0)
            $N = ((p-1) * (q-1));
        else
            throw new RuntimeException("Numbers must be positive", failure);
    } 
    
    /**
     * this method generate encrypted Key
     */
   
    public void encryptedKey(){
        Random random = new Random();
        
        e = random.nextInt(1024);
        if(e == 0)
            encryptedKey();
        
    }
    
    /**
     * this method convert message into Integers array 
     * @param meString
     * @return 
     * 
     */
    
    public int[] messageIntoIntergers(String meString){
        char[] array = meString.toCharArray();
        
        int[] convert = new int[meString.length()];
        for (int i = 0; i < meString.length(); i++) {
            convert[i] = (int) array[i];
        }
        return convert;
    }
    
    /**
     * this method convert into cipher Text which is helpful 
     * in cryptography Algorithm RSA 
     * 
     * @param messagetoIntegers
     * @param productOfPrime
     * @return 
     */
    
    public int[] CipherText(int[] messagetoIntegers, int productOfPrime){
        int[] cipherText = new int[messagetoIntegers.length];
        
        for (int i = 0; i < cipherText.length; i++) {
            cipherText[i] = ((messagetoIntegers[i]^e)% productOfPrime);
        }
        return cipherText;
    }
    
    /**
     * this method return decrypted "D" 
     * D is used in decryption of text
     * @return 
     */
    public int Decrypted(){
        
        return Math.abs((1/e)%$N);
    }
    
    /**
     * this method take encrypted message , product of prime no and decrypted key 
     * and then convert into decrypted form [ for more information see decryption on RSA]
     * @param message
     * @param N
     * @param D
     * @return 
     */
    public int[] DecryptedMessage(int[] message , int N, int D){
        int[]decrypt = new int[message.length];
        
        for(int i =0; i < message.length; i++){
            decrypt[i] = (message[i]^(e * D)%N);
        }
        return decrypt;
    }
    
    /**
     * This method is simple convert Integers back to Characters
     * @param decrypt
     * @return 
     */
    public char[] ConvertBackToChar(int[] decrypt){
        char[] convert = new char[decrypt.length];
        
        for (int i = 0; i < convert.length; i++) {
            convert[i] = (char)decrypt[i];
            
        }
        return convert;
    }
    
    /**
     * [simple take input]
     * @return 
     */
    public String message(){
       return JOptionPane.showInputDialog(null, "Enter any Message which you want to convert");
    }
    
}
