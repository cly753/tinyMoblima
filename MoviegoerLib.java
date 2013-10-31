class MoviegoerLib {
    private Linkedlist<Moviegoer> goerLib;

    public Moviegoer() {
        goerLib = new Linkedlist<Moviegoer>();
    }


    public boolean add() {
        String username, String password, String name, Sting mobileNumber, String emailAddress, Integer ag

        System.out.println("username: ");
        String newUsername = sc.next();

        System.out.println("password: ");
        String newPassword  = sc.next();

        System.out.println("name: ");
        String newName = sc.nextLine();

        System.out.println("mobile number: ");
        String newMobileNumber = sc.next();

        System.out.println("email address: ");
        String newEmailAddress = sc.next();

        System.out.println("age: ");
        Integer newAge =sc.nextInt();

        Moviegoer newGoer = new Moviegoer(
                                    newUsername, 
                                    newPassword, 
                                    newName, 
                                    newMobileNumber,
                                    newEmailAddress,
                                    newAge);
        
        goerLib.add(newGoer);
        return true;
    }

    public boolean delete(Moviegoer goer) {
        System.out.println("password: ");
        String tempPassword  = sc.next();

        if (goer.getPassword().compareTo(tempPassword)) {
            int i = goerLib.indexOf(toDelete)
            if (goerLib.indexOf(toDelete) != -1) {
                goerLib.remove(i);
                return true;
            }
        }

        return false;
    }

    public static boolean modify(Moviegoer goer, int choice) {
        
        switch (choice) {
            case 1:
                System.out.print("New name: ");
                goer.setName(sc.nextLine());
                break;
            case 2:
                System.out.print("New mobile number: ");
                goer.setMobileNumber(sc.next());
                break;
            case 3:
                System.out.print("New email address: ");
                goer.setEmailAddress(sc.next());
                break;
            case 4:
                System.out.print("New age: ");
                goer.setAge(sc.nextInt());
                break;
            default:
                System.out.println("invalid. again: ");
                return false;
        }
        return true;
    }

    public Moviegoer checkLogin(String nameTry, String pwdTry) {
        Integer goerSize = goerLib.size();
        ListIterator<Integer> iter = goerLib.listIterator(0);
        Moviegoer temp = NULL;
        while (iter.hasNext()) {
            temp = iter.next();
            if (temp.username.compareTo(nameTry))
                if (temp.password.compareTo(pwdTry))
                    return temp;
                else
                    return NULL;
        }
        return NULL;
    }

    public static boolean pay(Moviegoer goer, int index) {
        Time tempTime = new Time();

        System.out.println("1.Visa 2.Master? ");
        int card = sc.nextInt();

        tempTime.storeCurrentTime();
        goer.getUnpaid().get(index).setBuyTime(tempTime);

        System.out.println("paid!");
        return true;
    }

    public static void showHistory(Moviegoer goer, boolean onlyUnpaid) {
        int unpaidSize = goer.getUnpaid().size();
        int paidSize = goer.getPaid().size();
        Ticket ti;
        int pageSize = 5;

        int track = 0;

        for (int i = 0; i < unpaidSize; i++) {
            ti = goer.getUnpaid().get(i);

            Ticket.display(ti);
            System.out.print(i + "Not paid");
        }
        
        if (onlyUnpaid)
            return ;

        for (int i = 0; i < paidSize; i++)
            ti = goer.getPaid().get(i);

            Ticket.display(ti);
            System.out.print("paid");

            if (--pageSize == 0 && i < historySize - 1) {
                System.out.print("Continue? 1/0");
                if (sc.nextInt() == 0)
                    break;
                paidSize = 5;
            }
        }
    }
}