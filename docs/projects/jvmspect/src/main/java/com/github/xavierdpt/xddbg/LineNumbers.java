package com.github.xavierdpt.xddbg;

import com.sun.jdi.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LineNumbers {

    Map<Long, Integer> codeIndexLineNumber = new HashMap<>();
    Map<Integer, Set<Long>> lineNumberCodeIndex = new HashMap<>();

    public static LineNumbers of(List<Location> locations) {
        LineNumbers lineNumbers = new LineNumbers();
        for (Location location : locations) {
            long codeIndex = location.codeIndex();
            int lineNumber = location.lineNumber();
            lineNumbers.add(codeIndex, lineNumber);
        }
        return lineNumbers;

    }

    private void add(long codeIndex, int lineNumber) {
        codeIndexLineNumber.put(codeIndex, lineNumber);
        lineNumberCodeIndex.computeIfAbsent(lineNumber, integer -> new TreeSet<>()).add(codeIndex);
    }

    public Integer getLineNumber(int codeIndex) {
        return codeIndexLineNumber.get(codeIndex);
    }
}
