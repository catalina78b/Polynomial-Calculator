import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Model {
    Polynomial result = new Polynomial(new ArrayList<>());
    Operations operations = new Operations();

    String getResult(Polynomial p1, Polynomial p2, String operator) {
        if (operator.equals("Add"))
            result = operations.add(p1, p2);
        if (operator.equals("Subtract"))
            result = operations.subtract(p1, p2);
        if (operator.equals("Multiplicate"))
            result = operations.multiply(p1, p2);
        if (operator.equals("Divide"))
            result = operations.divide(p1, p2);
        if (operator.equals("Integrate"))
            result = operations.integrate(p1);
        if (operator.equals("Derivate"))
            result = operations.derivate(p1);

        return result.toString(result);

    }

    public static boolean isNumeric(String str) {

        return str.matches("([+-]?\\*?[^-+*]+)");
    }

    Polynomial getPolynomial(String polynomial) {
        Polynomial p = new Polynomial(new ArrayList<>());
        String monomialFormat = "([+-]?[\\d.]*\\*?[a-zA-Z]?\\^?\\d*)", monomialPartsFormat = "([+-]?[\\d.]*)\\*?([a-zA-Z]?)\\^?(\\d*)";

        Pattern p1 = Pattern.compile(monomialFormat);
        Matcher m1 = p1.matcher(polynomial);
        int exponent = 0;
        double coefficient = 0.0;
        Monomial monomial;
        while (!m1.hitEnd()) {
            m1.find();
            Pattern p2 = Pattern.compile(monomialPartsFormat);
            Matcher m2 = p2.matcher(m1.group());


            if (m2.find()) {

                try {
                    String coef = m2.group(1);
                    if (isNumeric(coef)) {
                        coefficient = Double.parseDouble(coef);
                    } else
                        coefficient = 1.0;
                    if (coefficient == 1.0 && m2.group(0).contains("-"))
                        coefficient = -1.0;
                } catch (IllegalStateException e) {
                    coefficient = 0.0;
                }

                try {
                    String exp = m2.group(3);
                    if (isNumeric(exp)) {
                        exponent = Integer.parseInt(exp);
                    } else {
                        if (m2.group(2).equals("x"))
                            exponent = 1;
                        else
                            exponent = 0;
                    }

                } catch (IllegalStateException e) {
                    exponent = 1;
                }
            }
            monomial = new Monomial(exponent, coefficient);
            p.addMonomialList(monomial);
        }
        return p;
    }
}
