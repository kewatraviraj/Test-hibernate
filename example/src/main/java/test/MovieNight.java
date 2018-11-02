package test;/**
 * 
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
public class MovieNight {
    public static Boolean canViewAll(Collection<Movie> movies) {
        Movie movie = new Movie(new Date(), new Date());
      //  reoturn (m).getStart().equals((m).getEnd());
        /*for (Iterator<Movie> iterator1 = movies.iterator(); iterator1.hasNext();){
            Movie movie1 = (Movie) iterator1.next(); 
            
            List<Movie> moviesstart = (List<Movie>) movie1.getStart();    
            List<Movie> moviesend = (List<Movie>) movie1.getEnd();    
	    
	       for(Iterator<Movie> iterator2 = moviesstart.iterator(); iterator2.hasNext();)  
	       {  
	    	   if(iterator2.next() == ){
                   break;
               }
               if(movies.getEnd() < movies.getStart()){
                   return true;
               }else{
                    return false;
               }
	        }    */
		return null;
            
          /*  for(int index1=0; index1 < movies.toArray().length;index1++){
               
            	if(movies.toArray()[index] == movies.toArray()[index1]){
                    break;
                }
                if(movies.getEnd() < movies.getStart()){
                    return true;
                }else{
                     return false;
                }*/
        }
        /*for(int index=0; index<movies.toArray().length;index++){
            
            for(int index1=0; index1<movies.toArray().length;index1++){
                if(movies.toArray()[index] == movies.toArray()[index1]){
                    break;
                }
                if(movies.getEnd() < movies.getStart()){
                    return true;
                }else{
                     return false;
                }
            }
    }
        }*/

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 21:30"), sdf.parse("2015-01-01 23:00")));
        System.out.println(MovieNight.canViewAll(movies));
    }
}

class Movie {
    private Date start, end;
    
    public Movie(Date start, Date end) {
        this.start = start;
        this.end = end;
    }
    
    public Date getStart() {
        return this.start;
    }
    
    public Date getEnd() {
        return this.end;
    } 
}