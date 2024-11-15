package org.firstinspires.ftc.teamcode.Auto;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm {
    private static DcMotorEx motorLeft, motorRight;
    private static Servo servoLeft, servoRight;
    private static final double SERVO_MIN = 0.4, SERVO_DEFAULT = 0.5, SERVO_MAX = 0.6;

    public static void init(@NonNull HardwareMap hardwareMap) {
        motorLeft = hardwareMap.get(DcMotorEx.class, "armMotorLeft");
        motorRight = hardwareMap.get(DcMotorEx.class, "armMotorRight");
        servoLeft = hardwareMap.get(Servo.class, "armServoLeft");
        servoRight = hardwareMap.get(Servo.class, "armServoRight");

        motorLeft.setDirection(DcMotorEx.Direction.REVERSE);
        motorLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        motorRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        servoLeft.setPosition(SERVO_DEFAULT);
        servoRight.setPosition(SERVO_DEFAULT);
    }

    public static void setServoOffset(double offset) {
        double newPosition = SERVO_DEFAULT + offset;
        if (SERVO_MIN <= newPosition && newPosition <= SERVO_MAX) {
            servoLeft.setPosition(newPosition);
            servoRight.setPosition(SERVO_DEFAULT - offset);
        }
    }

    private static void setMode(DcMotorEx.RunMode mode) {
        motorLeft.setMode(mode);
        motorRight.setMode(mode);
    }

    public static void moveTo(int ticks, double speed) {
        motorLeft.setTargetPosition(ticks);
        motorRight.setTargetPosition(ticks);
        motorLeft.setPower(speed);
        motorRight.setPower(speed);

        setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        while (motorLeft.isBusy() || motorRight.isBusy()) {
            // Intentional
        }

        setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }
}