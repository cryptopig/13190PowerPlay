package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name = "MechDive")
public class DriveTeleOp extends OpMode {

    @Override
    public void init() {

        MechDrive.init();

        telemetry.addData("init", "done");
        telemetry.update();
    }

    //TODO: make sure the code here lines up with the stuff written up on thursday
    @Override
    public void loop() {

        MechDrive.loop();

        //a faster way to stop opmode
        if (gamepad1.guide || gamepad2.guide) {

            terminateOpModeNow();

        }

    }

    @Override
    public void stop() {

        MechDrive.stop();

    }
}
