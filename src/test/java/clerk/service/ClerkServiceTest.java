package clerk.service;

import clerk.entity.Buyer;
import clerk.entity.Clerk;
import clerk.entity.Money;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ClerkServiceTest {

    @Test
    public void checkClerkService() {
        Buyer first = new Buyer(Money.TWENTY_FIVE);
        Buyer second = new Buyer(Money.TWENTY_FIVE);
        Buyer third = new Buyer(Money.FIFTY);
        Buyer fourth = new Buyer(Money.ONE_HUNDREAD);

        List<Buyer> buyers = new ArrayList<>();
        buyers.add(first);
        buyers.add(second);
        buyers.add(third);
        buyers.add(fourth);

        List<Integer> cashbox = new ArrayList<>();
        cashbox.add(50);
        cashbox.add(25);

        Clerk clerk = new Clerk(cashbox);
        Clerk secondClerk = new Clerk();

        assertEquals(true, ClerkService.isAbleToGiveTickets(buyers, secondClerk));
        assertEquals(1, secondClerk.cashbox.size());
    }
}
