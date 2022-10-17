package seedu.address.model.person;

import seedu.address.commons.util.StringUtil;

import java.util.List;
import java.util.function.Predicate;

public class MedicationContainsKeywordsPredicate implements Predicate<Person> {

    private final List<String> keywords;

    public MedicationContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> person.getMedications().stream()
                        .anyMatch(medication -> StringUtil.containsWordIgnoreCase(medication.medicationName, keyword)));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof MedicationContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((MedicationContainsKeywordsPredicate) other).keywords)); // state check
    }

}
