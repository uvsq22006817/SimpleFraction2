public class Fraction {
    private int numerateur;
    private int denominateur;


    Fraction(int num,int denom)
    {
        this.numerateur = num;
        this.denominateur = denom;
    }

    public String toString()
    {
        String str = this.numerateur + "et " + this.denominateur;
        return str;
    }


}
