package edu.cg.models.Locomotive;

/**
 * TODO-DONE(2) : Read the instructions below for further information.
 * This class contains constants that could be used when building our 3D Model.
 * BASE_UNIT is our unit measure and it represents a square in the provided sketch (see assignment instructions).
 */
public final class Specification {
    public static final float BASE_UNIT = (float) .1;
    public static final float EPS = (float) 1e-5;

    // Back Body
    public static final float BACK_BODY_DEPTH = 8 * BASE_UNIT;
    public static final float BACK_BODY_HEIGHT = 4 * BASE_UNIT;
    public static final float BACK_BODY_WIDTH = 4 * BASE_UNIT;

    // Front body:
    public static final float FRONT_BODY_DEPTH = 5 * BASE_UNIT;
    public static final float FRONT_BODY_HEIGHT = 2 * BASE_UNIT;
    public static final float FRONT_BODY_WIDTH = BACK_BODY_WIDTH;

    // Wheel:
    public static final float WHEEL_RIM_RADIUS = (float) (0.75 * BASE_UNIT);
    public static final float WHEEL_RADIUS = BASE_UNIT;
    public static final float WHEEL_WIDTH = BASE_UNIT;

    // Chimney:
    public static final float CHIMNEY_FIRST_TUBE_HEIGHT = 2 * BASE_UNIT;
    public static final float CHIMNEY_FIRST_TUBE_RADIUS = BASE_UNIT;
    public static final float CHIMNEY_SECOND_TUBE_HEIGHT = 1 * BASE_UNIT;
    public static final float CHIMNEY_SECOND_TUBE_RADIUS = (float) (1.25 * BASE_UNIT);

    // Car Light:
    public static final float CAR_LIGHT_DEPTH = (float) (0.5 * BASE_UNIT);
    public static final float CAR_LIGHT_INNER_RADIUS = (float) (0.4 * BASE_UNIT);
    public static final float CAR_LIGHT_OUTER_RADIUS = (float) (0.5 * BASE_UNIT);

    // Roof:
    public static final float ROOF_DEPTH = BACK_BODY_DEPTH - 2 * EPS;
    public static final float ROOF_HEIGHT = (float) (0.6 * BASE_UNIT);
    public static final float ROOF_WIDTH = BACK_BODY_WIDTH;

    // Door:
    public static final float DOOR_DEPTH = EPS;
    public static final float DOOR_HEIGHT = (float) (BACK_BODY_HEIGHT - 0.5*BASE_UNIT);
    public static final float DOOR_WIDTH = (float) (1.5 * BASE_UNIT);

    // Window - SMALL:
    public static final float WINDOW_S_HEIGHT = 2 * BASE_UNIT;
    public static final float WINDOW_S_WIDTH = (float) (1.5 * BASE_UNIT);

    // Window - LARGE:
    public static final float WINDOW_L_HEIGHT = 2 * BASE_UNIT;
    public static final float WINDOW_L_WIDTH = 3 * BASE_UNIT;
}
