//
// a rough menu
// only menu
// and
// suggested action after select
//


class Menu {

    public static void welcome() {
        System.out.println("Welcome to xxx");
    }

    public static void overall() {
        System.out.println("for customers");
        System.out.println("1.Search movies"); // call search
        System.out.println("2.List all movies"); // call listAllMovie
        System.out.println("3.Book movie"); // select and call search/listAllMovie
        System.out.println("4.Check status/history"); // call checkkLogin
        System.out.println("5.Pay"); // call checkLogin

        System.out.println("9.Staff Login"); // call checkLoginStaff
    }

    public static void staffMenu() {
        System.out.println("1.Add/Modify a movie"); // call listAllMovie and listPastMovie
        System.out.println("3.Set holidays"); // call setHoliday in Time class
        System.out.println(".Generate revenue report"); // call generateRevenueReport in Revenue class
    }

    public static void addModifyMovie() {
        System.out.println("1.Add a movie"); // call addMovie
        System.out.println("2.Change ticket price"); // call setPrice in Movie class
        System.out.println("3.Update a movie"); // call xxx in Movie class
        System.out.println("4.Remove a movie"); // call xxx in Movie class
    }
}