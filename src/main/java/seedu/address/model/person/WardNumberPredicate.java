package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

/**
 * Tests that a {@code Person}'s {@code Ward Number} matches any of the ward numbers given.
 */
public class WardNumberPredicate implements Predicate<Person> {

    private final List<String> wardNumbers;

    public WardNumberPredicate(List<String> wardNumbers) {
        this.wardNumbers = wardNumbers;
    }

    @Override
    public boolean test(Person person) {
        Boolean isInpatient = person.getPatientType().value.equals(PatientType.PatientTypes.INPATIENT);
        if (isInpatient) {
            return wardNumbers.stream()
                    .anyMatch(wardNumber -> person.getHospitalWing().get().value.equals(wardNumber));
        }
        return false;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof WardNumberPredicate // instanceof handles nulls
                && wardNumbers.equals(((WardNumberPredicate) other).wardNumbers)); // state check
    }
}