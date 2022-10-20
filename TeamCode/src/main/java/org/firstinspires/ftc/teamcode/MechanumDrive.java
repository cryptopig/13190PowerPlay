package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class MechanumDrive extends OpMode {

    DcMotor lf, lb, rf, rb;
    private void drive() {

        double px = gamepad1.left_stick_x;
        double py = -gamepad1.left_stick_y;
        double pa = gamepad1.right_stick_y;

        if (Math.abs(pa) < 0.05) pa = 0;

        double p1 = px + py + pa;
        double p2 = -px + py - pa;
        double p3 = -px + py + pa;
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

    }


    @Override
    public void init() {

        lf = hardwareMap.dcMotor.get("lf");
        lb = hardwareMap.dcMotor.get("lb");
        rf = hardwareMap.dcMotor.get("rf");
        rb = hardwareMap.dcMotor.get("rb");
        telemetry.addData("motors", "initialised");
        telemetry.update();

        telemetry.addData("init", "finished");
        telemetry.update();

    }

    @Override
    public void loop() {

        drive();

        telemetry.addData("lf power", lf::getPower);
        telemetry.addData("lb power", lb::getPower);
        telemetry.addData("rf power", rf::getPower);
        telemetry.addData("rb power", rb::getPower);
        telemetry.update();

    }
}
