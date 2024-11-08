package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive {
    private static DcMotorEx motorFL, motorFR, motorBL, motorBR;

    public static void init(HardwareMap hardwareMap) {
        motorFL = hardwareMap.get(DcMotorEx.class, "driveMotorFL");
        motorFR = hardwareMap.get(DcMotorEx.class, "driveMotorFR");
        motorBL = hardwareMap.get(DcMotorEx.class, "driveMotorBL");
        motorBR = hardwareMap.get(DcMotorEx.class, "driveMotorBR");

        setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        motorFL.setDirection(DcMotorEx.Direction.REVERSE);
        motorBL.setDirection(DcMotorEx.Direction.REVERSE);
    }

    private static void setMode(DcMotorEx.RunMode mode) {
        motorFL.setMode(mode);
        motorFR.setMode(mode);
        motorBL.setMode(mode);
        motorBR.setMode(mode);
    }

    private static int inches2Ticks(int inches) {
        if (inches < 0) {
            throw new IllegalArgumentException("Inches cannot be negative");
        }

        /*
            Formula:
            (inches * Gear Ratio * Motor Ticks per Revolution) / (Wheel Circumference)

            Values:
            return (int) Math.round((inches * 2.01570871261 * 384.5) / (Math.PI * 3.77953));

            Simplified:
            return (int) Math.round(inches * 65.27343193133062);
        */

        return (int) Math.round(inches * 65.273432);
    }

    public static void setDirection(DcMotorEx.Direction motorFLDirection, DcMotorEx.Direction motorFRDirection, DcMotorEx.Direction motorBLDirection, DcMotorEx.Direction motorBRDirection) {
        motorFL.setDirection(motorFLDirection);
        motorFR.setDirection(motorFRDirection);
        motorBL.setDirection(motorBLDirection);
        motorBR.setDirection(motorBRDirection);
    }

    public static void moveTo(int motorFLInches, int motorFRInches, int motorBLInches, int motorBRInches, double speed) {
        motorFL.setTargetPosition(inches2Ticks(motorFLInches));
        motorFR.setTargetPosition(inches2Ticks(motorFRInches));
        motorBL.setTargetPosition(inches2Ticks(motorBLInches));
        motorBR.setTargetPosition(inches2Ticks(motorBRInches));
        motorFL.setPower(speed);
        motorFR.setPower(speed);
        motorBL.setPower(speed);
        motorBR.setPower(speed);

        setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        while (motorFL.isBusy() || motorFR.isBusy() || motorBL.isBusy() || motorBR.isBusy()) {
            // Intentional
        }

        setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }
}