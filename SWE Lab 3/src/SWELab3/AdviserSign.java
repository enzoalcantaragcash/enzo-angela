package SWELab3;

import java.util.logging.Logger;

public class AdviserSign implements Chain{

    final private static Logger logger = Logger.getLogger(Main.class.getName());
    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void sign(Signature request) {
        if(request.getPersonToSign().equals("Adviser")) {
            logger.info("Adviser has signed the document for " + request.getStudent() + ".");
        } else {

            nextInChain.sign(request);
        }
    }

}
