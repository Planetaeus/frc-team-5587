package org.usfirst.frc.team5587.robot;


public class RobotPorts 
{
	//these are for where the robot's wheels are connected to which PWM ports.
	public static final int rightMotor1 = 0; 
	public static final int rightMotor2 = 1;
	public static final int leftMotor1 = 2;
	public static final int leftMotor2 = 3;
	
	// these are for the left side and right side of the drive train for the encoder ports
	public static final int rightSideEncoderA = 2;
	public static final int rightSideEncoderB = 3;
	public static final int leftSideEncoderA = 4;
	public static final int leftSideEncoderB = 5;
	
	// this is the ports for the lift motors on the PWM ports.
	public static final int liftMotor1 = 9;
	public static final int liftMotor2 = 8;
	
	//this is where the encode for the lift is
	public static final int liftEncoderA = 0;
	public static final int liftEncoderB = 1;
	
	//here are the camera ips
	public static final String topCamera = "";
	public static final String bottomCamera = "";
	
	//usb port order is here
	public static final int joystick = 0;

}
