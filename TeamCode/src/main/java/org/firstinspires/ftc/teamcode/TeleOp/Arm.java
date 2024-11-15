package org.firstinspires.ftc.teamcode.TeleOp;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm {
    private static DcMotorEx motorLeft, motorRight;
    private static Servo servoLeft, servoRight;
    private static final double SERVO_MIN = 0.4, SERVO_DEFAULT = 0.5, SERVO_CHANGE = 0.0005, SERVO_MAX = 0.6;
    private static double servoOffset = 0;

    public static void init(@NonNull HardwareMap hardwareMap) {
        motorLeft = hardwareMap.get(DcMotorEx.class, "armMotorLeft");
        motorRight = hardwareMap.get(DcMotorEx.class, "armMotorRight");
        servoLeft = hardwareMap.get(Servo.class, "armServoLeft");
        servoRight = hardwareMap.get(Servo.class, "armServoRight");

        motorLeft.setDirection(DcMotorEx.Direction.REVERSE);
        motorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        servoLeft.setPosition(SERVO_DEFAULT);
        servoRight.setPosition(SERVO_DEFAULT);
    }

    public static void handleInput(float left_stick_y, boolean left_bumper, boolean right_bumper) {
        motorLeft.setPower(left_stick_y);
        motorRight.setPower(left_stick_y);

        if (left_bumper && SERVO_DEFAULT + servoOffset > SERVO_MIN) {
            servoOffset -= SERVO_CHANGE;
        }
        if (right_bumper && SERVO_DEFAULT + servoOffset < SERVO_MAX) {
            servoOffset += SERVO_CHANGE;
        }

        servoLeft.setPosition(SERVO_DEFAULT + servoOffset);
        servoRight.setPosition(SERVO_DEFAULT - servoOffset);
    }
}