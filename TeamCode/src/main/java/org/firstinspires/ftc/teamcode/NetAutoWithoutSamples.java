package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Auto.Arm;
import org.firstinspires.ftc.teamcode.Auto.Claw;
import org.firstinspires.ftc.teamcode.Auto.Drive;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous
public class NetAutoWithoutSamples extends LinearOpMode {
    @Override
    public void runOpMode() {
        new Drive(hardwareMap);
        new Claw(hardwareMap);
        new Arm(hardwareMap);

        waitForStart();

        // Expand
        Claw.setBottomOffset(0);
        sleep(500);

        // Tokyo Drift AKA pivot robot along BR wheel to align with submersible in one move
        Drive.moveTo(1150, -1150, -1150, 0, 0.5);

        // Add specimen to bar
        Drive.moveTo(400, 400, 400, 400, 0.5);
        Claw.toggleTopPosition();
        sleep(100);

        // Reverse out of the way
        Drive.moveTo(-200, -200, -200, -200, 1);
    }
}
