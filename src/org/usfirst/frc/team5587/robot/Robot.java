package org.usfirst.frc.team5587.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team5587.robot.RobotDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.Encoder;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot 
{
	RobotDrive myRobot; // i think we should create a library class for these things. @Daren
	Joystick stick;     // we should probably organise the code a bit before we do some real programming. @Daren
	Encoder leftWheelsCount, rightWheelsCount, liftPulleyCount;
	
	int autoLoopCounter;
	//Rawr Rawr RAWR!!
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() 
    {
    	myRobot = new RobotDrive(2,3,0,1);
    	stick = new Joystick(0);
    }
    
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() 
    {
    	autoLoopCounter = 0;
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
    	if(autoLoopCounter < 450) //Check if we've completed 100 loops (approximately 2 seconds)
		{
    		myRobot.drive(-0.25, 0); 	// drive forwards half speed
			autoLoopCounter++;
		} 
    	else 
		{
			myRobot.drive(0.0, 0.0); 	// stop robot
		}
    }
    
    /**
     * This function is called once each time the robot enters tele-operated mode
     */
    public void teleopInit()
    {
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() 
    {
        myRobot.arcadeDrive(stick);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() 
    {
    	LiveWindow.run();
        myRobot.arcadeDrive(stick);
    }
    
    /**
     * This will return the speed needed for the second wheel when we turn the robot on an arc.
     */
    public double secondSpeed(double v1, double d, double r)
    {
    	return v1 * d / (d + r);
    }
    
    public double clicks(double d, double r, double c, double deltaTheta)
    {
    	return (d+r) * deltaTheta / c;
    }
    
    public double clicks(double d, double c)
    {
    	return d / c
    }
}
