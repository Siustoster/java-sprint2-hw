public class Transaction {
    String name;
    int quantity;
    int unitPrice;
    boolean isExpense;
    int yearlyAmount;
    Transaction(String[] lineContents)
    {
        name = lineContents[0];
        quantity = Integer.parseInt(lineContents[2]);
        unitPrice= Integer.parseInt(lineContents[3]);
        isExpense=Boolean.parseBoolean(lineContents[1]);
    }
    Transaction(String[] lineContents, boolean isYearlyTrans)
    {
        name=lineContents[0];
        yearlyAmount=Integer.parseInt(lineContents[1]);
        isExpense=Boolean.parseBoolean(lineContents[2]);

    }
}
