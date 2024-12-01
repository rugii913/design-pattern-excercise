package pattern.behavioral.strategy.guru.pay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

/*
 * 구체적인 strategy
 * */
public class PayByCreditCard implements PayStrategy {

    private CreditCard card;

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public boolean pay(int paymentAmount) {
        if (cardIsPresent()) {
            System.out.printf("Paying %d using Credit Card.%n", paymentAmount);
            card.setAmount(card.getAmount() - paymentAmount);
            return true;
        } else {
            return false;
        }
    }

    private boolean cardIsPresent() {
        return this.card != null;
    }

    @Override
    public void collectPaymentDetails() {
        try {
            System.out.println("Enter the card number: ");
            String number = reader.readLine();
            System.out.println("Enter the card expiration date 'mm/yy': ");
            String date = reader.readLine();
            System.out.println("Enter the CVV code: ");
            String cvv = reader.readLine();
            this.card = new CreditCard(number, date, cvv);

        } catch (IOException exception) {
            logger.info(exception.getMessage());
        }
    }

    public static class CreditCard {

        private int amount;
        private final String number;
        private final String date;
        private final String cvv;

        public CreditCard(String number, String date, String cvv) {
            this.amount = 100_000;
            this.number = number;
            this.date = date;
            this.cvv = cvv;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }
    }
}
