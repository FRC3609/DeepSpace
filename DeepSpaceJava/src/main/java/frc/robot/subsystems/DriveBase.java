package frc.robot.subsystems;

// WPI libraries
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap.CAN;
import frc.robot.OI;
import frc.robot.Robot;

// CTRE Libraries
import com.ctre.phoenix.motorcontrol.can.*;

public class DriveBase extends Subsystem 
{
	private DifferentialDrive m_Drive;
	private WPI_TalonSRX leftMaster;
	private WPI_TalonSRX leftFollower;
	private WPI_TalonSRX rightMaster;
	private WPI_TalonSRX rightFollower;

	private SpeedControllerGroup m_Left;
	private SpeedControllerGroup m_Right;
	private OI _oi;
	
	public DriveBase() 
	{
        // Setup the motor controllers
		leftMaster = new WPI_TalonSRX(CAN.LEFT_MASTER_SRX);
		leftFollower = new WPI_TalonSRX(CAN.LEFT_FOLLOWER_SRX);
		rightMaster = new WPI_TalonSRX(CAN.RIGHT_MASTER_SRX);
        rightFollower = new WPI_TalonSRX(CAN.RIGHT_FOLLOWER_SRX);
        // Create speed controller groups for each side of the drive train
		m_Left = new SpeedControllerGroup(leftMaster, leftFollower);
        m_Right = new SpeedControllerGroup(rightMaster, rightFollower);
        // Create the drive base
        m_Drive = new DifferentialDrive(m_Left, m_Right);
		_oi = OI.getInstance();
	}

	protected void initDefaultCommand()
	{
		setDefaultCommand(this);
	}
	public void cheesyDrive() 
	{
		// Cheesy Drive
		m_Drive.curvatureDrive(_oi.getDriveSpeed(), _oi.getCurvature(), _oi.getQuickTurn());
	}

	public void Stop() 
	{
        // Stop all motors
		m_Drive.stopMotor();
	}

}