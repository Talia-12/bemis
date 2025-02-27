package at.petrak.bemis.impl;

import at.petrak.bemis.api.BemisApi;
import at.petrak.bemis.api.book.BemisVerse;
import at.petrak.bemis.impl.adoc.ConversionPage;
import org.asciidoctor.ast.Block;
import org.asciidoctor.ast.StructuralNode;
import org.asciidoctor.extension.BlockMacroProcessor;
import org.asciidoctor.extension.JavaExtensionRegistry;

import java.util.List;
import java.util.Map;

import static at.petrak.bemis.api.BemisApi.BLOCK_MACRO_SENTINEL;

public class BemisApiImpl implements BemisApi.IBemisApi {
    @Override
    public Block makeVerseMacroNode(BlockMacroProcessor self, StructuralNode parent, List<BemisVerse> verses) {
        return self.createBlock(parent, "", BLOCK_MACRO_SENTINEL,
            Map.of(BLOCK_MACRO_SENTINEL, new ConversionPage.BodyPart(verses)));
    }

    @Override
    public JavaExtensionRegistry getJavaExtensionRegistry() {
        return BemisBookRegistry.ASCIIDOCTOR.javaExtensionRegistry();
    }
}
