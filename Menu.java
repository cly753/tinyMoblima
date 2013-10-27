package Moblima;

//
// a rough menu
// only menu
// and
// suggested action after select
//


class Menu {
    
    public static Scanner sc = new Scanner(System.in);
    public static int userType = -1;
    public static boolean loginState = false;
    public static Moviegoer customer;
    
    public static void welcome() {
        System.out.println("Welcome to xxx");
    }

    public static void toplevel() {
        int choice;
        while (true) {
            System.out.println("Please Enter Your Choice:");
            System.out.println("1. Search movies"); // call search
            System.out.println("2. List all movies"); // call listAllMovie
            System.out.println("3. Book movie"); // select and call search/listAllMovie
            System.out.println("4. Check status/history"); // call checkLogin
            System.out.println("5. Pay"); // call checkLogin
            System.out.println("6. Login");
            System.out.ptintln("7. Logout");
            System.out.println("0. Exit");
            choice = sc.nextInt();
            if (choice == 0) {
                System.out.println("Exit...");
                break;
            }
            switch (choice) {
                case 1, 3:
                    String nameOfMovie;
                    System.out.println("Please Enter the movie name:");
                    nameOfMovie = sc.next();
                    if (movieLib.search(nameOfMovie) && choice == 3) {
                        //if find the movie, then it's available for booking
                        this.book(nameOfMovie);
                    }
                    break;
                case 2:
                    System.out.println("List all movies:");
                    movieLib.listAllMovie();
                    break;
                case 4:
                    if (this.checkLogin()) {
                        loginState = true;
                        userType = 1;
                    }
                    break;
                case 5:
                    if (loginState) {
                        this.pay();
                    }
                    break;
                case 6:
                    if (!loginState) {
                        this.login();
                    } else {
                        System.out.println("You have logged in. You may want to log out first.");
                        System.out.println("If so, please choose 7.");
                    }
                    break;
                case 7:
                    loginState = false;
                    userType = -1;
                    break;
                defult:
                    System.out.println("Wrong input.");
                    break;
            }
            
        }
    }
    public static void staffMenu() {
        System.out.println("1.Add/Modify a movie"); // next level: add modify remove
        System.out.println("2.Set holidays"); // call setHoliday in Time class
        System.out.println("3.Generate revenue report"); // call generateRevenueReport in Revenue class
        System.out.println("17.exit"); // previous level: toplevel
    }

    public static void addModifyRemove() {
        System.out.println("1.list movies"); // call listMovie in MovieLib class
        System.out.println("2.Add a movie"); // call addMovie in MovieLib class
        System.out.println("3.Update a movie"); // next level: modify >>> call xxx in Movie class
        System.out.println("4.Remove a movie"); // call remove in MovieLib class
        System.out.println("17.back"); // previous level: staff menu
    }

    public static void modify() { // call modify in MovieLib class
        System.out.println("-1.list movies"); // call listMovie in MovieLib class
        System.out.println("0.show menu");
        System.out.println("Modify:");
        System.out.println("1.name");
        System.out.println("2.type");
        System.out.println("3.cast");
        System.out.println("4.director");
        System.out.println("5.language");
        System.out.println("6.runtime");
        System.out.println("7.description");
        System.out.println("8.openingTime");
        System.out.println("9.add showtime");
        System.out.println("10.delete showtime");
        System.out.println("11.rating");
        System.out.println("17.exit"); // previous level: staff menu
    }
}
