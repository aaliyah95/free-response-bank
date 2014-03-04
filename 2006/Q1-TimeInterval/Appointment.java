import java.util.*;

/**
 * Class that represents an appointment.  
 * An appointment has a name and time 
 * interval (start date and time and 
 * end date and time)
 * @author Barb Ericson
 * @see TimeInterval
 */
public class Appointment
{
  ///////// fields /////////////////
  /* object that represents the
   * starting date and time and
   * ending date and time
   */
  private TimeInterval time;
  /* name of this apointment */
  private String name; 
  
  ////////// constructors ///////////
  public Appointment(String theName,
                     TimeInterval theTime)
  {
    this.name = theName;
    this.time = theTime;
  }
  
  /**
   * Method to get the time interval
   * @return the time interval for the
   * appointment
   */
  public TimeInterval getTime()
  {
    return this.time;
  }
  
  /**
   * Method to check if a passed appointment
   * conflicts with this appointment
   * @param other the other appointment
   * @return true if conflict, else false
   */
  public boolean conflictsWith(Appointment other)
  {
    return this.getTime().overlapsWith(other.getTime());
  }
  
  public static void main(String[] args)
  {
    TimeInterval t1 = 
      new TimeInterval(
      new GregorianCalendar(2006, Calendar.JUNE,6),
      new GregorianCalendar(2006, Calendar.JUNE,8));
    TimeInterval t2 = 
      new TimeInterval(
      new GregorianCalendar(2006, Calendar.JUNE,8),
      new GregorianCalendar(2006, Calendar.JUNE,8));
    Appointment vacation = new Appointment("vacation",t1);
    Appointment teaching = new Appointment("teaching",t2);
    System.out.println(vacation.conflictsWith(teaching));
  }
}