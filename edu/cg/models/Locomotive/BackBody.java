package edu.cg.models.Locomotive;

import edu.cg.models.Box;
import edu.cg.models.IRenderable;

import static org.lwjgl.opengl.GL21.*;


/***
 * A 3D locomotive back body renderer. The back-body of the locomotive model is composed of a chassis, two back wheels,
 * , a roof, windows and a door.
 */
public class BackBody implements IRenderable {
    // The back body is composed of one box that represents the locomotive front body.
    private Box chassis = new Box(Specification.BACK_BODY_WIDTH, Specification.BACK_BODY_HEIGHT, Specification.BACK_BODY_DEPTH);
    // The back body is composed of two back wheels.
    private Wheel wheel = new Wheel();
    // The back body is composed of a roof that lies on-top of the locomotive chassis.
    private Roof roof = new Roof();
    // TODO-DONE (9): Define your window/door objects here. You are free to implement these models as you wish as long as you
    //           stick to the locomotive sketch.
    // The back body is composed of a small window that lies on the right side of the locomotive
    private Box door = new Box(Specification.DOOR_WIDTH, Specification.DOOR_HEIGHT, Specification.DOOR_DEPTH);
    // The back body is composed of a small window that lies on the side of the locomotive
    private Box windowSmall = new Box(Specification.WINDOW_S_WIDTH, Specification.WINDOW_S_HEIGHT, Specification.EPS);
    // The back body is composed of a large window that lies on front/back of the locomotive
    private Box windowLarge = new Box(Specification.WINDOW_L_WIDTH, Specification.WINDOW_L_HEIGHT, Specification.EPS);

    @Override
    public void render() {
        glPushMatrix();
        // TODO-DONE(8): render the back-body of the locomotive model. You need to combine the chassis, wheels and roof using
        //          affine transformations. In addition, you need to render the back-body windows and door. You can do
        //          that using simple QUADRATIC polygons (use GL_QUADS).

        // Render chassis
        glPushMatrix();
        Materials.setMaterialChassis();
        chassis.render();
        glPopMatrix();

        // Render roof
        glPushMatrix();
        glTranslatef(0,
                Specification.BACK_BODY_HEIGHT / 2,
                -Specification.BACK_BODY_DEPTH / 2);
        roof.render();
        glPopMatrix();

        // Render left wheel
        glPushMatrix();
        glTranslated(Specification.BACK_BODY_WIDTH/2,
                -Specification.BACK_BODY_HEIGHT/2,
                -Specification.WHEEL_RADIUS);
        wheel.render();
        glPopMatrix();

        // Render right wheel
        glPushMatrix();
        glTranslated(-Specification.BACK_BODY_WIDTH/2,
                -Specification.BACK_BODY_HEIGHT/2,
                -Specification.WHEEL_RADIUS);
        wheel.render();
        glPopMatrix();

        // Render door on the right
        glPushMatrix();
        Materials.setMaterialInternal();
        float doorBaseOffset = (float) (Specification.BACK_BODY_DEPTH/2-1.5*Specification.BASE_UNIT);
        glTranslated(-(Specification.BACK_BODY_WIDTH/2+Specification.EPS), -0.25*Specification.BASE_UNIT, doorBaseOffset);
        glRotated(-90, 0, 1, 0);
        door.render();
        glPopMatrix();

        // Render back window
        glPushMatrix();
        Materials.setMaterialInternal();
        glTranslated(0, Specification.BASE_UNIT*0.5, -Specification.BACK_BODY_DEPTH/2-Specification.EPS);
        windowLarge.render();
        glPopMatrix();

        // Render front window
        glPushMatrix();
        Materials.setMaterialInternal();
        glTranslated(0, Specification.BASE_UNIT*0.5, Specification.BACK_BODY_DEPTH/2+Specification.EPS);
        windowLarge.render();
        glPopMatrix();

        // Render right windows
        for (int i = 1; i < 3; i++) {
            glPushMatrix();
            Materials.setMaterialInternal();
            glTranslated(-(Specification.BACK_BODY_WIDTH/2+Specification.EPS),
                    Specification.DOOR_HEIGHT/2-Specification.WINDOW_S_HEIGHT/2-0.25*Specification.BASE_UNIT,
                    doorBaseOffset-2.5*i*Specification.BASE_UNIT);
            glRotated(-90, 0, 1, 0);
            windowSmall.render();
            glPopMatrix();
        }

        // Render left windows
        for (int i = 0; i < 3; i++) {
            glPushMatrix();
            Materials.setMaterialInternal();
            glTranslated(Specification.BACK_BODY_WIDTH/2+Specification.EPS,
                    Specification.DOOR_HEIGHT/2-Specification.WINDOW_S_HEIGHT/2-0.25*Specification.BASE_UNIT,
                    doorBaseOffset-2.5*i*Specification.BASE_UNIT);
            glRotated(-90, 0, 1, 0);
            windowSmall.render();
            glPopMatrix();
        }
        glPopMatrix();
    }


    @Override
    public void init() {

    }
}
