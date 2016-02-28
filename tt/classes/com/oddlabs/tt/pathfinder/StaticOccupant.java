package com.oddlabs.tt.pathfinder;

public final strictfp class StaticOccupant implements Occupant {
        @Override
	public final int getPenalty() {
		return Occupant.STATIC;
	}

        @Override
	public final int getGridX() {
		throw new RuntimeException();
	}

        @Override
	public final int getGridY() {
		throw new RuntimeException();
	}

        @Override
	public final float getPositionX() {
		throw new RuntimeException();
	}

        @Override
	public final float getPositionY() {
		throw new RuntimeException();
	}

        @Override
	public final float getSize() {
		throw new RuntimeException();
	}

        @Override
	public final boolean isDead() {
		throw new RuntimeException();
	}

	public final void startRespond() {
		throw new RuntimeException();
	}
	
	public final void stopRespond() {
		throw new RuntimeException();
	}
}
