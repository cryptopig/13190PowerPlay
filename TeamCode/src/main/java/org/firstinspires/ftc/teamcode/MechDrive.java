package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.*;

/**
 * this turns most of Pranav's mechanum drive into a class that can be implemented in any opMode
 */
public final class MechDrive {

    public static DcMotor lf, rf, lb, rb;

    /**
     * call this in init phase
     */
    public static void init() {

        lf = hardwareMap.dcMotor.get("lf");
        lb = hardwareMap.dcMotor.get("lb");
        rf = hardwareMap.dcMotor.get("rf");
        rb = hardwareMap.dcMotor.get("rb");

        lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //left side might need to be swapped
        lf.setDirection(DcMotor.Direction.REVERSE);
        lb.setDirection(DcMotor.Direction.REVERSE);

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
        telemetry.update();

    }


    /**
     * call this in loop phase
     */
    public static void loop() {

        double px = gamepad1.left_stick_x;
        double py = -gamepad1.left_stick_y;
        double pa = gamepad1.right_stick_y;

        if (Math.abs(pa) < 0.05) pa = 0;

        double p1 = px + py + pa;
        double p2 = -px + py - pa;
        double p3 = -px + py - pa;
        double p4 = px + py + pa;

        double max = Math.max(1.0, Math.abs(p2));
        max = Math.max(max, Math.abs(p1));
        max = Math.max(max, Math.abs(p3));
        max = Math.max(max, Math.abs(p4));

        p2 /= max;
        p1 /= max;
        p3 /= max;
        p4 /= max;

        lf.setPower(p1);
        lb.setPower(p2);
        rf.setPower(p3);
        rb.setPower(p4);

        telemetry.addData("lf power", lf::getPower);
        telemetry.addData("lb power", lb::getPower);
        telemetry.addData("rf power", rf::getPower);
        telemetry.addData("rb power", rb::getPower);
        telemetry.update();

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
