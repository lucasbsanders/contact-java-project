
/**
 * Creates a list of contacts, and uses methods to search for contacts
 * 
 * @author Lucas Sanders
 * @version 04/11/2015
 */
public class TestContacts
{
    public static void main(String[] args)
    {
        Contact[] myContacts = new Contact[6];
        
        myContacts[0] = new Contact("John Carter","brother","Mar 3","(342) 555‐7069","jcarter@carter.com");
        myContacts[1] = new Contact("Elise Carter","mom","Apr 19","(342) 555‐7011","carterMom@carter.com");
        myContacts[2] = new Contact("Ellie Carter","me","Jun 10","(342) 555‐8102","ecarter@carter.com");
        myContacts[3] = new Contact("Sue Ellen","friend","Mar 9","(341) 555‐9182","susieE@hotmail.com");
        myContacts[4] = new Contact("Frank Carter","dad","Dec 1","(342) 555‐7011","carterDad@carter.com");
        myContacts[5] = new Contact("Johnnie","friend","Jan 21","(341) 555‐7789","jDawg5555@yahoo.com");
        
        printContacts(myContacts);
        System.out.println();
        System.out.println();
        
        findByName(myContacts, "Johnnie");
        System.out.println();
        findByName(myContacts, "Sam Parker");
        System.out.println();
        findByRelation(myContacts, "friend");
        System.out.println();
        findByRelation(myContacts, "Aunt");
        System.out.println();
        findByPhone(myContacts, "(333) 555-8989");
        System.out.println();
        findByPhone(myContacts, "(342) 555‐7011");
        System.out.println();
        findByBMonth(myContacts, "May");
        System.out.println();
        findByBMonth(myContacts, "Mar");
        System.out.println();
        findByEmail(myContacts, "rgoodman@hotmail.com");
        System.out.println();
        findByEmail(myContacts, "susieE@hotmail.com");
    }
    
    /**
     * Prints the array of Contacts
     */
    public static void printContacts(Contact[] contacts)
    {
        System.out.println("Contact List:");
        System.out.println();
        System.out.println("Name            Relation    Birthday    Phone             Email");
        System.out.println("-------------------------------------------------------------------------------");
        
        for(Contact c : contacts)
            System.out.println(c);
    }
    
    /**
     * Sorts the array of Contacts by name
     */
    public static void sortName(Contact[] contacts)
    {
        int i;
        int k;
        Contact temporary;
        int indexMax;
        
        for(k = contacts.length - 1; k >=0; k--)
        {
            indexMax = 0;
            for(i = 0; i <= k; i++)
            {
                if(contacts[indexMax].getName().compareTo(contacts[i].getName()) < 0)
                {
                    indexMax = i;
                }
            }
            temporary = contacts[k];
            contacts[k] = contacts[indexMax];
            contacts[indexMax] = temporary;
        }
    }
    /**
     * Uses a binary method to locate a Contact with a particular name in the Contact array
     */
    public static void findByName(Contact[] contacts, String target)
    {
        sortName(contacts);
        System.out.println("Find Name - " + target);
        
        int low = -1;
        int high = contacts.length;
        int probe;

        while(high - low > 1)
        {
            probe = (high + low) / 2;
            if(target.compareTo(contacts[probe].getName()) < 0)
                high = probe;
            else
                low = probe;
        }
        
        if(low >= 0 && contacts[low].getName().equals(target))
            System.out.println("Found: " + contacts[low]);
        else
            System.out.println("Not found.");
    }
    
    /**
     * Uses sequential sorting to find all Contacts of a certain relation in the array of Contacts
     */
    public static void findByRelation(Contact[] contacts, String target)
    {
        System.out.println("Find Relation - " + target);
        System.out.println("Find results:");
        
        int numberFound = 0;
        
        for(int i = 0; i < contacts.length; i++)
        {
            if(contacts[i].getRelation().equals(target))
            {
                System.out.println(contacts[i]);
                numberFound++;
            }
        }
        
        if(numberFound > 0)
        {
            System.out.println("There were " + numberFound + " listings for " + target);
        }
        else
        {
            System.out.println("There are no listings for " + target);
        }
    }
    
    /**
     * Uses sequential sorting to find all Contacts with a certain phone number in the array of Contacts
     */
    public static void findByPhone(Contact[] contacts, String target)
    {
        System.out.println("Find Phone - " + target);
        System.out.println("Find results:");
        
        int numberFound = 0;
        
        for(int i = 0; i < contacts.length; i++)
        {
            if(contacts[i].getPhone().equals(target))
            {
                System.out.println(contacts[i]);
                numberFound++;
            }
        }
        
        if(numberFound > 0)
        {
            System.out.println("There were " + numberFound + " listings for " + target);
        }
        else
        {
            System.out.println("There are no listings for " + target);
        }
    }
    
    /**
     * Uses sequential sorting to find all Contacts  born in a certain month in the array of Contacts
     */
    public static void findByBMonth(Contact[] contacts, String target)
    {
        target = target.substring(0,3);
        System.out.println("Find Bday - " + target);
        System.out.println("Find results:");
        
        int numberFound = 0;
        
        for(int i = 0; i < contacts.length; i++)
        {
            if(contacts[i].getBDay().substring(0,3).equals(target))
            {
                System.out.println(contacts[i]);
                numberFound++;
            }
        }
        
        if(numberFound > 0)
        {
            System.out.println("There were " + numberFound + " listings for " + target);
        }
        else
        {
            System.out.println("There are no listings for " + target);
        }
    }
    
    /**
     * Sorts the array of Contacts by email
     */
    public static void sortEmail(Contact[] contacts)
    {
        int i;
        int k;
        Contact temporary;
        int indexMax;
        
        for(k = contacts.length - 1; k >=0; k--)
        {
            indexMax = 0;
            for(i = 0; i <= k; i++)
            {
                if(contacts[indexMax].getEmail().compareTo(contacts[i].getEmail()) < 0)
                {
                    indexMax = i;
                }
            }
            temporary = contacts[k];
            contacts[k] = contacts[indexMax];
            contacts[indexMax] = temporary;
        }
    }
    /**
     * Uses a binary method to locate a Contact with a particular email address in the Contact array
     */
    public static void findByEmail(Contact[] contacts, String target)
    {
        sortEmail(contacts);
        System.out.println("Find Email - " + target);
        
        int low = -1;
        int high = contacts.length;
        int probe;

        while(high - low > 1)
        {
            probe = (high + low) / 2;
            if(target.compareTo(contacts[probe].getEmail()) < 0)
                high = probe;
            else
                low = probe;
        }
        
        if(low >= 0 && contacts[low].getEmail().equals(target))
            System.out.println("Found: " + contacts[low]);
        else
            System.out.println("Not found.");
    }
}
