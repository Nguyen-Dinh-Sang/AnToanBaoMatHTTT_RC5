package javaapplication14;

import java.io.*;
public class RC5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Encryption");
        RC5Enc enc = new RC5Enc();
        enc.encrypt();
        System.out.println("Encryption");
        RC5Dec dec = new RC5Dec();
        dec.decrypt();
    }
}
