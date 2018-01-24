package com.team1389.operation;

import java.util.function.Supplier;

import com.team1389.hardware.controls.ControlBoard;
import com.team1389.hardware.inputs.software.DigitalIn;
import com.team1389.robot.RobotSoftware;
import com.team1389.system.Subsystem;
import com.team1389.system.SystemManager;

/**
 * system manager
 * 
 * @author Quunii
 *
 */
public class TeleopMain
{
	SystemManager manager;
	ControlBoard controls;
	RobotSoftware robot;
	DigitalIn timeRunning;

	/**
	 * 
	 * @param robot
	 *            container of all ohm streams
	 */
	public TeleopMain(RobotSoftware robot)
	{
		this.robot = robot;
	}

	/**
	 * initializes systems, and adds them to a list of systems to update
	 */
	public void init()
	{
		
	}

	/**
	 * 
	 * @return a new OctoMecanumSystem
	 */
	

	/**
	 * 
	 * @return a new GearIntakeSystem
	 */
	

	/**
	 * 
	 * @return a new ClimberSystem
	 */
	

	/**
	 * periodically calls update method in all subsystems
	 */
	public void periodic()
	{
		manager.update();
	}

}
