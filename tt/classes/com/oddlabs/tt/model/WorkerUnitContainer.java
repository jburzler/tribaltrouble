package com.oddlabs.tt.model;

public final strictfp class WorkerUnitContainer extends UnitContainer {
	private final Building building;

	public WorkerUnitContainer(Building building) {
		super(building.getOwner().getWorld().getMaxUnitCount());
		this.building = building;
	}

        @Override
	public final void enter(Unit unit) {
		assert canEnter(unit);
		unit.removeNow();
		increaseSupply(1);
	}

        @Override
	public final boolean canEnter(Unit unit) {
		return getTotalSupplies() != getMaxSupplyCount();
	}

	private final int getTotalSupplies() {
//		return getNumSupplies() + building.getBuildSupplyContainer(Unit.class).getNumSupplies() == getMaxSupplyCount();
		return getNumSupplies() + getNumPreparing();
	}

        @Override
	public final Unit exit() {
		assert getNumSupplies() > 0;
		increaseSupply(-1);
		return null;
	}

        @Override
	public int increaseSupply(int amount) {
		int result = building.getOwner().getUnitCountContainer().increaseSupply(amount);
		assert result == amount: "result = " + result + " | amount = " + amount;
		return super.increaseSupply(amount);
	}

        @Override
	public final void animate(float t) {
	}
}
