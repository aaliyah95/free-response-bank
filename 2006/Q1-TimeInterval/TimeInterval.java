import java.util.*;
/**
 * Class that represents a period of time
 * this class is based on Free Reponse 
 * Question #1 2006 CS A Exam
 * @author Barb Ericson
 */
public class TimeInterval
{
  ////////////// fields ////////////
  /** starting date and time */
  private Calendar start;
  /** ending date and time */
  private Calendar end;
  
  ///////////// constructors /////////
  
  /**
   * Constructor that takes a start and
   * end calendar (date and time). The start
   * date should be before the end date but
   * it will accept fix it if it isn't.
   * @param theStart start of time interval
   * @param theEnd end of the time interval
   */
  public TimeInterval(Calendar theStart,
                      Calendar theEnd)
  {
    /* check that start is before end 
     * and if not switch them
     */
    if (theStart.compareTo(theEnd) > 0)
    {
      this.start = theEnd;
      this.end = theStart;
    }
    else
    {
      this.start = theStart;
      this.end = theEnd;
    }
  }
  
  /**
   * Method that returns true if this time
   * interval overlaps with the passed
   * time interval, else returns false
   * @param interval the interval to compare to
   * @return true if overlap, else false
   */
  public boolean overlapsWith(TimeInterval interval)
  {
    /* check if they start with the same day
     * and time
     */
    boolean result = false;
    int temp = this.start.compareTo(interval.start);
    
    /* if they start with the same day and time
     * they do overlap
     */
    if (temp == 0)
      result = true;
    /* otherwise check if this one starts after
     * the passed one starts     
     */
    else if (temp > 0)
      /* check that this starts 
       * before the passed one ends
       */
      result = (this.start.compareTo(interval.end) <= 0);
    else 
      /* this one started before the passed one
       * so check if this one ends before the passed one
       * starts
       */
      result = (interval.start.compareTo(this.end) <= 0);
    return result;  
  }
  
  /**
   * Main for testing
   */
  public static void main (String[] args)
  {
    Calendar t1start = 
      new GregorianCalendar(2006,Calendar.JUNE,1);
    Calendar t1end = 
      new GregorianCalendar(2006, Calendar.JUNE,15);
    TimeInterval t1 = 
      new TimeInterval(t1start,t1end);
    TimeInterval t2 = 
      new TimeInterval(
      new GregorianCalendar(2006, Calendar.JUNE,3),
      new GregorianCalendar(2006, Calendar.JUNE, 6));
    System.out.println(t1.overlapsWith(t2));                             
  }                               
    
}