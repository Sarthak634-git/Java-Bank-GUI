package Coursework2;

/**
 * Program to display the information of the credit card, including the CVCnumber, CreditLimit, InterestRate, ExpirationDate, GracePeriod and isGranted.
 * @author (Sarthak Thapa)
 */
public class CreditCard extends BankCard
// Coursework2.CreditCard class is a subclass of Coursework2.BankCard
{
    // private instance variable
    private int CVCnumber;
    private double creditLimit;
    private double interestRate;
    private String expirationDate;
    private int gracePeriod;
    private boolean isGranted;
    // constructor method of Coursework2.CreditCard that initializes the cardId, clientName, issuerBank, bankAccount, balanceAmount, CVCnumber, interestRate, expirationDate
    public CreditCard(int cardId, String clientName, String issuerBank, String bankAccount, double balanceAmount, int CVCnumber, double interestRate, String expirationDate){
        // calls the constructor of the superclass to initialize the card ID, issuer bank, bank account, and balance amount
        super(cardId, issuerBank, bankAccount,balanceAmount);
        super.setBalanceAmount(balanceAmount);
        super.setClientName(clientName);
        this.CVCnumber=CVCnumber;
        this.interestRate=interestRate;
        this.expirationDate=expirationDate;
    }
    // accessor method to get CVCnumber
    public int getCVCnumber(){
        return this.CVCnumber;
    }
    // accessor method to get CreditLimit
    public double getCreditLimit(){
        return this.creditLimit;
    }
    // accessor method to get InterestRate
    public double getInterestRate(){
        return this.interestRate;
    }
    // accessor method to get ExpirationDate
    public String getExpirationDate(){
        return this.expirationDate;
    }
    // accessor method to get GarcePeriod
    public int getGracePeriod(){
        return this.gracePeriod;
    }
    // accessor method to get IsGranted
    public boolean getIsGranted(){
        return this.isGranted;
    }
    // mutator method to set CreditLimit
    public void setCreditLimit(double creditLimit, int gracePeriod) {
        if (creditLimit <= 2.5 * getBalanceAmount()){
            this.creditLimit = creditLimit;
            this.gracePeriod = gracePeriod;
            isGranted = true;
//            System.out.println("Your Credit is granted");
        }
        else{
            System.out.println("Credit cannot be issued");
        }
    }

    // method to cancel the credit card
    public void cancelCreditCard(){
        CVCnumber = 0;
        creditLimit = 0;
        gracePeriod = 0;
        isGranted = false;
    }

    //method to display credit card detail
    public void display(){
        super.display();
        if (isGranted){
            System.out.println("CVC Number: " + CVCnumber);
            System.out.println("Credit Limit: " + creditLimit);
            System.out.println("Interest Rate: " + interestRate);
            System.out.println("Expiration Date: " + expirationDate);
            System.out.println("Grace Period: " + gracePeriod);
        } else {
            System.out.println("Credit not granted yet");
        }
    }
}




