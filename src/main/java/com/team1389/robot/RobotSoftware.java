package com.team1389.robot;

import com.team1389.hardware.inputs.software.PositionEncoderIn;
import com.team1389.hardware.inputs.software.RangeIn;
import com.team1389.hardware.outputs.software.PercentOut;
import com.team1389.hardware.outputs.software.RangeOut;
import com.team1389.hardware.value_types.Percent;
import com.team1389.hardware.value_types.Position;
import com.team1389.hardware.value_types.Speed;
import com.team1389.system.drive.DriveOut;

public class RobotSoftware extends RobotHardware {
	private static RobotSoftware INSTANCE = new RobotSoftware();
	//public final RangeOut<Percent> right = rightA.getVoltageController().addFollowers(leftB.getVoltageController());
	//public final RangeOut<Percent> left = leftA.getVoltageController().addFollowers(leftB.getVoltageController());
	public final DriveOut<Percent> drive = new DriveOut<Percent>(leftA.getVoltageController(),
			rightA.getVoltageController());
	public final RangeIn<Position> elevatorPositionIn = rightB.getSensorPositionStream();
	public final RangeIn<Speed> elevatorSpeedIn = rightB.getVelocityStream();
	public final PercentOut elevatorVoltage = elevatorA.getVoltageController()
			.addFollowers(elevatorB.getVoltageController().invert());
	// public AngleIn<Position> angle;
	// public RobotStateEstimator state;

	/*
	 * public RobotStateEstimator setupRobotStateEstimator() { RangeIn<Position>
	 * left = leftA.getPositionInput().setRange(0, 1440).mapToRange(0, Math.PI *
	 * RobotConstants.WheelDiameter); RangeIn<Position> right =
	 * rightA.getPositionInput().setRange(0, 1440).mapToRange(0, Math.PI *
	 * RobotConstants.WheelDiameter); RangeIn<Speed> leftS =
	 * leftA.getSpeedInput().setRange(0, 1440).mapToRange(0, Math.PI * 4);
	 * RangeIn<Speed> rightS = rightA.getSpeedInput().setRange(0,
	 * 1440).mapToRange(0, Math.PI * 4); AngleIn<Position> gyro = angle; return new
	 * RobotStateEstimator(new RobotState(), left, right, leftS, rightS, gyro,
	 * RobotConstants.TrackWidth, RobotConstants.TrackLength,
	 * RobotConstants.TrackScrub); }
	 */
	public static RobotSoftware getInstance() {
		return INSTANCE;
	}

	public RobotSoftware() {
		PositionEncoderIn.setGlobalWheelDiameter(RobotConstants.WheelDiameter);
	}

}
