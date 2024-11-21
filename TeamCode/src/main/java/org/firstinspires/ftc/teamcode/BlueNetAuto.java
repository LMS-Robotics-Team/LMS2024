package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.Auto.Drive;
import org.firstinspires.ftc.teamcode.Auto.Claw;
import org.firstinspires.ftc.teamcode.Auto.Arm;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous
public class BlueNetAuto extends LinearOpMode {
    @Override
    public void runOpMode() {
        new Drive(hardwareMap);
        new Claw(hardwareMap);
        new Arm(hardwareMap);

        waitForStart();

        // Get room by moving away from starting spot
        Drive.setDirection(DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.FORWARD);
        Drive.moveTo(200, 200, 200, 200, 0.75);

        // Strafe right to miss side of submersible
        Drive.setDirection(DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.FORWARD);
        Drive.moveTo(280, 280, 280, 280, 0.75);

        // Add specimen to bar
        Drive.setDirection(DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.FORWARD);
        Drive.moveTo(500, 500, 500, 500, 0.75);
        Claw.toggleTopPosition();
        sleep(100);

        // Reverse out of the way
        Drive.setDirection(DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.REVERSE);
        Drive.moveTo(200, 200, 200, 200, 0.75);

        // Move claw out of the way
        Claw.setBottomOffset(0.5);

        // Turn left to get three samples
        Drive.setDirection(DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.FORWARD);
        Drive.moveTo(520, 520, 520, 520, 0.75);

        // Move to gap
        Drive.setDirection(DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.FORWARD);
        Drive.moveTo(950, 950, 950, 950, 0.75);

        // Strafe right to align in parallel with three samples
        Drive.setDirection(DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.FORWARD);
        Drive.moveTo(1000, 1000, 1000, 1000, 0.75);

        for (int i = 0; i <= 2; i++) {
            // Align to push first sample
            Drive.setDirection(DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.FORWARD);
            Drive.moveTo(250, 250, 250, 250, 0.2);

            // Strafe left to score sample
            Drive.setDirection(DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.REVERSE);
            Drive.moveTo(1300, 1300, 1300, 1300, 0.75);

            // Strafe Right to return
            Drive.setDirection(DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.FORWARD);
            Drive.moveTo(1300, 1300, 1300, 1300, 0.75);
        }
    }
}
