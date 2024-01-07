package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static HashMap<Integer, user> accdetails = new HashMap<>();
    static ArrayList<transdet> tdetails = new ArrayList<>();
    static HashMap <Integer,ArrayList<transdet>> transdetails = new HashMap<>();
    public static  void selection(int userchoice){
        Scanner ip = new Scanner(System.in);
        switch ((userchoice)) {
            case 1: {
                System.out.println("Enter the accountnumber");
                int accnum = ip.nextInt();
                // user u = new user(name);
                if (accdetails.containsKey(accnum)) {
                    System.out.println("Enter the password");
                    String pass = ip.next();
                    user u = accdetails.get(accnum);
                  //  System.out.println(u.password);
                    if (pass.equals(u.password) ){
                       // System.out.println(accdetails.get(1));

                        acc_transac atc = new acc_transac();
                         atc.showdetails(accnum, u.accname, u.accbalance);

                    } else {
                        System.out.println("Incorrect Password,Enter a valid Password");
                        System.out.println();
                    }

                }else{
                    System.out.println("Incorrect accountnumber");
                    System.out.println();
                }

            }break;

            case 2: {
                System.out.println("Enter your Name");
                String uname = ip.next();
                System.out.println("Enter your Password");
                String upass = ip.next();

                user u = new user(uname,upass);

                accdetails.put(u.accnumber,u);
                System.out.println("Your Account number is "+u.accnumber);
                System.out.println();
                System.out.println("Your account is created successfully now sign-in");

            }break;

            case 3: {
                System.out.println("in progress");
            }break;


        }
        System.out.println("To return back to main menu click Enter 0");
        int op=ip.nextInt();
        if(op==0){
            main(null);
        }
    }
    public static void main(String[] args) {
        // write your code here

       // System.out.println(accdetails.get(1));
        Scanner ip = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to Quantum Bank");
            System.out.println("Enter 1 to sign-in");
            System.out.println("Enter 2 to create account");
            System.out.println("Enter 3 to Admin account");
            int userchoice = ip.nextInt();
           selection(userchoice);

        }
    }
}
