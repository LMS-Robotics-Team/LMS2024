package org.firstinspires.ftc.teamcode.Auto;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw {
    private static Servo servoBottomLeft, servoBottomRight, servoTop;
    private static final double SERVO_BOTTOM_MIN = 0, SERVO_BOTTOM_DEFAULT = 0.5, SERVO_BOTTOM_MAX = 1, SERVO_TOP_MIN = 0, SERVO_TOP_MAX = 0.15;

    public Claw(@NonNull HardwareMap hardwareMap) {
        servoBottomLeft = hardwareMap.get(Servo.class, "clawServoBottomLeft");
        servoBottomRight = hardwareMap.get(Servo.class, "clawServoBottomRight");
        servoTop = hardwareMap.get(Servo.class, "clawServoTop");

        servoTop.setPosition(SERVO_TOP_MAX);
    }

    public static void setBottomOffset(double offset) {
        double newPosition = SERVO_BOTTOM_DEFAULT + offset;
        if (SERVO_BOTTOM_MIN <= newPosition && newPosition <= SERVO_BOTTOM_MAX) {
            servoBottomLeft.setPosition(newPosition);
            servoBottomRight.setPosition(SERVO_BOTTOM_DEFAULT - offset);
        }
    }

    public static void toggleTopPosition() {
        if (servoTop.getPosition() == SERVO_TOP_MIN) servoTop.setPosition(SERVO_TOP_MAX);
        else servoTop.setPosition(SERVO_TOP_MIN);
    }
}