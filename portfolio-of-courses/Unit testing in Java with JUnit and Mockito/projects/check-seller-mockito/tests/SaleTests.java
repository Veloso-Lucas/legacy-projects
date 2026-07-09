import org.junit.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SaleTests {

    private static Customer customer;
    private static ICredit creditService;

    private static Sale sale;

    @BeforeClass
    public static void beforeClass() {
        customer = new Customer("132", "João");

        // Mock Config
        sale = new Sale(2000, customer, creditService);
    }

    @AfterClass
    public static void afterClass() {
        customer = null;
        creditService = null;
        sale = null;
    }

    @Before
    public void beforeTest() {
        creditService = mock(ICredit.class);
        sale = new Sale(2000, customer, creditService);
    }

    @After
    public void afterTest() {
        sale = null;
        creditService = null;
    }

    @Test
    public void testCheckoutWithLimit() {
        // Mock Config for this test
        when(creditService.getLimit(customer.getCpf())).thenReturn(2500d);
        sale.setOneTimePayment(false);

        boolean result = sale.checkout();
        assertTrue(result);
    }

    @Test
    public void testCheckoutWithoutLimit() {
        // Mock Config for this test
        when(creditService.getLimit(customer.getCpf())).thenReturn(1500d);
        sale.setOneTimePayment(false);

        boolean result = sale.checkout();
        assertFalse(result);
    }

    @Test
    public void testCheckoutOneTimePayment() {
        sale.checkout();

        // Verify if the function getLimit was never executed for the customer.getCpf()
        verify(creditService, never()).getLimit(customer.getCpf());

    }

    @Test
    public void testCheckoutWithRequestFailed() {
        // Mock Config for this test
        when(creditService.getLimit(anyString())).thenThrow(new RuntimeException());

        sale.setOneTimePayment(false);
        boolean result = sale.checkout();

        assertFalse(result);
    }
}
