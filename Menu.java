package Moblima;


class Menu {
    
    public static Scanner sc = new Scanner(System.in);
    public static int userType = -1;
    public static boolean loginState = false;
    public static Moviegoer customer;
    
    public static void welcome() {
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("|                                | ");
        System.out.println("|                                | ");
        System.out.println("|       Welcome to Moblima       | ");
        System.out.println("|           Da Shen Lu           | ");
        System.out.println("|                                | ");
        System.out.println("++++++++++++++++++++++++++++++++++");
    }

    public static void toplevel() {
        int choice;
        while (true) {
            System.out.println("Please Enter Your Choice:");
            System.out.println("1. List all movies"); // call listAllMovie
            System.out.println("2. Search movies"); // call search
            System.out.println("3. Book movie"); // select and call search/listAllMovie
            System.out.println("4. Check status/history"); // call checkLogin
            System.out.println("5. Pay"); // call checkLogin
            System.out.println("6. Login");
            System.out.ptintln("7. Logout");
            System.out.ptintln("8. Register");
            System.out.println("0. Exit");
            choice = sc.nextInt();
            if (choice == 0) {
                System.out.println("Exit...");
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("List all movies:");
                    movieLib.listMovie();
                    break;
                case 2, 3:
                    System.out.println("Please Enter the movie name:");
                    String nameOfMovie = sc.next();
                    ArrayList<Movie> searchResult = movieLib.search(nameOfMovie);
                    if (searchResult.length == 0) {
                        System.out.println("Sorry, cannot find any movie!");
                        break;
                    }
                    
                    if (searchResult.length == 1 && choice == 3) {
                        //if find the only one movie, then it's available for booking
                        System.out.println("Do want to see details about this movie?");
                        System.out.println("1 for yes, others for no");
                        int showOrNot = sc.nextInt();
                        if (showOrNot == 1) {
                            searchResult[0].showInfo();//movie shows its info 
                        }
                        System.out.println("Do want to book this movie?");
                        System.out.println("1 for yes, others for no");
                        int bookOrNot = sc.nextInt();
                        if (bookOrNot == 1) {
                            //// **** ????
                        } else {
                            System.out.println("Back...");
                        }
                        break;
                    }

                    while (true) {
                        System.out.println("Which movie do you want to see details?");
                        System.out.println("Please input the index in front of it: ");
                        System.out.println("input other to return");
                        int selectMovie = sc.nextInt();

                        if (selectMovie < 0 || selectMovie >= searchResult.length)) {
                            System.out.println("back...");
                            break;
                        }

                        searchResult.get(selectMovie).showInfo();

                        System.out.println("Do want to book this movie?");
                        System.out.println("1 for yes, others for no");
                        int bookOrNot = sc.nextInt();
                        if (bookOrNot == 1)
                            this.book(searchResult[0].movieName);
                    }
                    break;
                case 4, 5, 6:

                    if (curUser == null) {
                        String username;
                        String password;
                        System.out.println("please login");
                        System.out.print("username: ");
                        username = sc.next();
                        System.out.print("password: ");
                        password = sc.next();

                        curUser = goerLib.checkLogin(username, password);

                        if (curUser != null) {
                            System.out.println("login succeed.");
                        }
                    }

                    if (choice == 6) {
                        break;
                    }
                    
                    if (choice == 4) {
                        MoviegoerLib.showHistory(goerLib, false);

                        if (goerLib.unpaid().size() != 0) {
                            System.out.print("pay(index) or go back(other)?");
                            int toPay = sc.nextInt();

                            if (0 <= toPay && toPay < goerLib.unpaid().size())
                                MoviegoerLib.pay(movieLib, toPay);
                            else
                                break;
                        }
                    }

                    if (choice == 5) {
                        MoviegoerLib.showHistory(goerLib, true);

                        if (goerLib.unpaid().size() == 1)
                            MoviegoerLib.pay(movieLib, 0);
                        else {
                            System.out.print("pay(index) or go back(other)?");
                            int toPay = sc.nextInt();

                            if (0 <= toPay && toPay < goerLib.unpaid().size())
                                MoviegoerLib.pay(movieLib, toPay);
                        }
                    }
                    break;
                case 6:
                    if (curUser != null) {
                        String username;
                        String password;
                        System.out.print("username: ");
                        username = sc.next();
                        System.out.print("password: ");
                        password = sc.next();

                        curUser = goerLib.checkLogin(username, password);

                        if (curUser != null)
                            System.out.println("login succeeded.");
                        else
                            System.out.println("login failed.");
                    } else {
                        System.out.println("Already logged in. Log out first.");
                    }
                    break;
                case 7:
                    curUser = null;
                    break;
                case 8:
                    curUser = goerLib.add();
                    break;
                default:
                    System.out.println("Wrong input.");
                    break;
            }
            
        }
    }
    public static void staffMenu() {
        int choice;
        while (true) {
            System.out.println("Enter your choice, Da Shen!");
            System.out.println("1. Add/Modify/Remove a movie");
            System.out.println("2. Set holidays"); // call setHoliday in Time class
            System.out.println("3. Generate revenue report"); // call generateRevenueReport in Revenue class
            System.out.println("0. exit"); // previous level: toplevel
            choice = sc.nextInt();
            if (choice == 0) {
                System.out.println("Bye-Bye Da Shen! ");
                break;
            }
            switch (choice) {
                case 1:
                    this.addModifyRemove();
                    break;
                case 2:
                    System.out.print("New public holiday(yyyymmdd): ");
                    Time.setPubHoliday(sc.next());
                    break;
                case 3:
                    this.generateRevenueReport();
                    break;
                default:
                    System.out.println("Wrong Input.");
                    break;
            }
        }
    }

    public static void addModifyRemove() {
        int choice;
        while (true) {
            System.out.println("Please Enter your choice:");
            System.out.println("1. list movies"); // call listMovie in MovieLib class
            System.out.println("2. Search a movie"); // call search in MovieLib class
            System.out.println("3. Add a movie"); // call addMovie in MovieLib class
            System.out.println("4. Update a movie"); // next level: modify >>> call xxx in Movie class
            System.out.println("5. Remove a movie"); // call remove in MovieLib class
            System.out.println("0.back"); // previous level: staff menu
            choice = sc.nextInt();
            if (choice == 0) {
                System.out.println("Back...");
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("List all movies:");
                    movieLib.listMovie();
                    break;
                case 2, 4, 5:
                    System.out.println("Please Enter the movie name:");
                    String nameOfMovie = sc.next();
                    ArrayList<Movie> result = movieLib.searchMovie(nameOfMovie);
                    
                    if (choice != 2) {
                        System.out.print("select: ");
                        int sel = sc.nextInt();
                    }
                    if (choice == 4)
                        MovieLib.modify(result.get(sel));
                    else if (choice == 5)
                        movieLib.remove(movieLib.indexOf(result.get(sel)));
                    break;
                case 3:
                    System.out.println("Add a movie:");
                    movieLib.add();
                    break;
                default:
                    System.out.println("Wrong Input.");
                    break;
            }
        }
    }
    
    public static void modify(String nameOfMovie) { // call modify in MovieLib class
        //System.out.println("list movies"); // call listMovie in MovieLib class
        int choice;
        while (true) {
            System.out.println("Modify:");
            System.out.println("Please Enter your choice:");
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
            System.out.println("0.back"); // previous level: staff menu
            choice = sc.nextInt();
            if (choice == 0) {
                System.out.println("Back...");
                break;
            }
            if (choice < 0 || choice > 11) {
                System.out.println("Wrong Input.");
                continue;
            }
            if (movieLib.modify(nameOfMovie, choice)) {
                System.out.println("Successful modified");
            }
        }
    }
}
