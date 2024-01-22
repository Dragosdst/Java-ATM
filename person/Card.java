package list.person;

class Card implements CardActions {
    private String nume;
    private double balance;

    public Card(String nume) {
        this.nume = nume;
        this.balance = 0;
    }

    public String getNume() {
        return nume;
    }

    @Override
    public void depunere(double suma) {
        balance += suma;
    }

    @Override
    public boolean plata(double suma) {
        if (balance >= suma) {
            balance -= suma;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double verificareCont() {
        return balance;
    }
}

