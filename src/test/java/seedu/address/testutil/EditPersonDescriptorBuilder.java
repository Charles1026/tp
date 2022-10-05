package seedu.address.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.person.Email;
import seedu.address.model.person.FloorNumber;
import seedu.address.model.person.HospitalWing;
import seedu.address.model.person.Name;
import seedu.address.model.person.NextOfKin;
import seedu.address.model.person.PatientType;
import seedu.address.model.person.PatientType.PatientTypes;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Medication;
import seedu.address.model.person.WardNumber;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditPersonDescriptorBuilder {

    private EditPersonDescriptor descriptor;

    public EditPersonDescriptorBuilder() {
        descriptor = new EditPersonDescriptor();
    }

    public EditPersonDescriptorBuilder(EditPersonDescriptor descriptor) {
        this.descriptor = new EditPersonDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code person}'s details
     */
    public EditPersonDescriptorBuilder(Person person) {
        descriptor = new EditPersonDescriptor();
        descriptor.setName(person.getName());
        descriptor.setPhone(person.getPhone());
        descriptor.setEmail(person.getEmail());
        descriptor.setNextOfKin(person.getNextOfKin());
        descriptor.setPatientType(person.getPatientType());
        descriptor.setHospitalWing(person.getHospitalWing().orElse(null));
        descriptor.setFloorNumber(person.getFloorNumber().orElse(null));
        descriptor.setWardNumber(person.getWardNumber().orElse(null));
        descriptor.setMedications(person.getMedications());
    }

    /**
     * Sets the {@code Name} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withPhone(String phone) {
        descriptor.setPhone(new Phone(phone));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code NextOfKin} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withNextOfKin(String nextOfKin) {
        descriptor.setNextOfKin(new NextOfKin(nextOfKin));
        return this;
    }

    /**
     * Sets the {@code PatientType} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withPatientType(PatientTypes patientType) {
        descriptor.setPatientType(new PatientType(patientType));
        return this;
    }

    /**
     * Sets the {@code HospitalWing} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withHospitalWing(String hospitalWing) {
        descriptor.setHospitalWing(new HospitalWing(hospitalWing));
        return this;
    }

    /**
     * Sets the {@code Floor Number} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withFloorNumber(Integer floorNumber) {
        descriptor.setFloorNumber(new FloorNumber(floorNumber));
        return this;
    }

    /**
     * Sets the {@code Ward Number} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withWardNumber(Integer wardNumber) {
        descriptor.setWardNumber(new WardNumber(wardNumber));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public EditPersonDescriptorBuilder withMedication(String... tags) {
        Set<Medication> tagSet = Stream.of(tags).map(Medication::new).collect(Collectors.toSet());
        descriptor.setMedications(tagSet);
        return this;
    }

    public EditPersonDescriptor build() {
        return descriptor;
    }
}
