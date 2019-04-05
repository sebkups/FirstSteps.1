import java.util.ArrayList;
import java.util.List;

public class money {
    String table;
    String currency;
    String code;
    Rate[] rates;

    public String getCurrency() {
        return currency;
    }
}

    class Rate {
        String no;
        String effectiveDate;
        Double bid;
        Double ask;
    }
