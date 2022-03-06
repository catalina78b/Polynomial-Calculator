public class Monomial {
    private int grad;
    private double coef;
    private boolean found;

    public Monomial(int grad, double coef) {
        this.grad = grad;
        this.coef = coef;
    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public String toString() {

        if (coef == 0 && grad>0)
            return "";
        if (coef == 0 && grad == 0)
            return "";
        if (grad == 0 && coef > 0)
            return "+" + coef;

        if (grad == 0 && coef < 0)
            return coef + "";

        if (coef == 1 && grad == 1)
            return coef+"*x^"+grad;

        if (grad > 0 && coef > 0)
            return "+" + coef + "*x^" + grad;
        else
            return coef + "*x^" + grad;
    }

    public Monomial divide(Monomial monomial)
    {
        return new Monomial(this.grad-monomial.getGrad(),this.coef/monomial.getCoef());
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean b) {
        found = b;
    }

}
