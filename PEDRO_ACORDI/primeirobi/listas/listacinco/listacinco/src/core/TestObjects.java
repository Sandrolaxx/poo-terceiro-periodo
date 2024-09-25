package core;

import entities.Address;
import entities.Client;
import entities.SalesPerson;
import entities.Store;

public class TestObjects {
    public static void main(String[] args) {
        Store store = createStore("Gabrielinha & CIA LTDA",
                "Loja da Dona Gabrielinha",
                "34.524.449/0001-70",
                createAddress("Rua das Flores", "Centro", "Cascavel")
        );

        SalesPerson sellerJoao = createSalesPerson("João",
                27,
                createAddress("Avenida Brasil", "Centro", "Cascavel"),
                store,
                2500.40
        );
        store.addSalesPerson(sellerJoao);

        SalesPerson sellerJoana = createSalesPerson("Joana",
                20,
                createAddress("Rua Vinicius de Moraes", "Floresta", "Cascavel"),
                store,
                3000.00
        );
        store.addSalesPerson(sellerJoana);


        Client clientErick = createClient( "Erick",
                20,
                createAddress("Rua Manaus", "Centro", "Cascavel")
        );
        store.addClient(clientErick);


        store.introduceSelf();
        sellerJoao.introduceSelf();
        sellerJoana.introduceSelf();
        clientErick.introduceSelf();
    }

    private static SalesPerson createSalesPerson(String name, int age, Address address, Store store, double grossSalary) {
        return new SalesPerson(name, age, address, store, grossSalary);
    }

    private static Address createAddress(String street, String neighborhood, String city){
        return new Address(street, neighborhood, city);
    }

    private static Store createStore(String companyName, String tradingName, String cnpj, Address address){
        return new Store(companyName, tradingName, cnpj, address);
    }

    private static Client createClient(String name, int age, Address address){
        return new Client(name, age, address);
    }
}