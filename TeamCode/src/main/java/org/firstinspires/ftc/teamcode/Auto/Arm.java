package org.firstinspires.ftc.teamcode.Auto;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm {
    private static Servo servoLeft, servoRight;
    private static final double SERVO_MIN = 0.4, SERVO_DEFAULT = 0.5, SERVO_MAX = 0.6;

    public static void init(@NonNull HardwareMap hardwareMap) {
        servoLeft = hardwareMap.get(Servo.class, "armServoLeft");
        servoRight = hardwareMap.get(Servo.class, "armServoRight");

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
}