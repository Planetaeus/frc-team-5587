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
    	//these loops will run the motors at specific encoder counts
    	if (Robot.lift.liftequalsThrottle())
    	{
    		Robot.lift.upLiftAtSpeed(.02);//this speed should stop the lift
    	}
    	
    	if (Robot.lift.liftAtBottom())
    	{
    		Robot.lift.upLiftAtSpeed(.02);
    	}
    	
    	if (Robot.lift.liftGreaterThanThrottle() && Robot.lift.liftNotAtBottom())
    	{
    		Robot.lift.upLiftAtSpeed(.02);
    	}
    	
    	if (Robot.lift.liftLessThanThrottle() && Robot.lift.liftAtTop())
    	{
    		Robot.lift.upLiftAtSpeed(.3);//this speed should lift stuff
    	}
    	
    	else
    	{
    		Robot.lift.stopLift();
    	}
    	
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
