# The Flying Fish

The Flying Fish is a simple Android game where players control a fish to avoid obstacles and collect points. The game ends when the fish runs out of lives, and the player's score and highest score are displayed on the game over screen.

## Features

- Animated fish with touch controls
- Collectible points with sound effects
- Obstacles to avoid
- Background music
- High score saving
- Game over screen with the option to play again

## Screenshots

<p align="center">
  <img src="https://github.com/chamindu2001/Android-Game-App/assets/127916715/06872a8c-4bc3-49e8-ba0e-b1cb16a9e095" width="200" style="margin-right: 50px;" />
  <img src="https://github.com/chamindu2001/Android-Game-App/assets/127916715/9adc3a6b-fa8a-4dae-9db8-3aa8010d16d4" width="200" style="margin-right: 50px;" />
  <img src="https://github.com/chamindu2001/Android-Game-App/assets/127916715/2cf33ecc-d3cb-406d-912e-682f18c1dd3f" width="200" style="margin-right: 50px;" />
</p>
<p align="center">
  <img src="https://github.com/chamindu2001/Android-Game-App/assets/127916715/5f945bcb-a523-4ae2-9515-b055c1113974" width="200" style="margin-right: 50px;" />
  <img src="https://github.com/chamindu2001/Android-Game-App/assets/127916715/7fa807ac-cc27-4ef9-8a14-c555a53c8365" width="200" />
</p>

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
