package com.oddlabs.tt.pathfinder;

import com.oddlabs.tt.model.Selectable;
import java.util.*;

public final strictfp class FindOccupantFilter<T extends Selectable> implements ScanFilter {
	private final float x;
	private final float y;
	private final float radius;
	private final Selectable src;
	private final Class<T> type;
	private final List<T> result;

	public FindOccupantFilter(float x, float y, float radius, Selectable src, Class<T> type) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.src = src;
		this.type = type;
		result = new ArrayList<>();
	}

        @Override
	public int getMinRadius() {
		return 0;
	}

        @Override
	public int getMaxRadius() {
		return UnitGrid.toGridCoordinate(radius);
	}

        @Override
        @SuppressWarnings("unchecked")
	public boolean filter(int grid_x, int grid_y, Occupant occ) {
		if (type.isInstance(occ) && occ != src) {
			T s = (T)occ;
			float dx = s.getPositionX() - x;
			float dy = s.getPositionY() - y;
			float squared_dist = dx*dx + dy*dy;
			if (!result.contains(s) && squared_dist < radius*radius) {
				result.add(s);
			}
		}
		return false;
	}

	public List<T> getResult() {
		return result;
	}
}
