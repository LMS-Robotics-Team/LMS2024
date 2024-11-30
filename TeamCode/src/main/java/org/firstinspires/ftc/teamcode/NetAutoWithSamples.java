package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Auto.Drive;
import org.firstinspires.ftc.teamcode.Auto.Claw;
import org.firstinspires.ftc.teamcode.Auto.Arm;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous
public class NetAutoWithSamples extends LinearOpMode {
    @Override
    public void runOpMode() {
        new Drive(hardwareMap);
        new Claw(hardwareMap);
        new Arm(hardwareMap);

        waitForStart();

        // Expand
        Claw.setBottomOffset(0);
        sleep(500);

        // Wait for other team
        sleep(2000);

        // Tokyo Drift AKA pivot robot along BR wheel to align with submersible in one move
        Drive.moveTo(1150, -1150, -1150, 0, 0.5);

        // Add specimen to bar
        Drive.moveTo(400, 400, 400, 400, 0.5);
        Claw.toggleTopPosition();
        sleep(100);

        // Reverse out of the way
        Drive.moveTo(-200, -200, -200, -200, 1);

        // Start Retracting
        Claw.setBottomOffset(0.4);

        // Turn left to get three samples
        Drive.moveTo(-520, 520, -520, 520, 1);

        // Move to gap
        Drive.moveTo(1100, 1100, 1100, 1100, 1);

        // Strafe right to align in parallel with three samples
        Drive.moveTo(1000, -1000, -1000, 1000, 1);

        for (int i = 0; i <= 2; i++) {
            // Align to push first sample
            Drive.moveTo(200, 200, 200, 200, 1);

            // Strafe left to score sample
            Drive.moveTo(-1400, 1400, 1400, -1400, 1);

            // Strafe right to return
            Drive.moveTo(1400, -1400, -1400, 1400, 1);
        }
    }
}
