package org.firstinspires.ftc.teamcode.TeleOp;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw {
    private static Servo servoBottom, servoTop;
    private static final double SERVO_MIN = 0, SERVO_MAX = 1;

    public static void init(@NonNull HardwareMap hardwareMap) {
        servoBottom = hardwareMap.get(Servo.class, "clawServoBottom");
        servoTop = hardwareMap.get(Servo.class, "clawServoTop");

        servoBottom.setPosition(0);
        servoTop.setPosition(SERVO_MIN);
    }

    public static void handleInput(float right_stick_y, boolean a) throws InterruptedException {
        servoBottom.setPosition(right_stick_y);
        if (a) {
            if (servoTop.getPosition() == SERVO_MIN) servoTop.setPosition(SERVO_MAX);
            else servoTop.setPosition(SERVO_MIN);
            Thread.sleep(500);
        }
    }
}