package WebApp.WebSite.models;

import WebApp.WebSite.security.AES;
import jakarta.persistence.*;

/*
 * @author h0riz4n m1d1
 */
@Entity
@Table(name = "tgUsers")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String login;
    private byte[] password;
    private long tgid;

    public String getLogin() {
        return login;
    }

    public byte[] getPassword() {
        return password;
    }

    public long getTgid() {
        return tgid;
    }

    public Person(String login, String password, Long id) {
        try {
            this.login = login;
            this.password = AES.encrypt(password);
            this.tgid = id;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Person() { }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public void setTgid(long tgid) {
        this.tgid = tgid;
    }
}
