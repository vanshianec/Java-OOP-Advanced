public enum Weapon {
    AXE(5, 10, 4), SWORD(4, 6, 3), KNIFE(3, 4, 2);

    private int minDamage;
    private int maxDamage;
    private int socketsCount;


    Weapon(int minDamage, int maxDamage, int socketsCount) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.socketsCount = socketsCount;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getSocketsCount() {
        return socketsCount;
    }
}
