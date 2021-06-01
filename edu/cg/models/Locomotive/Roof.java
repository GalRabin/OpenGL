package edu.cg.models.Locomotive;

import edu.cg.models.IRenderable;
import edu.cg.util.glu.Cylinder;
import edu.cg.util.glu.Disk;

import static org.lwjgl.opengl.GL11.*;

/***
 * A 3D roof model renderer.
 * The roof is modeled using a cylinder bounded by disks that undergo a non-uniform scaling.
 */
public class Roof implements IRenderable {

    @Override
    public void render() {
        glPushMatrix();
        // TODO-DONE(7): Render the locomotive back body roof
        // Set roof color
        Materials.setMaterialRoof();

        // Set scaling
        glScaled(Specification.ROOF_WIDTH / 2, Specification.ROOF_HEIGHT / 2, 1);

        // Render roof top cylinder
        glPushMatrix();
        (new Cylinder()).draw(1, 1, Specification.ROOF_DEPTH, 20, 1);
        glPopMatrix();

        // Render front roof closing cylinder
        glPushMatrix();
        glTranslated(0, 0, Specification.ROOF_DEPTH - Specification.EPS);
        (new Disk()).draw(0, 1, 20, 1);
        glPopMatrix();

        // Render back roof closing cylinder
        glPushMatrix();
        glRotated(180, 0, 1, 0);
        glTranslated(0, 0, -Specification.EPS);
        (new Disk()).draw(0, 1, 20, 1);
        glPopMatrix();

        glPopMatrix();
    }

    @Override
    public void init() {

    }
}
