package com.sven.Xindongfang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Algorithm3 {

    public static void main(String[] args) {
        List<School> schools = new ArrayList<>();
        List<Lesson> lessons = new ArrayList<>();

        List<String> schoolNames = statistics(schools, lessons);
        schoolNames.forEach(System.out::println);
    }

    public static List<String> statistics(List<School> schools, List<Lesson> lessons) {
        Map<Integer, String> schoolMap = schools.parallelStream().collect(Collectors.toMap(School::getSchoolId, School::getSchoolName));
        return lessons.parallelStream().collect(Collectors.groupingBy(Lesson::getShoolId))
                .entrySet().parallelStream().map(e -> new Lesson(e.getKey(), e.getValue().stream().mapToInt(Lesson::getStudentCount).sum()))
                .filter(e -> e.getStudentCount() > 1000).sorted((a, b) -> b.getStudentCount() - a.getStudentCount())
                .map(e -> schoolMap.get(e.getShoolId())).collect(Collectors.toList());
    }
}

class School {
    private int schoolId;
    private String schoolName;

    public int getSchoolId() { return schoolId; }
    public String getSchoolName() { return schoolName; }
};

class Lesson {
    private int schoolId;
    private int studentCount;

    public Lesson(int schoolId, int studentCount) {
        this.schoolId = schoolId;
        this.studentCount = studentCount;
    }

    public int getShoolId() { return schoolId; }
    public int getStudentCount() { return studentCount; }
}
