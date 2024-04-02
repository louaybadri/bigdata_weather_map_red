# Average Temperature Per Capital - MapReduce Maven Project

This project is a MapReduce application that calculates the average temperature per capital. It is implemented using Apache Hadoop and Maven.

## Project Structure

The project consists of two main Java classes:

1. `TokenizerMapper`: This class extends `Mapper` and is responsible for mapping input key/value pairs to a set of intermediate key/value pairs. It splits the input lines into tokens, extracts the capital name and temperature, and writes them to the context.

2. `AvgTempReducer`: This class extends `Reducer` and is responsible for reducing a set of intermediate values which share a key to a smaller set of values. It calculates the average temperature for each capital and writes the result to the context.

## How to Run

To run this project, you need to have Hadoop and Maven installed on your machine.

1. Compile the project using Maven:
    ```
    mvn clean install
    ```

2. Run the MapReduce job:
    ```
    hadoop jar target/avg-temp-per-capital-1.0-SNAPSHOT.jar com.example.AvgTempPerCapital input.txt output
    ```
    Replace `input.txt` with the path to your input file and `output` with the directory where you want the output to be stored.

## Input Format

The input file should be a CSV file with at least three columns. The second column should be the capital name and the sixth column should be the average temperature in Celsius.

## Output Format

The output will be a set of lines. Each line contains a capital name and its average temperature, separated by a tab.

## Error Handling

If a line in the input file does not have at least three columns or if the temperature is not a valid float, the line will be ignored.
