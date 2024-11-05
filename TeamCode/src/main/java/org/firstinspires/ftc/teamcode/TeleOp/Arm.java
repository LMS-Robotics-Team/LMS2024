package org.firstinspires.ftc.teamcode.TeleOp;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm {
    private static DcMotorEx motorLeft, motorRight;
    private static Servo servoLeft, servoRight;
    private static final double SERVO_MIN = 0.4, SERVO_DEFAULT = 0.55, SERVO_CHANGE = 0.001, SERVO_MAX = 0.7;

    public static void init(@NonNull HardwareMap hardwareMap) {
        motorLeft = hardwareMap.get(DcMotorEx.class, "slideMotorLeft");
        motorRight = hardwareMap.get(DcMotorEx.class, "slideMotorRight");
        servoLeft = hardwareMap.get(Servo.class, "slideServoLeft");
        servoRight = hardwareMap.get(Servo.class, "slideServoRight");

        motorLeft.setDirection(DcMotorEx.Direction.REVERSE);
        motorRight.setDirection(DcMotorEx.Direction.FORWARD);
        servoLeft.setPosition(SERVO_DEFAULT);
        servoRight.setPosition(SERVO_DEFAULT);
    }

    public static void handleInput(float left_stick_y, boolean left_bumper, boolean right_bumper) {
        motorLeft.setPower(left_stick_y);
        motorRight.setPower(left_stick_y);

        if (left_bumper && servoLeft.getPosition() > SERVO_MIN) {
            servoLeft.setPosition(servoLeft.getPosition() - SERVO_CHANGE);
            servoRight.setPosition(servoRight.getPosition() + SERVO_CHANGE);
        }
        if (right_bumper && servoLeft.getPosition() < SERVO_MAX) {
            servoLeft.setPosition(servoLeft.getPosition() + SERVO_CHANGE);
            servoRight.setPosition(servoRight.getPosition() - SERVO_CHANGE);
        }
    }
}