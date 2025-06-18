# Chess Game

A Java-based chess game implementation with a graphical user interface.

## Description

This is a complete chess game built in Java that allows two players to play chess against each other. The game features a graphical interface and implements all standard chess rules including piece movements, check detection, and game state management.

## Features

- **Complete Chess Rules**: Implements all standard chess piece movements and rules
- **Graphical Interface**: Visual board representation with piece images
- **Check Detection**: Automatic detection of check and checkmate situations
- **Move Validation**: Ensures all moves follow chess rules
- **Piece Movement**: All pieces (King, Queen, Rook, Bishop, Knight, Pawn) with proper movement patterns
- **Turn-based Gameplay**: Alternating turns between white and black players

## Project Structure

```
Chess/
├── src/
│   ├── main/
│   │   ├── Board.java          # Main game board logic
│   │   ├── CheckScanner.java   # Check detection system
│   │   ├── Input.java          # Input handling
│   │   ├── Main.java           # Application entry point
│   │   └── Move.java           # Move representation and validation
│   ├── pieces/
│   │   ├── Bishop.java         # Bishop piece implementation
│   │   ├── King.java           # King piece implementation
│   │   ├── Knight.java         # Knight piece implementation
│   │   ├── Pawn.java           # Pawn piece implementation
│   │   ├── Piece.java          # Base piece class
│   │   ├── Queen.java          # Queen piece implementation
│   │   └── Rook.java           # Rook piece implementation
│   └── res/
│       └── pieces.png          # Chess piece images
├── Chess.iml                   # IntelliJ IDEA project file
└── README.md                   # This file
```

## Setup and Installation

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- IntelliJ IDEA (recommended) or any Java IDE

### Running the Game

1. Clone the repository:
   ```bash
   git clone https://github.com/rsebany/Chess.git
   cd Chess
   ```

2. Open the project in your IDE (IntelliJ IDEA recommended)

3. Run the `Main.java` file located in `src/main/`

## How to Play

1. **Starting the Game**: Run the application and the chess board will appear
2. **Making Moves**: Click on a piece to select it, then click on the destination square
3. **Valid Moves**: Only legal chess moves are allowed
4. **Check Detection**: The game automatically detects when a king is in check
5. **Game End**: The game ends when checkmate occurs or a draw is declared

## Game Rules

- **White moves first**
- **Standard chess piece movements**:
  - **Pawn**: Moves forward one square (or two on first move), captures diagonally
  - **Rook**: Moves horizontally and vertically
  - **Bishop**: Moves diagonally
  - **Queen**: Moves horizontally, vertically, and diagonally
  - **King**: Moves one square in any direction
  - **Knight**: Moves in L-shape pattern
- **Check**: When a king is under attack
- **Checkmate**: When a king is in check with no legal moves to escape

## Contributing

Feel free to contribute to this project by:
- Reporting bugs
- Suggesting new features
- Submitting pull requests

## License

This project is open source and available under the [MIT License](LICENSE).

## Author

Created by [Your Name] - A chess game implementation in Java. 