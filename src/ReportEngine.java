import java.util.ArrayList;

public class ReportEngine {
    Transaction currentTrans;
    void reportMonth(MonthlyReport monthlyReport)
    {
        double maxProfit=0;
        String maxProfitUnit="";
        double maxExpense=0;
        String maxExpenseUnit="";
        for (String month:monthlyReport.listOfMonths.keySet())
        {
            System.out.println("Месяц:"+month);
            ArrayList<String> monthList = monthlyReport.listOfMonths.get(month);
            monthList.remove(0);
            for (String trans:monthList) {
                currentTrans = new Transaction(trans.split(","));
                if(currentTrans.isExpense)
                {
                    double currentExpense = currentTrans.quantity* currentTrans.unitPrice;
                    String currentUnit = currentTrans.name;
                    if(currentExpense>maxExpense)
                    {
                        maxExpense = currentExpense;
                        maxExpenseUnit = currentUnit;
                    }
                }
                else
                {
                    double currentProfit = currentTrans.quantity* currentTrans.unitPrice;
                    String currentUnit = currentTrans.name;
                    if(currentProfit>maxProfit)
                    {
                        maxProfit=currentProfit;
                        maxProfitUnit=currentUnit;
                    }
                }
            }
            System.out.println("Самый прибыльный товар:" +maxProfitUnit+". Прибыль составила "+maxProfit);
            System.out.println("Самая большая трата: "+maxExpenseUnit+". Расходы составили " +maxExpense);
        }
    }

}
