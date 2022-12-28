package passport;

import java.time.LocalDate;
import java.util.Objects;

public class Passport {

    private String passportNumber;
    private String surname;
    private String name;
    private String patronymic;
    private int dateBirth;

    public Passport(String passportNumber, String surname, String name, String patronymic, int age) {
        setPassportNumber(passportNumber);
        setSurname(surname);
        setName(name);
        setPatronymic(patronymic);

        if (age <= 0) {
            this.dateBirth = 0;
        } else {
            this.dateBirth = LocalDate.now().getYear() - age;
        }
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        if (passportNumber == null && name.isEmpty() && name.isBlank()) {
            this.passportNumber = "0000000";
        } else {
            this.passportNumber = passportNumber;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname != null || !surname.isEmpty() || !surname.isBlank()) {
            this.surname = surname;
        } else {
            System.out.println("default");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null || !name.isEmpty() || !name.isBlank()) {
            this.name = name;
        } else {
            System.out.println("default");
        }
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getDateBirth() {
        return dateBirth;
    }


    @Override
    public String toString() {
        return "Номер паспорта " + passportNumber +
                ", фамилия " + surname +
                ", Имя " + name +
                ", отчество " + patronymic +
                ", дата рождения " + dateBirth +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(passportNumber, passport.passportNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passportNumber);
    }
}
