package org.unlogged.demo.controller;

import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOpsController {

    Stream.Builder<User> userBuilder = Stream.builder();

    private Stream.Builder<User> getbuilderWithDefaultValues() {
        userBuilder = Stream.builder();
        userBuilder.accept(new User(11, "UserA", "a", "userA@gmail.com"));
        userBuilder.accept(new User(23, "UserB", "b", "userB@gmail.com"));
        userBuilder.accept(new User(14, "UserC", "c", "userC@gmail.com"));
        userBuilder.accept(new User(59, "UserD", "d", "userD@gmail.com"));
        userBuilder.accept(new User(64, "UserE", "e", "userE@gmail.com"));
        userBuilder.accept(new User(80, "UserF", "f", "userF@gmail.com"));
        userBuilder.accept(new User(24, "UserG", "g", "userG@gmail.com"));
        return userBuilder;
    }

    private List<List<User>> getUserGroups() {
        return List.of(
                List.of(
                        new User(1, "User1", "User1pass", "User1@gmail.com"),
                        new User(2, "User2", "User2pass", "User2@gmail.com"),
                        new User(3, "User3", "User3pass", "User3@gmail.com")
                ),
                List.of(
                        new User(401, "CLP", "C401", "CLP401@gmail.com"),
                        new User(402, "TRP", "T402", "TRP402@gmail.com"),
                        new User(403, "DED", "D403", "DED403@gmail.com")
                ),
                List.of(
                        new User(9901, "lck", "S???", "SL?@gmail.com"),
                        new User(9902, "msc", "S117", "S117@gmail.com"),
                        new User(9903, "arb", "YK04", "SHA@gmail.com")
                )
        );
    }

    public List<User> getUserList() {
        return getbuilderWithDefaultValues().build().toList();
    }

    public List<User> forEachRun() {
        List<User> users = getUserList();
        users.forEach(User::addHashToName);
        users.forEach(user -> {
            if (user.getUser_id() % 2 == 0) {
                user.updateDetails("+@");
            } else {
                user.updateDetails("-@");
            }
        });
        return users;
    }

    public List<User> forEachRunParallel() {
        List<User> users = getUserList();
        users.parallelStream().forEach(User::addHashToName);
        users.parallelStream().forEach(user -> {
            if (user.getUser_id() % 2 == 0) {
                user.updateDetails("+@");
            } else {
                user.updateDetails("-@");
            }
        });
        return users;
    }

    public List<Long> mapAndCollect() {
        List<User> users = getUserList();
        return users.stream().map(User::getUser_id).collect(Collectors.toList());
    }

    public Set<Long> mapSet() {
        return getUserList().stream().map(User::getUser_id).collect(Collectors.toSet());
    }

    public Vector<Long> mapVector() {
        return getUserList().stream().map(User::getUser_id)
                .collect(Collectors.toCollection(Vector::new));
    }

    public List<Long> mapAndFilter() {
        return getUserList().stream()
                .map(User::getUser_id)
                .filter(userId -> userId % 2 != 0)
                .toList();
    }

    public Optional<User> filterAndFindFirst() {
        return getUserList().stream()
                .filter(user -> user.getUser_id() % 2 == 0)
                .findFirst();
    }

    public Object[] toArrayCollection_Usernames() {
        return getUserList().stream().map(User::getUsername).toArray();
    }

    public Optional<User> flatmap_maxId() {
        return getUserGroups().stream().
                flatMap(List::stream)
                .max(Comparator.comparingInt(user -> (int) user.getUser_id()))
                .stream().findFirst();
    }

    public Optional<User> flatmap_minId() {
        return getUserGroups().stream().
                flatMap(List::stream)
                .min(Comparator.comparingInt(user -> (int) user.getUser_id()))
                .stream().findFirst();
    }

    public List<List<User>> peek_all() {
        List<List<User>> userGroups = getUserGroups();
        userGroups.forEach(group -> {
            group = group.stream()
                    .peek(User::addHashToName)
                    .peek(user -> user.updateDetails("+@"))
                    .peek(user -> user.setPassword(user.getPassword().toLowerCase()))
                    .peek(user -> user.setEmail(user.getPassword().toLowerCase()))
                    .toList();
        });
        return userGroups;
    }

    public long countUsersInGroups() {
        return getUserGroups().stream().flatMap(List::stream).count();
    }

    public List<User> limitUsers(int limit) {
        return getUserGroups().stream().flatMap(List::stream).limit(limit).toList();
    }

    public List<Integer> distinctUsage() {
        List<Integer> listOfIntegers = List.of(2, 5, 3, 2, 4, 3);
        return listOfIntegers.stream().distinct().collect(Collectors.toList());
    }

    public Map<String, Boolean> matchCases() {
        Map<String, Boolean> resMap = new TreeMap<>();
        resMap.put("all-true", getUserGroups().get(0).stream().allMatch(user -> user.getUsername().contains("User")));
        resMap.put("any-true", getUserGroups().get(1).stream().anyMatch(user -> user.getUsername().contains("CLP")));
        resMap.put("none-true", getUserGroups().get(2).stream().noneMatch(user -> user.getUsername().contains("CLP")));

        resMap.put("all-false", getUserGroups().get(0).stream().allMatch(user -> user.getUsername().contains("CLP")));
        resMap.put("any-false", getUserGroups().get(1).stream().anyMatch(user -> user.getUsername().contains("User")));
        resMap.put("none-false", getUserGroups().get(2).stream().noneMatch(user -> user.getEmail().contains("@")));

        return resMap;
    }

    public Long reduceUsage() {
        return getUserGroups().stream().flatMap(List::stream)
                .map(User::getUser_id)
                .reduce(0L, Long::sum);
    }

    public String getSortedIdOrder() {
        return getUserList().stream()
                .sorted((user1, user2) -> {
                    return (int) (user1.getUser_id() - user2.getUser_id());
                })
                .map(user -> "" + user.getUser_id())
                .collect(Collectors.joining(" < "));
    }

    public Map<Boolean, List<User>> partitionBy() {
        return getUserList().stream()
                .collect(Collectors.partitioningBy(user -> user.getUser_id() % 2 == 0));
    }

    public Map<Character, List<User>> groupBy() {
        return getUserGroups().stream().flatMap(List::stream)
                .collect(Collectors.groupingBy(user -> new Character(user.getUsername().toLowerCase().charAt(0))));
    }
}
