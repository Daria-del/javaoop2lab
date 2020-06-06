package po82.nazar.oop.model;

public class Individual implements Client{
    private String title;
    private Account[] accounts;
    private int size;


    public Individual(String title) {
        this.title = title;
        this.accounts = new Account[16];
        this.size = 0;
    }

    public Individual(int size, String title) {
        this.title = title;
        this.accounts = new Account[size];
        this.size = 0;
    }

    public Individual(String title,Account[] accounts) {
        this.title = title;
        this.accounts = accounts;
        this.size = accounts.length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean add(Account account){
        Account[] copy = new Account[accounts.length + 1];
        size++;
        System.arraycopy(accounts, 0, copy, 0, accounts.length);
        copy[accounts.length] = account;
        accounts = copy;
        return true;
    }


    public boolean add(Account account,int index){
        Account[] copy = new Account[accounts.length + 1];
        size++;

        copy[index - 1] = account;

        int i = 0, j = 0;
        while(i < copy.length){
            if(copy[i] == null){
                copy[i] = accounts[j];
                j++;
            }
            i++;
        }
        accounts = copy;
        return true;
    }

    public Account get(int index){
        return accounts[index];
    }

    public Account get(String number){
        for(int i = 0; i<size;i++){
            if(accounts[i].checkNumber(number)) return accounts[i];
        }
        return null;
    }

    public boolean hasAccountWithNumber(String number){
        for(int i = 0; i<size;i++){
            if(accounts[i].checkNumber(number)) return true;
        }
        return false;
    }

    public Account set(Account account,int index){
        Account buf = accounts[index];
        accounts[index] = account;
        return buf;
    }

    public Account remove(int index){
        Account[] copy = new Account[accounts.length - 1];
        Account deletedAccount = accounts[index - 1];

        int i = 0, j = 0;

        while(i < accounts.length){
            if(i != index - 1){
                copy[j] = accounts[i];
                j++;
            }
            i++;
        }
        accounts = copy;
        return deletedAccount;
    }

    public Account remove(String number){
        Account[] copy = new Account[accounts.length - 1];
        Account deletedAccount = null;

        int i = 0, j = 0;

        while(i < accounts.length){
            if(!accounts[i].getNumber().equals(number)){
                copy[j] = accounts[i];
                j++;
            } else {
                deletedAccount = accounts[i];
            }
            i++;
        }
        accounts = copy;
        return deletedAccount;
    }

    public int indexOf(String number){
        for(int i = 0; i<size;i++){
            if(accounts[i].getNumber().equals(number)) return i;
        }
        return -1;
    }

    public int size(){
        return size;
    }

    public Account[] getAccounts(){
        return accounts;
    }

    public Account[] getSortedAccountsByBalance(){
        for(int i = 0; i<accounts.length;i++){
            for(int j = 0; j<accounts.length-1;j++){
                if(accounts[j].getBalance() > accounts[j+1].getBalance()){
                    Account tmp = accounts[j];
                    accounts[j] = accounts[j+1];
                    accounts[j+1] = tmp;
                }
            }
        }
        return accounts;
    }

    public double getTotalBalance(){
        double totalBalance = 0;
        for(int i = 0; i<size;i++){
            totalBalance+=accounts[i].getBalance();
        }
        return totalBalance;
    }
}
