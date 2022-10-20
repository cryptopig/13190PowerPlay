package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ServoImpl;

public final class ArmClass extends LinearOpMode {
    public void runOpMode() {} //oly for linear opMode

    private enum LiftTarget {
        JUNCTION,
        SHORT,
        MEDIUM,
        TALL;
    }

    private final int LIFT_RANGE = 2849; // + .81, double check if this is right

    public static DcMotor liftMotor;
    public static ServoImpl armServo, clawServo;

    public int getLIFT_RANGE() {
        return LIFT_RANGE;
    }

    public void initArm () {

        liftMotor = hardwareMap.dcMotor.get("arm_motor"); //312 rpm motor
        liftMotor.setTargetPosition(0);
        liftMotor.setMode( DcMotor.RunMode.RUN_TO_POSITION );

        armServo = (ServoImpl) hardwareMap.servo.get("arm_servo");
        clawServo = (ServoImpl) hardwareMap.servo.get("claw_servo");
    }

    public void turnArm () {

        if( armServo.getPosition() == 0.0 ) {
            armServo.setPosition(1);
        }

        else if( armServo.getPosition() == 1 ) {
            armServo.setPosition(0);
        }

        else {
            armServo.setPosition(0);
        }

    }

    public void turnArm (int degrees) {

        armServo.setPosition( Math.min( Math.max( armServo.getPosition() + degrees, 0 ), 1 ) );

    }

    public void runClaw () {
        if( clawServo.getPosition() == 0 ) {
            clawServo.setPosition(1);
        }

        else{
            clawServo.setPosition(0);
        }
    }

    public void runLift (LiftTarget liftTarget) {

        switch (liftTarget) { //swap 33.5 with max arm hight
            case JUNCTION:
                liftMotor.setTargetPosition(0);
                break;

            case SHORT:
                liftMotor.setTargetPosition( (int)(LIFT_RANGE * 13.5 / 33.5) );
                break;

            case MEDIUM:
                liftMotor.setTargetPosition( (int)(LIFT_RANGE * 23.5 / 33.5) );
                break;

            case TALL:
                liftMotor.setTargetPosition(LIFT_RANGE);
                break;

            default:
                break;
        }

    }

    public void runLift (int inches) {
        liftMotor.setTargetPosition( LIFT_RANGE * inches / 47 );
    } //meed to lessen 47

    public void grabCone ( int coneHight ) {

        if (armServo.getPosition() != 0) {
            turnArm();
        }

        runLift(coneHight);

        runClaw();

    }

    public void grabCone () {

        if (armServo.getPosition() != 0) {
            turnArm();
        }

        runLift(0);

        runClaw();

    }



    public void dropCone (LiftTarget liftTarget) {

        runLift(liftTarget);

        turnArm();

        runClaw();
    }

    public void dropCone (LiftTarget liftTarget, int degrees) {

        runLift(liftTarget);

        turnArm(degrees);

        runClaw();
    }

}