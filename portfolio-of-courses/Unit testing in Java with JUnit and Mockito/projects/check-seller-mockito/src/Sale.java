public class Sale {

    private final double value;
    private final Customer customer;
    private final ICredit creditService;
    private boolean oneTimePayment = true;

    public Sale(double value, Customer customer, ICredit creditService) {
        this.value = value;
        this.customer = customer;
        this.creditService = creditService;
    }

    public double getValue() {
        return value;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setOneTimePayment(boolean isOneTimePayment) {
        this.oneTimePayment = isOneTimePayment;
    }

    public boolean checkout() {
        if (oneTimePayment) return true;

        double limit;
        try {
            limit = creditService.getLimit(customer.getCpf());
            return !(value > limit);
        } catch (RuntimeException e) {
            return false;
        }
    }
}
