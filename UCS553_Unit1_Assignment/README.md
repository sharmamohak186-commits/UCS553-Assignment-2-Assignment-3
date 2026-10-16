# UCS553 Unit-1 Java Assignment

This repository contains solutions for both experiments:
1. Online Food Delivery Order Management (Q1)
2. Smart Library Resource Management (Q2)

## Requirements
- Java JDK 8 or later
- No external libraries

## Project structure
```text
src/
├── food/
│   ├── model/
│   ├── service/
│   ├── utility/
│   └── main/
└── library/
    ├── model/
    ├── service/
    ├── util/
    └── main/
```

## Compile and run

From the project root:

### Q1 - Food orders
```bash
javac -d out src/food/model/*.java src/food/service/*.java src/food/utility/*.java src/food/main/*.java
java -cp out food.main.Main
```

### Q2 - Library resources
```bash
javac -d out src/library/model/*.java src/library/service/*.java src/library/util/*.java src/library/main/*.java
java -cp out library.main.Main
```

Both programs use sample data and print bills/details to the console.
