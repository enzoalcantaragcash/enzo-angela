package SWELab3;

import java.util.logging.Logger;

public class Transaction {
    final private static Logger logger = Logger.getLogger(Transaction.class.getName());

    //create an object of Transaction
    private static Transaction transaction = new Transaction();

    //make the constructor private so that this class cannot be instantiated
    private Transaction() {}

    //Get the only object available
    public static Transaction getTransaction() {
        return transaction;
    }

    public void confirmStart() {
        logger.info("Transaction started.");
    }

    public void confirmProcessing() {
        logger.info("Transaction is now being processed...");
    }

    public void confirmFinish() {
        logger.info("Transaction is successful and is now closed.");
    }

}
