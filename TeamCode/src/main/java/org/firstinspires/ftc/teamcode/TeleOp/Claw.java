package org.firstinspires.ftc.teamcode.TeleOp;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw {
    private static Servo claw;

    public static void init(@NonNull HardwareMap hardwareMap) {
        claw = hardwareMap.get(Servo.class, "claw");
    }

    public static void handleInput(float stick) {
        claw.setPosition(stick);
    }
}