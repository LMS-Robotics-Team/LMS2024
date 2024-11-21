package org.firstinspires.ftc.teamcode.TeleOp;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw {
    private static Servo servoBottomLeft, servoBottomRight, servoTop;
    private static final double SERVO_BOTTOM_MIN = 0, SERVO_BOTTOM_DEFAULT = 0.5, SERVO_BOTTOM_MAX = 1, SERVO_BOTTOM_CHANGE = 0.005, SERVO_TOP_MIN = 0, SERVO_TOP_MAX = 0.15;
    private static double servoOffset = 0;

    public Claw(@NonNull HardwareMap hardwareMap) {
        servoBottomLeft = hardwareMap.get(Servo.class, "clawServoBottomLeft");
        servoBottomRight = hardwareMap.get(Servo.class, "clawServoBottomRight");
        servoTop = hardwareMap.get(Servo.class, "clawServoTop");

        servoBottomLeft.setPosition(SERVO_BOTTOM_DEFAULT);
        servoBottomRight.setPosition(SERVO_BOTTOM_DEFAULT);
        servoTop.setPosition(SERVO_TOP_MIN);
    }

    public static void handleInput(boolean a, boolean dpad_up, boolean dpad_down) throws InterruptedException {
        if (a) {
            if (servoTop.getPosition() == SERVO_TOP_MIN) servoTop.setPosition(SERVO_TOP_MAX);
            else servoTop.setPosition(SERVO_TOP_MIN);
            Thread.sleep(500);
        }
        if (dpad_up && SERVO_BOTTOM_DEFAULT + servoOffset > SERVO_BOTTOM_MIN) {
            servoOffset -= SERVO_BOTTOM_CHANGE;
        }
        if (dpad_down && SERVO_BOTTOM_DEFAULT + servoOffset < SERVO_BOTTOM_MAX) {
            servoOffset += SERVO_BOTTOM_CHANGE;
        }
        servoBottomLeft.setPosition(SERVO_BOTTOM_DEFAULT + servoOffset);
        servoBottomRight.setPosition(SERVO_BOTTOM_DEFAULT - servoOffset);
    }
}