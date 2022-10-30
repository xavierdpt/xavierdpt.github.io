package xdtest.org.apache.cxf.annotations;

import org.apache.cxf.annotations.FastInfoset;

public class FastInfosetTest {

    @FastInfoset(
            force = true,
            serializerAttributeValueMapMemoryLimit = 1,
            serializerCharacterContentChunkMapMemoryLimit = 1,
            serializerMaxAttributeValueSize = 1,
            serializerMaxCharacterContentChunkSize = 1,
            serializerMinAttributeValueSize = 1,
            serializerMinCharacterContentChunkSize = 1
    )
    public static class Dummy {

    }
}
