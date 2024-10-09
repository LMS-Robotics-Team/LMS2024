package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.TeleOp.Slide;

@TeleOp(name="Op2024", group="TeleOp")
public class Op2024 extends LinearOpMode {
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        Slide.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            Slide.handleInput(gamepad2.left_stick_y);
        }
    }
}
