import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Поехали!

        System.out.println("Добро пожаловать в БухЯП v1.0");
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader();
        int action=0;
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        ReportEngine reportEngine = new ReportEngine();
        while(true)
        {
            printMenu();
            action=scanner.nextInt();
            if(action==1) {
                monthlyReport.loadMonth(fileReader);
            }
            else if(action==2){
                yearlyReport.loadYear(fileReader);
            }
            else if(action==3){
                reportEngine.checkReports(monthlyReport,yearlyReport);
            }
            else if(action==4){
                reportEngine.reportMonth(monthlyReport);
            }
            else if(action==5){
                reportEngine.reportYear(yearlyReport);
            }
            else if(action==666){
                System.out.println("БухЯП v1.0 завершает работу");
                return;
            }
            else System.out.println("Такое действие пока не предусмотрено. Пожалуйста, выберите другое");

        }
    }
    public static void printMenu()
    {

        System.out.println("Выберите действие:");
        System.out.println("1 - загрузить месячные отчеты в программу");
        System.out.println("2 - загрузить годовой отчет в программу");
        System.out.println("3 - сверить отчеты");
        System.out.println("4 - вывести информацию о месячных отчетах");
        System.out.println("5 - вывести информацию о годовом отчете");
        System.out.println("666 - завершить работу");
    }
}

