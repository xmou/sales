import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DateFormat;

public class Goods {
    private String name;
    private double price;
    private double rate;
    private double tax;

    public Goods(String name, double price, double rate) {
        this.name = name;
        this.price = price;
        this.rate = rate;
    }

    public static Goods parse(String input) {
        InputReader reader = new InputReader();
        return reader.read(input);
    }

    public double computeTax() {
        MathContext mc = new MathContext(3);
        tax = new BigDecimal(price * rate).round(mc).doubleValue();
        return tax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (Double.compare(goods.price, price) != 0) return false;
        if (Double.compare(goods.rate, rate) != 0) return false;
        if (name != null ? !name.equals(goods.name) : goods.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = price != +0.0d ? Double.doubleToLongBits(price) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = rate != +0.0d ? Double.doubleToLongBits(rate) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
