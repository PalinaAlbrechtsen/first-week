package clerk.service;

import clerk.entity.Buyer;
import clerk.entity.Clerk;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ClerkService {

    private static final Integer TICKET_PRICE = 25;
    private static int cashboxSum;

    private static Integer getCashboxSum(List<Integer> cashbox) {
        for (Integer cash : cashbox) {
            cashboxSum += cash;
        }

        return cashboxSum;
    }

    public static Boolean isAbleToGiveTickets(List<Buyer> buyers, Clerk clerk) {
        int change;
        List<Integer> cashbox = clerk.getCashbox();
        cashbox.sort(Collections.reverseOrder());
        for (Buyer buyer : buyers) {
            change = buyer.getMoney() - TICKET_PRICE;
            if (change == 0) {
                cashbox.add(TICKET_PRICE);
                continue;
            }
            if (change > 0 && change <= getCashboxSum(cashbox)) {
                Iterator<Integer> cashboxIterator = cashbox.iterator();
                while (cashboxIterator.hasNext()) {
                    Integer bill = cashboxIterator.next();
                    if (bill <= change) {
                        change -= bill;
                        cashboxIterator.remove();
                    }
                }
                cashbox.add(buyer.getMoney());
            } else {
                clerk.setCashbox(cashbox);
                return false;
            }
        }
        clerk.setCashbox(cashbox);
        return true;
    }
}
