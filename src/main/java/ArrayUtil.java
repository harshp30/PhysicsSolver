
public class ArrayUtil {
    
    public static int search(double[] array, double searchTerm){
        //linear search aka sequential search
        int foundIndex = -1;
        
        for(int i=0; i<array.length; i++){
            if( array[i] == searchTerm ){
               return i;
            }            
        }       
        return foundIndex;
    }//end search 
    
    
    public static int search(int[] array, int searchTerm){
        //linear search aka sequential search
        int foundIndex = -1;
        
        for(int i=0; i<array.length; i++){
            if( array[i] == searchTerm ){
               return i;
            }            
        }       
        return foundIndex;
    }//end search 
    
    public static int search(String[] array, String searchTerm){
        //linear search aka sequential search
        int foundIndex = -1;
        
        for(int i=0; i<array.length; i++){
            if( array[i].equalsIgnoreCase(searchTerm) ){
               return i;
            }            
        }       
        return foundIndex;
    }//end search 
    
    
    
    public static void printArray( String[] arr ){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println();        
    }//end printArray
    
    public static void printArray( int[] arr ){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println();        
    }//end printArray
    
    public static void printArray( double[] arr){
        for (  double temp :  arr     ){
             System.out.print(temp + ", ");
        }
        System.out.println();
        
    }//end printArray
        
    
    
    
}//end ArrayUtil
