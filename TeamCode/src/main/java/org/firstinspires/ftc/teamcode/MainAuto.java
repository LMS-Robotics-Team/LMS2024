package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.Auto.Drive;
import org.firstinspires.ftc.teamcode.Auto.Claw;
import org.firstinspires.ftc.teamcode.Auto.Arm;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous
public class MainAuto extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Drive.init(hardwareMap);
        Claw.init(hardwareMap);
        Arm.init(hardwareMap);

        waitForStart();

        telemetry.addLine("Started Drive Move To");
        telemetry.update();
        Drive.setDirection(DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.FORWARD);
        Drive.moveTo(100, 100, 100, 100, 0.5);
    }
}
