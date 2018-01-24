
package com.team1389.robot;

import com.team1389.auto.AutoModeBase;
import com.team1389.auto.AutoModeExecuter;
import com.team1389.configuration.PIDConstants;
import com.team1389.control.PIDController;
import com.team1389.control.SynchronousPIDController;
import com.team1389.hardware.inputs.hardware.SpartanGyro;
import com.team1389.hardware.inputs.software.RangeIn;
import com.team1389.hardware.registry.port_types.CAN;
import com.team1389.hardware.value_types.PIDTunableValue;
import com.team1389.hardware.value_types.Percent;
import com.team1389.hardware.value_types.Position;
import com.team1389.operation.TeleopMain;
import com.team1389.util.Color;
import com.team1389.watch.Watcher;
import com.team1389.watch.info.NumberInfo;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{
	RobotSoftware robot;
	TeleopMain teleOperator;
	AutoModeExecuter autoModeExecuter;
	SpartanGyro.CalibrateCommand gyroCalib;
	Watcher watcher;
	RangeIn<Position> pos;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit()
	{
		robot = RobotSoftware.getInstance();
		watcher = new Watcher();
		pos = robot.offBoard.getSensorPositionStream();
		robot.constants = new PIDConstants(0, 0, 0);
		robot.pid = new SynchronousPIDController<Percent, Position>(robot.constants, robot.offBoard.getSensorPositionStream(), 
				robot.offBoard.getVoltageController());
		
	}

	@Override
	public void teleopInit()
	{
		Watcher.resetWatchers();
		watcher.watch(pos.getWatchable("Pos"));
		watcher.outputToDashboard();;
		
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic()
	{
		Watcher.update();		
		robot.pid.getPIDDoCommand();
		
		robot.onBoard.getVoltageController().set(0);
		robot.offBoard.getVoltageController().set(0.1);
		
		
		//robot.armElevator.getWrappedTalon().setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
		//System.out.println(robot.armElevator.getWrappedTalon().getPosition());

	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testInit()
	{

	}
}
