package Coursework2;

/**
 * Program to simulate the functionality of Bank Card.
 * @Auther (Sarthak Thapa)
 */
public class BankCard
{
    // private instance variable
    private int cardId;
    private String clientName;
    private String issuerBank;
    private String bankAccount;
    private Double balanceAmount;

    //constructor method of Coursework2.BankCard that initializes the cardId, issuerBank, bankAccount, and balanceAmount
    protected BankCard(int cardId, String issuerBank, String bankAccount, double balanceAmount){
        this.clientName = ""; // initializes the clientName to an empty string
        this.cardId = cardId;
        this.issuerBank= issuerBank;
        this.bankAccount = bankAccount;
        this.balanceAmount = balanceAmount;
    }
    // method to set the clientName
    protected void setClientName(String clientName){
        this.clientName = clientName;
    }
    // accessor method to get cardId
    public int getCardId(){
        return this.cardId;
    }
    // accessor method to get issuerBank
    public String getIssuerBank(){
        return this.issuerBank;
    }
    // accessor method to get clientName
    public String getClientName(){
        return this.clientName;
    }
    // accessor method to get BankAccount
    public String getBankAccount(){
        return this.bankAccount;
    }
    // accessor method to get BalanceAmount
    public double getBalanceAmount(){
        return this.balanceAmount;
    }
    // mutator method to set BalanceAmount
    protected void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
    // method to display the details of the bank card
    protected void display() {
        if (clientName.equals("")) { // If the clientName is assigned or not
            System.out.println("Client name not assigned");
        } else {
            System.out.println("Card ID: " + cardId);
            System.out.println("Client Name: " + clientName);
            System.out.println("Issuer Bank: " + issuerBank);
            System.out.println("Bank Account: " + bankAccount);
            System.out.println("Balance Amount: " + balanceAmount);
        }
    }

}

