package com.fssa.studentmanagementapp.Enum;

import java.util.HashMap;

/**
 * Enumeration representing the gender of a person.
 */
public enum Gender {
	MALE("MALE"), FEMALE("FEMALE");

	// Property to store the value of each enum constant
	public final String value;

	// Constructor to initialize the enum constants with values
	Gender(String value) {
		this.value = value;
	}

	// Getter method to retrieve the value of the enum constant
	public String getValue() {
		return value;
	}
	
	public static Gender valueToEnumMapping(String value) {
		// Create a mapping of values to enum constants using a HashMap
		HashMap<String, Gender> valueToEnumMapping = new HashMap<String, Gender>();

		// Iterate through all RequestStatus enum constants and populate the mapping
		for (Gender gender : Gender.values()) {
			valueToEnumMapping.put(gender.getValue(), gender);
		}

		// Return the enum constant corresponding to the provided value
		return valueToEnumMapping.get(value);
	}

}
