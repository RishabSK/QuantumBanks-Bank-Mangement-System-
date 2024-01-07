package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class acc_transac {




    public static void showdetails(int accn,String accnam,int bal){
        System.out.println("Hello "+accnam+"!");
        System.out.println("Account Balance = "+bal );
        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.println("Enter 1 for deposit");
        System.out.println("Enter 2 for withdrawal");
        System.out.println("Enter 3 for money transfer");
        System.out.println("Enter 4 for transaction history");
        System.out.println("To return back to main menu click Enter 0");
        Scanner ip = new Scanner(System.in);
        int choice = ip.nextInt();
        if(choice==0){
           Main.main(null);
        }else{
            bankoperation(choice,accn);
        }

    }
    public static void bankoperation(int choice,int accnum){
        Scanner ip = new Scanner(System.in);
        if(choice==1){
            System.out.println("Enter the amount to be deposited");
            int deposit = ip.nextInt();
            System.out.println("Enter the password");
            String pass = ip.next();
            user u = Main.accdetails.get(accnum);
            String opass = u.password;
            int obal = u.accbalance;
            if(pass.equals(opass)){
                u.accbalance=obal+deposit;
                transdet t = new transdet(u.accbalance,deposit," is deposited in the account ","-");
                Main.tdetails.add(t);
                Main.transdetails.put(u.accnumber,Main.tdetails);
                System.out.println(deposit+" deposited successfully and total balance is "+u.accbalance);
                System.out.println("--------------------------------------------------------------------");
                System.out.println();
            }else{
                System.out.println("Incorrect Password");
            }

            showdetails(u.accnumber,u.accname,u.accbalance);
        }else if(choice==2){
            //check balance before withdrawal
            System.out.println("Enter the amount to be withdrawn");
            int withdrawal = ip.nextInt();
            System.out.println("Enter the password");
            String pass = ip.next();
            user u = Main.accdetails.get(accnum);
            String opass  = u.password;
            int obal= u.accbalance;
            if(pass.equals(opass)){
                u.accbalance = obal-withdrawal;
                transdet t = new transdet(u.accbalance,withdrawal," is withdrawn from the account ","-");
                Main.tdetails.add(t);
                Main.transdetails.put(u.accnumber,Main.tdetails);
                System.out.println(withdrawal+" withdrawn successfully and total balance is "+u.accbalance);
                System.out.println("--------------------------------------------------------------------");
                System.out.println();
            }else{
                System.out.println("Incorrect Password");
            }

            showdetails(u.accnumber,u.accname,u.accbalance);
        }else if(choice==3){
            //check balance before transfer
            System.out.println("Enter the account number for money transaction");
            int acnum = ip.nextInt();
            System.out.println("Enter the amount to transfered");
            int amt = ip.nextInt();
            System.out.println("Enter the password");
            String pass = ip.next();
            user u1 = Main.accdetails.get(accnum);
            user u2 = Main.accdetails.get(acnum);
            String opass = u1.password;
            int obal = u1.accbalance;
            int tbal = u2.accbalance;
            if(Main.accdetails.containsKey(acnum)){

                if(pass.equals(opass)){
                    u2.accbalance = tbal+amt;
                    u1.accbalance = obal-amt;
                    String an = Integer.toString(acnum);
                  //  String an2 = Integer.toString(accnum);
                    transdet t = new transdet(u1.accbalance, amt," is tranferred to account number ",an);
                  //  transdet t2 = new transdet(u2.accbalance,amt," is tranferred to account number ",an2);
                    Main.tdetails.add(t);
                   // Main.tdetails.add(t2);
                    Main.transdetails.put(u1.accnumber,Main.tdetails);
                  //  Main.transdetails.put(u2.accnumber,Main.tdetails);
                    System.out.println(amt +" transferred from account number "+u1.accnumber+" to "+ u2.accnumber);
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println();
                }else{
                    System.out.println("Incorrect password");
                }
            }else{
                System.out.println("Incorrect account number for transaction");
            }

            showdetails(u1.accnumber,u1.accname,u1.accbalance);
        }else if(choice==4){
              ArrayList<transdet> t = Main.transdetails.get(accnum);
            System.out.println("Balance  "+"Transaction amount  "+"Transaction method  "+"to");
            System.out.println("-------------------------------------------------------------");
            System.out.println();
            for(transdet tr:t){

                System.out.println(" "+tr.amount+"            "+tr.tamt+"              "+tr.op+"            "+tr.to);
            }

            user u1 = Main.accdetails.get(accnum);
            System.out.println("-------------------------------------------------------------");
            System.out.println();
            showdetails(u1.accnumber,u1.accname,u1.accbalance);
        }else{
            System.out.println("Choose a correct option");
        }

    }
}
