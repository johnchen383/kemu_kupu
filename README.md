# Kemu Kupu
Kēmu Kupu is an educational GUI application for children between the ages of 8 to 12 who are picking up te reo Māori. It allowed such children to upskill their Māori vocabulary in a fun, gamified manner.

This was the design project for SE206 (Software Engineering Design) undertaken for Part 2 Engineering at the University of Auckland.

## Running
Ensure that the required files are all available
- There should be `runQuiz.sh`, `quiz.jar`, and `words/` directory available.
- Within `words/` there should be a selection of csv files, **named and stored in identical format** to that found at the GitHub repository https://github.com/SOFTENG206-2021/assignment-3-and-project-team-11

To get started, ensure that executable permissions are given to the shell scripts `runQuiz.sh`
```bash
chmod +x runQuiz.sh
```

Ensure that `JavaFX` external jar files are located at `/home/student/javafx-sdk-11.0.2/javafx`

Run the code by executing the shell script `runQuiz.sh`
```bash
./runQuiz.sh
```

Note that for optimal results, please ensure Kemu Kupu is run on the VM image provided for SE206
