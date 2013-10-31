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

    public boolean delete(Moviegoer toDelete) {
        System.out.println("password: ");
        String tempPassword  = sc.next();

        if (toDelete.getPassword().compareTo(tempPassword)) {
            int i = goerLib.indexOf(toDelete)
            if (goerLib.indexOf(toDelete) != -1) {
                goerLib.remove(i);
                return true;
            }
        }

        return false;
    }

    public static boolean modify(Moviegoer toModify, int choice) {
        
        switch (choice) {
            case 1:
                System.out.print("New name: ");
                toModify.setName(sc.nextLine());
                break;
            case 2:
                System.out.print("New mobile number: ");
                toModify.setMobileNumber(sc.next());
                break;
            case 3:
                System.out.print("New email address: ");
                toModify.setEmailAddress(sc.next());
                break;
            case 4:
                System.out.print("New age: ");
                toModify.setAge(sc.nextInt());
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


}