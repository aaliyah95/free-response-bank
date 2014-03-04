import java.util.*;

/**
 * Contains  a list of non-overlapping 
 * appointments 
 */
public class DailySchedule
{
  ////////// fields ////////////////
  /* List of non-conflicting appointments */
  //private ArrayList<Appointment> apptList;
  private ArrayList apptList;
  
  //////////// constructors ///////////
  
  /**
   * No arg constructor.  All fields
   * have default values except we 
   * create the array list of appointments
   */
  public DailySchedule()
  {
    //this.apptList = 
    //  new ArrayList<Appointment>();
    this.apptList = new ArrayList();
  }
  
  ///////////// methods ///////////////////
  
  /**
   * method to return information about
   * this daily schedule as a string
   */
  public String toString()
  {
    return "There are " + this.apptList.size() +
        " appointments";
  }
  
  /**
   * Method to check if there are any conflicts
   * with a passed appointment
   * @param appt the appontment to check against
   * @return true if any conflicts else false
   */
  public boolean anyConflictsWith(Appointment appt)
  {
    boolean result = false;
//    for (Appointment currAppt : this.apptList)
//    {
//      if (currAppt.conflictsWith(appt))
//      {
//        result = true;
//        break;
//      }
//    }
    Iterator iterator = this.apptList.iterator();
    Appointment currAppt = null;
    while(iterator.hasNext())
    {
      currAppt = (Appointment) iterator.next();
      if (currAppt.conflictsWith(appt))
      {
        result = true;
        break;
      }
    }
      
    return result;
  }
  
  /**
   * Method to clear all conflicts with the
   * passed appointment
   * @param appt the appoint to clear conflicts
   * with
   * postcondition: all apointments that have
   * a time conflict with appt have been 
   * removed from the appointment list
   */
  public void clearConflicts(Appointment appt)
  {
    //Iterator<Appointment> iterator = 
    //  apptList.iterator();
    Iterator iterator = apptList.iterator();
    Appointment currAppt = null;
    
    // loop while more items in the iterator
    while (iterator.hasNext())
    {
      // get the current item
      //currAppt = iterator.next();
      currAppt = (Appointment) iterator.next();
      
      // if this conficts with the appointment
      if (currAppt.conflictsWith(appt))
      {
        // remove it from the collection
        iterator.remove();
      }
    }  
  }
  
  /**
   * Method to add an appointment.  If there
   * is no emergency the appointment will only
   * be added if there are no conflicts.  If
   * it is an emergency any conflicting 
   * appointments will be removed and this 
   * appointment added
   * @param appt the Appointment to add
   * @param emergency flag that is true
   * if this is an emergency
   * @returns true if the appointment was added
   */
  public boolean addAppt(Appointment appt,
                         boolean emergency)
  {
    boolean result = false;
    
    /* if this is an emergency clear
     * any conflicts and set result to 
     * true
     */
    if (emergency)
    {
      clearConflicts(appt);
      result = true;
    }
    
    /**
     * else if not any conflicts with current
     * appointments set result to true
     */
    else if (!this.anyConflictsWith(appt))
    {
      result = true;
    }
    
    /**
     * If the result has been set to true
     * add the appointment
     */
    if (result)
      this.apptList.add(appt);
    
    return result;
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
    DailySchedule sched = new DailySchedule();
    sched.addAppt(vacation, false);
    System.out.println(sched);
    sched.clearConflicts(teaching);
    //sched.addAppt(teaching,true);
    System.out.println(sched);
  }
}
  