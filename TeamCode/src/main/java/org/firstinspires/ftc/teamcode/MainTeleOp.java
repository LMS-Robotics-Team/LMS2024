package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.TeleOp.Arm;
import org.firstinspires.ftc.teamcode.TeleOp.Claw;
import org.firstinspires.ftc.teamcode.TeleOp.Drive;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class MainTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Arm.init(hardwareMap);
        Claw.init(hardwareMap);
        Drive.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            Arm.handleInput(gamepad2.left_stick_y, gamepad2.left_bumper, gamepad2.right_bumper, telemetry);
            Claw.handleInput(gamepad2.a);
            Drive.handleInput(gamepad1);
        }
    }
}
