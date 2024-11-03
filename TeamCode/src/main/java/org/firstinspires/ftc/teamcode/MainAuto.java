package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Auto.Drive;
import org.firstinspires.ftc.teamcode.Auto.Claw;
import org.firstinspires.ftc.teamcode.Auto.Arm;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous
public class MainAuto extends LinearOpMode {
    @Override
    public void runOpMode() {
        Drive.init(hardwareMap);
        Claw.init(hardwareMap);
        Arm.init(hardwareMap);

        waitForStart();

        Drive.moveTo(5, 5, 5, 5, 1);

        sleep(1000);

        Claw.togglePosition();

        sleep(1000);

        Claw.togglePosition();

        sleep(1000);

        Arm.setServoOffset(-0.15);

        sleep(1000);

        Arm.setServoOffset(0.2);

        sleep(1000);

        Arm.moveTo(50, 1);
    }
}
