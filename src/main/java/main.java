import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        
        System.out.println();
        while (true) {
            pickCurrency();
            System.out.println();

        }
    }
    private static money chooseDate(String currency,String date) throws IOException{
        String urlText1 = "http://api.nbp.pl/api/exchangerates/rates/c/" + currency + "/"+date+"/";
        URL url1 = new URL(urlText1);
        URLConnection connection1 = url1.openConnection();
        connection1.addRequestProperty("user-agent", "Chrome");
        InputStream stream1 = connection1.getInputStream();

        Scanner scanner11 = new Scanner(stream1);
        String line1 = scanner11.nextLine();

        Gson gson = new Gson();

        money m = gson.fromJson(line1, money.class);
        double wartoscBid = m.rates[0].bid;
        String code = m.code;
        String day = m.rates[0].effectiveDate;

        System.out.println(code);
        System.out.println("Aktualny kurs: " + wartoscBid);
        System.out.println("Wartość za jaką byś kupił dzisaj 100 ziko" + " " + wartoscBid * 100);
        System.out.println("Kurs z dnia: " + day);
        return m;
    }

    private static money pickCurrency() throws IOException {
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Wybierz walutę: ");
        String text = scanner1.nextLine();
        System.out.println("wybierz date: rrrr-mm-dd");
        String date =scanner1.nextLine();

        return chooseDate(text,date);
    }
}







