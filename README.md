# WatchIt

WatchIt is a movie and TV show management application that allows users to search, save, and manage their favorite films and shows. It utilizes The Movie Database ([TMDb](https://www.themoviedb.org/)) API for searching movies and TV shows, and provides functionality to manage a personal watchlist.

## Available API Endpoints

### User Management

- **POST /signup**
  - **Description**: Create a new user.
  - **Request Body**: JSON object containing user details.
    ```json
    {
      "username": "testUsername",
      "password": "dontHackMe"
    }
    ```

- **POST /login**
  - **Description**: Authenticate an existing user.
  - **Request Body**: JSON object containing user credentials.
    ```json
    {
      "username": "testUsername",
      "password": "dontHackMe"
    }
    ```

### Movie and TV Show Search

- **GET /api/v1/search**
  - **Description**: Search for movies or TV shows in The Movie Database (TMDb).
  - **Parameters**:
    - `query` (string): Search query (e.g., "Inception").
    - `mediaType` (string): Type of media to search for (e.g., "Movie", "Tv"). Use "Any" for all types.
    - `page` (integer): Page number for paginated results.
  - **Response**: JSON object containing search results.
    ```json
    {
      "page": 1,
      "results": [
        {
          "adult": false,
          "backdropPath": "/8ZTVqvKDQ8emSGUEMjsS4yHAwrp.jpg",
          "id": 27205,
          "title": "Inception",
          "originalLanguage": "en",
          "originalTitle": "Inception",
          "overview": "Cobb, a skilled thief who...",
          "posterPath": "/ljsZTbVsrQSqZgWeep2B1QiDKuh.jpg",
          "mediaType": "movie",
          "genreIds": [28, 878, 12],
          "popularity": 84.37,
          "releaseDate": "2010-07-15g",
          "video": false,
          "voteAverage": 8.369,
          "voteCount": 36100
        }
      ],
      "totalPages": 10,
      "totalResults": 100
    }
    ```

### Saved Movies

- **GET /api/v1/movies**
  - **Description**: Search saved movies in your personal watchlist.
  - **Parameters**:
    - `title` (string): Title of the movie (optional).
    - `mediaType` (string): Type of media (e.g., "Movie", "TV") (optional). Use "Any" for all types.
  - **Response**: JSON array of saved movies.
    ```json
    [
      {
        "savedMovieId": 123,
        "finished": false,
        "rating": 0,
        "user_id": 1,
        "id": 456,
        "title": "Test Movie",
        "originalLanguage": "ru",
        "originalTitle": "Тестовое кино",
        "overview": "This is a test.",
        "posterPath": "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
        "mediaType": "tv",
        "popularity": 168.9,
        "releaseDate": "1987-07-27",
        "voteAverage": 10.0
      }
    ]
    ```

- **GET /api/v1/movies/{id}**
  - **Description**: Retrieve a saved movie by its ID.
  - **Parameters**:
    - `id` (integer): ID of the saved movie.
  - **Response**: JSON object containing saved movie details.

- **POST /api/v1/movies**
  - **Description**: Save a movie to your personal watchlist.
  - **Request Body**: JSON object containing movie details.

- **PUT /api/v1/movies**
  - **Description**: Update a saved movie's information, such as marking it as watched or updating the personal rating.
  - **Request Body**: JSON object containing updated movie details.

- **DELETE /api/v1/movies/{id}**
  - **Description**: Delete a movie from your personal watchlist.
  - **Parameters**:
    - `id` (integer): ID of the movie to be deleted.

## Technology Stack

- **Spring Boot**: For creating and configuring the application.
- **Spring Data JPA**: For interacting with the PostgreSQL database.
- **Spring Boot MVC**: For handling web requests and rendering views.
- **PostgreSQL**: Database management system for storing user and movie data.
- **Lombok**: For reducing boilerplate code in Java.
- **Spring Security**: For securing the application and managing user authentication.

## Frontend

The repository includes a sample frontend built with HTML, JavaScript, and Bootstrap. It provides a user interface for interacting with the WatchIt API, including features like searching for movies, managing a watchlist, and viewing saved movies.

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/watchit.git
   ```
2. Navigate to the project directory:
   ```bash
   cd watchit
   ```
3. Set up the PostgreSQL database and configure the connection settings in `env.properties` in project root directory.
4. Build and run application:
   ```bash
   ./mvnw spring-boot:run
   ```
5. Open your browser and navigate to `http://localhost:8080` to access the application.
