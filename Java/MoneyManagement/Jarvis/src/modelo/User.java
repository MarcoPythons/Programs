/*
 * Esto es un proyecto que da vida a un sueño de un simple programador principiante
 * que intenta hacer algo que lo haga sentirse util en esta vida.
 */
package modelo;

/**
 *
 * @author Maily
 */
public class User {
    
    
    private String name;
    private String password;
    private int code;

    public User() {
    }
    
    public User(int code, String name,String password) {
        this.code = code;
        this.name = name;
        this.password = password;
        
    }
    public User(String name, String password){
        this.name= name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getPassword(){
        
        return password;
    }
    public void setPassword( String password){
        this.password = password;
    }
    public int getCode(){
        return code;
    }
    public void setCode(int code){
        
        this.code = code;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", password=" + password + ", code=" + code + '}';
    }
    
}
