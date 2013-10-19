package Moblima;

class Movie {
    private String movieName;
    private String typeOfMovie;
    private String[] cast;
    private String[] director;
    private String language;
    private int runtime;
    private String[] description;
    private Time openingTime;
    private ArrayList<Time> showtimeList;
    private String rating;

    private static final String ratingList[] = {"G", "PG", "R18"};
    
    public Movie(String movieName, String typeOfMovie, String[] cast, String[] director, String language,
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

    public static Movie manualNewAMovie(Scanner sc) {
        Movie newMovie = new Movie();
        System.out.print("Name: ");
        newMovie.setMovieName(sc.nextline());
        System.out.print("Type: ");
        newMovie.setTypeOfMovie(sc.next());
        System.out.print("Cast: ");
        newMovie.setCast(sc.nextLine().split(" "));
        System.out.print("Director: ");
        newMovie.setDirector(sc.nextLine().split(" "));
        System.out.print("Language: ");
        newMovie.setLanguage(sc.next());
        System.out.print("Runtime: ");
        newMovie.setRuntime(sc.nextInt());
        System.out.print("Description:");
        newMovie.setDescription(sc.nextLine());
        System.out.print("Showtime: ");
        newMovie.setShowtimeList(Time.manualNewATime());
        System.out.print("Opening time: ");
        newMovie.setOpeningTime(Time.manualNewATime());
        System.out.print("Rating: ");
        newMovie.setRatingBB(sc);
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

    private boolean setMovieName(String movieName) {
        this.movieName = movieName;
        return true;
    }
    private boolean setTypeOfMovie(String typeOfMovie) {
        this.typeOfMovie = typeOfMovie;
        return true;
    }
    private boolean setCast(String[] cast) {
        this.cast = cast;
        return true;
    }
    private boolean setDirector(String[] director) {
        this.director = director;
        return true;
    }
    private boolean setLanguage(String language) {
        this.language = language;
        return true;
    }
    private boolean setRuntime(int runtime) {
        this.runtime = runtime;
        return true;
    }
    private boolean setDescription(String[] description) {
        this.description = description;
        return true;
    }
    private boolean setOpeningTime(Time openingTime) {
        this.openingTime = openingTime;
        return true;
    }
    private boolean addShowtime(Time newShowtime) {
        this.showtimeList.add();
        return true;
    }
    private boolean deleteShowtime(Scanner sc) {
        Integer x;
        for (int i = 0; i < showtimeList.size(); i++) {
            System.out.println(i.);
            showtimeList.get(i).printTime();
            System.out.println();
        }
        System.out.print("Delete: ");
        x = sc.nextInt();
        return this.showtimeList.remove(x);
    }
    private boolean setRating(String rating) {
        this.rating = rating;
        return true;
    }
    private boolean setRatingBB(Scanner sc) {
        Integer ri;
        for (int i = 0; i < ratingList.length; i++) {
            System.out.print((i+1) + "." + ratingList[i]);
        }
        System.out.println("\nSelect new rating: ");
        this.setRating(ratingList[sc.nextInt()]);
        return true;
    }
}
