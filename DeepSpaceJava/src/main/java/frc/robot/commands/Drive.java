package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.DriveBase;
import frc.robot.OI;

/**
 * An example command.  You can replace me with your own command.
 */
public class Drive extends Command {
    DriveBase _driveBase;
    OI _oi;
  public Drive(DriveBase driveBase) {
    _driveBase = driveBase;
    _oi = new OI();
    requires(_driveBase);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      _driveBase.cheesyDrive(_oi.getDriveSpeed()*RobotMap.LIMITS.DRIVE_POWER_LIMIT, _oi.getCurvature(), _oi.getQuickTurn());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
