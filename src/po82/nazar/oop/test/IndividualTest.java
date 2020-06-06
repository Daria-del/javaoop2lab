package po82.nazar.oop.test;

import org.junit.Test;
import po82.nazar.oop.model.Account;
import po82.nazar.oop.model.Client;
import po82.nazar.oop.model.Account;
import po82.nazar.oop.model.Client;
import po82.nazar.oop.model.DebitAccount;
import po82.nazar.oop.model.Individual;

import java.sql.SQLOutput;

public class IndividualTest {

    Client account;

    public IndividualTest(){
        Account[] debitAccounts = new Account[2];
        debitAccounts[0] = new DebitAccount("321", 1321);
        debitAccounts[1] = new DebitAccount("3342", 121);
        account = new Individual("Nazarenko", debitAccounts);
    }

    public void returnAccount(){
        Account[] accounts = account.getAccounts();
        for(Account account: accounts){
            System.out.println("Number: " + account.getNumber() + " Balance: " + account.getBalance());
        }
    }

    @Test
    public void getTitle() {
        System.out.println(account.getTitle());
    }

    @Test
    public void setTitle() {
        account.setTitle("Mihailov");
        getTitle();
    }

    @Test
    public void add() {
        returnAccount();

        account.add(new DebitAccount("3121", 31));
        returnAccount();

    }

    @Test
    public void testAdd() {
        returnAccount();
        System.out.println("-----------");
        account.add(new DebitAccount("3121", 31), 1);
        returnAccount();
        System.out.println("-----------");
        account.add(new DebitAccount("3235121", 31), 2);
        returnAccount();
    }

    @Test
    public void get() {

    }

    @Test
    public void testGet() {
    }

    @Test
    public void hasAccountWithNumber() {
    }

    @Test
    public void set() {
    }

    @Test
    public void remove() {
        returnAccount();
        account.remove(1);
        System.out.println("-----");
        returnAccount();
    }

    @Test
    public void testRemove() {
        returnAccount();
        account.remove("321");
        System.out.println("-----");
        returnAccount();
    }

    @Test
    public void indexOf() {
        returnAccount();
        System.out.println(account.indexOf("3342"));
    }

    @Test
    public void size() {
    }

    @Test
    public void getAccounts() {
    }

    @Test
    public void getSortedAccountsByBalance() {
        returnAccount();
        Account[] accounts = account.getSortedAccountsByBalance();

        for(Account account: accounts){
            System.out.println("Number: " + account.getNumber() + " Balance: " + account.getBalance());
        }
    }

    @Test
    public void getTotalBalance() {
        System.out.println(account.getTotalBalance());
    }
}