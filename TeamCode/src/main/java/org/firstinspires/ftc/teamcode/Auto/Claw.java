package org.firstinspires.ftc.teamcode.Auto;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw {
    private static Servo servoBottom, servoTop;
    private static final double SERVO_BOTTOM_MIN = 0, SERVO_BOTTOM_DEFAULT = 0.5, SERVO_BOTTOM_MAX = 1, SERVO_TOP_MIN = 0, SERVO_TOP_MAX = 1;

    public Claw(@NonNull HardwareMap hardwareMap) {
        servoBottom = hardwareMap.get(Servo.class, "clawServoBottom");
        servoTop = hardwareMap.get(Servo.class, "clawServoTop");

        servoBottom.setPosition(SERVO_BOTTOM_DEFAULT);
        servoTop.setPosition(SERVO_TOP_MIN);
    }

    public static void setBottomOffset(double offset) throws InterruptedException {
        double newPosition = SERVO_BOTTOM_DEFAULT + offset;
        if (SERVO_BOTTOM_MIN <= newPosition && newPosition <= SERVO_BOTTOM_MAX) {
            servoBottom.setPosition(newPosition);
            Thread.sleep(1000);
        }
    }

    public static void toggleTopPosition() throws InterruptedException {
        if (servoTop.getPosition() == SERVO_TOP_MIN) servoTop.setPosition(SERVO_TOP_MAX);
        else servoTop.setPosition(SERVO_TOP_MIN);
        Thread.sleep(500);
    }
}