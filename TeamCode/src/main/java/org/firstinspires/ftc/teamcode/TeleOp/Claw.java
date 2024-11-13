package org.firstinspires.ftc.teamcode.TeleOp;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw {
    private static Servo servoBottom, servoTop;
    private static final double SERVOBOTTOM_DEFAULT = 0.4, SERVOTOP_MIN = 0, SERVOTOP_MAX = 1;

    public static void init(@NonNull HardwareMap hardwareMap) {
        servoBottom = hardwareMap.get(Servo.class, "clawServoBottom");
        servoTop = hardwareMap.get(Servo.class, "clawServoTop");

        servoBottom.setPosition(SERVOBOTTOM_DEFAULT);
        servoTop.setPosition(SERVOTOP_MIN);
    }

    public static void handleInput(boolean a, boolean right_stick_button, float right_stick_y) throws InterruptedException {
        if (a) {
            if (servoTop.getPosition() == SERVOTOP_MIN) servoTop.setPosition(SERVOTOP_MAX);
            else servoTop.setPosition(SERVOTOP_MIN);
            Thread.sleep(500);
        }
        if (right_stick_button) {
            servoBottom.setPosition(SERVOBOTTOM_DEFAULT * (1 - right_stick_y) / 2);
        }
    }
}