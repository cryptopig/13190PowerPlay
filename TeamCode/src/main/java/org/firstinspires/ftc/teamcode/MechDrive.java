package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.*;

/**
 * this turns Pranav's mechanum drive into a class that can be implemented in any opMode
 */
public final class MechDrive {

    public static DcMotor lf, rf, lb, rb;

    public static double vertical, horizontal, pivot;

    /**
     * call this in init phase
     */
    public static void init() {

        lf = hardwareMap.dcMotor.get("lf");
        rf = hardwareMap.dcMotor.get("rf");
        lb = hardwareMap.dcMotor.get("lb");
        rb = hardwareMap.dcMotor.get("rb");
        telemetry.addData("Motors", "initialized");

        telemetry.addData("Init ","finished");
    }

    /**
     * call this in init phase
     */
    public static void start () {

        vertical = gamepad1.left_stick_y;
        horizontal = gamepad1.left_stick_x;
        pivot = gamepad1.right_stick_x;
    }

    /**
     * call this in init phase
     */
    public static void loop() {

        lf.setPower(pivot + (-horizontal - vertical));
        rf.setPower(pivot + (horizontal - vertical));
        lb.setPower(pivot + (horizontal - vertical));
        rb.setPower(pivot + (-horizontal - vertical));

    }

}
