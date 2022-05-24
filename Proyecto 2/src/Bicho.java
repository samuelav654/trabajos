public class Bicho {
    private int vida;
    private String tipo;

    public Bicho() {
        this.vida = 10;
        tipo = "  BichosNormales";
    }

    public void setVida(int v) {
        this.vida = v;
    }

    public int getVida() {
        return this.vida;
    }

    public int reducirVida(int r) {
        this.vida -= r;
        if (vida <= 0)
            vida = 0;
        return this.vida;

    }

    public int aumentarvida(int a) {
        this.vida += a;
        return this.vida;
    }

    public void setTipo(String t) {
        this.tipo = t;
    }

    public String getTipo() {
        return this.tipo;
    }

    @Override
    public String toString() {
        return tipo + "-" + vida;
    }
}