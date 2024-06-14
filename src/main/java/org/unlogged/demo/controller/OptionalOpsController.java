package org.unlogged.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;
import org.unlogged.demo.models.UserOptional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import java.util.stream.Stream;

@RestController
@RequestMapping("/optionalops")
public class OptionalOpsController {

    private User getDefaultUser() {
        return new User(1, "User1", "user", "user@gmail.com");
    }

    private UserOptional getEmptyOptionalUser() {
        return new UserOptional();
    }

    private UserOptional getNonEmptyOptionalUser() {
        return new UserOptional("a", "c", "e");
    }

    @RequestMapping("/create1")
    public Optional<String> create1() {
        return Optional.of("default");
    }

    @RequestMapping("/createNullable")
    public Optional<String> createNullable() {
        return Optional.ofNullable(null);
    }

    @RequestMapping("/getpresent")
    public List<Boolean> getPresentStatus() {
        return List.of(Optional.of("A").isPresent(), Optional.ofNullable(null).isPresent());
    }

    @RequestMapping("/getempty")
    public List<Boolean> getEmptyStatus() {
        return List.of(Optional.of("A").isEmpty(), Optional.ofNullable(null).isEmpty());
    }

    @RequestMapping("/present")
    public AtomicReference<String> ifPresent() {
        AtomicReference<String> stringRef = new AtomicReference<>("Ace");
        Optional<String> opt = Optional.of("Ace");
        opt.ifPresent(payload -> {
            stringRef.set(stringRef.get() + "###");
        });
        return stringRef;
    }

    @RequestMapping("/orelse")
    public Object orElseCase() {
        return Optional.ofNullable(null).orElse("Default");
    }

    @RequestMapping("/orelseget")
    public User orElseGet() {
        User u = null;
        User u2 = Optional.ofNullable(u).orElseGet(this::getDefaultUser);
        return u2;
    }

    @RequestMapping("/throwonnull")
    public Object throwOnNull() {
        return Optional.ofNullable(null).orElseThrow(
                IllegalArgumentException::new);
    }

    @RequestMapping("/getusage")
    public User getUserUsage() {
        Optional<User> userOpt = Optional.of(getDefaultUser());
        return userOpt.get();
    }

    @RequestMapping("/filteruseroptional")
    public List<Boolean> filterUserOptional() {
        Optional<User> user1 = Optional.of(getDefaultUser());
        Optional<User> user2 = Optional.of(new User(2, "user2", "u2", "u2"));
        return List.of(user1.filter(user -> user.getEmail().contains("@")).isPresent(),
                user2.filter(user -> user.getEmail().contains("@")).isPresent());
    }

    @RequestMapping("/mapcount")
    public int countNameLength() {
        return Optional.of(getDefaultUser()).map(user -> user.getUsername().length()).orElse(0);
    }

    @RequestMapping("/flatmap")
    public String flatMapUsage() {
        Optional<UserOptional> optionalUser = Optional.of(getNonEmptyOptionalUser());

        Optional<Optional<String>> usernameOptional = optionalUser.map(UserOptional::getName);
        String name = optionalUser.flatMap(UserOptional::getName).orElse("");
        return name;
    }

    @RequestMapping("/chain")
    public String chain() {
        return Stream.<Supplier<Optional<String>>>of(
                        () -> Optional.empty(),
                        () -> Optional.empty()
                )
                .map(Supplier::get)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseGet(() -> "default");
    }
}
