import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class Attendance {

    private int employeeId;
    private LocalDate date;
    private LocalTime checkIn;
    private LocalTime checkOut;    

    public Attendance(int employeeId){
        this.employeeId = employeeId;
        this.date = LocalDate.now();
        this.checkIn = LocalTime.now();
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getCheckIn() {
        return checkIn;
    }

    public LocalTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalTime checkOut) {
        this.checkOut = checkOut;
    }

    public Duration getWorkingHours(){
        if(checkOut == null || checkIn == null) {
            return Duration.ZERO;
        }
        return Duration.between(checkIn, checkOut);
    }

    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

        String in = checkIn.format(formatter);

        String out = checkOut == null
                ? "Not Checked Out"
                : checkOut.format(formatter);

        Duration duration = getWorkingHours();

        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();

        return "Employee ID: " + employeeId
                + ", Date: " + date
                + ", Check-in: " + in
                + ", Check-out: " + out
                + ", Working Hours: " + hours + "h " + minutes + "m";
    }
}