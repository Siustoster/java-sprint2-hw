import java.util.ArrayList;
public class YearlyReport {
    ArrayList<String> listOfMonths ;
    boolean yearLoaded = false;
    void loadYear(FileReader fileReader)
    {
        if (yearLoaded) {
            System.out.println("Данные уже были загружены");
        } else {
            if (fileReader.readFileContents("y.2021.csv").isEmpty())
            {
                System.out.println("Проблема с файлом y.2021.csv. Проверьте  наличие и расположение в нужной директории.");
                return;
            }
                listOfMonths=fileReader.readFileContents("y.2021.csv");
                listOfMonths.remove(0);
            yearLoaded = true;
            System.out.println("Считаны данные за 2021 год");
        }
    }
}
