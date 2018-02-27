public class Main {
    public static void main(String [] args) {
        ContactManager myContactManager = new ContactManager();

        Contact contact1 = new Contact();
        contact1.name = "Poofybuttons";
        contact1.phoneNumber = "4445556767";

        Contact contact2 = new Contact();
        contact2.name = "Butterbutt";
        contact2.phoneNumber = "9119119111";

        Contact contact3 = new Contact();
        contact3.name = "Billgourneous";
        contact3.phoneNumber = "3033300300";

        Contact contact4 = new Contact();
        contact4.name = "Flufferbottom";
        contact4.phoneNumber = "8885558858";

        Contact contact5 = new Contact();
        contact5.name = "Plopsalot";
        contact5.phoneNumber = "8108108108";

        myContactManager.addContact(contact1);
        myContactManager.addContact(contact2);
        myContactManager.addContact(contact3);
        myContactManager.addContact(contact4);
        myContactManager.addContact(contact5);

        Contact foundContact = myContactManager.searchContact("Plopsalot");
        System.out.println(foundContact.phoneNumber);
    }
}
