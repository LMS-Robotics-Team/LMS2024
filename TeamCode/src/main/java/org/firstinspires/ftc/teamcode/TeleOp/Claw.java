package org.firstinspires.ftc.teamcode.TeleOp;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw {
    private static Servo servoBottom, servoTop;
    private static final double SERVOBOTTOM_MIN = 0, SERVOBOTTOM_MAX = 1, SERVOBOTTOM_CHANGE = 0.005, SERVOTOP_MIN = 0, SERVOTOP_MAX = 0.15;
    private static double servoOffset = 0;

    public static void init(@NonNull HardwareMap hardwareMap) {
        servoBottom = hardwareMap.get(Servo.class, "clawServoBottom");
        servoTop = hardwareMap.get(Servo.class, "clawServoTop");

        servoBottom.setPosition(servoOffset);
        servoTop.setPosition(SERVOTOP_MIN);
    }

    public static void handleInput(boolean a, boolean dpad_up, boolean dpad_down) throws InterruptedException {
        if (a) {
            if (servoTop.getPosition() == SERVOTOP_MIN) servoTop.setPosition(SERVOTOP_MAX);
            else servoTop.setPosition(SERVOTOP_MIN);
            Thread.sleep(500);
        }
        if (dpad_up && SERVOBOTTOM_MIN + servoOffset > SERVOBOTTOM_MIN) {
            servoOffset -= SERVOBOTTOM_CHANGE;
        }
        if (dpad_down && SERVOBOTTOM_MIN + servoOffset < SERVOBOTTOM_MAX) {
            servoOffset += SERVOBOTTOM_CHANGE;
        }
        servoBottom.setPosition(SERVOBOTTOM_MIN + servoOffset);
    }
}