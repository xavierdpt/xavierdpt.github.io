package com.github.xavierdpt.xddbg;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.code.Instruction;

import java.util.List;

public class InstructionsWithResolver {
    private final List<Instruction> instructions;
    private final ConstantResolver constantResolver;

    public InstructionsWithResolver(List<Instruction> instructions, ConstantResolver constantResolver) {
        this.instructions = instructions;
        this.constantResolver = constantResolver;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public ConstantResolver getConstantResolver() {
        return constantResolver;
    }
}
