package SWELab3;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //singleton
        Transaction application = Transaction.getTransaction();

        application.confirmStart();
        application.confirmProcessing();

        //Chain of Responsibility
        Chain chainCalc1 = new AdviserSign();
        Chain chainCalc2 = new CollegeSecSign();
        Chain chainCalc3 = new DeanSign();

        chainCalc1.setNextChain(chainCalc2);
        chainCalc2.setNextChain(chainCalc3);

        Signature request = new Signature("Enzo Alcantara", "Adviser");
        chainCalc1.sign(request);
        request.setPersonToSign("College Secretary");
        chainCalc1.sign(request);
        request.setPersonToSign("Dean");
        chainCalc1.sign(request);

        application.confirmFinish();
    }
}
