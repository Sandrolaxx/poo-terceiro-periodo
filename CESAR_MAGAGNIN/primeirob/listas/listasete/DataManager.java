package primeirob.listas.listasete;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    // Método para salvar pedidos
    public static void salvarPedidos(List<Pedido> pedidos, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(pedidos);
        }
    }

    // Método para carregar pedidos
    @SuppressWarnings("unchecked")
    public static List<Pedido> carregarPedidos(String fileName) throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                return (List<Pedido>) obj;
            } else {
                throw new ClassNotFoundException("Dados incompatíveis no arquivo: " + fileName);
            }
        }
    }

    // Método para salvar pessoas (Clientes e Funcionários)
    public static void salvarPessoas(List<Pessoa> pessoas, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(pessoas);
        }
    }

    // Método para carregar pessoas
    @SuppressWarnings("unchecked")
    public static List<Pessoa> carregarPessoas(String fileName) throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                return (List<Pessoa>) obj;
            } else {
                throw new ClassNotFoundException("Dados incompatíveis no arquivo: " + fileName);
            }
        }
    }

    // Método para salvar lojas
    public static void salvarLojas(List<Loja> lojas, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(lojas);
        }
    }

    // Método para carregar lojas
    @SuppressWarnings("unchecked")
    public static List<Loja> carregarLojas(String fileName) throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                return (List<Loja>) obj;
            } else {
                throw new ClassNotFoundException("Dados incompatíveis no arquivo: " + fileName);
            }
        }
    }
}
