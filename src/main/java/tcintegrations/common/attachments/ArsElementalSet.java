package tcintegrations.common.attachments;

public class ArsElementalSet {
    private boolean hasAir;
    private boolean hasAqua;
    private boolean hasEarth;
    private boolean hasFire;

    public ArsElementalSet() {}

    public boolean hasAir() { return hasAir; }
    public boolean hasAqua() { return hasAqua; }
    public boolean hasEarth() { return hasEarth; }
    public boolean hasFire() { return hasFire; }

    public void setAir(boolean value) { this.hasAir = value; }
    public void setAqua(boolean value) { this.hasAqua = value; }
    public void setEarth(boolean value) { this.hasEarth = value; }
    public void setFire(boolean value) { this.hasFire = value; }

    public void copyFrom(ArsElementalSet other) {
        this.hasAir = other.hasAir;
        this.hasAqua = other.hasAqua;
        this.hasEarth = other.hasEarth;
        this.hasFire = other.hasFire;
    }
}
