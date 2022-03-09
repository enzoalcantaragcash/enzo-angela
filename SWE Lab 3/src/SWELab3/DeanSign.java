package SWELab3;

import java.util.logging.Logger;

public class DeanSign implements Chain{

    final private static Logger logger = Logger.getLogger(Main.class.getName());
    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void sign(Signature request) {
        if(request.getPersonToSign().equals("Dean")) {
            logger.info("Dean has signed the document for " + request.getStudent() + ". It is now approved.");
        } else {
            logger.warning("Signing only accepts \"Adviser\", \"College Secretary\", or \"Dean\"");
        }
    }
}
