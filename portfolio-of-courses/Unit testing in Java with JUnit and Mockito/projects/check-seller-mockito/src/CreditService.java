
public class CreditService implements ICredit {

    @Override
    public double getLimit(String cpf) {

        //Accessing webservice from credit card administration
        System.out.println("Checking card administration...");
        return 1500;
    }
}
