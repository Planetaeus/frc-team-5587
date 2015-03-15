package org.usfirst.frc.team5587.robot.subsystems;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.RobotPorts;
import org.usfirst.frc.team5587.robot.commands.liftstuff.MoveLiftWithStickSecond;
import org.usfirst.frc.team5587.robot.commands.liftstuff.MoveLiftWithThrottle;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;

public class Lift extends Subsystem 
{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private VictorSP LiftVictorSP1, LiftVictorSP2;
	private Encoder LiftEncoder;
	
	public double LiftMotorSpeed = .1;
	public int countsToTopOfLift = 500;//FIND ME 
	
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        setDefaultCommand(new MoveLiftWithStickSecond());
    	//setDefaultCommand(new MoveLiftWithThrottle());
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
    
    public double getScaledToThrottle()
    {  //gives double between 0/2 so it can be used with throttle
    	return ((LiftEncoder.getRaw()*2)/countsToTopOfLift);
    }  //used in the statements below to create booleans
    
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
    
    public boolean liftNotAtBottom()
    {
    	if (LiftEncoder.getRaw() > 0)
    	{
    		return true;
    	}
    	else
    		return false;
    }
    
    public boolean liftAtBottom()
    {
    	if (LiftEncoder.getRaw() == 0)
    	{
    		return true;
    	}
    	else
    		return false;
    }
    public boolean liftAtTop()
    {
    	if (LiftEncoder.getRaw() == countsToTopOfLift)
    	{
    		return true;
    	}
    	else
    		return false;
    }
    
    
    public int getEncoderCount()
    {
    	return LiftEncoder.getRaw();
    }  
    
    public void upLift()//not really used anymore
    {
    	LiftVictorSP1.set(LiftMotorSpeed);
    	LiftVictorSP2.set(LiftMotorSpeed);
    }
    public void upLiftAtSpeed(double Meow) //used alot in command MoveWithThrottle
    {
    	LiftVictorSP1.set(Meow);
    	LiftVictorSP2.set(Meow);
    }
    
    public void stopLift()//not really used anymore
    {
    	LiftVictorSP1.set(0);
    	LiftVictorSP2.set(0);
    }
    
    public void moveLiftWithJoystickSecond(Joystick Blah)
    {
    	double yValueSpeed = 0;
    	yValueSpeed = Blah.getY();
    	LiftVictorSP1.set(yValueSpeed);
    	LiftVictorSP2.set(yValueSpeed);
    }
    
}

