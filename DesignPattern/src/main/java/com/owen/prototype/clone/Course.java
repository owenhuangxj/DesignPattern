package com.owen.prototype.clone;
/**
 * @Author：Owen
 * @Package：com.owen.prototype.clone
 * @Project：PatternDesign
 * @name：Course
 * @Date：2022/12/4 16:52
 * @Filename：Course
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author OwenHuang
 * @since 2022/12/4 16:52
 */
public class Course {
    List<Teacher> teachers = new ArrayList<>();

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
