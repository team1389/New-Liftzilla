
package com.team1389.robot;

import org.usfirst.frc.team1389.operation.TeleopMain;

import com.team1389.auto.AutoModeBase;
import com.team1389.auto.AutoModeExecuter;
import com.team1389.robot.watchers.DashboardInput;
import com.team1389.watch.Watcher;

import edu.wpi.first.wpilibj.IterativeRobot;
import jaci.pathfinder.Waypoint;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	RobotSoftware robot;
	TeleopMain teleOperator;
	AutoModeExecuter autoModeExecuter;
	Watcher broadWatcher;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		robot = RobotSoftware.getInstance();
		teleOperator = new TeleopMain(robot);
		autoModeExecuter = new AutoModeExecuter();
		DashboardInput.getInstance().init();
		robot.threadManager.init();
	}

	@Override
	public void autonomousInit() {
		robot.threadManager.init();
		autoModeExecuter.stop();
		AutoModeBase selectedAutonMode = DashboardInput.getInstance().getSelectedAutonMode();
		autoModeExecuter.setAutoMode(selectedAutonMode);
		robot.threadManager.borrowThreadToRun(autoModeExecuter);
		broadWatcher = new Watcher();
		broadWatcher.watch(selectedAutonMode);
		broadWatcher.watch(robot.gyro.getAngleInput().getWatchable("angle"));
		broadWatcher.watch(robot.leftA.getPositionInput().getWatchable("pos"));

		broadWatcher.outputToDashboard();
		new Waypoint(0, 0, 0);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
	}

	@Override
	public void disabledPeriodic() {
	}

	@Override
	public void disabledInit() {
		robot.threadManager.reset();
		robot.threadManager.borrowThreadToRun(robot.gyro::calibrate);
	}

	@Override
	public void teleopInit() {
		robot.threadManager.init();
		autoModeExecuter.stop();
		teleOperator.init();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		teleOperator.periodic();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testInit() {
	}

	@Override
	public void testPeriodic() {
	}

}
