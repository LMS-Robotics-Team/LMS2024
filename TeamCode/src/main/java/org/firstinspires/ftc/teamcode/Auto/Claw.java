package org.firstinspires.ftc.teamcode.Auto;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw {
    private static Servo servoBottom, servoTop;
    private static final double SERVOBOTTOM_MIN = 0.4, SERVOBOTTOM_MAX = 0, SERVOTOP_MIN = 0, SERVOTOP_MAX = 1;

    public static void init(@NonNull HardwareMap hardwareMap) {
        servoBottom = hardwareMap.get(Servo.class, "clawServoBottom");
        servoTop = hardwareMap.get(Servo.class, "clawServoTop");

        servoBottom.setPosition(SERVOBOTTOM_MIN);
        servoTop.setPosition(SERVOTOP_MIN);
    }

    public static void setBottomOffset(double offset) {
        double newPosition = SERVOBOTTOM_MIN - offset;
        if (SERVOBOTTOM_MIN > newPosition && newPosition > SERVOBOTTOM_MAX) {
            servoBottom.setPosition(newPosition);
        }
    }

    public static void toggleTopPosition() {
        if (servoTop.getPosition() == SERVOTOP_MIN) servoTop.setPosition(SERVOTOP_MAX);
        else servoTop.setPosition(SERVOTOP_MIN);
    }
}