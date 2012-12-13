import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class InputReader {
    public Goods read(String input) {
        Matcher matcher = Pattern.compile("^\\d(.+)at(.+)$").matcher(input);
        if (matcher.matches()) {
            return toGoods(matcher);
        }
        return null;
    }

    private Goods toGoods(Matcher matcher) {
        String name = matcher.group(1).trim();
        double price = Double.parseDouble(matcher.group(2).trim());
        double rate = getRate(name);

        return new Goods(name, price, rate);
    }

    private double getRate(String name) {
        double rate = 0.0;
        if (name.contains("Atom Bomb")) {
            rate += 0.1;
        }

        if (name.toLowerCase().contains("imported")) {
            rate += 0.05;
        }
        return rate;

    }
}
