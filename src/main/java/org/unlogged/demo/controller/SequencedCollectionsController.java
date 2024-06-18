package org.unlogged.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class SequencedCollectionsController {

    @RequestMapping("/sequence-list")
    public SequencedCollection<String> seqSerialization() {
        SequencedCollection<String> sequencedCollection = new ArrayList<>();
        sequencedCollection.addFirst("ab");
        sequencedCollection.add("c");
        sequencedCollection.add("d");
        sequencedCollection.addLast("e");
        System.out.println(sequencedCollection.getLast());
        System.out.println(sequencedCollection.getFirst());
        sequencedCollection.removeFirst();
        sequencedCollection.removeLast();
        return sequencedCollection.reversed();
    }

    @RequestMapping("/sequence-set")
    public SequencedSet<String> seqSetSerialization() {
        SequencedSet<String> sequencedSet = new LinkedHashSet<>();
        sequencedSet.addFirst("ab");
        sequencedSet.add("c");
        sequencedSet.add("d");
        sequencedSet.addLast("e");
        System.out.println(sequencedSet.getLast());
        System.out.println(sequencedSet.getFirst());
        sequencedSet.removeFirst();
        sequencedSet.removeLast();
        return sequencedSet.reversed();
    }

    @RequestMapping("/sequence-map")
    public SequencedMap<Integer, String> seqMapSerialization() {
        SequencedMap<Integer, String> sequencedMap = new LinkedHashMap<>();
        sequencedMap.put(2, "b");
        sequencedMap.put(3, "c");
        sequencedMap.putFirst(1, "a");
        sequencedMap.putLast(4, "d");
        System.out.println("Last Entry: " + sequencedMap.lastEntry().getKey() + ":" + sequencedMap.lastEntry().getValue());
        System.out.println("First Entry: " + sequencedMap.firstEntry().getKey() + ":" + sequencedMap.firstEntry().getValue());
        sequencedMap.pollLastEntry();
        sequencedMap.pollFirstEntry();
        return sequencedMap.reversed();
    }

    @RequestMapping("/sequence-map/keyset")
    public SequencedSet<Integer> seqKeySetFromMap() {
        SequencedMap<Integer, String> sequencedMap = new LinkedHashMap<>();
        sequencedMap.put(2, "b");
        sequencedMap.put(3, "c");
        return sequencedMap.reversed().sequencedKeySet();
    }

    @RequestMapping("/sequence-map/valueset")
    public SequencedCollection<String> seqValueSetFromMap() {
        SequencedMap<Integer, String> sequencedMap = new LinkedHashMap<>();
        sequencedMap.put(2, "b");
        sequencedMap.put(3, "c");
        return sequencedMap.reversed().sequencedValues();
    }

    @RequestMapping("/sequence-map/entryset")
    public SequencedSet<Map.Entry<Integer, String>> seqEntrySetFromMap() {
        SequencedMap<Integer, String> sequencedMap = new LinkedHashMap<>();
        sequencedMap.put(2, "b");
        sequencedMap.put(3, "c");
        return sequencedMap.reversed().sequencedEntrySet();
    }

    // Should throw UnsupportedOperationException
    @RequestMapping("/sequence-map/unmod")
    public SequencedMap<Integer, String> seqMapUnModifiable() {
        SequencedMap<Integer, String> sequencedMap = new LinkedHashMap<>();
        sequencedMap.put(2, "b");
        sequencedMap.put(3, "c");
        SequencedMap<Integer, String> unmodSequencedMap = Collections.unmodifiableSequencedMap(sequencedMap);
        unmodSequencedMap.putFirst(1, "a"); // This line should throw UnsupportedOperationException
        return unmodSequencedMap;
    }

    @RequestMapping("/sequence-list/unmod")
    public SequencedCollection<String> seqListUnmodifiable() {
        SequencedCollection<String> sequencedCollection = new ArrayList<>();
        sequencedCollection.addFirst("ab");
        sequencedCollection.add("c");
        sequencedCollection.add("d");
        sequencedCollection.addLast("e");
        SequencedCollection<String> unmodSequencedCollection = Collections.unmodifiableSequencedCollection(sequencedCollection);
        unmodSequencedCollection.addFirst("xyz"); // This line should throw UnsupportedOperationException
        return unmodSequencedCollection;
    }

    @RequestMapping("/sequence-set/unmod")
    public SequencedSet<String> seqSetUnmodifiable() {
        SequencedSet<String> sequencedSet = new LinkedHashSet<>();
        sequencedSet.addFirst("ab");
        sequencedSet.add("c");
        sequencedSet.add("d");
        sequencedSet.addLast("e");
        SequencedSet<String> unmodSeqSet = Collections.unmodifiableSequencedSet(sequencedSet);
        unmodSeqSet.addFirst("xyz"); // This line should throw UnsupportedOperationException
        return unmodSeqSet;
    }
}
