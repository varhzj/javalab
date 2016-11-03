package com.varhzj.lab.concurrency.examples;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by varhzj on 11/3/16.
 * Delegating thread safety to a ConcurrentHashMap
 */
public class DelegatingVehicleTracker {

    private final ConcurrentMap<String, ImmutablePoint> locations;
    private final Map<String, ImmutablePoint> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, ImmutablePoint> points) {
        locations = new ConcurrentHashMap<>(points);
        // unmodifiableMap 是locations的一个不可更改的视图
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, ImmutablePoint> getLocations() {
        // 保证不被改变
        return unmodifiableMap;
    }

    // Alternate version of getLocations
    public Map<String, ImmutablePoint> getLocationsAsStatic() {
        return Collections.unmodifiableMap(new HashMap<>(locations));
    }

    public ImmutablePoint getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (locations.replace(id, new ImmutablePoint(x, y)) == null) {
            throw new IllegalArgumentException("No such ID: " + id);
        }
    }

    public static void main(String[] args) {
        Map<String, ImmutablePoint> points = new HashMap<>();
        points.put("110", new ImmutablePoint(1, 2));
        points.put("119", new ImmutablePoint(2, 3));
        points.put("120", new ImmutablePoint(3, 4));
        DelegatingVehicleTracker tracker = new DelegatingVehicleTracker(points);

        Map<String, ImmutablePoint> locationsStatic = tracker.getLocationsAsStatic();
        Map<String, ImmutablePoint> locations = tracker.getLocations();
        // 将不会改变locationsStatic中的值
        tracker.setLocation("110", 4, 5);
        System.out.println("Print locationsStatic after modified locations by tracker:");
        for (Map.Entry<String, ImmutablePoint> entry : locationsStatic.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // 效率低的遍历Map方式
        System.out.println("Print locations after modified locations by tracker:");
        for (String id : locations.keySet()) {
            System.out.println(id + ": " + locations.get(id));
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                tracker.setLocation("119", 10, 10);
            }
        }).start();
        // 效率高的遍历Map方式
        for (Map.Entry<String, ImmutablePoint> entry : locations.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

}
