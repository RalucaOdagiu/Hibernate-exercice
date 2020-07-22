import dao.CarDao;
import dao.GenericDao;
import dao.StudentDao;
import model.Address;
import model.Car;
import model.Student;

public class Main {


  public static void main(String[] args) {
    System.out.println("Start");

    Student student = new Student("Iulian", "Barbu", "asd@j.com");

    Address address = new Address();
    address.setCity("Barcelona");
    address.setStreetName("La rambla");
    address.setStreetNo(42);

    student.setAddress(address);
    address.setStudent(student);

    Car car1 = new Car();
    car1.setMake("Audi");
    car1.setModel("A8");
    car1.setStudent(student);

    Car car2 = new Car();
    car2.setMake("Audi");
    car2.setModel("A7");
    car2.setStudent(student);

    student.getCars().add(car1);
    student.getCars().add(car2);

    StudentDao studentDao = new StudentDao();
    studentDao.saveEntity(student);

//fac cautare
//    Student student2 = (Student) studentDao.find(Student.class, 6L);
//    System.out.println(student2);

    System.out.println("Finish");


  }
}
