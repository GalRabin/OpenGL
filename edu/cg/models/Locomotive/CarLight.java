package edu.cg.models.Locomotive;

import edu.cg.models.IRenderable;
import edu.cg.util.glu.Cylinder;
import edu.cg.util.glu.Disk;

import static org.lwjgl.opengl.GL21.*;

/***
 * A 3D CarLight renderer. The locomotive light is oriented such that it is parallel to the XY plane.
 * TODO-DONE(4) : read this code and understand how do we render the locomotive light.
 */
public class CarLight implements IRenderable {
    @Override
    public void render() {
        glPushMatrix();

        // Render light cylinder case
        Materials.setMaterialLightCase();
        glPushMatrix();
        new Cylinder()
                .draw(Specification.CAR_LIGHT_OUTER_RADIUS,
                        Specification.CAR_LIGHT_OUTER_RADIUS,
                        Specification.CAR_LIGHT_DEPTH, 20, 1);
        glPopMatrix();

        // Render light cylinder closing case
        glTranslated(0., 0., Specification.CAR_LIGHT_DEPTH);
        new Disk().draw(Specification.CAR_LIGHT_INNER_RADIUS,
                        Specification.CAR_LIGHT_OUTER_RADIUS, 20, 1);
        // Render light actual light
        Materials.setMaterialFrontLight();
        new Disk().draw(0, Specification.CAR_LIGHT_INNER_RADIUS, 20, 1);

        glPopMatrix();
    }

    @Override
    public void init() {

    }
}
