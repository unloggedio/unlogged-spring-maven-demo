
package org.unlogged.demo.jspdemo.wfm.Controllers;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.UserListInfo;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.pojo;
import org.unlogged.demo.jspdemo.wfm.Services.CustomService;
import org.unlogged.demo.jspdemo.wfm.Services.UserService;
import org.unlogged.demo.jspdemo.wfm.UserInstanceService;

import java.time.Instant;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CustomService customService;
    private UserInstanceService userInstanceService = new UserInstanceService();

    
    @RequestMapping("/getUser")
    public User testFetchUser(@RequestParam String username) {return userService.getUser(username);
    }

    //some comment
    @RequestMapping("/saveUser")
    public ResponseEntity saveUser(@RequestParam String username,
                                   @RequestParam String password, @RequestParam String email) {
        //some other comment
        //this doesn't break
        return ResponseEntity.ok(userInstanceService.saveUser(username, password, email));
    }

    @RequestMapping("/fetchById")
    public ResponseEntity saveUser(@RequestParam int id) {
        return ResponseEntity.ok("aaa");
        //sometingii
    }

    //some comment
    @PostMapping("/test")
    public String getTestText() {
//        String e = "e".split(" ")[10];
        String a = "ba";
        if (a.equals("")) {
            int x = 44;
            return customService.getValue();
        } else {
            int ao = 357;
            return "cc";
        }
    }

    @GetMapping("/instant")
    public Instant getInstant() {
//        return userService.throwExceptionTest();
        Instant inst1 = Instant.parse("2021-02-09");
        return inst1;
    }

    @GetMapping("/joda")
    public DateTime jodatest() {
        String rs;
//        return userService.throwExceptionTest();
        DateTime time = new DateTime();
        return time;
    }

    @RequestMapping("/testPojo")
    public Object getTestPojo() {
//        return userService.throwExceptionTest();
        String b = "A";
        pojo res = pojo.builder().name("f").build();
        System.out.println(res.getId());
        System.out.println("long : " + res.getx());
        return res;
    }

    @RequestMapping("/many")
    public String a() {
        int x = 0;
        userService.many("b", "b", "c", "d");
        return "d";
    }

    @RequestMapping("/bool")
    public boolean getBool() {
        String e = "e".split(" ")[10];
        return true;
    }

    void restMethod(User user, User u2) {
        String e = "a".split(" ")[10];
    }

    public String methodA(String a) {
        return a + "13";
    }

    public String methodIntTest(int id) {
        int x = 8;
        return "OBJECTb_" + id;
    }

    public void testEE() {
        System.out.println("E");
    }

    public void addUser(User user) {
        userService.addUser(user);
    }

    public double d(double a, double b) {
        return a + b + 1;
    }

    public Float f(Float a, Float b) {
        Float res = a + b;
        return res;
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public UserListInfo getULI() {
        return userService.getULO();
    }

    public void someMethod(User u, String username, String pass, String id, String email) {
        String a = "a".split(" ")[10];
    }

    public int getInt() {
        int a = 10;
        //some code
        int a1 = 45;
        return userService.getNumber() + 2;
    }

    public String getE(int x) {
        if (x > 5) {
            if (x >= 8) {
                return "GTE8";
            } else {
                return "LT8GT5";
            }
        } else {
            if (x >= 4) {
                return "LTE5GTE3";
            } else {
                return "LT3";
            }
        }
    }

    public String getSomeString() {
        String e = "e";
        if (e.equals("e")) {
            return "n";
        } else {
            return "some";
        }
    }

    public PojoF getPojoF() {
        return new PojoF();
    }

    public User getSomeUser() {
        return userService.getUser("admin");
    }

    public int e() {
        Set<User> modelSet = new HashSet<>();

        List<User> models = new ArrayList<>();
        User u = new User(1, "1", "2", "3");
        User u1 = new User(2, "1", "2", "3");
        User u2 = new User(3, "1", "2", "3");
        models.add(u1);
        models.add(u2);
        modelSet.add(u);
        modelSet.addAll(models);
        return 10;
    }

    public int getint(int x) {
        customService.getValue();
        return x;
    }

    public long getlong(long x) {
        customService.getValue();
        return x;
    }

    public double getdouble(double x) {
        customService.getValue();
        return x;
    }

    public float getfloat(float x) {
        customService.getValue();
        return x;
    }

    public char getChar(char x) {
        customService.getValue();
        return x;
    }

    public boolean getbool(boolean b) {
        return b;
    }

}

class testX {
    int x;

    CustomService service = null;

    public Xe xe = new Xe();

    class Xe {
        int y = 4;

        public int getY() {
            return y;
        }
    }

    public void serviceMethod() {
        String val = service.getValue();
    }

    public int e() {
        int e = xe.getY();
        return e;
    }
}

class PojoF {
    int x = 10;
    float f = 12.0f;
    double d = 24.0;

    String e = "e";

    public boolean getE() {
        return true;
    }

    @Override
    public String toString() {
        return "pojoF{" +
                "x=" + x +
                ", f=" + f +
                ", d=" + d +
                ", e='" + e + '\'' +
                '}';
    }
}

