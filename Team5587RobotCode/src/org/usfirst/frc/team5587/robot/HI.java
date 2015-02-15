package org.usfirst.frc.team5587.robot;

import org.usfirst.frc.team5587.robot.commands.drive.MinusDrivingSpeed;
import org.usfirst.frc.team5587.robot.commands.drive.PlusDrivingSpeed;
import org.usfirst.frc.team5587.robot.commands.liftstuff.StopLift;
import org.usfirst.frc.team5587.robot.commands.liftstuff.UpLiftWithButton;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class HI 
{
	private Joystick stick = new Joystick(RobotPorts.joystickMain);
	private Joystick stickSecond = new Joystick(RobotPorts.joystickSecond);
	
	private JoystickButton PlusDriveSpeed;
	private JoystickButton MinusDriveSpeed;
	private JoystickButton LiftUp;
	private JoystickButton LiftDown;
	private JoystickButton StopLift;

	public HI() 
	{
		PlusDriveSpeed = new JoystickButton(stick,1);
		PlusDriveSpeed.toggleWhenPressed(new PlusDrivingSpeed());
		
		MinusDriveSpeed= new JoystickButton(stick,2);
		MinusDriveSpeed.toggleWhenPressed(new MinusDrivingSpeed());
		
		LiftUp = new JoystickButton(stick, 3);
		LiftUp.toggleWhenActive(new UpLiftWithButton());
		
		StopLift= new JoystickButton(stick,6);
		StopLift.toggleWhenActive(new StopLift());
		
		
		
	}
	public Joystick getstick() //this is currently used for driving 
	{
		return stick;
	}
	
	public Joystick getstick2() // currently used for lift
	{
		return stickSecond;
	}
	
	public double throttle() // used to to scale from 0-2 for lifting
	{
	return stick.getThrottle()+1;
	}

}
