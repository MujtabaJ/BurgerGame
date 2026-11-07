# Burger Game (Android)

A level-based burger-building game for Android, written in **Java**.

## Features

- Level selection screen with a list of burger levels
- Gameplay screen where the player builds the burger for each level
- Success and fail screens after each level
- Splash screen, intro screens and custom animations

## Tech

- **Java** and the Android SDK
- **MVVM**: ViewModels for the main screen, the games list and the burger game
- RecyclerView adapter for the levels list
- Fragments for the games list, levels and gameplay
- Gradle build

## Run

1. Open the project in **Android Studio**.
2. Let Gradle sync.
3. Run the `app` configuration on an emulator or a device.

## Project structure

```
app/src/main/java/com/example/codeplay/
├── Adapter/            # BurgerLevelsAdapter
├── Games1D/burger/     # BurgerFragment, BurgerViewModel, LevelsFragment
├── animations/         # Custom animations
├── utils/              # Helpers and dialogs
├── MainActivity, Splash, SuccessActivity, FailActivity, ...
```

---

Built by [Ghulam Mujtaba](https://github.com/MujtabaJ), mobile and AI app developer. [Hire me on Upwork](https://www.upwork.com/freelancers/ghulammujtaba12).
