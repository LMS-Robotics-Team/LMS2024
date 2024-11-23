package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.TeleOp.Arm;
import org.firstinspires.ftc.teamcode.TeleOp.Claw;
import org.firstinspires.ftc.teamcode.TeleOp.Drive;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class MainTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        new Arm(hardwareMap);
        new Claw(hardwareMap);
        new Drive(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            Arm.handleInput(gamepad2.left_stick_y, gamepad2.left_bumper, gamepad2.right_bumper, gamepad2.y);
            Claw.handleInput(gamepad2.a, gamepad2.x, gamepad2.dpad_up, gamepad2.dpad_down);
            Drive.handleInput(gamepad1);
        }
    }
}
