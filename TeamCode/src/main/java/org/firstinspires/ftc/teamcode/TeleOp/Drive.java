package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive {
    private static DcMotorEx driveFL, driveFR, driveBL, driveBR;

    public static void init(HardwareMap hardwareMap) {
        // Get motors from hardwareMap
        driveFL = hardwareMap.get(DcMotorEx.class, "motor0");
        driveFR = hardwareMap.get(DcMotorEx.class, "motor1");
        driveBL = hardwareMap.get(DcMotorEx.class, "motor2");
        driveBR = hardwareMap.get(DcMotorEx.class, "motor3");

        // Set left motors to go reverse (relative to motor, not chassis).
        driveFL.setDirection(DcMotorEx.Direction.REVERSE);
        driveBL.setDirection(DcMotorEx.Direction.REVERSE);
    }

    public static void handleInput(Gamepad gamepad1) {
        // Sets values of variables for gamepad1 (start+a) inputs for driving
        // Creates variables for drive inputs from controllers
        double ForwardBackward = -gamepad1.left_stick_y;
        double LeftRight = gamepad1.right_stick_x;
        double Rotate = gamepad1.right_trigger - gamepad1.left_trigger;

        // Set drive powers and if pressing a, half the speed.
        if (gamepad1.a) {
            driveFL.setPower((ForwardBackward + LeftRight + Rotate) / 2);
            driveFR.setPower((ForwardBackward - LeftRight - Rotate) / 2);
            driveBL.setPower((ForwardBackward - LeftRight + Rotate) / 2);
            driveBR.setPower((ForwardBackward + LeftRight - Rotate) / 2);
        } else {
            driveFL.setPower(ForwardBackward + LeftRight + Rotate);
            driveFR.setPower(ForwardBackward - LeftRight - Rotate);
            driveBL.setPower(ForwardBackward - LeftRight + Rotate);
            driveBR.setPower(ForwardBackward + LeftRight - Rotate);
        }
    }
}