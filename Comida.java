public class Comida implements java.io.Serializable{
    public int dosisInicial;
    public int dosisMaxima;
    public int dosisFinal;
    public int diaMaximo;

    public Comida(int dosisInicial, int dosisMaxima, int dosisFinal, int diaMaximo) {
        if (dosisInicial < 0 || dosisInicial > 300 ||
                dosisMaxima < 0 || dosisMaxima > 300 ||
                dosisFinal < 0 || dosisFinal > 300) {
            throw new IllegalArgumentException("dosis debe estar entre 0 y 300");
        }
        this.dosisInicial = dosisInicial;
        this.dosisMaxima = dosisMaxima;
        this.dosisFinal = dosisFinal;
        this.diaMaximo = diaMaximo;
    }

    public int getDosis(int dia) {
        if (dia < 0 || dia > 30) {
            throw new IllegalArgumentException("dia debe estar entre 0 y 30");
        }
        if (dia < diaMaximo) {
            return dosisInicial + (dosisMaxima - dosisInicial) / (diaMaximo - 1) * (dia - 1);
        } else {
            return dosisMaxima + (dosisFinal - dosisMaxima) / (30 - diaMaximo) * (dia - diaMaximo);
        }
    }

    public int getDosisInicial() {
        return dosisInicial;
    }

    public int getDosisMaxima() {
        return dosisMaxima;
    }

    public int getDosisFinal() {
        return dosisFinal;
    }

    public int getDiaMaximo() {
        return diaMaximo;
    }

    public void setDosisInicial(int dosisInicial) {
        this.dosisInicial = dosisInicial;
    }

    public void setDosisMaxima(int dosisMaxima) {
        this.dosisMaxima = dosisMaxima;
    }

    public void setDosisFinal(int dosisFinal) {
        this.dosisFinal = dosisFinal;
    }

    public void setDiaMaximo(int diaMaximo) {
        this.diaMaximo = diaMaximo;
    }

}
