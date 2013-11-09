package Moblima;

import java.util.*;

public class Menu {

    public static Scanner sc = new Scanner(System.in);

    public static void welcome() {
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("|                                | ");
        System.out.println("|             *^_^*              | ");
        System.out.println("|       Welcome to Moblima       | ");
        System.out.println("|           Gong Da Shi          | ");
        System.out.println("|                                | ");
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static void toplevel(Moviegoer curUser, MovieLib movieLib, MoviegoerLib goerLib, TicketLib tiLib, Company company) {
        int choice;
        while (true) {
            System.out.println("++++++++++++++++++++++++++++");
            System.out.println("|Please Enter Your Choice: |");
            System.out.println("|>1. List all movies       |"); // call listAllMovie
            System.out.println("|>2. Search movies         |"); // call search
            System.out.println("|>3. Book movie            |"); // select and call search/listAllMovie
            System.out.println("|>4. Check status/history  |"); // call checkLogin
            System.out.println("|>5. Pay                   |"); // call checkLogin
            if (curUser == null) {
                System.out.println("|>6. Login                 |");
            } else {
                System.out.println("|>7. Logout               |");
            }
            System.out.println("|>8. Register              |");
            System.out.println("|>9. Staff                 |");
            System.out.println("|>10. GUI Trial            |");
            System.out.println("|>0. Exit                  |");
            System.out.println("++++++++++++++++++++++++++++");
            choice = sc.nextInt();
            if (choice == 0) {
                System.out.println("Exit...");
                return;
            }
            switch (choice) {
                case 1:
                    System.out.println("List all movies:");
                    movieLib.listMovie();
                    break;
                case 2:
                case 3:
                    System.out.println("Please Enter the movie name:");
                    String nameOfMovie = sc.next();
                    ArrayList<Movie> searchResult = movieLib.searchMovie(nameOfMovie);
                    if (searchResult.size() == 0) {
                        System.out.println("Sorry, cannot find any movie!");
                        break;
                    }

                    if (searchResult.size() == 1 && choice == 3) {
                        //if find the only one movie, then it's available for booking
                        System.out.println("Do want to see details about this movie?");
                        System.out.println("1 for yes, others for no");
                        int showOrNot = sc.nextInt();
                        if (showOrNot == 1) {
                            searchResult.get(0).showInfo();
                        }
                        System.out.println("Do want to book this movie?");
                        System.out.println("1 for yes, others for no");
                        int bookOrNot = sc.nextInt();
                        if (bookOrNot == 1) {
                            Ticket currentTicket = MoviegoerLib.book(curUser, searchResult.get(0), tiLib, company);
                            tiLib.addTicket(currentTicket);
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

                        if (selectMovie < 0 || selectMovie >= searchResult.size()) {
                            System.out.println("back...");
                            break;
                        }

                        searchResult.get(selectMovie).showInfo();

                        System.out.println("Do want to book this movie?");
                        System.out.println("1 for yes, others for no");
                        int bookOrNot = sc.nextInt();
                        if (bookOrNot == 1) {
                        	Ticket currentTicket = MoviegoerLib.book(curUser, searchResult.get(0), tiLib, company);
                            tiLib.addTicket(currentTicket);
                        }
                    }
                    break;
                case 4:
                case 5:
                case 6:
                    if (curUser == null) {
                        String username;
                        String password;
                        System.out.print("username: ");
                        username = sc.next();
                        System.out.print("password: ");
                        password = sc.next();

                        curUser = goerLib.checkLogin(username, password);

                        if (curUser != null) {
                            System.out.println("login succeeded.");
                        } else {
                            System.out.println("login failed.");
                            break;
                        }
                    } else {
                        System.out.println("???");
                        break;
                    }

                    if (choice == 6) {
                        break;
                    }

                    if (choice == 4) {
                        MoviegoerLib.showHistory(curUser, tiLib, false);
                        if (curUser.getUnpaid().size() != 0) {
                            System.out.print("pay(index) or go back(other)?");
                            int toPay = sc.nextInt();
                            if (0 <= toPay && toPay < curUser.getUnpaid().size()) {
                                MoviegoerLib.pay(curUser, tiLib, toPay);
                            } else {
                                break;
                            }
                        }
                    }

                    if (choice == 5) {
                        MoviegoerLib.showHistory(curUser, tiLib, true);

                        if (curUser.getUnpaid().size() == 1) {
                            MoviegoerLib.pay(curUser, tiLib, 0);
                        } else {
                            System.out.print("pay(index) or go back(other)?");
                            int toPay = sc.nextInt();

                            if (0 <= toPay && toPay < curUser.getUnpaid().size()) {
                                MoviegoerLib.pay(curUser, tiLib, toPay);
                            }
                        }
                    }
                    break;

                case 7:
                    curUser = null;
                    break;
                case 8:
                    curUser = goerLib.add();
                    break;
                case 9:
                    System.out.print("password: ");
                    if (sc.next().compareTo(Main.adminPwd) == 0) {
                        staffMenu(movieLib, goerLib, tiLib, company);
                    }
                    break;
                case 10:
                    new NewJFrame().setVisible(true);
                    System.out.println("HAHA");
                    break;
                default:
                    System.out.println("Wrong input.");
                    break;
            }
        }
    }

    public static void staffMenu(MovieLib movieLib, MoviegoerLib goerLib, TicketLib tiLib, Company company) {
        int choice;
        while (true) {
            System.out.println("+++++++++++++++++++++++++++++++");
            System.out.println("|Enter your choice, Da Shen!  |");
            System.out.println("|1. Add/Modify/Remove a movie |");
            System.out.println("|2. Set holidays              |"); // call setHoliday in Time class
            System.out.println("|3. Generate revenue report   |"); // call generateRevenueReport in Revenue class
            System.out.println("|0. exit                      |"); // previous level: toplevel
            System.out.println("+++++++++++++++++++++++++++++++");

            choice = sc.nextInt();
            if (choice == 0) {
                System.out.println("Bye-Bye Da Shen! ");
                break;
            }
            switch (choice) {
                case 1:
                    addModifyRemove(movieLib);
                    break;
                case 2:
                    System.out.print("New public holiday(yyyymmdd): ");
                    Time.setPublicHoliday(sc.next());
                    break;
                case 3:
                    System.out.println("1.by one Cineplex");
                    System.out.println("2.by all Cineplex");
                    int i = sc.nextInt();
                    Cineplex cineplex = null;
                    if (i == 1) {
                        System.out.println("Choose");
                        for (int j = 0; j < company.get().size(); j++) {
                            System.out.println(j + " " + company.get(i).getName());
                        }
                        int which = sc.nextInt();
                        if (0 <= which && which < company.get().size()) {
                            cineplex = company.get(which);
                        } else {
                            System.out.println("Out of range.");
                            break;
                        }
                    }
                    System.out.print("Choose 1.daily 2.monthly 3.total?");
                    i = i * 10 + sc.nextInt();

                    switch (i) {
                        case 11:
                        case 12:
                        case 13:
                        case 21:
                        case 22:
                            Time day = Time.manualNewATime();
                            if (i == 11) {
                                Revenue.getDailyCineplexRevenue(tiLib, cineplex, day);
                            } else if (i == 12) {
                                Revenue.getMonthlyCineplexRevenue(tiLib, cineplex, day);
                            } else if (i == 13) {
                                System.out.println("no such funtion...");
                            } else if (i == 21) {
                                Revenue.getDailyTotalRevenue(tiLib, day);
                            } else if (i == 22) {
                                Revenue.getMonthlyTotalRevenue(tiLib, day);
                            }
                            break;
                        case 33:
                            Revenue.getTotalRevenue(tiLib);
                            break;
                        default:
                            System.out.println("invalid...");
                    }

                    break;
                default:
                    System.out.println("Wrong Input.");
                    break;
            }
        }
    }

    public static void addModifyRemove(MovieLib movieLib) {
        int choice;
        while (true) {
            System.out.println("+++++++++++++++++++++++++++");
            System.out.println("|Please Enter your choice:|");
            System.out.println("|1. list movies           |"); // call listMovie in MovieLib class
            System.out.println("|2. Search a movie        |"); // call search in MovieLib class
            System.out.println("|3. Add a movie           |"); // call addMovie in MovieLib class
            System.out.println("|4. Update a movie        |"); // next level: modify >>> call xxx in Movie class
            System.out.println("|5. Remove a movie        |"); // call remove in MovieLib class
            System.out.println("|0.back                   |"); // previous level: staff menu
            System.out.println("+++++++++++++++++++++++++++");
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
                case 2:
                case 4:
                case 5:
                    System.out.println("Please Enter the movie name:");
                    String nameOfMovie = sc.next();
                    ArrayList<Movie> result = movieLib.searchMovie(nameOfMovie);

                    int sel = 0;
                    if (choice != 2) {
                        System.out.print("select: ");
                        sel = sc.nextInt();
                    }
                    if (choice == 4) {
                        MovieLib.modify(result.get(sel), sel);
                    } else if (choice == 5) {
                        movieLib.get().remove(movieLib.get().indexOf(result.get(sel)));
                    }
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

    public static void modify(Movie movie, String nameOfMovie) { // call modify in MovieLib class
        //System.out.println("list movies"); // call listMovie in MovieLib class
        int choice;
        while (true) {
            System.out.println("+++++++++++++++++++++++++++");
            System.out.println("|Modify:                  |");
            System.out.println("|Please Enter your choice:|");
            System.out.println("|1.name                   |");
            System.out.println("|2.type                   |");
            System.out.println("|3.cast                   |");
            System.out.println("|4.director               |");
            System.out.println("|5.language               |");
            System.out.println("|6.runtime                |");
            System.out.println("|7.description            |");
            System.out.println("|8.openingTime            |");
            System.out.println("|9.add showtime           |");
            System.out.println("|10.delete showtime       |");
            System.out.println("|11.rating                |");
            System.out.println("|0.back                   |"); // previous level: staff menu
            System.out.println("+++++++++++++++++++++++++++");
            choice = sc.nextInt();
            if (choice == 0) {
                System.out.println("Back...");
                break;
            }
            if (choice < 0 || choice > 11) {
                System.out.println("Wrong Input.");
                continue;
            }
            if (MovieLib.modify(movie, choice)) {
                System.out.println("Successful modified");
            }
        }
    }
}
