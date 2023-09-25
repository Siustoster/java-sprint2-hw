import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Поехали!
        String[] monthNames ={"Январь","Февраль","Март"};
        System.out.println("Добро пожаловать в БухЯП v1.0");
        Scanner scanner = new Scanner(System.in);
        boolean monthLoaded = false;
        boolean yearLoaded = false;
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
                if (monthLoaded) {
                    System.out.println("Данные уже были загружены");
                } else {
                    for (int i = 1; i < 4; i++)
                        monthlyReport.listOfMonths.put(monthNames[i-1],fileReader.readFileContents("m.20210" + i + ".csv"));
                    monthLoaded = true;
                    System.out.println("Считаны данные за 3 месяца");
                }
            }
            else if(action==2){
                if (yearLoaded) {
                    System.out.println("Данные уже были загружены");
                } else {

                    yearlyReport.listOfMonths=fileReader.readFileContents("y.2021.csv");
                    yearLoaded = true;
                    System.out.println("Считаны данные за 2021 год");
                }
            }
            else if(action==3){
                if(yearLoaded&&monthLoaded)
                {

                }
                else if(!yearLoaded&&!monthLoaded)
                {
                    System.out.println("Сначала необходимо загрузить данные по годам и месяцам");

                }
                else if(!yearLoaded){
                    System.out.println("Сначала необходимо загрузить данные за год");
                }
                else if(!monthLoaded){
                    System.out.println("Сначала необходимо загрузить данные по месяцам");
                }
            }else if(action==4){
                if(monthLoaded)
                {
                    reportEngine.reportMonth(monthlyReport);
                }
                else
                {
                    System.out.println("Сначала необходимо загрузить данные по месяцам");
                }
            }
            else if(action==5){

            }
            else if(action==6){
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

