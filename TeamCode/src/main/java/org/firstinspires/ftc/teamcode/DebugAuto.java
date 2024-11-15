package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Auto.Drive;
import org.firstinspires.ftc.teamcode.Auto.Claw;
import org.firstinspires.ftc.teamcode.Auto.Arm;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous
public class DebugAuto extends LinearOpMode {
    @Override
    public void runOpMode() {
        Drive.init(hardwareMap);
        Claw.init(hardwareMap);
        Arm.init(hardwareMap);

        waitForStart();

        telemetry.addLine("Started Drive Move To");
        telemetry.update();
        Drive.moveTo(60, 60, 60, 60, 1);

        sleep(3000);

        telemetry.addLine("Started Claw Toggle Top Position");
        telemetry.update();
        Claw.toggleTopPosition();

        sleep(3000);

        telemetry.addLine("Started Claw Toggle Top Position");
        telemetry.update();
        Claw.toggleTopPosition();

        telemetry.addLine("Started Claw Set Bottom Position");
        telemetry.update();
        Claw.setBottomOffset(-0.5);

        sleep(3000);

        telemetry.addLine("Started Claw Set Bottom Position");
        telemetry.update();
        Claw.setBottomOffset(0.5);

        sleep(3000);

        telemetry.addLine("Started Arm Set Servo Offset Backwards");
        telemetry.update();
        Arm.setServoOffset(-0.1);

        sleep(3000);

        telemetry.addLine("Started Arm Set Servo Offset Forwards");
        telemetry.update();
        Arm.setServoOffset(0.2);

        sleep(3000);

        telemetry.addLine("Started Arm Move To");
        telemetry.update();
        Arm.moveTo(200, 1);
    }
}
