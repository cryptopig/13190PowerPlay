package org.firstinspires.ftc.teamcode;


import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequenceBuilder;

public class prateekTriesRoadRunner extends LinearOpMode {

        @Override
        public void runOpMode() {

            SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

            Trajectory myTrajectory = drive.trajectoryBuilder( new Pose2d() )
                    .forward(42)
                    .build();

            waitForStart();

            if(isStopRequested()) return;

            drive.followTrajectory(myTrajectory);
        }

}
