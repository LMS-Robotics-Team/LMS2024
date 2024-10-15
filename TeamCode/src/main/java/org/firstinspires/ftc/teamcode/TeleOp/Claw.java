package org.firstinspires.ftc.teamcode.TeleOp;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw {
    private static Servo claw;

    public static void init(@NonNull HardwareMap hardwareMap) {
        claw = hardwareMap.get(Servo.class, "claw");
        claw.setPosition(0);
    }

    public static void handleInput(boolean a) throws InterruptedException {
        if (a) {
            if (claw.getPosition() == 0) claw.setPosition(1);
            else claw.setPosition(0);
            Thread.sleep(500);
        }
    }
}