package com.driver;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SportsEventRegistration {

    private static final Logger LOGGER = Logger.getLogger(SportsEventRegistration.class.getName());

    private Map<String, String> registeredParticipants;

    public SportsEventRegistration() {
        registeredParticipants = new HashMap<>();
    }

    public Map<String, String> getRegisteredParticipants() {
        return registeredParticipants;
    }

    public void registerParticipant(String eventName, String participantName) {
        LOGGER.log(Level.INFO, participantName + " registered for the event " + eventName);
        registeredParticipants.put(eventName, participantName);
    }

    public void displayParticipants() {
        if (registeredParticipants.isEmpty()) {
            LOGGER.log(Level.WARNING, "No participants registered for any event.");
        } else {
            LOGGER.log(Level.INFO, "Registered Participants:");
            for (Map.Entry<String, String> entry : registeredParticipants.entrySet()) {
                LOGGER.log(Level.INFO, entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public void cancelRegistration(String eventName, String participantName) {
        if (registeredParticipants.containsKey(eventName) &&
                registeredParticipants.get(eventName).equals(participantName)) {
            registeredParticipants.remove(eventName);
            LOGGER.log(Level.WARNING, participantName + " canceled registration for the event " + eventName);
        } else {
            LOGGER.log(Level.SEVERE, "Error: No registration found for " + participantName + " in the event " + eventName);
        }
    }

    public static void main(String[] args) {
        SportsEventRegistration registrationSystem = new SportsEventRegistration();

        registrationSystem.registerParticipant("Football", "John");
        registrationSystem.registerParticipant("Basketball", "Alice");
        registrationSystem.registerParticipant("Tennis", "Bob");

        registrationSystem.displayParticipants();

        registrationSystem.cancelRegistration("Football", "John");
        registrationSystem.cancelRegistration("Cricket", "Alice"); // Invalid event name

        registrationSystem.displayParticipants();
    }
}
