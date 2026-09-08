# Riyadh Season Ticket Booking System

A console application in Java that simulates ticket booking for **Riyadh Season** events. Built as an early-terms programming project at King Saud University, it focuses on classes and objects, input validation, and keeping running totals in memory.

## What it does

- Welcomes the user and shows the available events:
  - **Boulevard World** – SAR 153
  - **Boulevard City** – SAR 25
  - **Wonder Garden** – SAR 254
  - **Boulevard Runway** – SAR 110
- Validates the booking **year and month** (2024 onward, with month rules for 2024)
- **Books a ticket** for a customer (ID + name) on a specific date, if that date isn't already taken for the event
- **Cancels a booking** by customer ID and date
- Tracks **per-event profit**, **total profit**, and the **number of tickets** booked
- Prints a summary of bookings per event

The repo contains two iterations of the driver:
- `RiyadhSeasonBooking.java` – earlier procedural version
- `RiyadhSeasonBooking2.java` – object-oriented version using the `Event` class for all four events

## Tech stack

- **Java** (JDK 11+), console I/O with `Scanner`
- Object-oriented design: an `Event` class encapsulating pricing, booked-date tracking, profit, and static class-wide counters
- No external libraries; built as an Eclipse project

## Project structure

```
src/projectcsc/
├── Event.java                    # Event model: book(), cancel(), profit tracking, static totals
├── RiyadhSeasonBooking.java      # Driver v1
└── RiyadhSeasonBooking2.java     # Driver v2 (uses Event objects)
```

## How to run

**With Eclipse**
1. Import the project folder as an existing Eclipse project.
2. Run `projectcsc.RiyadhSeasonBooking2` as a Java Application.

**From the command line**
```bash
cd src
javac projectcsc/Event.java projectcsc/RiyadhSeasonBooking2.java -d ../bin
java -cp ../bin projectcsc.RiyadhSeasonBooking2
```

Follow the prompts to enter a year, month, and then book or cancel tickets.

## Team

Group project at King Saud University:

- **Noora Hussain Alsaiari**
- **Maria Alshamrani**

## License

Developed for educational purposes as part of coursework at King Saud University.
