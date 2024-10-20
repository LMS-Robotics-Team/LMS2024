package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive {
    private static DcMotorEx driveFL, driveFR, driveBL, driveBR;
    private static final double MIN_SPEED = 0.5, MAX_SPEED = 1;

    public static void init(HardwareMap hardwareMap) {
        driveFL = hardwareMap.get(DcMotorEx.class, "driveMotorFL");
        driveFR = hardwareMap.get(DcMotorEx.class, "driveMotorFR");
        driveBL = hardwareMap.get(DcMotorEx.class, "driveMotorBL");
        driveBR = hardwareMap.get(DcMotorEx.class, "driveMotorBR");

        driveFL.setDirection(DcMotorEx.Direction.REVERSE);
        driveBL.setDirection(DcMotorEx.Direction.REVERSE);
    }

    public static void handleInput(Gamepad gamepad1) {
        double forwardBackward = -gamepad1.left_stick_y;
        double leftRight = gamepad1.right_stick_x;
        double rotate = gamepad1.right_trigger - gamepad1.left_trigger;

        double scale = gamepad1.a ? MIN_SPEED : MAX_SPEED;
        double powerFL = scale * (forwardBackward + leftRight + rotate);
        double powerFR = scale * (forwardBackward - leftRight - rotate);
        double powerBL = scale * (forwardBackward - leftRight + rotate);
        double powerBR = scale * (forwardBackward + leftRight - rotate);

        driveFL.setPower(powerFL);
        driveFR.setPower(powerFR);
        driveBL.setPower(powerBL);
        driveBR.setPower(powerBR);
    }
}