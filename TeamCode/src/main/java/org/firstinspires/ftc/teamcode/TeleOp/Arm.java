package org.firstinspires.ftc.teamcode.TeleOp;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm {
    private static DcMotorEx motorLeft, motorRight;
    public static Servo servoLeft, servoRight;
    private static final double SERVO_DEFAULT = 0.35, SERVO_CHANGE = 0.07;

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

    public static void handleInput(float left_stick_y, boolean left_bumper, boolean right_bumper, Telemetry telemetry) throws InterruptedException {
        motorLeft.setPower(left_stick_y);
        motorRight.setPower(left_stick_y);

        if (left_bumper && servoLeft.getPosition() >= SERVO_DEFAULT - (SERVO_CHANGE / 2)) {
            servoLeft.setPosition(servoLeft.getPosition() - SERVO_CHANGE);
            servoRight.setPosition(servoRight.getPosition() + SERVO_CHANGE);
            Thread.sleep(500);
        }
        if (right_bumper && servoLeft.getPosition() <= SERVO_DEFAULT + (SERVO_CHANGE / 2)) {
            servoLeft.setPosition(servoLeft.getPosition() + SERVO_CHANGE);
            servoRight.setPosition(servoRight.getPosition() - SERVO_CHANGE);
            Thread.sleep(500);
        }
    }
}