package domain.entities;

import java.util.ArrayList;

public class Store {
    private String companyName; //Razão social
    private String tradingName; //Nome fantasia
    private String cnpj;
    private Address address;
    private ArrayList<Client> clients;
    private ArrayList<SalesPerson> salesPeople;

    public Store(String companyName, String tradingName, String cnpj, Address address) {
        this.companyName = companyName;
        this.tradingName = tradingName;
        this.cnpj = cnpj;
        this.address = address;
        this.clients = new ArrayList<>();
        this.salesPeople = new ArrayList<>();
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getTradingName() {
        return tradingName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Address getAddress() {
        return address;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<SalesPerson> getSalesPeople() {
        return salesPeople;
    }

    public int countClients(){
        return clients.size();
    }

    public int countSalesPeople(){
        return salesPeople.size();
    }

    public void introduceSelf(){
        System.out.println("Loja: "
                .concat(companyName)
                .concat(" CNPJ: ")
                .concat(cnpj)
                .concat(" Endereço: ")
                .concat(address.toString()));
    }

    public void addClient(Client client){
        if(clients.contains(client)){ return; }
        clients.add(client);
    }

    public void addSalesPerson(SalesPerson salesPerson){
        if(salesPeople.contains(salesPerson)){ return; }
        salesPeople.add(salesPerson);
    }
}
