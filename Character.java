public class Character {
        private String name;
        private int lebensPunkte;
        private int ausdauer;
        private String[] inventar;

        public Character(String name,int lebensPunkte,int ausdauer,String[] inventar) {
        this.name = name;
        this.lebensPunkte = lebensPunkte;
        this.ausdauer = ausdauer;
        this.inventar = inventar;
        }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLebensPunkte() {
        return this.lebensPunkte;
    }

    public void setLebensPunkte(int lebensPunkte) {
        this.lebensPunkte = lebensPunkte;
    }

    public int getAusdauer() {
        return this.ausdauer;
    }

    public void setAusdauer(int ausdauer) {
        this.ausdauer = ausdauer;
    }

    public String[] getInventar() {
        return this.inventar;
    }

    public void setInventar(String[] inventar) {
        this.inventar = inventar;
    }
        
    }