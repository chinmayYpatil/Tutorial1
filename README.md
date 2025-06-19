# 📱 LazyColumn vs Column Performance Demo (Jetpack Compose)

This is a simple Android app that demonstrates the performance difference between **LazyColumn** and **Column** in **Jetpack Compose** when rendering a large list of 1,000 questions.

When the app runs, it will:

✅ Measure and log the composition time for both `LazyColumn` and `Column`  
✅ Allow toggling between the two composables to compare performance  
✅ Display the list of questions on the screen  

## How It Works

Each time the app composes the UI, it:

1. Records the start time of composition  
2. Renders the list using either `LazyColumn` or `Column`  
3. Logs the composition time in Logcat  
4. Allows performance comparison by toggling between the two approaches

## Example Performance Flow
| Composable   | Composition Time (ms) | Notes                              |
|--------------|-----------------------|------------------------------------|
| LazyColumn   | ~173 ms               | Renders only visible items         |
| Column       | ~1129 ms              | Renders all 1,000 items upfront    |


<img width="1055" alt="Screenshot 2025-06-20 at 1 55 13 AM" src="https://github.com/user-attachments/assets/7462b712-0532-4b80-93b8-af0f38446d96" />

How to Run

1. Clone this project
2. Open in Android Studio
3. Run the app on a device or emulator
4. In Logcat, apply the filter PERF_TEST to view performance logs
