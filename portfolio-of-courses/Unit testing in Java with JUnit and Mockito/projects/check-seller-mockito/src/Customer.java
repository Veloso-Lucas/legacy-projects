public class Customer {

    private String cpf;
    private String name;

    public Customer(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }
}
