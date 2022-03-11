package SWELab3;


public interface Chain {

    //chain functions for chain of responsibility
    void setNextChain(Chain nextChain);
    void sign(Signature request);
}
