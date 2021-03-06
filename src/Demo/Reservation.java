
package Demo;

import java.util.Date;
import java.util.Calendar;

public class Reservation {
    
    private Date start;
    private Date end;
    private UsersWeb user;
        
    public Reservation(Date start, Date end, UsersWeb user) {
        this.start = start;
        this.end = end;
        this.user = user;
    }
    
    public Date getStart() {
        return start;
    }
    
    public Date getEnd() {
        return end;
    }
    
    public UsersWeb getUser() {
        return user;
    }
}
