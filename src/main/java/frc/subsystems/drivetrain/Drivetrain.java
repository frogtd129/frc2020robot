package frc.subsystems.drivetrain;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.sensors.*;

public class Drivetrain extends SubsystemBase {
    //public CANSparkMax leftA, leftB;
    public SpeedController leftDrive;
   // public CANSparkMax rightA, rightB;
    public SpeedController rightDrive;
    public Differencialdrive diffDrive;
    public TalonSRX leftA,leftB;
    public TalonSRX rightA,rightB;
    public OI oi = new OI();

    public Drivetrain() {
        rightA = new TalonSRX(4);
        rightB = new TalonSRX(2);
        rightDrive = new SpeedController(rightA, rightB);
        leftA = new TalonSRX(3);
        leftB = new TalonSRX(1);
        leftDrive = new SpeedController(leftA, leftB);
        diffDrive = new Differencialdrive(leftDrive, rightDrive);

    }

    public Timer timer = new Timer();

    @Override
    public void periodic() {
        //leftDrive.drive(0.25);
        //rightDrive.drive(0.25);

        diffDrive.drive(oi.leftDriverY(), oi.rightDriverX(),true);


       // rightB.set(ControlMode.PercentOutput,0.25);
        //drive.drive(0.25,-0.25);

        //drive.curvatureDrive(Robot.oi.leftDriverY(), Robot.oi.rightDriverX(), Robot.oi.driverLeftBumper());
        //System.out.println("RPM: leftA: " + String.valueOf(leftAEncoder.getVelocity()));
        //System.out.println("RPM: leftB: " + String.valueOf(leftBEncoder.getVelocity()));
        //System.out.println("RPM: rightA: " + String.valueOf(rightAEncoder.getVelocity()));
        //System.out.println("RPM: rightB: " + String.valueOf(rightBEncoder.getVelocity()));
    }


}
