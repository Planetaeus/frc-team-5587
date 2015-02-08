package org.usfirst.frc.team5587.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5587.robot.Robot;

/**
 *
 */
public class LiftUp extends Command {
	
    public LiftUp() {
        super();
    	requires(Robot.liftMechanism);
    	setTimeout(.9);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
        setInterruptible(false);
    	Robot.liftMechanism.lift();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	Robot.liftMechanism.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    	end();
    }
}
