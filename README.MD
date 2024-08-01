# Gamma Function Calculator

This is a Java Swing GUI application for calculating the Gamma function using Euler's method. The application features a simple user interface with two main screens: a welcome screen and a main calculator screen.

## Features

- **Welcome Screen**: A welcoming interface with a button to proceed to the calculator.
- **Calculator Screen**: Allows users to input a number, calculates the Gamma function using Euler's method, and displays the result.
- **Accessible**: Designed with accessibility in mind, including descriptions for screen readers.

## Screenshots

![Welcome Screen](screenshots/welcome.png)
![Calculator Screen](screenshots/calculator.png)

## Installation

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/yourusername/gamma-function-calculator.git
2. **Navigate to the Project Directory:**
   ```bash
   cd gamma-function-calculator
3. **Compile the Java Code:**
   ```bash
   cd gamma-function-calculator
4. **Run the Application:**
   ```bash
   java GammaFunctionGUI

## Usage

1. **Launch the Application**: Run the `GammaFunctionGUI` class.
2. **Welcome Screen**: Click the "Continue" button to proceed to the calculator.
3. **Calculator Screen**:
   - **Enter a Number**: Input a positive number into the text field.
   - **Calculate**: Click the "Calculate" button or press Enter to compute the Gamma function.
   - **Result**: View the result in the result area.
   - **Close**: Click the "Close" button to exit the application.

## Code Overview

The application consists of a single class, `GammaFunctionGUI`, which contains methods for initializing the GUI and calculating the Gamma function using Euler's method. The GUI includes:

- **Welcome Screen**: A simple frame with a welcome message and a continue button.
- **Main Frame**: Contains input fields, buttons, and result display areas, arranged using a GridBagLayout.

## Accessibility

The GUI has been designed with accessibility in mind, including:

- Accessible descriptions for buttons and text fields.
- Focus management for user inputs.

## Dependencies

- Java SE 8 or higher

## Contributing

Feel free to submit issues, pull requests, or suggestions to improve the application. Please adhere to the coding style used in the project.
