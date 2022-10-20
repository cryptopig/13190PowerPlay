package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.*;

/**
 * this turns Pranav's mechanum drive into a class that can be implemented in any opMode
 */
public final class MechDrive {

    public static DcMotor lf, rf, lb, rb;

    /**
     * call this in init phase
     */
    public static void init() {

        lf = hardwareMap.dcMotor.get("lf");
        rf = hardwareMap.dcMotor.get("rf");
        lb = hardwareMap.dcMotor.get("lb");
        rb = hardwareMap.dcMotor.get("rb");

        lf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        lf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Motors", "initialized");
        telemetry.update();

        telemetry.addData("Drive init", "done");

    }


    /**
     * call this in loop phase
     */
    public static void loop() {

        double vertical, horizontal, pivot;

        //take gamepad input
        vertical = gamepad1.left_stick_y;
        horizontal = gamepad1.left_stick_x;
        pivot = gamepad1.right_stick_x;

        //use gamepad input
        lf.setPower(pivot + (-horizontal - vertical));
        rf.setPower(pivot + (horizontal - vertical));
        lb.setPower(pivot + (horizontal - vertical));
        rb.setPower(pivot + (-horizontal - vertical));

    }

    /**
     * this is to reset motors. call in stop section
     */
    public static void stop() {

        lf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

}
