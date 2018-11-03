public class WeaponType implements Comparable<WeaponType>{
    private String name;
    private Weapon type;
    private int totalStrength;
    private int totalAgility;
    private int totalVitality;
    private int minDamage;
    private int maxDamage;
    private Gem[] sockets;
    private int averagePowerLevel;


    public WeaponType(String name, String type) {
        this.name = name;
        this.type = Enum.valueOf(Weapon.class, type.toUpperCase());
        this.sockets = new Gem[this.type.getSocketsCount()];
        this.minDamage = this.type.getMinDamage();
        this.maxDamage = this.type.getMaxDamage();
        this.totalStrength = 0;
        this.totalAgility = 0;
        this.totalVitality = 0;
        this.averagePowerLevel = 0;
    }

    public void addGem(int index, Gem gem) {
        if (index >= 0 && index < this.sockets.length) {
            if (sockets[index] != null) {
                totalStrength -= sockets[index].getStrength();
                totalAgility -= sockets[index].getAgility();
                totalVitality -= sockets[index].getVitality();
                minDamage -= sockets[index].getStrength() * 2 + sockets[index].getAgility();
                maxDamage -= sockets[index].getStrength() * 3 + sockets[index].getAgility() * 4;
            }
            sockets[index] = gem;
            totalStrength += sockets[index].getStrength();
            totalAgility += sockets[index].getAgility();
            totalVitality += sockets[index].getVitality();
            minDamage += sockets[index].getStrength() * 2 + sockets[index].getAgility();
            maxDamage += sockets[index].getStrength() * 3 + sockets[index].getAgility() * 4;
        }
    }

    public void removeGem(int index){
        if(index >= 0 && index < this.sockets.length){
            if(sockets[index] != null){
                totalStrength -= sockets[index].getStrength();
                totalAgility -= sockets[index].getAgility();
                totalVitality -= sockets[index].getVitality();
                minDamage -= sockets[index].getStrength() * 2 + sockets[index].getAgility();
                maxDamage -= sockets[index].getStrength() * 3 + sockets[index].getAgility() * 4;
                sockets[index] = null;
            }
        }
    }

    public double getAveragePowerLevel(){
        return ((double)this.minDamage + (double)this.maxDamage)/ 2 + this.totalStrength + this.totalAgility + this.totalVitality;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
       return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.name,this.minDamage,this.maxDamage,this.totalStrength,this.totalAgility,this.totalVitality);
    }


    @Override
    public int compareTo(WeaponType that) {
            return Double.compare(this.getAveragePowerLevel(),that.getAveragePowerLevel());
    }
}
