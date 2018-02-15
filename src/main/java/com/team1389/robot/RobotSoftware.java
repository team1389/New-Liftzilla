package com.team1389.robot;

import com.team1389.hardware.inputs.software.AngleIn;
import com.team1389.hardware.inputs.software.RangeIn;
import com.team1389.hardware.outputs.software.RangeOut;
import com.team1389.hardware.value_types.Percent;
import com.team1389.hardware.value_types.Position;
import com.team1389.system.drive.FourDriveOut;

public class RobotSoftware extends RobotHardware{
	
	private static RobotSoftware INSTANCE = new RobotSoftware();
	
	public final FourDriveOut<Percent> drive; 
	public final RangeOut<Percent> left;
	public final RangeOut<Percent> right;
	public final RangeIn<Position> leftPos;
	public final RangeIn<Position> rightPos;
	public AngleIn<Position> gyroInput;
	
	public static RobotSoftware getInstance()
	{
		return INSTANCE;
	}
	
	public RobotSoftware()
	{
		drive = new FourDriveOut<Percent>(leftA.getVoltageController(), rightA.getVoltageController(), leftB.getVoltageController(), 
				rightB.getVoltageController());
		left = leftA.getVoltageController().addFollowers(leftB.getVoltageController());
		right = rightA.getVoltageController().addFollowers(leftB.getVoltageController());
		leftPos = leftA.getSensorPositionStream();
		rightPos = rightA.getSensorPositionStream();
		gyroInput = gyro.getAngleInput();
	}
}
