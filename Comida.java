public class Comida {
    public int dosisInicial;
    public int dosisMedia;
    public int dosisFinal;
    public int diaMedio;

    public Comida(int dosisInicial, int dosisMedia, int dosisFinal, int diaMedio) {
        if (dosisInicial < 0 || dosisInicial > 300 ||
                dosisMedia < 0 || dosisMedia > 300 ||
                dosisFinal < 0 || dosisFinal > 300) {
            throw new IllegalArgumentException("dosis debe estar entre 0 y 300");
        }
        this.dosisInicial = dosisInicial;
        this.dosisMedia = dosisMedia;
        this.dosisFinal = dosisFinal;
        this.diaMedio = diaMedio;
    }

    public int getDosis(int dia) {
        if (dia < 0 || dia > 30) {
            throw new IllegalArgumentException("dia debe estar entre 0 y 30");
        }
        if (dia < diaMedio) {
            return dosisInicial + (dosisMedia - dosisInicial) / (diaMedio - 1) * (dia - 1);
        } else {
            return dosisMedia + (dosisFinal - dosisMedia) / (30 - diaMedio) * (dia - diaMedio);
        }
    }

    public int getDosisInicial() {
        return dosisInicial;
    }

    public int getDosisMedia() {
        return dosisMedia;
    }

    public int getDosisFinal() {
        return dosisFinal;
    }

    public int getDiaMedio() {
        return diaMedio;
    }

    public void setDosisInicial(int dosisInicial) {
        this.dosisInicial = dosisInicial;
    }

    public void setDosisMedia(int dosisMedia) {
        this.dosisMedia = dosisMedia;
    }

    public void setDosisFinal(int dosisFinal) {
        this.dosisFinal = dosisFinal;
    }

    public void setDiaMedio(int diaMedio) {
        this.diaMedio = diaMedio;
    }
}
