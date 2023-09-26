import java.util.ArrayList;
import java.util.HashMap;

public class ReportEngine {
    Transaction currentTrans;
     ArrayList<String> monthNames;
    void reportMonth(MonthlyReport monthlyReport) {
        double maxProfit = 0;
        String maxProfitUnit = "";
        double maxExpense = 0;
        String maxExpenseUnit = "";
        for (String month : monthlyReport.listOfMonths.keySet()) {
            System.out.println("Месяц:" + month);
            ArrayList<String> monthList = monthlyReport.listOfMonths.get(month);

            for (String trans : monthList) {
                currentTrans = new Transaction(trans.split(","));
                if (currentTrans.isExpense) {
                    double currentExpense = currentTrans.quantity * currentTrans.unitPrice;
                    String currentUnit = currentTrans.name;
                    if (currentExpense > maxExpense) {
                        maxExpense = currentExpense;
                        maxExpenseUnit = currentUnit;
                    }
                } else {
                    double currentProfit = currentTrans.quantity * currentTrans.unitPrice;
                    String currentUnit = currentTrans.name;
                    if (currentProfit > maxProfit) {
                        maxProfit = currentProfit;
                        maxProfitUnit = currentUnit;
                    }
                }
            }
            System.out.println("Самый прибыльный товар:" + maxProfitUnit + ". Прибыль составила " + maxProfit);
            System.out.println("Самая большая трата: " + maxExpenseUnit + ". Расходы составили " + maxExpense);
            maxProfit=0;
            maxProfitUnit="";
            maxExpense =0;
            maxExpenseUnit="";
        }
    }

    void reportYear(YearlyReport yearlyReport) {
        System.out.println("Год: 2021");
        double currentMonthExpense = 0;
        double currentMonthProfit = 0;
        double sumProfit = 0;
        double sumExpenses = 0;
        Transaction currentMonthTrans1;
        Transaction currentMonthTrans2;

        for (int i = 0; i < yearlyReport.listOfMonths.size(); i = i + 2) {
            currentMonthTrans1 = new Transaction(yearlyReport.listOfMonths.get(i).split(","), true);
            currentMonthTrans2 = new Transaction(yearlyReport.listOfMonths.get(i + 1).split(","), true);
            if (currentMonthTrans1.isExpense) {
                sumExpenses += currentMonthTrans1.yearlyAmount;
                sumProfit += currentMonthTrans2.yearlyAmount;
                System.out.println("Прибыль за месяц " + currentMonthTrans1.name + " составила " + (currentMonthTrans2.yearlyAmount - currentMonthTrans1.yearlyAmount));
            } else {
                sumExpenses += currentMonthTrans2.yearlyAmount;
                sumProfit += currentMonthTrans1.yearlyAmount;
                System.out.println("Прибыль за месяц " + currentMonthTrans1.name + " составила " + (currentMonthTrans1.yearlyAmount - currentMonthTrans2.yearlyAmount));
            }

        }
        System.out.println("Средний расход за все имеющиеся операции в году: " + sumExpenses / 3.0);
        System.out.println("Средний доход за все имеющиеся операции в году: " + sumProfit / 3.0);

    }

    void checkReports(MonthlyReport monthlyReport, YearlyReport yearlyReport) {
        monthNames = new ArrayList<>();
        monthNames.add("Заглушка");
        monthNames.add("Январь");
        monthNames.add("Февраль");
        monthNames.add("Март");
        monthNames.add("Апрель");
        monthNames.add("Май");
        monthNames.add("Июнь");
        monthNames.add("Июль");
        monthNames.add("Август");
        monthNames.add("Сентябрь");
        monthNames.add("Октябрь");
        monthNames.add("Ноябрь");
        monthNames.add("Декабрь");
        double totalProfit = 0;
        double totalExpense = 0;
        HashMap<String,HashMap<String, Double>> monthsTransformed = new HashMap<>();
        HashMap<String,Double> monthType;
        Transaction yearlyTrans;
        int i=0;
        for (String month : monthlyReport.listOfMonths.keySet()) {
            //System.out.println(""+month);
            i=monthNames.indexOf(month);
            monthType= new HashMap<>();
            ArrayList<String> monthList = monthlyReport.listOfMonths.get(month);

            for (String trans : monthList) {
                currentTrans = new Transaction(trans.split(","));
                if (currentTrans.isExpense)
                {
                    totalExpense +=currentTrans.quantity*currentTrans.unitPrice;
                } else
                {
                    totalProfit +=currentTrans.quantity*currentTrans.unitPrice;
                }
            }
            monthType.put("Доходы",totalProfit);
            monthType.put("Расходы",totalExpense);
            totalExpense=0;
            totalProfit=0;
            monthsTransformed.put("0"+i,monthType);


        }
        for (int j=0;j<yearlyReport.listOfMonths.size();j++)
        {
            yearlyTrans = new Transaction(yearlyReport.listOfMonths.get(j).split(","), true);
            if(yearlyTrans.isExpense)
            {
                monthType = new HashMap<>(monthsTransformed.get(yearlyTrans.name));
                if(!(yearlyTrans.yearlyAmount==monthType.get("Расходы")))
                {
                    System.out.println("Несоответствие в месяце "+ yearlyTrans.name + ". Статья расходы");
                }

            }
            else {
                monthType = new HashMap<>(monthsTransformed.get(yearlyTrans.name));
                if(!(yearlyTrans.yearlyAmount==monthType.get("Доходы")))
                {
                    System.out.println("Несоответствие в месяце "+ yearlyTrans.name + ". Статья Доходы");
                }
            }
        }
        System.out.println("Операция успешно завершена");
    }
}
