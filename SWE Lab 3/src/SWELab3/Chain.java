package SWELab3;


public interface Chain {

    public void setNextChain(Chain nextChain);
    public void sign(Signature request);
}
