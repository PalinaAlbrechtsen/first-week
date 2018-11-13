package clerk.service;

import clerk.entity.Buyer;
import clerk.entity.Clerk;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ClerkServiceTest {

    @Test
    public void checkClerkService() {
        Buyer first = new Buyer(25);
        Buyer second = new Buyer(25);
        Buyer third = new Buyer(50);
        Buyer fourth = new Buyer(100);

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
