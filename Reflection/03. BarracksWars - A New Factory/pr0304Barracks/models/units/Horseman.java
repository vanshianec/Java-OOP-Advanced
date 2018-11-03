package pr0304Barracks.models.units;

public class Horseman extends AbstractUnit{

    private static final int HORSEMAN_HEALLTH = 50;
    private static final int HORSEMAN_DAMAGE = 10;

    public Horseman(){
        super(HORSEMAN_HEALLTH,HORSEMAN_DAMAGE);
    }
}
