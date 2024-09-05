# The Flying Fish

The Flying Fish is a simple Android game where players control a fish to avoid obstacles and collect points. The game ends when the fish runs out of lives, and the player's score and highest score are displayed on the game over screen.

## Features

- Animated fish with touch controls
- Collectible points with sound effects
- Obstacles to avoid
- Background music
- High score saving
- Game over screen with the option to play again


![App Design Plan Brainstorm Classroom Worksheet](https://github.com/user-attachments/assets/5e3d7437-0a0e-4c95-986e-273b79c1d5d9)


## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/chamindu2001/theflyingfish.git
    ```

2. Open the project in Android Studio.

3. Build and run the project on an Android device or emulator.

## Game Instructions

- Touch the screen to make the fish move up.
- Avoid red obstacles and collect yellow and green points.
- The game ends when the fish collides with a red obstacle three times.
- The game over screen will display the score and highest score, with an option to play again.

## Project Structure

- `MainActivity.kt`: The main activity that initializes the game view.
- `StartActivity.kt`: The start screen activity.
- `StartUpActivity.kt`: The startup activity that shows a splash screen.
- `GameView.kt`: The custom view that handles game logic and rendering.
- `GameOverActivity.kt`: The activity that shows the game over screen.
- `res/layout`: XML layout files.
- `res/drawable`: Images used in the game.
- `res/raw`: Audio files used in the game.
- `res/values`: Colors, strings, and other XML resource files.

## Resources

### Layout Files

- `activity_main.xml`: Layout for the main game activity.
- `activity_start.xml`: Layout for the start screen activity.
- `activity_start_up.xml`: Layout for the startup screen activity.
- `activity_game_over.xml`: Layout for the game over screen activity.

### String Resources

- `strings.xml`: Contains all the string resources used in the game.

### Color Resources

- `colors.xml`: Contains all the color resources used in the game.

### Drawable Resources

- Various image files used for the background, fish, obstacles, and life indicators.

### Raw Resources

- Background music and sound effect files.

## License

This project is licensed under the MIT License.
