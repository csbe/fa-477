package ch.csbe.ifa.partei;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ch.csbe.ifa.partei.model.Ort;
import ch.csbe.ifa.partei.model.Person;
import javassist.tools.reflect.Reflection;

/**
 * Hello world!
 *
 */
public class App 
{
	static Logger log = Logger.getLogger("ifa");
	
    public static void main( String[] args ) throws IOException
    {    	
    	log.info("Application starts");
    	
    	Properties properties = new Properties();
    	properties.load(App.class.getResourceAsStream("/hibernate.properties"));
    	
    	Configuration cfg = new Configuration()
    		    .addAnnotatedClass(ch.csbe.ifa.partei.model.Ort.class)
    		    .addAnnotatedClass(ch.csbe.ifa.partei.model.Person.class)
    		    .setProperty("hibernate.dialect", properties.getProperty("dialect"))
    		    .setProperty("hibernate.connection.url", properties.getProperty("url"))
    		    .setProperty("hibernate.connection.username", properties.getProperty("user"))
    		    .setProperty("hibernate.connection.password", properties.getProperty("password"))
    		    .setProperty("hibernate.hbm2ddl.auto", properties.getProperty("strategy")) //validate, create, create-drop, update
    		    .setProperty("hibernate.order_updates", "true");
    	
    	
    	SessionFactory sessions;
    	Session session;
    	sessions = cfg.buildSessionFactory();
    	session = sessions.openSession(); // open a new Session
    	
    	try{
	    	Ort o = new Ort("2552", "Orpund");
	    	session.save(o);
	    	
	    	Person person = new Person("Muster","Max", o);
	    	//person.setOrt(null);
	    	session.save(person);
	    	
	    	
	    	Ort ort = new Ort();
    		ort = session.get(ort.getClass(),1);
	    	session.delete(ort);
	    	
	    	
	    	/*Ort ort = new Ort();
    		ort = session.get(ort.getClass(),1);
    		
    		System.out.println(ort.getPlz() + " " + ort.getOrt());*/
	    	Person p = new Person();
	    	p = session.get(p.getClass(), 1);
	    	
	    	System.out.println(p.getOrt().getOrt());	    	
        	
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}finally{ 	
    		session.disconnect();
        	session.close();   
        	sessions.close();
    	}
    	
    	
    	log.info("Application ends");
    }
}
