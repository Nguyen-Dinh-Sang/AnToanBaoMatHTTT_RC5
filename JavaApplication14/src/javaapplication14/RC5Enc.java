package javaapplication14;

import java.io.*;

public class RC5Enc {

    public void encrypt() throws Exception{
        KeyExp ke = new KeyExp();                
        String s[] = ke.compute();
        System.out.println("Enter Input");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("a = ");
        String a = fullfill0(Long.toBinaryString(Long.parseLong(br.readLine(), 16)));
        System.out.print("b = ");
        String b = fullfill0(Long.toBinaryString(Long.parseLong(br.readLine(), 16)));
        a = add(a, fullfill0(s[0]));
        b = add(b, fullfill0(s[1]));
        int tmp = 0;
        for (int i = 1; i <= 12; i++) {                
            tmp = Integer.parseInt(""+Long.parseLong(b,2)%32);             
            a = xor(a, b);           
            a = a.substring(tmp)+a.substring(0,tmp);
            a = add(a, fullfill0(s[2 * i]));          
            tmp = Integer.parseInt(""+Long.parseLong(a,2)%32);
            b = xor(b, a);
            b = b.substring(tmp)+b.substring(0,tmp);
            b = add(b, fullfill0(s[(2 * i)+1]));
            System.out.println(i+" iteration = "+(Long.toHexString(Long.parseLong(a,2)))+ " --- " +(Long.toHexString(Long.parseLong(b,2))));
        }        
        String out = a+b;
        System.out.println("Output = "+(Long.toHexString(Long.parseLong((out.substring(0,32)),2)))+ " --- " +(Long.toHexString(Long.parseLong((out.substring(32)),2))));
    }
    public String fullfill0(String x) {
        return (get0(32-x.length())+ x);
    }
    
    public String xor(String x, String y) {
        String result = "";
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == y.charAt(i)) {
                result += "0";
            } else {
                result += "1";
            }

        }
        return result;
    }

    public String get0(int len) {
        String result = "";
        for (int i = 0; i < len; i++) {
            result += "0";
        }
        return result;
    }

    public String add(String x, String y) {
        String result = "";
        boolean carry = false;
        for (int i = x.length()- 1; i >= 0; i--) {                      
            if((x.charAt(i) == y.charAt(i) && carry == false)|| (x.charAt(i) != y.charAt(i)  && carry == true)){
                result = "0"+result;                
            }else{
                result = "1"+result;
            }
            if((x.charAt(i) == '1' && y.charAt(i) == '1') || 
                    (x.charAt(i) == '1' && y.charAt(i) == '1' && carry == true) || 
                    (x.charAt(i) !=  y.charAt(i) && carry == true)){carry = true;}
            else{carry = false;}
        }       
        return result;
    }
}
        /*String s[] = {Long.toBinaryString(Long.parseLong("9BBBD8C8", 16)),
            Long.toBinaryString(Long.parseLong("1A37F7FB", 16)),
            Long.toBinaryString(Long.parseLong("46F8E8C5", 16)),
            Long.toBinaryString(Long.parseLong("460C6085", 16)),
            Long.toBinaryString(Long.parseLong("70F83B8A", 16)),
            Long.toBinaryString(Long.parseLong("284B8303", 16)),
            Long.toBinaryString(Long.parseLong("513E1454", 16)),
            Long.toBinaryString(Long.parseLong("F621ED22", 16)),
            Long.toBinaryString(Long.parseLong("3125065D", 16)),
            Long.toBinaryString(Long.parseLong("11A83A5D", 16)),
            Long.toBinaryString(Long.parseLong("D427686B", 16)),
            Long.toBinaryString(Long.parseLong("713AD82D", 16)),
            Long.toBinaryString(Long.parseLong("4B792F99", 16)),
            Long.toBinaryString(Long.parseLong("2799A4DD", 16)),
            Long.toBinaryString(Long.parseLong("A7901C49", 16)),
            Long.toBinaryString(Long.parseLong("DEDE871A", 16)),
            Long.toBinaryString(Long.parseLong("36C03196", 16)),
            Long.toBinaryString(Long.parseLong("A7EFC249", 16)),
            Long.toBinaryString(Long.parseLong("61A78BB8", 16)),
            Long.toBinaryString(Long.parseLong("3B0A1D2B", 16)),
            Long.toBinaryString(Long.parseLong("4DBFCA76", 16)),
            Long.toBinaryString(Long.parseLong("AE162167", 16)),
            Long.toBinaryString(Long.parseLong("30D76B0A", 16)),
            Long.toBinaryString(Long.parseLong("43192304", 16)),
            Long.toBinaryString(Long.parseLong("F6CC1431", 16)),
            Long.toBinaryString(Long.parseLong("65046380", 16))
        };        */