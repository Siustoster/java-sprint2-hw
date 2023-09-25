public class Transaction {
    String name;
    int quantity;
    int unitPrice;
    boolean isExpense;
    Transaction(String[] lineContents)
    {
        name = lineContents[0];
        quantity = Integer.parseInt(lineContents[2]);
        unitPrice= Integer.parseInt(lineContents[3]);
        isExpense=Boolean.parseBoolean(lineContents[1]);
    }
}
