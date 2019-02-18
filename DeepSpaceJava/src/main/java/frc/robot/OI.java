/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
  private static OI singleInstance = null;
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
  private XboxController _driverController;
  private Joystick _operatorController;

  public OI() 
  {
    _driverController = new XboxController(RobotMap.CONTROLLER.DRIVER_CONTROLLER);
    _operatorController = new Joystick(RobotMap.CONTROLLER.OPERATOR_CONTROLLER);
  }
  /**
   * Gets the left side drive power from the controller
   * for tank drive.
   * @return The left drive power output.
   */
  public double getLeftDrive()
  {
    return _driverController.getY(Hand.kLeft);
  }
  /**
   * Gets the right side drive power from the controller
   * for tank drive.
   * @return The right drive power output
   */
  public double getRightDrive()
  {
    return _driverController.getY(Hand.kRight);
  }
  /**
   * Gets the drive speed from the controller.
   * @return The drive speed for curvature drive
   */
  public double getDriveSpeed()
  {
    return _driverController.getY(Hand.kLeft);
  }

  /**
   * Gets the curvature angle from the controller
   * @return The curvature for curvature drive
   */
  public double getCurvature()
  {
    return _driverController.getX(Hand.kRight);
  }

  /**
   * Gets the quick turn flag for curvature drive so the robot
   * can turn in place when selected.
   * @return The quick turn flag for curvature drive
   */
  public boolean getQuickTurn()
  {
    if(_driverController.getTriggerAxis(Hand.kLeft) > 0)
    {
      return true;
    }
    return false;
  }
  /**
   * Gets the only instance of this object. Creates one if one 
   * does not yet exist.
   * @return The only instance of this object
   */
  public static OI getInstance()
  {
    if (singleInstance == null)
    {
      singleInstance = new OI ();
    }
    return singleInstance;
  }
}
