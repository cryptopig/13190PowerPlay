package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * an opMode that tries the MechDrive and ArmClass classes
 */
@TeleOp
public class TeleOpV2 extends OpMode {

    @Override
    public void init() {

        MechDrive.init();

    }

    @Override
    public void start() {

        MechDrive.start();

    }

    @Override
    public void loop() {

        MechDrive.loop();

    }

}
