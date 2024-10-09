package org.firstinspires.ftc.teamcode.TeleOp;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Slide {
    private static DcMotorEx viperSlideLeft, viperSlideRight;

    public static void init(@NonNull HardwareMap hardwareMap) {
        viperSlideLeft = hardwareMap.get(DcMotorEx.class, "viperSlideLeft");
        viperSlideRight = hardwareMap.get(DcMotorEx.class, "viperSlideRight");

        viperSlideLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        viperSlideRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public static void handleInput(float stick) {
        viperSlideLeft.setPower(stick);
        viperSlideRight.setPower(stick);
    }
}