package com.team1389.autonomous.command;

import com.team1389.command_framework.command_base.Command;
import com.team1389.robot.RobotSoftware;
import com.team1389.util.Timer;

public class RobotCommands {
	
	RobotSoftware robot;
	
	public RobotCommands(RobotSoftware robot)
	{
		this.robot = robot;
	}
	
	public class Drive extends Command
	{
		Timer timer;
		double voltage;
		double time;
		
		public Drive(double voltage, double time)
		{
			this.voltage = voltage;
			this.time = time;
			timer.zero();
		}
		
		public void go()
		{
			robot.leftA.getVoltageController().set(voltage);
			robot.leftB.getVoltageController().set(voltage);
			robot.rightA.getVoltageController().set(voltage);
			robot.rightB.getVoltageController().set(voltage);

		}
		
		public void stop()
		{
			robot.leftA.getVoltageController().set(0);
			robot.leftB.getVoltageController().set(0);
			robot.rightA.getVoltageController().set(0);
			robot.rightB.getVoltageController().set(0);
		}
		
		
		@Override
		protected boolean execute() {
			
			while(time <= timer.get())
			{
				go();
			}
			
			stop();
			
			return true;
		}
		
	}

}
