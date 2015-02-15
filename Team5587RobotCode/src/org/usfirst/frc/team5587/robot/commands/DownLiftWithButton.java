package org.usfirst.frc.team5587.robot.commands;

import org.usfirst.frc.team5587.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class DownLiftWithButton extends Command 
{
	private boolean rawr;
	
    public DownLiftWithButton() 
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	rawr = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	if (rawr==true)
    	{
    		Robot.lift.downLift();
    		rawr = false;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return rawr;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.lift.stopLift();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
