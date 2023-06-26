package Coursework2;

/**
 * Program to display the information of the debit card, including the pin number and any withdrawal information if a withdrawal has been made.
 * @author (Sarthak Thapa)
 */
public class DebitCard extends BankCard
//Coursework2.DebitCard is a subclass of Coursework2.BankCard
{
    // private instance variable
    private int pinNumber;
    private double withdrawalAmount;
    private String dateOfWithdrawal;
    private boolean hasWithdrawn;
    // constructor method of Coursework2.DebitCard that initializes the cardId, issuerBank, bankAccount, clientName, pinNumber
    public DebitCard(int cardId, String issuerBank, String bankAccount, String balanceAmount, String clientName, int pinNumber){
        // calls the constructor of the superclass to initialize the card ID, issuer bank, bank account, and balance amount
        super(cardId, issuerBank, bankAccount, Double.parseDouble(balanceAmount));
        super.setBalanceAmount(Double.parseDouble(balanceAmount));
        super.setClientName(clientName);
        this.pinNumber= pinNumber;
        this.hasWithdrawn=false;
        setClientName(clientName);
    }
    // accessor method to get pinNumber
    public int getPinNumber(){
        return this.pinNumber;
    }
    // accessor method to get withdrawalAmount
    protected double getWithdrawalAmount(){
        return this.withdrawalAmount;
    }
    // accessor method to get DateOfWithdrawal
    public String getDateOfWithdrawal(){
        return this.dateOfWithdrawal;
    }
    // accessor method to get hasWithdrawn
    public boolean getHasWithdrawn(){
        return this.hasWithdrawn;
    }
    // mutator method to set withdrawalAmount
    protected void setWithdrawalAmount(double withdrawalAmount){
        this.withdrawalAmount=withdrawalAmount;
    }
    // method to withdraw a specified amount from the account with a specific pin number and date
    public void withdraw(int withdrawalAmount, String dateOfWithdrawal, int pinNumber){
        if (this.pinNumber == pinNumber) {// checks if the entered pin number matches the one stored
            if (getBalanceAmount() >= withdrawalAmount) {// checks if the account has sufficient balance
                setBalanceAmount(getBalanceAmount() + withdrawalAmount);// updates the balance
                this.dateOfWithdrawal = dateOfWithdrawal;
                this.withdrawalAmount = withdrawalAmount;
                hasWithdrawn = true;
                System.out.println("Withdrawal successful. Your new balance is " + getBalanceAmount());
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Invalid pin number.");
        }
    }
    // method to display the details of Coursework2.BankCard
    public void display() {
        super.display();
        System.out.println("Pin Number: " + pinNumber);
        if (hasWithdrawn) {
            System.out.println("Withdrawal Amount: " + withdrawalAmount);
            System.out.println("Date of Withdrawal: " + dateOfWithdrawal);
        } else {
            System.out.println("Transaction not carried out yet.");
        }
    }
}
