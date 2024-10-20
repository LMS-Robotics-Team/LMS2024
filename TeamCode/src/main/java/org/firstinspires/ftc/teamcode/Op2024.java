package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.TeleOp.Slide;
import org.firstinspires.ftc.teamcode.TeleOp.Claw;
import org.firstinspires.ftc.teamcode.TeleOp.Drive;

@TeleOp(name="Op2024", group="TeleOp")
public class Op2024 extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Slide.init(hardwareMap);
        Claw.init(hardwareMap);
        Drive.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            Slide.handleInput(gamepad2.left_stick_y, gamepad2.left_bumper, gamepad2.right_bumper);
            Claw.handleInput(gamepad2.a);
            Drive.handleInput(gamepad1);
        }
    }
}
