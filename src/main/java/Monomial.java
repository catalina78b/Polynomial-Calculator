public class Monomial {
    private int grad;
    private double coef;
    public Monomial(int grad, double coef)
    {
        this.grad=grad;
        this.coef=coef;
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

}
