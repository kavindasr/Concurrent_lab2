# **CS4532 Concurrent Programming** - Lab 2

## Senate Bus Problem

### Running the program

1. Go to the `src` folder which has the files to be run.
```bash
cd src
```

2. Compile the java program.
```
javac Main.java
```

3. Run the java program and record output to a text file
```bash
java Main | tee -i simulation.txt
```

Project Contains,

```bash
src
├── Main.java
├── models
│   ├── BoardingArea.java
│   ├── Bus.java
│   └── Rider.java
└── simulator
    ├── Simulator.java
    ├── BusSimulator.java
    └── RiderSimulator.java
```

Tested with Java 11.

