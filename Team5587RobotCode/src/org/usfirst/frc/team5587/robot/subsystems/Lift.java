package org.usfirst.frc.team5587.robot.subsystems;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.RobotPorts;
import org.usfirst.frc.team5587.robot.commands.MoveLiftWithThrottle;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;

public class Lift extends Subsystem 
{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private VictorSP LiftVictorSP1, LiftVictorSP2;
	private Encoder LiftEncoder;
	
	public double LiftMotorSpeed = -.17;//negative to correct for direction
	public int countsToTopOfLift = 500;//FIND ME 
	
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        setDefaultCommand(new MoveLiftWithThrottle());
    }
    
    public Lift()
    {
    	LiftVictorSP1 = new  VictorSP(RobotPorts.liftMotor1);
    	LiftVictorSP2 = new VictorSP(RobotPorts.liftMotor2);
    	LiftEncoder = new Encoder(RobotPorts.liftEncoderA, RobotPorts.liftEncoderB);
    }
    
    public void setLiftSpeed(double Something)
    {
    	LiftVictorSP1.set(Something);
    	LiftVictorSP2.set(Something);
    }
    
    public boolean liftequalsThrottle()
    {
    	if (Robot.lift.getScaledToThrottle() == Robot.hi.throttle())
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    public boolean liftGreaterThanThrottle()
    {
    	if(Robot.lift.getScaledToThrottle() > Robot.hi.throttle())
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    public boolean liftLessThanThrottle()
    {
    	if(Robot.lift.getScaledToThrottle() < Robot.hi.throttle())
    	{
    		return true;
    	}
    	else 
    	{
    		return false;
    	}
    }
    
    public void upLift()
    {
    	LiftVictorSP1.set(LiftMotorSpeed);
    	LiftVictorSP2.set(LiftMotorSpeed);
    }
    
    public void downLift()
    {
    	LiftVictorSP1.set(-LiftMotorSpeed);
    	LiftVictorSP2.set(-LiftMotorSpeed);
    }
    
    public void stopLift()
    {
    	LiftVictorSP1.set(0);
    	LiftVictorSP2.set(0);
    }
    
    public int getEncoderCount()
    {
    	return LiftEncoder.getRaw();
    }
    
    public double getScaledToThrottle()
    {
    	return ((LiftEncoder.getRaw()*2)/countsToTopOfLift);
    }
    
}

