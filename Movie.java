class Movie {
    private String movieName;
    private String typeOfMovie;
    private String[] cast;
    private String[] director;
    private String language;
    private int runtime;
    private String[] description;
    private Time openingTime;
    private Time[] showtimeList;
    private String rating;
    
    private Movie(String movieName, String typeOfMovie, String[] cast, String[] director, String language,
                  int runtime, String[] description, Time openingTime, Time[] showtimeList, String rating) {
        this.setMovieName(movieName);
        this.setTypeOfMovie(typeOfMovie);
        this.setCast(cast);
        this.setDirector(director);
        this.setLanguage(language);
        this.setRuntime(runtime);
        this.setDiscription(description);
        this.setShowtimeList(showtimeList);
        this.setRating(rating);
    }
    
    private String getMovieName() {
        return this.movieName;
    }
    private String getTypeOfMovie() {
        return this.typeOfMovie;
    }
    private String[] getCast() {
        return this.cast;
    }
    private String[] getDirector() {
        return this.director;
    }
    private String getLanguage() {
        return this.language;
    }
    private int getRuntime() {
        return this.runtime;
    }
    private String[] getDescription() {
        return this.description;
    }
    private Time getOpeningTime() {
        return this.openingTime;
    }
    private Time[] getShowtimeList() {
        return this.showtimeList();
    }
    private String getRating() {
        return this.rating;
    }



    private String setMovieName(String movieName) {
        this.movieName = movieName;
    }
    private String setTypeOfMovie(String typeOfMovie) {
        this.typeOfMovie = typeOfMovie;
    }
    private String[] setCast(String[] cast) {
        this.cast = cast;
    }
    private String[] setDirector(String[] director) {
        this.director = director;
    }
    private String setLanguage(String language) {
        this.language = language;
    }
    private int setRuntime(int runtime) {
        this.runtime = runtime;
    }
    private String[] setDescription(String[] description) {
        this.description = description;
    }
    private Time setOpeningTime(Time openingTime) {
        this.openingTime = openingTime;
    }
    private Time[] setShowtimeList(Time[] showtimeList) {
        this.showtimeList() = showtimeList;
    }
    private String setRating(String rating) {
        this.rating = rating;
    }
}
