package org.usfirst.frc.team5587.robot.subsystems;

import org.usfirst.frc.team5587.robot.RobotPorts;
import org.usfirst.frc.team5587.robot.commands.drive.Drive;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;

public class Feet extends Subsystem 
{
	private Talon leftWheels1, leftWheels2, rightWheels1, rightWheels2;
	private Encoder leftSideE, rightSideE;
	private RobotDrive DriveTrain;
	public static final int right = 0;
	public static final int left = 1;
	
	@Override
	protected void initDefaultCommand() 
	{
		setDefaultCommand(new Drive());
	}
	
	public Feet() 
	{
		leftWheels1 = new Talon(RobotPorts.leftMotor1);
		leftWheels2= new Talon(RobotPorts.leftMotor2);
		rightWheels1 = new Talon(RobotPorts.rightMotor1);
		rightWheels2 = new Talon(RobotPorts.rightMotor2);
		DriveTrain = new RobotDrive (leftWheels1, leftWheels2, rightWheels1, rightWheels2);
    	DriveTrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
    	DriveTrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    	rightSideE = new Encoder(RobotPorts.rightSideEncoderA, RobotPorts.rightSideEncoderB);
    	leftSideE = new Encoder(RobotPorts.leftSideEncoderA, RobotPorts.leftSideEncoderB);
	}
	
	public void arcadeDriving(Joystick Controller)
	{
    	double xValue = 0, yValue = 0;
    	xValue = Controller.getX();
    	yValue = Controller.getY();
    	
    	DriveTrain.arcadeDrive(xValue, yValue);
    }
    
	public void stopFeet()
	{
		DriveTrain.stopMotor();
	}
	
    public void goStraight()
    {
    	DriveTrain.arcadeDrive(1.0, 1.0);
    }
    
    public int getEncoderCount(int encoderNum)
    { 
    	switch(encoderNum)
    	{
    		case right: //if = 0
    			return rightSideE.getRaw();//multipled by some number
    		case left: //if = 1
    			return leftSideE.getRaw();//multipled by some number
    		default:
    			return 0;
    	}
    }
}
