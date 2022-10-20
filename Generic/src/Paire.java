
public class Paire<T>  {

    T premier ;

    T second;

    public Paire (T a, T b){

        premier= a; 
        second = b;

    }

    public T getPremier(){

        return premier;

    }

    public T getSecond(){

        return second;

    }

}
