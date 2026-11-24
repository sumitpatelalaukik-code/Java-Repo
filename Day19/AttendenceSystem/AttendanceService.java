import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.LocalTime;

public class AttendanceService {

    private List<Attendance> attendanceList = new ArrayList<>();

    public void checkIn(int employeeId) {
        Optional<Attendance> existing = attendanceList.stream()
                .filter(a -> a.getEmployeeId() == employeeId
                        && a.getDate().equals(LocalDate.now()))
                .findFirst();

        if (existing.isPresent()) {
            System.out.println("Already checked in today!");
            return;
        }

        Attendance attendance = new Attendance(employeeId);
        attendanceList.add(attendance);
        System.out.println("Check-in successful!");
    }

    public void checkOut(int employeeId) {
        Optional<Attendance> existing = attendanceList.stream()
                .filter(a -> a.getEmployeeId() == employeeId
                        && a.getDate().equals(LocalDate.now()))
                .findFirst();

        if (existing.isPresent()) {
            Attendance attendance = existing.get();
            if (attendance.getCheckOut() != null) {
                System.out.println("Already checked out!");
                return;
            }
            attendance.setCheckOut(LocalTime.now());
            System.out.println("Check-out successful!");
        } else {
            System.out.println("Please check in first!");
        }
    }

    public void attendanceReport() {
        if (attendanceList.isEmpty()) {
            System.out.println("No attendance records found!");
            return;
        }

        System.out.println("\n----- Attendance Report -----");
        attendanceList.forEach(a -> System.out.println(a));
    }
}
