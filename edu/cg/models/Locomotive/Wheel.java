package edu.cg.models.Locomotive;

import edu.cg.models.IRenderable;
import edu.cg.util.glu.Cylinder;
import edu.cg.util.glu.Disk;

import static org.lwjgl.opengl.GL21.*;

/***
 * A simple 3D wheel renderer. The 3D wheel is centered at the origin, and its oriented along the x-axis.
 * This means that the wheel is parallel to the YZ-axis.
 */
public class Wheel implements IRenderable {
    @Override
    public void render() {
        glPushMatrix();
        // TODO-DONE(3) : Render the wheel using a Cylinder, and disks that about the cylinder.
        // Render base wheels tires
        glPushMatrix();
        Materials.setMaterialWheelTire();
        glRotated(90, 0, 1, 0);
        glTranslated(0., 0., -Specification.WHEEL_WIDTH/2);
        new Cylinder().draw(Specification.WHEEL_RADIUS, Specification.WHEEL_RADIUS, Specification.WHEEL_WIDTH,
                20,1);
        glPopMatrix();

        // Render right wheel rim
        glPushMatrix();
        Materials.setMaterialWheelRim();
        glRotated(90, 0, 1, 0);
        glTranslated(0, 0, Specification.WHEEL_RADIUS/2);
        new Disk().draw(0f, Specification.WHEEL_RIM_RADIUS, 20, 1);
        Materials.setMaterialWheelTire();
        new Disk().draw(Specification.WHEEL_RIM_RADIUS, Specification.WHEEL_RADIUS, 20, 1);
        glPopMatrix();

        // Render left wheel rim
        glPushMatrix();
        Materials.setMaterialWheelRim();
        glRotated(270, 0, 1, 0);
        glTranslated(0, 0, Specification.WHEEL_WIDTH/2);
        new Disk().draw(0f, Specification.WHEEL_RIM_RADIUS, 20, 1);
        Materials.setMaterialWheelTire();
        new Disk().draw(Specification.WHEEL_RIM_RADIUS, Specification.WHEEL_RADIUS, 20, 1);
        glPopMatrix();

        glPopMatrix();
    }

    @Override
    public void init() {
        // HW6 Related
    }
}
