
# _FINAL ANDROID PROJECT_

My project is an Android app that shows list of movies
or tv shows according to your choice,
and when clicking one of the items it shows the
details of the chosen movie/tv show.

In my project I used TMDB Api.

### <ins>Features</ins>
- **Home Page:** welcoming page for the app.
- **Movies/Tvs overview:** discovering recent movies and tvs.
- **Movie/Tv Details:** discovering details on each movie/tv show.

### <ins>Technologies Used</ins>
- Fully written in Kotlin language.
- Built o MVVM architecture pattern.
- Implements Android Data Binding for efficient UI updates and data binding.
- Uses Android Architecture Component, specifically ViewModel and LiveData.
- Uses Retrofit for making API calls, handling endpoints, and networking.
- Utilizes Picasso for efficient image loading and caching.
- Implements Room and SQLite for local data storage and management.
- Utilizes Kotlin Coroutines for handling asynchronous tasks and background operations.
- Utilizes HILT in order to organize the code and follow the single responsibility principle(SRP).

### <ins>Usages</ins>
**Running the app:**
Now you can build and run the app on an Android emulator or a physical device:
- Make sure your emulator/device is connected and recognized by Android Studio.
- Make sure the date on your device is set to the current date.
- Click the "Run" button in Android Studio to build and launch the app.

**Using the app:**
- On the first run, the app will fetch the data from the API and store it in the local database for future use. This ensures smoother and faster access to data on subsequent runs.
- On subsequent runs, the app will retrieve the data directly from the local database, providing a quicker and offline-friendly experience.
- After retrieving the data from the local database the app will try and fetch the data from the API. This prevents the user from waiting until the data is loaded from the API by enjoying the existing data from the database.

**Exploring the app:**
Once the app is up and running, you can:
- Choose the type of information you'd like to explore by clicking the right button.
- View a list of the most recent movies/tv shows.
- Getting details on each movie/tv by clicking the item in the list.

### <ins>Screenshots</ins>

<img src="/screenshots/home.png" width="300" height="600"/>
<img src="/screenshots/movie_details.png" width="300" height="600"/>
<img src="/screenshots/movies.png" width="300" height="600"/>
<img src="/screenshots/tv_details.png" width="300" height="600"/>
<img src="/screenshots/tvs.png" width="300" height="600"/>








