package com.company;

public class user {
    static int number=1;
    int accnumber;
    String accname;
    int accbalance;
    String password;

     public user(String accname,String password){
        this.accnumber = number++;
        this.accname = accname;
        this.accbalance = 0;
        this.password = password;
    }
}
