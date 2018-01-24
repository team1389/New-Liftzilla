package com.team1389.robot;

import java.util.function.Function;

import com.team1389.configuration.PIDConstants;
import com.team1389.control.PIDController;
import com.team1389.control.SynchronousPIDController;
import com.team1389.hardware.inputs.software.AngleIn;
import com.team1389.hardware.inputs.software.DigitalIn;
import com.team1389.hardware.inputs.software.RangeIn;
import com.team1389.hardware.outputs.software.DigitalOut;
import com.team1389.hardware.outputs.software.PercentOut;
import com.team1389.hardware.value_types.PIDTunableValue;
import com.team1389.hardware.value_types.Percent;
import com.team1389.hardware.value_types.Position;
import com.team1389.hardware.value_types.Speed;
import com.team1389.hardware.value_types.Value;
import com.team1389.system.drive.FourDriveOut;

public class RobotSoftware extends RobotHardware
{
	private static RobotSoftware INSTANCE = new RobotSoftware();
	public AngleIn<Position> gyroInput;
	public DigitalOut pistons;
	public FourDriveOut<Percent> voltageDrive;
	public FourDriveOut<Percent> compensatedDrive;
	public AngleIn<Position> armAngle;
	public AngleIn<Position> armAngleNoOffset;
	public AngleIn<Speed> armVel;
	public RobotHardware hardware;
	public RangeIn<Value> gearIntakeCurrent;
	public RangeIn<Position> flPos, frPos;
	public DigitalIn timeRunning;
	public RangeIn<Value> flCurrent, frCurrent, blCurrent, brCurrent;
	public RangeIn<Value> armCurrent;
	public DigitalIn gearBeamBreak;
	public PercentOut climberVoltage;
	public SynchronousPIDController<Percent, Position> pid;
	public PIDConstants constants;

	public static RobotSoftware getInstance()
	{
		return INSTANCE;
	}

	public RobotSoftware()
	{
		hardware = new RobotHardware();
		
		/*
		 * flCurrent = pdp.getCurrentIn(pdp_FRONT_LEFT_CURRENT); frCurrent =
		 * pdp.getCurrentIn(pdp_FRONT_RIGHT_CURRENT); blCurrent =
		 * pdp.getCurrentIn(pdp_REAR_LEFT_CURRENT); brCurrent =
		 * pdp.getCurrentIn(pdp_REAR_RIGHT_CURRENT);
		 */
		
	}

	public void zeroAngle()
	{
		
	}

}
