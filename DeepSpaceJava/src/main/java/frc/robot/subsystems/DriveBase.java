package main.java.frc.robot.subsystems;

// WPI libraries
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap.CAN;

// CTRE Libraries
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
// Robot Libraries
import org.usfirst.frc.team3609.robot.RobotMap;

public class Drivebase extends Subsystem {
	private DifferentialDrive m_Drive;
	private WPI_TalonSRX leftMaster;
	private WPI_TalonSRX leftFollower;
	private WPI_TalonSRX rightMaster;
	private WPI_TalonSRX rightFollower;

	public SpeedControllerGroup m_Left;
	public SpeedControllerGroup m_Right;

	public Drivebase() {
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
    }

	protected void initDefaultCommand() {
		setDefaultCommand(System.out.println("DriveBase Default Command not Implemented!"));

	}

	public void Stop() {
        // Stop all motors by setting their output to 0
		m_Drive.TankDrive(0,0);
	}

}