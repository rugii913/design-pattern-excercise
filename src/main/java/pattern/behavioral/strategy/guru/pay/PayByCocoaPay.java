package pattern.behavioral.strategy.guru.pay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/*
* 구체적인 strategy
* */
public class PayByCocoaPay implements PayStrategy {

    private static final Map<String, String> database = new HashMap<>();
    private boolean signedIn;


    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    static {
        database.put("first@asdf.com", "1111");
        database.put("second@asdf.com", "1234");
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (signedIn) {
            System.out.printf("Paying %d using Cocoa Pay.%n", paymentAmount);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void collectPaymentDetails() {
        try {
            while (!signedIn) {
                System.out.print("Enter the user's email: ");
                final String email = reader.readLine();

                System.out.print("Enter the password: ");
                final String password = reader.readLine();

                if (verify(email, password)) {
                    System.out.println("Data verification has been successful.");
                } else {
                    System.out.println("Wrong email or password!");
                }
            }
        } catch (IOException exception) {
            logger.info(exception.getMessage());
        }
    }

    private boolean verify(String email, String password) {
        setSignedIn(password.equals(database.get(email)));
        return signedIn;
    }
}
