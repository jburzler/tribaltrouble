package com.oddlabs.tt.particle;

public final strictfp class StunFunction implements ParametricFunction {
	private final float radius;
	private final float height;

	public StunFunction(float radius, float height) {
		this.radius = radius;
		this.height = height;
	}

        @Override
	public final float getX(float u, float v) {
		return radius*(float)StrictMath.cos(u);
	}

        @Override
	public final float getY(float u, float v) {
		return radius*(float)StrictMath.sin(u);
	}

        @Override
	public final float getZ(float u, float v) {
		return height*(float)StrictMath.cos(v);
	}
}
