package org.usfirst.frc.team5587.robot;

import org.usfirst.frc.team5587.robot.commands.MinusDrivingSpeed;
import org.usfirst.frc.team5587.robot.commands.DownLiftWithButton;
import org.usfirst.frc.team5587.robot.commands.PlusDrivingSpeed;
import org.usfirst.frc.team5587.robot.commands.UpLiftWithButton;
import org.usfirst.frc.team5587.robot.commands.StopLift;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class HI 
{
	private Joystick stick = new Joystick(RobotPorts.joystick);
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
		LiftUp.toggleWhenActive(new DownLiftWithButton());
		/*
		LiftDown = new JoystickButton(stick, 4);
		LiftDown.toggleWhenActive(new UpLiftWithButton());
		
		StopLift= new JoystickButton(stick,6);
		StopLift.toggleWhenActive(new StopLift());
		*/
		
		
	}
	public Joystick getstick() 
	{
		return stick;
	}
	public double throttle()
	{
	return stick.getThrottle()+1;
	}

}
