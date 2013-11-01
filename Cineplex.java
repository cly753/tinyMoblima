package Moblima;

class Cineplex {
    private final int numOfCinema = 3;
    private ArrayList<Cinema> cinemaList = new ArrayList<Cinema>();
    private String info;
    //private static String infoField[] = {"Name", "Location", "CineplexId"};

    public Cineplex() {
        for (int i = 0; i < numOfCinema; i++) {
            cinemaList.add(new Cinema());
        }
    }
}
