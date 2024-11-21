package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive {
    private static DcMotorEx motorFL, motorFR, motorBL, motorBR;

    public Drive(HardwareMap hardwareMap) {
        motorFL = hardwareMap.get(DcMotorEx.class, "driveMotorFL");
        motorFR = hardwareMap.get(DcMotorEx.class, "driveMotorFR");
        motorBL = hardwareMap.get(DcMotorEx.class, "driveMotorBL");
        motorBR = hardwareMap.get(DcMotorEx.class, "driveMotorBR");

        motorFL.setDirection(DcMotorEx.Direction.REVERSE);
        motorBL.setDirection(DcMotorEx.Direction.REVERSE);
        motorFL.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        motorFR.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        motorBL.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        motorBR.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }

    private static void setMode(DcMotorEx.RunMode mode) {
        motorFL.setMode(mode);
        motorFR.setMode(mode);
        motorBL.setMode(mode);
        motorBR.setMode(mode);
    }
    
    private static int mm2Ticks(int mm) {
        if (mm < 0) {
            throw new IllegalArgumentException("MM cannot be negative");
        }

        /*
            Formula:
            (mm * Gear Ratio * Motor Ticks per Revolution) / (Wheel Circumference in mm)

            Values:
            return (int) Math.round((mm * 2 * 384.5) / (Math.PI * 96));

            Simplified:
            return (int) Math.round(mm * 2.54979481745);
        */

        return (int) Math.round(mm * 2.549795);
    }

    public static void setDirection(DcMotorEx.Direction motorFLDirection, DcMotorEx.Direction motorFRDirection, DcMotorEx.Direction motorBLDirection, DcMotorEx.Direction motorBRDirection) {
        motorFL.setDirection(motorFLDirection);
        motorFR.setDirection(motorFRDirection);
        motorBL.setDirection(motorBLDirection);
        motorBR.setDirection(motorBRDirection);
    }

    public static void moveTo(int motorFLMM, int motorFRMM, int motorBLMM, int motorBRMM, double speed) {
        motorFL.setTargetPosition(mm2Ticks(motorFLMM));
        motorFR.setTargetPosition(mm2Ticks(motorFRMM));
        motorBL.setTargetPosition(mm2Ticks(motorBLMM));
        motorBR.setTargetPosition(mm2Ticks(motorBRMM));
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