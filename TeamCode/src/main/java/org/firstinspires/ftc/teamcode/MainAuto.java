package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Auto.Drive;
import com.qualcomm.robotcore.hardware.DcMotor;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous
public class MainAuto extends LinearOpMode {
    @Override
    public void runOpMode() {
        Drive.init(hardwareMap);

        waitForStart();

        // Set Positions
        Drive.motorFL.setTargetPosition(Drive.inches2Ticks(50));
        Drive.motorFR.setTargetPosition(Drive.inches2Ticks(50));
        Drive.motorBL.setTargetPosition(Drive.inches2Ticks(50));
        Drive.motorBR.setTargetPosition(Drive.inches2Ticks(50));
        Drive.motorFL.setPower(0.8);
        Drive.motorFR.setPower(0.8);
        Drive.motorBL.setPower(0.8);
        Drive.motorBR.setPower(0.8);

        // Start Moving
        Drive.SetMode(DcMotor.RunMode.RUN_TO_POSITION);

        // Wait Until Finished Moving
        while (opModeIsActive() && Drive.IsBusy()) {
            telemetry.addData("driveMotorFL", Drive.motorFL.getCurrentPosition());
            telemetry.addData("driveMotorFR", Drive.motorFR.getCurrentPosition());
            telemetry.addData("driveMotorBL", Drive.motorBL.getCurrentPosition());
            telemetry.addData("driveMotorBR", Drive.motorBR.getCurrentPosition());
            telemetry.update();
        };

        // Stop Moving
        Drive.SetMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
}
