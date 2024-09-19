package CESAR_MAGAGNIN.primeirob.listas.listaseis;
// DataManager.java

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

    // Método para salvar clientes
    public static void salvarClientes(List<Cliente> clientes, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(clientes);
        }
    }

    // Método para carregar clientes
    @SuppressWarnings("unchecked")
    public static List<Cliente> carregarClientes(String fileName) throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                return (List<Cliente>) obj;
            } else {
                throw new ClassNotFoundException("Dados incompatíveis no arquivo: " + fileName);
            }
        }
    }

    // Método para salvar funcionários
    public static void salvarFuncionarios(List<Funcionario> funcionarios, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(funcionarios);
        }
    }

    // Método para carregar funcionários
    @SuppressWarnings("unchecked")
    public static List<Funcionario> carregarFuncionarios(String fileName) throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                return (List<Funcionario>) obj;
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
