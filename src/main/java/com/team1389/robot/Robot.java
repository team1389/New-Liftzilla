package com.team1389.robot;

import com.team1389.auto.AutoModeExecuter;
import com.team1389.autos.AutoConstants;
import com.team1389.autos.commands.RobotCommands;
import com.team1389.autos.commands.RobotCommands.DriveStraight;
import com.team1389.autos.commands.RobotCommands.DriveStraightOpenLoop;
import com.team1389.autos.commands.RobotCommands.TurnAngle;
import com.team1389.autos.paths.AutoTest;
import com.team1389.operation.TeleopMain;
import com.team1389.watchers.DashboardInput;
import com.team1389.watchers.DebugDash;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot
{
	RobotSoftware robot;
	TeleopMain teleOperator;
	AutoModeExecuter autoModeExecuter;
	RobotCommands commands;
	AutoTest test;
	AutoConstants constants;
	DriveStraight drive;
	DriveStraightOpenLoop driveOpen;
	TurnAngle turn;
	
	@Override
	public void robotInit()
	{
		robot = RobotSoftware.getInstance();
		DashboardInput.getInstance().init();
		autoModeExecuter = new AutoModeExecuter();
		commands = new RobotCommands(robot);
		teleOperator = new TeleopMain(robot);
		//gyroCalib = robot.gyro.new CalibrateCommand(true);

	}
	
	@Override
	public void autonomousInit()
	{
		autoModeExecuter.stop();
		//AutoModeBase selectedAutonMode = DashboardInput.getInstance().getSelectedAutonMode();
		//autoModeExecuter.setAutoMode(selectedAutonMode);
		//DebugDash.getInstance().watch(selectedAutonMode);
		//gyroCalib.cancel();
		drive = commands.new DriveStraight(AutoConstants.getRotations(AutoConstants.AUTO_TEST_DIS));

		
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic()
	{
	}

	@Override
	public void teleopInit()
	{
		//gyroCalib.cancel();
		DebugDash.getInstance().outputToDashboard();
		autoModeExecuter.stop();
		teleOperator.init();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic()
	{
		teleOperator.periodic();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testInit()
	{

	}
}
