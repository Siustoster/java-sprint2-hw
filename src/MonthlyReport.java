import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    HashMap<String,ArrayList<String>> listOfMonths = new HashMap<>();
    boolean monthLoaded = false;
    String[] monthNames ={"Январь","Февраль","Март"};
    void loadMonth(FileReader fileReader)
    {
        if (monthLoaded) {
            System.out.println("Данные уже были загружены");
        } else {
            for (int i = 1; i < 4; i++) {
                if(fileReader.readFileContents("m.20210" + i + ".csv").isEmpty())
                {
                    System.out.println("Проблема с файлом m.20210"+i+".csv. Проверьте  наличие и расположение в нужной директории.");
                    return;
                }
                listOfMonths.put(monthNames[i - 1], fileReader.readFileContents("m.20210" + i + ".csv"));
                listOfMonths.get(monthNames[i-1]).remove(0);
            }
            monthLoaded = true;
            System.out.println("Считаны данные за 3 месяца");
        }
    }

}
