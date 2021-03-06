package po82.nazar.oop.model;

public class AccountManager {
    private Client[] clients;
    private int size;

    public AccountManager(int size) {
        this.clients = new Client[size];
        this.size = 0;
    }

    public AccountManager(Client[] clients) {
        this.clients = clients;
        this.size = clients.length;
    }

    public boolean add(Client client){
        Client[] copy = new Client[clients.length + 1];
        size++;
        System.arraycopy(clients, 0, copy, 0, clients.length);
        copy[clients.length] = client;
        clients = copy;
        return true;
    }



    public boolean add(Client client, int index){
        Client[] copy = new Client[clients.length + 1];
        size++;

        copy[index - 1] = client;

        int i = 0, j = 0;
        while(i < copy.length){
            if(copy[i] == null){
                copy[i] = clients[j];
                j++;
            }
            i++;
        }
        clients = copy;
        return true;
    }

    public Client get(int index){
        return clients[index];
    }

    public Client set(Client client, int index){
        Client buf = clients[index];
        clients[index] = client;
        if(buf == null && client != null) size++;
        if(buf!=null && client == null) size--;
        return buf;
    }

    public Client remove(int index){
        Client[] copy = new Client[clients.length - 1];
        Client deletedAccount = clients[index - 1];

        int i = 0, j = 0;

        while(i < clients.length){
            if(i != index - 1){
                copy[j] = clients[i];
                j++;
            }
            i++;
        }
        clients = copy;
        return deletedAccount;
    }

    //Возвращат число физ. лиц
    public int size(){
        return size;
    }

    public Client[] getClients(){
        return clients;
    }

    public Client[] getSortedIndividualsByTotalBalance(){
        Client[] buf = getClients();
        for(int i = 0; i<buf.length;i++){
            for(int j = 0; j<buf.length-1;j++){
                if(buf[j].getTotalBalance() > buf[j+1].getTotalBalance()){
                    Client tmp = buf[j];
                    buf[j] = buf[j+1];
                    buf[j+1] = tmp;
                }
            }
        }
        return buf;
    }

    public Account getAccountWithNumber(String number){
        for(Client client: clients){
            if(client.get(number) != null){
                return client.get(number);
            }
        }
        return null;
    }

    public Account removeAccount(String number){
        for(Client client: clients){
            if(client.get(number) != null){
                Account removeAccount = client.get(number);
                client.remove(number);
                return removeAccount;
            }
        }
        return null;
    }

    public Account setAccount(Account account,String number){
        for(Client client: clients){
            if(client.get(number) != null){
                return client.set(account,client.indexOf(number));
            }
        }
        return null;
    }
}
