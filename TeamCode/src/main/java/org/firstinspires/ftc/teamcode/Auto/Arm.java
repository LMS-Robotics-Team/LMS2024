package org.firstinspires.ftc.teamcode.Auto;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm {
    private static DcMotorEx motorLeft, motorRight;
    private static Servo servoLeft, servoRight;
    private static final double SERVO_MIN = 0.2, SERVO_DEFAULT = 0.35, SERVO_MAX = 0.4;

    public static void init(@NonNull HardwareMap hardwareMap) {
        motorLeft = hardwareMap.get(DcMotorEx.class, "slideMotorLeft");
        motorRight = hardwareMap.get(DcMotorEx.class, "slideMotorRight");
        servoLeft = hardwareMap.get(Servo.class, "slideServoLeft");
        servoRight = hardwareMap.get(Servo.class, "slideServoRight");

        setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        motorLeft.setDirection(DcMotorEx.Direction.REVERSE);

        servoLeft.setPosition(SERVO_DEFAULT);
        servoRight.setPosition(SERVO_DEFAULT);
    }

    public static void setServoOffset(double offset) {
        double newPosition = SERVO_DEFAULT + offset;
        if (SERVO_MIN < newPosition && newPosition < SERVO_MAX) {
            servoLeft.setPosition(newPosition);
            servoRight.setPosition(SERVO_DEFAULT - offset);
        }
    }

    private static void setMode(DcMotorEx.RunMode mode) {
        motorLeft.setMode(mode);
        motorRight.setMode(mode);
    }

    public static void moveTo(int ticks, double velocity) {
        motorLeft.setTargetPosition(ticks);
        motorRight.setTargetPosition(ticks);
        motorLeft.setVelocity(velocity);
        motorRight.setVelocity(velocity);

        setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        while (motorLeft.isBusy() || motorRight.isBusy()) {
            Thread.yield();
        };

        setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }
}