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
    
    public String getMovieName() {
        return this.movieName;
    }
    public String getTypeOfMovie() {
        return this.typeOfMovie;
    }
    public String[] getCast() {
        return this.cast;
    }
    public String[] getDirector() {
        return this.director;
    }
    public String getLanguage() {
        return this.language;
    }
    public int getRuntime() {
        return this.runtime;
    }
    public String[] getDescription() {
        return this.description;
    }
    public Time getOpeningTime() {
        return this.openingTime;
    }
    public Time[] getShowtimeList() {
        return this.showtimeList();
    }
    public String getRating() {
        return this.rating;
    }

    public boolean setMovieName(String movieName) {
        this.movieName = movieName;
        return true;
    }
    public boolean setTypeOfMovie(String typeOfMovie) {
        this.typeOfMovie = typeOfMovie;
        return true;
    }
    public boolean setCast(String[] cast) {
        this.cast = cast;
        return true;
    }
    public boolean setDirector(String[] director) {
        this.director = director;
        return true;
    }
    public boolean setLanguage(String language) {
        this.language = language;
        return true;
    }
    public boolean setRuntime(int runtime) {
        this.runtime = runtime;
        return true;
    }
    public boolean setDescription(String[] description) {
        this.description = description;
        return true;
    }
    public boolean setOpeningTime(Time openingTime) {
        this.openingTime = openingTime;
        return true;
    }
    public boolean addShowtime(Time newShowtime) {
        this.showtimeList.add();
        return true;
    }
    public boolean deleteShowtime(Scanner sc) {
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
    public boolean setRating(String rating) {
        this.rating = rating;
        return true;
    }
    public boolean setRatingBB(Scanner sc) {
        Integer ri;
        for (int i = 0; i < ratingList.length; i++) {
            System.out.print((i+1) + "." + ratingList[i]);
        }
        System.out.println("\nSelect new rating: ");
        this.setRating(ratingList[sc.nextInt()]);
        return true;
    }
}
