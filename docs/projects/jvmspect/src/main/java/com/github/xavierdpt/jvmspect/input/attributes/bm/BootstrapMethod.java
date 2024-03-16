package com.github.xavierdpt.jvmspect.input.attributes.bm;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class BootstrapMethod {
    private final int boostrapMethodRef;
    private final int[] boostrapArguments;

    public BootstrapMethod(int boostrapMethodRef, int[] boostrapArguments) {
        this.boostrapMethodRef = boostrapMethodRef;
        this.boostrapArguments = boostrapArguments;
    }

    public Node toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("boostrapMethod");
        result.appendChild(constantResolver.resolve(boostrapMethodRef).toXMLRef(document, constantResolver));
        Element arguments = XML.createChild(document, result, "arguments");
        for (int boostrapArgument : boostrapArguments) {
            arguments.appendChild(constantResolver.resolve(boostrapArgument).toXMLRef(document, constantResolver));
        }
        return result;
    }
}
