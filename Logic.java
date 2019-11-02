import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;
 
public class Logic {
 
    public static void main(String[] args)
    {
 
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();       
 
// Using label
 
        Query qry = session.createQuery("from Product p where p.productId= :x");
        qry.setParameter("x",102);
 
        List l =qry.list();
        System.out.println("Total Number Of Records : "+l.size());
        Iterator it = l.iterator();
 
        while(it.hasNext())
        {
        	Product p = (Product) it.next();
            System.out.println("Product Name : "+p.getProName());
            System.out.println("Product Price : "+p.getPrice());
            System.out.println("---------------------------");
 
        }      
 
    
 
/* Using Question Mark  */
 
        Query qry1 = session.createQuery("from Product p where p.productId= ?");
            qry1.setParameter(0,101);
 
            List<?> d =qry.list();
            System.out.println("Total Number Of Records : "+d.size());
            Iterator<?> it1 = d.iterator();
 
            while(it1.hasNext())
            {
            	Product p = (Product) it1.next();
                System.out.println("Product Name : "+p.getProName());
                System.out.println("Product Price : "+p.getPrice());
                System.out.println("---------------------------");
 
            }      
 
        session.close();
        factory.close();
    }
 
}