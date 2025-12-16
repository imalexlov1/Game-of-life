# Game of Life (Java)

A simple console-based implementation of John Conway's **Game of Life** written in Java.

## Features
* **Grid Size:** 20x20.
* **Display:** Runs directly in the terminal using ASCII characters (`x` for alive, `.` for dead).
* **Architecture:** Object-Oriented design with a dedicated `Cell` class.

## Project Structure
* `Cell.java`: Manages the state of a single cell (alive/dead).
* `JeuDeLaVie.java`: Main class containing the grid logic, rules, and render loop.

## How to Run

1.  **Start the game:**
    ```bash
    java JeuDeLaVie
    ```

2.  **Stop the game:**
    Press `Ctrl + C` in your terminal.
