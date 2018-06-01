/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbit;

import javax.swing.JOptionPane;

/**
 *
 * @author Ali Hassan
 */
public class RSA_Algorithm implements Algorithm{

    private int p =0;
    private int q =0;
    private int n =0;
    private int D;
    
    private int [] message;
    private int [] cipher;
    private int[] decrypt;
    private char[] text;
    
    

    public RSA_Algorithm() {
    }
    /**
     * this method take First No  
     */
    
    private void SetP(){
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        String message = JOptionPane.showInputDialog(null,"Enter any number [Warning no must be even]");
        p = Integer.parseInt(message);
    }
    
    /**
     * this method take Second No  
     */
    
    private void SetQ(){
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        String message = JOptionPane.showInputDialog(null,"Enter any number [Warning no must be even]");
        q = Integer.parseInt(message);
    }
    
    /**
     * this method implement RSA Algorithm 
     * user just call this method 
     */
    
    @Override
    public void getInstance(){
        System.out.println("Data encrytion.....");
        SetP();
        SetQ();
        RSA algo = new RSA(p, q);
        n = algo.ProductOfPrimeNo();
        algo.ProductOfPrevNo();
        algo.encryptedKey();
         message = algo.messageIntoIntergers(algo.message());
         cipher = algo.CipherText(message, n);
         D =  algo.Decrypted();
         decrypt = algo.DecryptedMessage(message, n,D);
         text = algo.ConvertBackToChar(decrypt);
         CipherText();
         System.out.println("Data encryted..");
    }
    
    /**
     * this method printed Decrypted message developer 
     * use this function for  
     * output
     */
    @Override
    public void DecryptedText(){
               for(int i =0; i < message.length; i++){
                System.out.print(text[i] );
            }
    }
    
    /**
     * this method call by getInstance() so don't worry about this
     */
    
    @Override
    public void CipherText(){
        for (int i = 0; i < message.length; i++) {
            System.out.print(cipher[i]);
        }
        System.out.println("");
    }
    
    
    
    
}
