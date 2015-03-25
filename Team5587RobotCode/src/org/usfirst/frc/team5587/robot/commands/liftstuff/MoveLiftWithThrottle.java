package org.usfirst.frc.team5587.robot.commands.liftstuff;

import org.usfirst.frc.team5587.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class MoveLiftWithThrottle extends Command 
{

    public MoveLiftWithThrottle() 
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	//Michael's Improvements
    	/*
    	double diff = Robot.lift.liftThrottleDiff();
    	int count = Robot.lift.getEncoderCount(), top = Robot.lift.countsToTopOfLift; 
    	
    	//If the lift's position is greater than the throttle's
    	if( diff > 0 && count > 0 );
    	{
    		Robot.lift.downLift();
    	}
    	else if( diff < 0 && count < top )
    	{
    		Robot.lift.upLift();
    	}
    	else
    	{
    		Robot.lift.stopLift();
    	}
    	*/
    	
    	//Daren's original code
    	/*
    	if (Robot.lift.liftequalsThrottle())
    	{
    		Robot.lift.stopLift();
    	}
    	
    	if (Robot.lift.liftGreaterThanThrottle() && Robot.lift.getEncoderCount() > 0)
    	{
    		if( Robot.lift.getEncoderCount() - ( Robot.lift.countsToTopOfLift / 25 ) > )
    		{
    			Robot.lift.setLiftSpeed( Robot.lift.LiftMotorSpeed * .5 );
    		}
    		
    		Robot.lift.downLift();
    	}
    	
    	if (Robot.lift.liftLessThanThrottle() && Robot.lift.getEncoderCount() < Robot.lift.countsToTopOfLift)
    	{
    		Robot.lift.upLift();
    	}
    	
    	else
    	{
    		Robot.lift.stopLift();
    	}
    	*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
