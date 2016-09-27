
/**
 * Contact object is immutable, storing the information of an entry in a list of contacts 
 * 
 * @author Lucas Sanders
 * @version 04/11/2015
 */
public class Contact
{
    private String name, relation, bday, phone, email;

    /**
     * Constructor for contact class
     */
    public Contact(String n, String r, String b, String p, String e)
    {
        name = n;
        relation = r;
        bday = b;
        phone = p;
        email = e;
    }
    
    public String getName()
    {
        return name;
    }
    public String getRelation()
    {
        return relation;
    }
    public String getBDay()
    {
        return bday;
    }
    public String getPhone()
    {
        return phone;
    }
    public String getEmail()
    {
        return email;
    }

    public String toString()
    {
        return String.format("%-16s%-12s%-12s%-18s%-18s", name, relation, bday, phone, email);
    }
}
