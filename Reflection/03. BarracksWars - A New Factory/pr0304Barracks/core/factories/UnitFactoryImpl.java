package pr0304Barracks.core.factories;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.models.units.AbstractUnit;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"pr0304Barracks.models.units.";

	@Override
	public Unit createUnit(String unitType) {
	    Unit unit = null;
        try {
            Class<?> refClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<?> constructor = refClass.getDeclaredConstructor();
            unit = (Unit) constructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return unit;
	}
}
