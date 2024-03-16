package com.github.xavierdpt.jvmspect.charts;

import com.github.xavierdpt.jvmspect.charts.library.NativeChartInfo;
import com.github.xavierdpt.jvmspect.charts.library.OpcodesChartInfo;

import java.util.function.Supplier;

public enum JVMSpectCharts {

    OPCODES(OpcodesChartInfo::new),
    NATIVE_METHODS(NativeChartInfo::new);

    private final Supplier<ChartInfo> supplier;

    JVMSpectCharts(Supplier<ChartInfo> supplier) {
        this.supplier = supplier;
    }

    public ChartInfo getChartInfo() {
        return supplier.get();
    }
}
