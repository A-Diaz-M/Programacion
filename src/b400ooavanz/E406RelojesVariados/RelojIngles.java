package b400ooavanz.E406RelojesVariados;

public class RelojIngles extends RelojTextual {

    private static final String[] ONES = {
        "zero", "one", "two", "three", "four", "five", "six", "seven",
        "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
        "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] TENS = {
        "", "", "twenty", "thirty", "forty", "fifty"
    };


    public RelojIngles() { super(); }

    public RelojIngles(int horas, int minutos) { super(horas, minutos); }

    public RelojIngles(int totalMinutos) { super(totalMinutos); }


    @Override
    protected String numeroTexto(int n) {
        if (n < 20) return ONES[n];
        int dec = n / 10;
        int uni = n % 10;
        return TENS[dec] + (uni != 0 ? "-" + ONES[uni] : "");
    }

    @Override
    protected String palabraHora(int h) {
        return h == 1 ? "hour" : "hours";
    }

    @Override
    protected String palabraMinuto(int m) {
        return m == 1 ? "minute" : "minutes";
    }

    @Override
    public String toString() {
        return numeroTexto(horas) + " " + palabraHora(horas)
             + ", " + numeroTexto(minutos) + " " + palabraMinuto(minutos);
    }

    @Override
    public RelojIngles clone() {
        return new RelojIngles(horas, minutos);
    }
}
