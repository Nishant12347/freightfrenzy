package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

// Controls:
// Gamepad1:
// driving (POV): gamepad1 right joystick
// Gamepad2:
// carousel: gamepad2 or gamepad1 A button
// servo for arm: gamepad2 right joystick
// motor for arm: gamepad2 left joystick

@TeleOp(name = "TeleOP")
public class TeleOpCode extends LinearOpMode {

    private DcMotor leftfrontmotor;
    private DcMotor leftbackmotor;
    private DcMotor rightfrontmotor;
    private DcMotor rightbackmotor;
    private DcMotor Carouselmotor1;
    private DcMotor Carouselmotor2;
    private DcMotor ArmMotor;
    private CRServo armservo;

    @Override
    public void runOpMode() {
        leftfrontmotor = hardwareMap.get(DcMotor.class, "leftfrontmotor");
        leftbackmotor = hardwareMap.get(DcMotor.class, "leftbackmotor");
        rightfrontmotor = hardwareMap.get(DcMotor.class, "rightfrontmotor");
        rightbackmotor = hardwareMap.get(DcMotor.class, "rightbackmotor");
        Carouselmotor1 = hardwareMap.get(DcMotor.class, "Carouselmotor1");
        Carouselmotor2 = hardwareMap.get(DcMotor.class, "Carouselmotor2");
        ArmMotor = hardwareMap.get(DcMotor.class, "ArmMotor");
        armservo = hardwareMap.get(CRServo.class, "armservo");
        leftfrontmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftbackmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        if (opModeIsActive()) {
            while (opModeIsActive()) {
                // For carousel. ONLY press A ONE time.
                if(gamepad2.a == true) {
                    Carouselmotor1.setPower(-0.45);
		    Carouselmotor2.setPower(-0.45);
                    sleep(100);
                    Carouselmotor1.setPower(0);
		    Carouselmotor2.setPower(0);
                }
                if(gamepad2.b == true) {
                    Carouselmotor1.setPower(0.45);
                    Carouselmotor2.setPower(0.45);
                    sleep(100);
                    Carouselmotor1.setPower(0);
                    Carouselmotor2.setPower(0);
                }
                if (gamepad2.x == true) {
                    Carouselmotor1.setPower(0.6);
                    Carouselmotor2.setPower(0.6);
                    sleep(100);
                    Carouselmotor1.setPower(0);
                    Carouselmotor2.setPower(0);
                }
                if (gamepad2.y == true) {
                    Carouselmotor1.setPower(-0.6);
                    Carouselmotor2.setPower(-0.6);
                    sleep(100);
                    Carouselmotor1.setPower(0);
                    Carouselmotor2.setPower(0);
                }
                // The Y and X axis of the Gamepad range from +1 to -1
                leftfrontmotor.setPower(-(gamepad1.right_stick_y / 2) + gamepad1.right_stick_x / 2);
                rightfrontmotor.setPower(-(gamepad1.right_stick_y / 2) - gamepad1.right_stick_x / 2);
                // There is a '-' sign so that the topmost position corresponds to maximum forward power.
                leftbackmotor.setPower(-(gamepad1.right_stick_y / 2) + gamepad1.right_stick_x / 2);
                rightbackmotor.setPower(-(gamepad1.right_stick_y / 2) - gamepad1.right_stick_x / 2);
                //for arm
                ArmMotor.setPower(-(gamepad2.left_stick_y) / 2);
                //for arm servo
                armservo.setPower(-(gamepad2.right_stick_y));

		//telemetry 
                telemetry.addData("Left Front Pow", leftfrontmotor.getPower());
                telemetry.addData("Left Pow", leftbackmotor.getPower());
                telemetry.addData("Right Front Pow", rightfrontmotor.getPower());
                telemetry.addData("Right Pow", rightbackmotor.getPower());
                telemetry.update();
            }
        }
    }
}
