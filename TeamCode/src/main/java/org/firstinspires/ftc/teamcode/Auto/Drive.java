package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive {
    public static DcMotorEx motorFL, motorFR, motorBL, motorBR;

    public static void init(HardwareMap hardwareMap) {
        motorFL = hardwareMap.get(DcMotorEx.class, "driveMotorFL");
        motorFR = hardwareMap.get(DcMotorEx.class, "driveMotorFR");
        motorBL = hardwareMap.get(DcMotorEx.class, "driveMotorBL");
        motorBR = hardwareMap.get(DcMotorEx.class, "driveMotorBR");

        SetMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        motorFL.setDirection(DcMotorEx.Direction.REVERSE);
        motorBL.setDirection(DcMotorEx.Direction.REVERSE);
    }

    public static void SetMode(DcMotorEx.RunMode mode) {
        motorFL.setMode(mode);
        motorFR.setMode(mode);
        motorBL.setMode(mode);
        motorBR.setMode(mode);
    }

    public static boolean IsBusy() {
        return motorFL.isBusy() || motorFR.isBusy() || motorBL.isBusy() || motorBR.isBusy();
    }

    public static int inches2Ticks(int inches) {
        if (inches < 0) {
            throw new IllegalArgumentException("Inches cannot be negative");
        }

        // Formula:
        // (inches * Gear Ratio * Motor Ticks per Revolution) / (Pi * Wheel Circumference)

        // Values:
        // return (int) Math.round((inches * 2.01570871261 * 384.5) / (Math.PI * 3.77953));

        // Simplified Version:
        // return (int) Math.round(inches * 65.27343193133062);

        return (int) Math.round(inches * 65.273432);
    }
}