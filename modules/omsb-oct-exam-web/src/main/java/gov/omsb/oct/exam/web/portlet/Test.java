package gov.omsb.oct.exam.web.portlet;

import java.text.ParseException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;


 class Country {
	 
	 String name;
	 long population;
	 
	 public Country(String name, long population) {
	  super();
	  this.name = name;
	  this.population = population;
	 }
	 public String getName() {
	  return name;
	 }
	 public void setName(String name) {
	  this.name = name;
	 }
	 public long getPopulation() {
	  return population;
	 }
	 public void setPopulation(long population) {
	  this.population = population;
	 }
	@Override
	public int hashCode() {
	 final int prime = 31;
	 int result = 1;
	 result = prime * result + ((name == null) ? 0 : name.hashCode());
	 return result;
	}
	@Override
	 public boolean equals(Object obj) {
	 
	  Country other = (Country) obj;
	   if (name.equalsIgnoreCase((other.name)))
	   return true;
	  return false;
	 }
	 
	}
public class Test {

	public static void main(String[] args) throws ParseException {
		 Country india=new Country("India",1000);
	        Country japan=new Country("Japan",10000);
	 
	        Country france=new Country("France",2000);
	        Country russia=new Country("Russia",20000);
	 
	        ConcurrentHashMap<Country,String> countryCapitalMap=new ConcurrentHashMap<Country,String>();
	        countryCapitalMap.put(india,"Delhi");
	        countryCapitalMap.put(japan,"Tokyo");
	        countryCapitalMap.put(france,"Paris");
	        countryCapitalMap.put(russia,"Moscow");
	 
	        Iterator countryCapitalIter=countryCapitalMap.keySet().iterator();//put debug point at this line
	        while(countryCapitalIter.hasNext())
	        {
	            Country countryObj=(Country) countryCapitalIter.next();
	            String capital=countryCapitalMap.get(countryObj);
	            System.out.println(countryObj.getName()+"----"+capital);
	            }
	        }
	 

}
