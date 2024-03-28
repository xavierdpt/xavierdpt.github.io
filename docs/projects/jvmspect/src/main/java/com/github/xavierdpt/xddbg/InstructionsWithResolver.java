package com.github.xavierdpt.xddbg;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.code.Instruction;

import java.util.List;

public class InstructionsWithResolver {
    private final List<Instruction> instructions;
    private final ConstantResolver constantResolver;
    private final LineNumbers lineNumbers;

    public InstructionsWithResolver(List<Instruction> instructions, ConstantResolver constantResolver, LineNumbers lineNumbers) {
        this.instructions = instructions;
        this.constantResolver = constantResolver;
        this.lineNumbers = lineNumbers;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public ConstantResolver getConstantResolver() {
        return constantResolver;
    }

    public Integer getLineNumber(int codeIndex) {
        return lineNumbers.getLineNumber(codeIndex);
    }
}
