package academic.driver;

/**
 * @author 12S22044 Jufourlisa Sirait
 */


 import academic.model.Course;
 import academic.model.Enrollment;
 import academic.model.Lecturer;
 import academic.model.Student;
 
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.Map;
 import java.util.Scanner;
 
 public class Driver1 {
 
     public static void main(String[] _args) {
         Scanner scanner = new Scanner(System.in);
         ArrayList<Lecturer> lecturers = new ArrayList<>();
         ArrayList<Course> courses = new ArrayList<>();
         ArrayList<Student> students = new ArrayList<>();
         ArrayList<Enrollment> enrollments = new ArrayList<>();
 
         while (scanner.hasNextLine()) {
             String input = scanner.nextLine();
 
             if (input.equals("---")) {
                 break;
             }
 
             String[] inputSegments = input.split("#");
 
             if (inputSegments[0].equals("lecturer-add")) {
                 String nidn = inputSegments[1];
                 String name = inputSegments[2];
                 String initial = inputSegments[3];
                 String email = inputSegments[4];
                 String prodi = inputSegments[5];
 
                 boolean isDuplicate = false;
                 for (Lecturer lecturer : lecturers) {
                     if (lecturer.getEmail().equals(email)) {
                         isDuplicate = true;
                         break;
                     }
                 }
                 if (!isDuplicate) {
                     Lecturer lecturer = new Lecturer(nidn, name, initial, email, prodi);
                     lecturers.add(lecturer);
                 }
 
             } else if (inputSegments[0].equals("course-add")) {
                 String code = inputSegments[1];
                 String matkul = inputSegments[2];
                 int credit = Integer.parseInt(inputSegments[3]);
                 String passingGrade = inputSegments[4];
                 String initial = inputSegments[5];
 
                 String[] initialSegments = initial.split(",");
                 StringBuilder courseInitials = new StringBuilder();
                 for (String initialSegment : initialSegments) {
                     for (Lecturer lecturer : lecturers) {
                         if (initialSegment.equals(lecturer.getInitial())) {
                             courseInitials.append(initialSegment).append(" (").append(lecturer.getEmail()).append(");");
                             break;
                         }
                     }
                 }

                 String courseInitial = courseInitials.toString().trim();
                 boolean isDuplicate = false;
                 for (Course course : courses) {
                     if (course.getcode().equals(code)) {
                         isDuplicate = true;
                         break;
                     }
                 }
                 
                 if (!isDuplicate) {
                     Course course = new Course(code, matkul, credit, passingGrade, courseInitial);
                     courses.add(course);
                 }
 
             } else if (inputSegments[0].equals("student-add")) {
                 String nim = inputSegments[1];
                 String name = inputSegments[2];
                 int year = Integer.parseInt(inputSegments[3]);
                 String prodi = inputSegments[4];
 
                 boolean isDuplicate = false;
                 for (Student student : students) {
                     if (student.getNim().equals(nim)) {
                         isDuplicate = true;
                         break;
                     }
                 }
                 if (!isDuplicate) {
                     Student student = new Student(nim, name, year, prodi);
                     students.add(student);
                 }
 
             } else if (inputSegments[0].equals("enrollment-add")) {
                 String id = inputSegments[1];
                 String nim = inputSegments[2];
                 String thauncourse = inputSegments[3];
                 String semester = inputSegments[4];
 
                 boolean cekstu = false;
                 for (Student student : students) {
                     if (student.getNim().equals(nim)) {
                         cekstu = true;
                         break;
                     }
                 }
                 boolean cekcourse = false;
                 for (Course course : courses) {
                     if (course.getcode().equals(id)) {
                         cekcourse = true;
                         break;
                     }
                 }
                 if (!cekcourse) {
                     System.out.println("invalid course|" + id);
                 } else if (!cekstu) {
                     System.out.println("invalid student|" + nim);
                 } else {
                     Enrollment enrollment = new Enrollment(id, nim, thauncourse, semester, "None");
                     enrollments.add(enrollment);
                 }
 
             } else if (inputSegments[0].equals("enrollment-grade")) {
                 String id = inputSegments[1];
                 String nim = inputSegments[2];
                 String thauncourse = inputSegments[3];
                 String semester = inputSegments[4];
                 String grade = inputSegments[5];
 
                 for (Enrollment enrollment : enrollments) {
                     if (enrollment.getId().equals(id) && enrollment.get_nim().equals(nim) && enrollment.getThauncourse().equals(thauncourse) && enrollment.getSemester().equals(semester)) {
                         enrollment.setGrade(grade);
                     }
                 }
 
             } else if (inputSegments[0].equals("student-details")) {
                 String nim = inputSegments[1];
                 boolean hasGrade = false;
                 for (Student student : students) {
                     if (student.getNim().equals(nim)) {
                         System.out.print(student.getNim() + "|" + student.getName() + "|" + student.getYear() + "|" + student.getProdi());
                         double totalGrade = 0.0;
                         int totalCredits = 0;
                         Map<String, String> latestGrades = new HashMap<>(); // Map to store latest grade for each course
                         for (Enrollment enrollment : enrollments) {
                             if (enrollment.get_nim().equals(nim)) {
                                 String courseId = enrollment.getId();
                                 latestGrades.put(courseId, enrollment.getGrade()); // Store the latest grade for each course
                             }
                         }
                         for (String courseId : latestGrades.keySet()) {
                             String grade = latestGrades.get(courseId);
                             if (!grade.equals("None")) { // Check if grade is available
                                 hasGrade = true;
                                 for (Course course : courses) {
                                     if (course.getcode().equals(courseId)) {
                                         int credits = course.getCredit();
                                         double gradeAsNumber = 0.00;
                                         String[] splitGrade = grade.split("\\(");
                                         switch (splitGrade[0]) { // Using only the main grade without previous
                                             case "A":
                                                 gradeAsNumber = 4.00;
                                                 break;
                                             case "AB":
                                                 gradeAsNumber = 3.50;
                                                 break;
                                             case "B":
                                                 gradeAsNumber = 3.00;
                                                 break;
                                             case "BC":
                                                 gradeAsNumber = 2.50;
                                                 break;
                                             case "C":
                                                 gradeAsNumber = 2.00;
                                                 break;
                                             case "D":
                                                 gradeAsNumber = 1.00;
                                                 break;
                                             case "E":
                                                 gradeAsNumber = 0.00;
                                                 break;
                                         }
                                         totalGrade += (gradeAsNumber * credits);
                                         totalCredits += credits;
                                     }
                                 }
                             }
                         }
                         if (hasGrade) { // If there is at least one grade available
                             double gpa = totalGrade / totalCredits;
                             System.out.println("|" + String.format("%.2f", gpa) + "|" + totalCredits);
                         } else { // If no grade available
                             System.out.println("|0.00|0");
                         }
                         break;
                     }
                 }
 
             } else if (inputSegments[0].equals("enrollment-remedial")) {
                 String id = inputSegments[1];
                 String nim = inputSegments[2];
                 String thauncourse = inputSegments[3];
                 String semester = inputSegments[4];
                 String grade = inputSegments[5];
 
                 // Meng-check jika ada remedial grade sebelumnya pada nim dan course yang sama
                 boolean hasPreviousRemedial = false;
                 for (Enrollment enrollment : enrollments) {
                     if (enrollment.getId().equals(id) && enrollment.get_nim().equals(nim) &&
                             enrollment.getThauncourse().equals(thauncourse) && enrollment.getSemester().equals(semester) &&
                             enrollment.getGrade().contains("(")) {
                         hasPreviousRemedial = true;
                         break;
                     }
                 }
 
                 // Meng-check jika tidak ada remedial grade sebelumnya pada nim dan course yang sama maka akan menambahkan remedial grade
                 if (!hasPreviousRemedial) {
                     for (Enrollment enrollment : enrollments) {
                         if (enrollment.getId().equals(id) && enrollment.get_nim().equals(nim) &&
                                 enrollment.getThauncourse().equals(thauncourse) && enrollment.getSemester().equals(semester)) {
 
                             // Meng-store nilai sebelumnya
                             String previousGrade = enrollment.getGrade();
 
                             // Update remedial grade
                             enrollment.setGrade(grade + "(" + previousGrade + ")");
                             break;
                         }
                     }
                 }
             }
         }
 
         for (Lecturer lecturer : lecturers) {
             System.out.println(lecturer.getNidn() + "|" + lecturer.getName() + "|" + lecturer.getInitial() + "|" + lecturer.getEmail() + "|" + lecturer.getProdi());
         }
         for (Course course : courses) {
             String courseInitial = course.getInitial();
             if (courseInitial.endsWith(";")) {
                 courseInitial = courseInitial.substring(0, courseInitial.length() - 1); // Remove the trailing semicolon
             }
             System.out.println(course.getcode() + "|" + course.getmatkul() + "|" + course.getCredit() + "|" + course.getPassingGrade() + "|" + courseInitial);
        }
         for (Student student : students) {
             System.out.println(student.getNim() + "|" + student.getName() + "|" + student.getYear() + "|" + student.getProdi());
         }
         for (Enrollment enrollment : enrollments) {
             System.out.println(enrollment.getId() + "|" + enrollment.get_nim() + "|" + enrollment.getThauncourse() + "|" + enrollment.getSemester() + "|" + enrollment.getGrade());
         }
         scanner.close();
     }
 }
 