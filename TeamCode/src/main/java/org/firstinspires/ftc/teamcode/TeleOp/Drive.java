package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive {
    private static DcMotorEx motorFL, motorFR, motorBL, motorBR;
    private static final double SLOW_SPEED = 0.5, NORMAL_SPEED = 1;

    public Drive(HardwareMap hardwareMap) {
        motorFL = hardwareMap.get(DcMotorEx.class, "driveMotorFL");
        motorFR = hardwareMap.get(DcMotorEx.class, "driveMotorFR");
        motorBL = hardwareMap.get(DcMotorEx.class, "driveMotorBL");
        motorBR = hardwareMap.get(DcMotorEx.class, "driveMotorBR");

        motorFL.setDirection(DcMotorEx.Direction.REVERSE);
        motorBL.setDirection(DcMotorEx.Direction.REVERSE);
        motorFL.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        motorFR.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        motorBL.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        motorBR.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
    }

    public static void handleInput(Gamepad gamepad1) {
        double forwardBackward = -gamepad1.left_stick_y;
        double leftRight = gamepad1.right_stick_x;
        double rotate = gamepad1.right_trigger - gamepad1.left_trigger;

        double scale = gamepad1.a ? SLOW_SPEED : NORMAL_SPEED;
        double powerFL = scale * (forwardBackward + leftRight + rotate);
        double powerFR = scale * (forwardBackward - leftRight - rotate);
        double powerBL = scale * (forwardBackward - leftRight + rotate);
        double powerBR = scale * (forwardBackward + leftRight - rotate);

        motorFL.setPower(powerFL);
        motorFR.setPower(powerFR);
        motorBL.setPower(powerBL);
        motorBR.setPower(powerBR);
    }
}