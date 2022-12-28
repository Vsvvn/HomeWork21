package passport;

import product.Product;

import java.util.HashSet;
import java.util.Set;

public class PassportList {

    Set<Passport> passports;

    public PassportList(Set<Passport> passports) {
        this.passports = passports;
    }

    public void add(Passport passport) {
        Passport old = get(passport.getPassportNumber());
        if (old != null) {
            passports.remove(old);
        }
        passports.add(passport);
    }

    public Passport get(String passportNumber) {
        for (Passport passport : passports) {
            if (passport.getPassportNumber().equals(passportNumber)) {
                return passport;

            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Список паспортов " + "\n" + passports;
    }
}
