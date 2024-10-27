package org.firstinspires.ftc.teamcode.Auto;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw {
    private static Servo servo;
    private static final double SERVO_MIN = 0, SERVO_MAX = 1;

    public static void init(@NonNull HardwareMap hardwareMap) {
        servo = hardwareMap.get(Servo.class, "clawServo");

        servo.setPosition(SERVO_MIN);
    }

    public static void togglePosition() {
        if (servo.getPosition() == SERVO_MIN) servo.setPosition(SERVO_MAX);
        else servo.setPosition(SERVO_MIN);
    }
}